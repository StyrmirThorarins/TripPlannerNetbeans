package Controller;

import Model.Basket;
import Model.User;
import controller.TripController;
import controller.DBBookingManager;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TourCompany;
import model.Trip;

/**
 * Created by Styrmir on 22.3.2017.
 */
public class Book {
    private User user;
    private Basket basket;
    
    private TripController tc;

    //constructors
    public Book(){
        
    }


    //getters,setters
    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Basket getBasket(){
        return this.basket;
    }

    public void setBasket(Basket basket){
        this.basket = basket;
    }


    //methods
    private boolean checkValid(){
        return true;
    }

    private boolean storeData(){
        return true;
    }


    public boolean book(){
        return true;
    }
    
    
    
    /***
     * 
     * @param trip 
     * @return true if booking successful, false otherwise
     */
    /***
     * books a trip from daytrips
     * @param trip trip to book
     * @param user user ordering the trip
     * @param numberOfTravelers number of travelers, including the user ordering the trip
     * @param hotelPickup whether or not user will be picked up from the hotel 
     * @param active -- not sure
     * @return 
     */
    public boolean BookTrip(Trip trip, User user, int numberOfTravelers, Boolean hotelPickup, Boolean active){
        
        try {
            tc = new TripController();
            try {
                tc.bookTrip(user.getName(),user.getPhoneInt() , user.getAddress(), user.getEmail(), trip, numberOfTravelers, hotelPickup, active);
                //tc.bookTrip("asd",10, "  ", "", trip, numberOfTravelers, hotelPickup, active);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return false;
    }
    
    public static void main(String[] args){
        Book b = new Book();
        Trip t = new Trip(0, "", new Date(2017, 04, 04), new Time(5, 5, 5), new Time(6, 6, 6), "", 0, "", "", "", 0, true, true, new TourCompany(0, "", 0, "", ""), 0);
        User u = new User(5);
        
        b.BookTrip(t, u, 0, Boolean.TRUE, Boolean.FALSE);
    }

}
