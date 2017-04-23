package Model;

import hotel3h.Hotel;
import java.util.ArrayList;
import model.Trip;
import java.util.List;
import model.Flight;

public class Basket {
    
    private static final double ISK_IN_USD_EXCHANGE_RATE = 100.0;
    
    private List<Flight> flights;
    private List<Hotel> hotels;
    private List<Trip> trips;   
    
    private ViewModel.SearchVM searchVM;       
    
    //constructors
    /**
     * *
     * Creates a new basket, all values set as null
     */
    public Basket() {
        flights = new ArrayList<>();
        hotels = new ArrayList<>();
        trips = new ArrayList<>();
        
        this.searchVM = new ViewModel.SearchVM();
        
        hotelsStayLength = new ArrayList<>();        
    }

    //getters, setters
    public void addFlight(Flight flight) {
        flights.add(flight);
    }
    
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
        hotelsStayLength.add(1);
    }

    /**
     * adds hotel to basket
     *
     * @param hotel hotel to ad
     * @param stayLength length of stay in days
     */
    public void addHotel(Hotel hotel, int stayLength) {
        hotels.add(hotel);
        hotelsStayLength.add(stayLength);
    }
    
    public void addTrip(Trip trip) {
        trips.add(trip);
    }   
    
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
    
    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
        
        if (this.hotels == null) {
            this.hotelsStayLength = null;
        } else {
            this.hotelsStayLength.clear();
            for (Hotel hotel : this.hotels) {
                this.hotelsStayLength.add(1);
            }
        }
    }
    
    public void setHotels(List<Hotel> hotels, List<Integer> hotelStayLength) {
        this.hotels = hotels;
        this.hotelsStayLength = hotelStayLength;
    }
    
    public void setHotels(Basket hotels) {
        this.hotels = hotels.getHotels();
        this.hotelsStayLength = hotels.getHotelsStayLength();
    }
    
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
    
    public void setTrips(Basket trips) {
        this.trips = trips.getTrips();
    }
    
    public List<Flight> getFlights() {
        return this.flights;
    }
    
    public Flight getFlight(int index) {
        return flights.get(index);
    }
    
    public List<Hotel> getHotels() {
        return this.hotels;
    }
    
    public Hotel getHotel(int index) {
        return hotels.get(index);
    }
    
    public List<Trip> getTrips() {
        return this.trips;
    }
    
    public Trip getTrip(int index) {
        return trips.get(index);
    }
    
    public Basket getAll() {
        return this;
    }

    //methods
    public boolean storeBasket() {
        return true;
    }
    
    public void removeTrip(int index) {
        trips.remove(index);
    }
    
    public void removeFlight(int index) {
        flights.remove(index);
    }
    
    public void removeHotel(int index) {
        hotels.remove(index);
    }
    
    public void ClearTrips() {
        this.trips = null;
    }
    
    public void setSearchVM(ViewModel.SearchVM model){
        this.searchVM = model;
    }
    
    public ViewModel.SearchVM getSearchVM(){
        return this.searchVM;
    }
    
    public List<Integer> getHotelsStayLength() {
        return this.hotelsStayLength;
    }
    
    /**
     * *
     * Merges all values from the input into this basket
     *
     * @param basket basket where the data is taken from
     */
    public void mergeBasket(Basket basket) {
        if (basket != null && this != basket) {
            if (basket.getFlights() != null) {
                for (Flight flight : basket.getFlights()) {
                    this.flights.add(flight);
                }
            }
            if (basket.getHotels() != null) {
                for (Hotel hotel : basket.getHotels()) {
                    this.hotels.add(hotel);
                }
            }
            if (basket.getHotelsStayLength() != null) {
                for (int stay : basket.getHotelsStayLength()) {
                    this.hotelsStayLength.add(stay);
                }
                
            }
            if (basket.getTrips() != null) {
                
                for (Trip trip : basket.getTrips()) {
                    this.trips.add(trip);
                }
            }
        }
    }    
    
    //convert from USD to ISK
    public static double USDtoISK(double curency) {
        return curency * ISK_IN_USD_EXCHANGE_RATE;
    }
    
    //convert from ISK to USD
    public static double ISKtoUSD(double curency) {
        return curency / ISK_IN_USD_EXCHANGE_RATE;
    }
    
    /**
     * returns the price of a basket
     * @return 
     */
    public double getPrice() {
        double priceTotal = 0;
        for (int i = 0; i < flights.size(); i++) {
            priceTotal += flights.get(i).getTicket_price() * searchVM.getPeople();
        }
        for (int i = 0; i < trips.size(); i++) {
            priceTotal += trips.get(i).getPrice() * searchVM.getPeople();
        }
        for (int i = 0; i < hotels.size(); i++) {
            priceTotal += USDtoISK(hotels.get(i).getMinPrice()) * this.hotelsStayLength.get(i);
        }
        return priceTotal;
    }

}
