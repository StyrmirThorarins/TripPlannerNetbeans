package Controller;

/**
 * Created by Styrmir on 22.3.2017.
 */
import storage.DatabaseManager;
import model.Flight;
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
    public Basket SearchAll(SearchVM SVM, boolean searchFlight, boolean searchHotel, boolean searchTrip) {
        Basket basket = new Basket();

        if (searchFlight) {
            List<Flight> flights = SearchFlights(SVM);
            basket.setFlights(flights);
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


    private List<Flight> SearchFlights(SearchVM SVM) {
        DatabaseManager DBM = new DatabaseManager();
        List<Flight>results;
        results = DBM.findFlights("Ísafjörður","20170424",1, "Reykjavík");
        results.addAll(DBM.findFlights("Reykjavík","20170424",1, "Ísafjörður"));
        //results = DBM.findFlights("SVM.getToWhere","20170424",SVM.getPeople, SVM.getFromWhere);
        //results = DBM.findFlights("SVM.getToWhere","20170424",SVM.getPeople, SVM.getFromWhere);
        return results;
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

    public List<Trip> SearchTripsList(SearchVM SVM) {
        String[] area={"Capital area","Eastern region","Western region","Northern region","Southern region","Highlands of Iceland"};
        String[] pref={"Golden Circle","Horse Trips","Volcano","Glaciers","Beer Trips","Food Trips"};
        List<Trip> t = new ArrayList<>();
        Trip[] results = null;
        if("All".equals(SVM.getArea())&& !"All".equals(SVM.getArea())){
            try {
            TripController tc = new TripController();
            try {
                for (int i = 0; i < area.length; i++) {
                results = tc.searchTrips("",SVM.getDateStart(),Time.valueOf("00:01:00"),Time.valueOf("23:59:00"),"",false,false,0,9999999,
                        SVM.getPref(),
                        area[i],
                        false);
                if(results!=null){
                t.addAll(Arrays.asList(results));
            }}
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else if("All".equals(SVM.getPref())&&"All".equals(SVM.getArea())){
            try {
            TripController tc = new TripController();
            try {
                //for (int i = 0; i < preferences.length; i++) {
                results = tc.searchTrips("",SVM.getDateStart(),Time.valueOf("00:01:00"),Time.valueOf("23:59:00"),"",false,false,0,9999999,
                        SVM.getPref(),
                        SVM.getArea(),
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
        }
        else{ try {
            TripController tc = new TripController();
            try {
                //for (int i = 0; i < preferences.length; i++) {
                results = tc.searchTrips("",SVM.getDateStart(),Time.valueOf("00:01:00"),Time.valueOf("23:59:00"),"",false,false,0,9999999,
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
        }
        return Arrays.asList(results);
        //results = controller.searchTrips("tripname", days, startTime, endTime, description, familyFriendly, accessible, minPrice, maxPrice, type, location,boolean showAllFromDate);

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
        SVM.setArea("Western region");
        SVM.setDateEnd(Date.valueOf("2017-06-23"));
        SVM.setPeople(1);
        List<Trip> trips = search.SearchTripsList(SVM);
        for (Trip t : trips) {
            System.out.println(t.getName() + ", " + t.getAvailablePlaces() + ", " + t.getDate() + ", " + t.getTourCompany().getName() + ", " + t.getType() + ", " + t.getArea() + ", " + t.getLocation());
        }
        List<Hotel> hotels = search.SearchHotels(SVM);
        for (Hotel h : hotels) {
            System.out.println(h.getName() + ", " + h.getType() + ", " + h.getStars() + ", " + h.getMaxPrice() + ", " + h.getMinPrice() + ", " + h.getAreacode() + ", " + h.getAddress());
        }
        System.out.println(hotels.get(0).getRooms().get(0).getPrice() + ", " + hotels.get(0).getRooms().get(0).getNr() + ", " + hotels.get(0).getRooms().get(0).getBed1()
         + ", " + hotels.get(0).getRooms().get(0).getBed2() + ", " + hotels.get(0).getRooms().get(0).getHnr());
    }


}
