package Model;

import hotel3h.Hotel;
import model.Trip;
import java.util.List;

public class Basket {        
    private List<Flight> flights;
    private List<Hotel> hotels;
    private List<Trip> trips;


    //constructors
    /***
     * Creates a new basket, all values set as null
     */
    public Basket(){
    }


    //getters, setters
    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public void addHotel(Hotel hotel){
        hotels.add(hotel);
    }

    public void addTrip(Trip trip){
        trips.add(trip);
    }
    
    /***
     * Merges all values from the input into this basket
     * @param basket basket where the data is taken from
     */
    public void mergeBasket(Basket basket){
        if(this != basket){
            for (Flight flight : basket.getFlights()) {
                flights.add(flight);
            }
        
            for (Hotel hotel : basket.getHotels()) {
                hotels.add(hotel);
            }
        
            for (Trip trip : basket.getTrips()) {
                trips.add(trip);
            }
        }
    }


    public void setFlights(List<Flight> flights){
        this.flights = flights;
    }

    public void setHotels(List<Hotel> hotels){
        this.hotels = hotels;
    }
    
    public void setHotels(Basket hotels){
        this.hotels = hotels.getHotels();
    }

    public void setTrips(List<Trip> trips){
        this.trips = trips;
    }
    public void setTrips(Basket trips){
        this.trips = trips.getTrips();
    }

    public List<Flight> getFlights(){
        return this.flights;
    }

    public Flight getFlight(int index){
        return flights.get(index);
    }

    public List<Hotel> getHotels(){
        return this.hotels;
    }

    public Hotel getHotel(int index){
        return hotels.get(index);
    }

    public List<Trip> getTrips(){
        return this.trips;
    }

    public Trip getTrip(int index){
        return trips.get(index);
    }
    

/*
    public double getPrice(){
        double priceTotal =0;
        for(int i=0;i < flights.size();i++)
            priceTotal =+ flights.get(i).getPrice();
        for(int i=0;i < trips.size();i++)
            priceTotal =+ trips.get(i).getPrice();
        for(int i=0;i < hotels.size();i++)
            priceTotal =+ hotels.get(i).getPrice();
        return priceTotal;
    }
*/
    /*
    public String getPriceCurrency(){
        String pricecurrency1="1";
        String pricecurrency2="2";
        String pricecurrency3="3";

        for(int i=0;i < flights.size()-1;i++) {
            pricecurrency1 = flights.get(i).getPriceCurrency();
            if (flights.get(i).getPriceCurrency() != flights.get(i + 1).getPriceCurrency())
                return "Flight Currency does not Match";
        }
        for(int i=0;i < trips.size();i++) {
            pricecurrency2 = flights.get(i).getPriceCurrency();
            if (hotels.get(i).getPriceCurrency() != hotels.get(i + 1).getPriceCurrency())
                return "Hotel Currency does not Match";
        }
        for(int i=0;i < hotels.size();i++) {
            pricecurrency3 = flights.get(i).getPriceCurrency();
            if (trips.get(i).getPriceCurrency() != trips.get(i + 1).getPriceCurrency())
                return "Trip Currency does not Match";
        }
        if(pricecurrency1!=pricecurrency2||pricecurrency1!=pricecurrency2||pricecurrency2!=pricecurrency3)
            return "Currency does not Match";
        return pricecurrency1;
    }
*/
    public Basket getAll(){
        return this;
    }

    //methods
    public boolean storeBasket(){
        return true;
    }
    
    public void ClearTrips(){
        this.trips = null;
    }

    public void setFlights() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
