/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModel;

import Model.DEPRECIATED_Preference;
import Model.User;
import java.sql.Date;

/**
 *
 * @author Hobby
 */
public class SearchVM {
  
    private String toWhere;
    private String fromWhere;
    private String area;
    private String pref;
    private User user;
    private Date day;
    private int people;
    private Date dateStart;
    private Date dateEnd;
    private double priceRangeMin;   
    private double priceRangeMax;
    private String currencyType;
    private DEPRECIATED_Preference[] preferences;
    
    private int dateRange;

    //constructors
    public SearchVM(){
    }

    //getters, setters
    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }
    
    public int getPeople(){
        return this.people;
    }
    
    public void setPeople(int people){
        this.people = people;
    }

    public Date day(){
        return this.dateStart;
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
    
    public String getPref(){
        return this.pref;
    }

    public void setPref(String pref){
        this.pref = pref;
    }
    
    public String getToWhere(){
        return this.toWhere;
    }

    public void setToWhere(String toWhere){
        this.toWhere = toWhere;
    }
    
    public String getFromWhere(){
        return this.fromWhere;
    }

    public void setFromWhere(String fromWhere){
        this.fromWhere = fromWhere;
    }
    
    public String getArea(){
        return this.area;
    }

    public void setArea(String area){
        this.area = area;
    }
}
