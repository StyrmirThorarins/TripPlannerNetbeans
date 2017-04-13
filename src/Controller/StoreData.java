package Controller;


import Model.Basket;
import Model.User;

/**
 * Created by Styrmir on 22.3.2017.
 */
public class StoreData {
    private User user;    
    private Basket basket;

    //constructors
    public StoreData(){}

    //getters, setters
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
    public boolean populateData(){
        return true;
    }

    public boolean storeData(){
        return true;
    }

}
