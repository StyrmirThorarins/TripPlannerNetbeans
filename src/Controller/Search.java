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
import ViewModel.SearchVM;
import Model.Basket;
import Model.DEPRECIATED_Preference;
import Model.User;

import Controller.DBC;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Search {

    private ViewModel.SearchVM searchVM;

    //constructors
    public Search() {
    }

    public Search(ViewModel.SearchVM searchVM) {
        this.searchVM = searchVM;
    }

    //getters, setters
    public void setSearchVM(ViewModel.SearchVM searchVM) {
        this.searchVM = searchVM;
    }

    public ViewModel.SearchVM getSearchVM() {
        return this.searchVM;
    }

    //methods
    public Basket SearchAll() {
        return new Basket();
    }

    /**
     * *
     * searches flights, hotels, and cutomers at the same time
     *
     * @param startDate starting date of search, inclusive
     * @param endDate ending date of search, inclusive
     * @param minPrice minimum price, inclusive
     * @param maxPrice maximum price, inclusive
     * @param curency curency of the transaction
     * @param numberOfCustomers number of customers in the order
     * @param prefrence list of prefrences
     * @param searchHotel whether or not to search in hotels, returns null if
     * false
     * @param searchFlight whether or not to search in flights, returns null if
     * false
     * @param searchTrip whether or not to search in trips, returns null if
     * false
     * @return basket containing all data matching the atributes
     */
    public Basket SearchAll(SearchVM SVM, boolean searchHotel, boolean searchFlight, boolean searchTrip) {
        Basket basket = new Basket();

        if (searchFlight) {
            Basket SearchFlights = SearchFlights(SVM);
            basket.setFlights(SearchFlights.getFlights());
        }
        if (searchHotel) {

            List<Hotel> hotels = SearchHotels(SVM);
            basket.setHotels(hotels);
        }
        if (searchTrip) {
            List<Trip> trips = SearchTripsList(SVM);
            basket.setTrips(trips);
        }

        return basket;
    }

    public Basket SearchFlights() {
        return new Basket();
    }

    private Basket SearchFlights(Date startDate, Date endDate, double minPrice, double maxPrice, String curency, int numberOfCustomers, DEPRECIATED_Preference[] prefrence) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new Basket();
    }

    public List<Hotel> SearchHotels(SearchVM SVM) {
        //create calander instance and get required params
        Calendar cal = Calendar.getInstance();
        cal.setTime(SVM.getDateStart());
        int month1 = cal.get(Calendar.MONTH);
        int day1 = cal.get(Calendar.DAY_OF_MONTH);
        int year1 = cal.get(Calendar.YEAR);
        cal.setTime(SVM.getDateEnd());
        int month2 = cal.get(Calendar.MONTH);
        int day2 = cal.get(Calendar.DAY_OF_MONTH);
        int year2 = cal.get(Calendar.YEAR);
        //initializer fyrir hótel leit
        //int type,gym,spa,pool,hottub,wifi,conference,restaurant,bar,inclusive,breakfast,cancellation,roomservice,wheelchair,elevator,flybus,minPrice,maxPrice,minSize,maxSize,minBeds,areaCode;
        //int[] startDate,endDate; 
        int[] heild = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99999, 0, 99999, SVM.getPeople(), 0, year1, month1, day1, year2, month2, day2};
        SearchManager sm = new SearchManager(heild);
        List<Hotel> results = sm.searchHotel();
        return results;

    }

    private Basket SearchHotels(Date startDate, Date endDate, double minPrice, double maxPrice, String curency, int numberOfCustomers, DEPRECIATED_Preference[] prefrence) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new Basket();
    }

    /**
     * *
     * Returns a basket containing list of all available trips
     *
     * @return
     */
    /* public Basket SearchTrips(){
        Basket result = new Basket();
        
        List<Trip> t = SearchTripsList();
        
        for (Trip trip : t) {
            result.addTrip(trip);
        }
        
        return result;
    }
     */
    /**
     * *
     * Inserts list of all available trips onto a basket
     *
     * @param oldBasket Basket that the list of Trips will be inserted into
     * @return
     */
    /*  public Basket SearchTrips(Basket oldBasket){
        
        return SearchTrips(oldBasket,false);
    }
     */ /**
     * *
     * Inserts list of all available trips onto a basket
     *
     * @param oldBasket Basket that the list of Trips will be inserted into
     * @param clearOld chose whether or not do delete old list
     * @return
     */
    /* public Basket SearchTrips(Basket oldBasket, Boolean clearOld){
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
     */
    /**
     * *
     * Returns a list of all available trips
     *
     * @return
     */
    public List<Trip> SearchTripsList(SearchVM SVM) {
        List<Trip> t = null;
        Trip[] results = null;
        try {
            TripController tc = new TripController();
            try {
                //for (int i = 0; i < preferences.length; i++) {
                results = tc.searchTrips(
                        "",
                        SVM.day(),
                        Time.valueOf("00:01:00"),
                        Time.valueOf("23:59:00"),
                        "",
                        false,
                        false,
                        5000,
                        30000,
                        SVM.getPref(),
                        SVM.getArea(),
                        false);
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

    private Basket searchTrips(Date startDate, Date endDate, double minPrice, double maxPrice, String curency, int numberOfCustomers, DEPRECIATED_Preference[] prefrence) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new Basket();
    }

    public Basket SearchByUserProfileTags() {
        return new Basket();
    }

    public Basket SearchByCustomizedTags() {
        return new Basket();
    }

    public final static long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;

    /**
     * *
     * finds the difference in number of days between dates
     *
     * @param from earlier date
     * @param to later date
     * @return difference in dates
     */
    public static int DifferenceInDays(Date from, Date to) {
        return (int) ((to.getTime() - from.getTime()) / MILLISECONDS_IN_DAY);
    }

    /**
     * *
     * Returns date incremented by one day
     *
     * @param date value to increment
     * @return
     */
    public static Date incrimentDate(Date date) {
        return incrimentDate(date, 1);
    }

    /**
     * *
     * Returns date incremented by a number of days
     *
     * @param date value to increment
     * @param dayDiff number of days to increment by, can be negative to
     * decrement
     * @return
     */
    public static Date incrimentDate(Date date, int dayDiff) {
        date.setTime(MILLISECONDS_IN_DAY * dayDiff + date.getTime());
        return date;
    }

    public static void main(String[] args) {
        Search search = new Search();
        SearchVM SVM = new SearchVM();
        SVM.setDateStart(Date.valueOf("2017-06-22"));
        SVM.setPref("Horse Trips");
        SVM.setArea("Western Region");
        SVM.setDateEnd(Date.valueOf("2017-06-23"));
        SVM.setPeople(1);
        List<Trip> trips = search.SearchTripsList(SVM);
        for (Trip t : trips) {
            System.out.println(t.getName() + ", " + t.getAvailablePlaces() + ", " + t.getDate() + ", " + t.getTourCompany().getName() + ", " + t.getType() + ", " + t.getArea() + ", " + t.getLocation());
        }
        List<Hotel> hotels = search.SearchHotels(SVM);
        for (Hotel h : hotels) {
            System.out.println(h.getName() + ", " + ", " + h.getType() + ", " + h.getStars() + ", " + h.getMaxPrice() + ", " + h.getMinPrice() + ", " + h.getAreacode() + ", " + h.getAddress());
        }
    }

    public Basket SearchAll(SearchVM vm, Boolean searchFlights, Boolean searchHotels, Boolean searchTrips) {
        Basket basket = new Basket();
        if (searchFlights) {
            basket.mergeBasket(this.SearchFlights(vm));
            //this.SearchFlights(vm);
        }
        if (searchHotels) {
            basket.setHotels(this.SearchHotels(vm));
            //this.SearchHotels(vm);
        }
        if (searchTrips) {
            basket.setTrips(this.SearchTripsList(vm));
            //this.SearchTripsList(vm);
        }
        return basket;
    }

    private Basket SearchFlights(SearchVM vm) {
        return new Basket();
    }

}
