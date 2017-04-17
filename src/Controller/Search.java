package Controller;

/**
 * Created by Styrmir on 22.3.2017.
 */
import model.Trip;
import controller.TripController;
import java.sql.Time;
import java.sql.Date;

import Model.Basket;
import Model.Preference;
import Model.User;
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
        //List<Basket> results;
        //results.add(Basket);
        return new Basket();
    }

    public Basket SearchFlights(){
        return new Basket();
    }

    public Basket SearchHotels(){
        return new Basket();
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
        Trip[] results;
        try {
            TripController tc = new TripController();
            try {
                for (int i = 0; i < preferences.length; i++) {
                    results = tc.searchTrips(
                            "",
                            day,
                            new Time(00, 00, 01),
                            new Time(23, 59, 59),
                            "",
                            false,
                            false,
                            0,
                            Integer.MAX_VALUE,
                            preferences[i].getName(),
                            "ADD HOTEL LOCATION");
                    for (Trip result : results) {
                        t.add(result);
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return t;
        //results = controller.searchTrips("tripname", days, startTime, endTime, description, familyFriendly, accessible, minPrice, maxPrice, type, location);
        
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
        search.SearchTripsList();
    }
}
