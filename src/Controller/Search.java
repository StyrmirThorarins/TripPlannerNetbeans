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

import java.util.*;

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

    //constructors
    public Search(){}

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

    public Basket SearchTrips(){
        List<Basket> resul;
        //Trip[] results = TripController.searchTrips("", day, null, null, "description", false, false, 0, 20000, "Preferance", "");
        return new Basket();
        //results = controller.searchTrips("", days, startTime, endTime, description, familyFriendly, accessible, minPrice, maxPrice, type, location);
    }

    public Basket SearchByUserProfileTags(){
        return new Basket();
    }

    public Basket SearchByCustomizedTags(){
        return new Basket();
    }


}
