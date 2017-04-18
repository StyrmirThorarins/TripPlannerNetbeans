package Controller;

/**
 * Created by Styrmir on 22.3.2017.
 */
import hotel3h.Room;
import hotel3h.Hotel;
import hotel3h.HotelDatabaseManager;
import hotel3h.SearchManager;
import model.Trip;
import controller.TripController;
import java.sql.Time;
import java.sql.Date;

import Model.Basket;
import Model.Preference;
import Model.User;

import Controller.DBC;


import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Search {
    private User user;
    private Date day;
    private int people;
    private Date dateStart;
    private Date dateEnd;
    private double priceRangeMin;   
    private double priceRangeMax;
    private String currencyType;
    private Preference[] preferences;
    
    private int dateRange;

    //constructors
    public Search(){
        day = new Date(2017, 04, 13);
        people = 10;
        dateStart = day;
        dateEnd = day;
        
        preferences = new Preference[5];
        for (int i = 0; i < preferences.length; i++) {
            preferences[i]=new Preference();
            
        }
        dateRange = DifferenceInDays(dateStart, dateEnd);
    }

    //getters, setters
    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Date getDateStart(){
        return this.dateStart;
    }

    public void setDateStart(Date dateStart){
        this.dateStart = dateStart;
    }

    public Date getDateEnd(){
        return this.dateEnd;
    }

    public void setDateEnd(Date dateEnd){
        this.dateEnd = dateEnd;
    }

    public double getPriceRangeMin(){
        return this.priceRangeMin;
    }

    public void setPriceRangeMin(double priceRangeMin){
        this.priceRangeMin = priceRangeMin;
    }

    public double getPriceRangeMax(){
        return this.priceRangeMax;
    }

    public void setPriceRangeMax(double priceRangeMax){
        this.priceRangeMax = priceRangeMax;
    }

    public String getCurrencyType(){
        return this.currencyType;
    }

    public void setCurrencyType(String currencyType){
        this.currencyType = currencyType;
    }

    public Preference[] getPreferences(){
        return this.preferences;
    }

    public void setPreferences(Preference[] preferences){
        this.preferences = preferences;
    }



    //methods
    public Basket SearchAll(){
        return new Basket();
    }

    public Basket SearchFlights(){
        return new Basket();
    }

    public List<Hotel> SearchHotels(){
       //create calander instance and get required params
       Calendar cal = Calendar.getInstance();
       cal.setTime(dateStart);
       int month1 = cal.get(Calendar.MONTH);
       int day1 = cal.get(Calendar.DAY_OF_MONTH);
       int year1 = cal.get(Calendar.YEAR);
       cal.setTime(dateEnd);
       int month2 = cal.get(Calendar.MONTH);
       int day2 = cal.get(Calendar.DAY_OF_MONTH);
       int year2 = cal.get(Calendar.YEAR);
       //initializer fyrir hótel leit
       // int type,gym,spa,pool,hottub,wifi,conference,restaurant,bar,inclusive,breakfast,cancellation,roomservice,wheelchair,elevator,flybus,minPrice,maxPrice,minSize,maxSize,minBeds,areaCode;
       //int[] startDate,endDate; 
       int[] heild={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,99999,0,99999,people,0,day1,month1,year1,day2,month2,year2};
       SearchManager sm = new SearchManager(heild);
       List<Hotel> results = sm.searchHotel();
       return results;
       
       
    }

    /***
     * Returns a basket containing list of all available trips
     * @return 
     */
    public Basket SearchTrips(){
        Basket result = new Basket();
        
        List<Trip> t = SearchTripsList();
        
        for (Trip trip : t) {
            result.addTrip(trip);
        }
        
        return result;
    }
    
    /***
     * Inserts list of all available trips onto a basket
     * @param oldBasket Basket that the list of Trips will be inserted into
     * @return 
     */
    public Basket SearchTrips(Basket oldBasket){
        
        return SearchTrips(oldBasket,false);
    }
    /***
      * Inserts list of all available trips onto a basket
      * @param oldBasket Basket that the list of Trips will be inserted into
      * @param clearOld chose whether or not do delete old list
      * @return 
      */
    public Basket SearchTrips(Basket oldBasket, Boolean clearOld){
        Basket result = oldBasket;
        if (clearOld) {
            result.ClearTrips();
        }
        
        List<Trip> t = SearchTripsList();
        
        for (Trip trip : t) {
            result.addTrip(trip);
        }
        return result;
    }
    
    /***
     * Returns a list of all available trips
     * @return 
     */
    public List<Trip> SearchTripsList(){
        List<Trip> t = null;
        Trip[] results= null;
        try {
            TripController tc = new TripController();
            try {
                //for (int i = 0; i < preferences.length; i++) {
                    results = tc.searchTrips(
                            "",
                            Date.valueOf("2017-06-22"),
                            Time.valueOf("10:00:00"),
                            Time.valueOf("13:00:00"),
                            "",
                            false,
                            false,
                            5000,
                            30000,
                            "Horse Trips",
                            "Western region", 
                            true);
                   // for (Trip result : results) {
                   //     t.add(result);
                   // }
               // }
              } catch (ClassNotFoundException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Arrays.asList(results);
        //results = controller.searchTrips("tripname", days, startTime, endTime, description, familyFriendly, accessible, minPrice, maxPrice, type, location,boolean showAllFromDate);
        
    }
    
    

    public Basket SearchByUserProfileTags(){
        return new Basket();
    }

    public Basket SearchByCustomizedTags(){
        return new Basket();
    }
    
    public final static long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;

    /***
     * finds the difference in number of days between dates
     * @param from earlier date
     * @param to later date
     * @return difference in dates
     */
    public static int DifferenceInDays(Date from, Date to) {
        return (int)((to.getTime() - from.getTime()) / MILLISECONDS_IN_DAY);
    }
    
    
    /***
     * Returns date incremented by one day
     * @param date value to increment
     * @return 
     */
    public static Date incrimentDate(Date date){
        return incrimentDate(date, 1);
    }
    
    /***
     * Returns date incremented by a number of days
     * @param date value to increment
     * @param dayDiff number of days to increment by, can be negative to decrement
     * @return 
     */
    public static Date incrimentDate(Date date, int dayDiff){
        date.setTime(MILLISECONDS_IN_DAY*dayDiff + date.getTime());
        return date;
    }
    


    
    
     public static void main(String[] args){
        
        Search search = new Search();
        List<Trip> trips = search.SearchTripsList();
        for(Trip t: trips) {
            System.out.println(t.getName() + ", " + t.getAvailablePlaces() + ", " + t.getDate() + ", " + t.getTourCompany().getName() + ", " + t.getType() + ", " + t.getArea() + ", " + t.getLocation());
        }
    }
}
