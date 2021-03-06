package UnitTests;

import model.Flight;
import Controller.Search;
import Model.Basket;
import ViewModel.SearchVM;
import hotel3h.Hotel;
import model.Trip;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class SearchTest {
    SearchVM SVM;
    private Basket basket;
    private Search search;
    private Basket flightsearch;

    @Before
    public void setUp(){
        this.search =new Search();
        this.basket = new Basket();

        //search pricemin
       // search.setPriceRangeMin(10000);
        //search.setCurrencyType("ISK");

        //search pricemax
        //search.setPriceRangeMax(100000);
        //search.setCurrencyType("ISK");

        //flight 1
        

        //flight 2
        


/*
        basket.addFlight(flight1);
        basket.addFlight(flight2);

        flightsearch.addFlight(flight1);
        flightsearch.addFlight(flight2);
        
*/
    }


    //deconstruction
    @After
    public void tearDown(){
        basket = null;
    }

/*
    //1) search for flight
    @Test
    public void testFlightSearch(){
        String flightName1 = flightsearch.getFlight(0).getName();
        String flightName2 = flightsearch.getFlight(1).getName();
        String flightDep1 = flightsearch.getFlight(0).getDepartureLocation();
        String flightArr1 = flightsearch.getFlight(0).getArrivalLocation();
        String flightDep2 = flightsearch.getFlight(1).getDepartureLocation();
        String flightArr2 = flightsearch.getFlight(1).getArrivalLocation();

        // Flightname regulations always 2 char then 3 int
        assertTrue(Pattern.matches("^\\D{2}\\d{3}\\b", flightName1));
        assertTrue(Pattern.matches("^\\D{2}\\d{3}\\b", flightName2));
        // Airport ICAO codes always 4 char
        assertTrue(Pattern.matches("^\\D{4}\\b", flightArr1));
        assertTrue(Pattern.matches("^\\D{4}\\b", flightArr2));
        assertTrue(Pattern.matches("^\\D{4}\\b", flightDep1));
        assertTrue(Pattern.matches("^\\D{4}\\b", flightDep2));

    }
*/    
/*
    //2) check price max !> given max price
    @Test
    public void testPriceMax(){
        assertTrue(basket.getPrice() <= search.getPriceRangeMax());
    }


    //3) check price min !> given min price
    @Test
    public void testPriceMin(){
        assertTrue(basket.getPrice() >= search.getPriceRangeMax());
    }
*/
    //4) check currency type == set currency price
/*    @Test
    public void testCurrency(){
        assertEquals(basket.getPriceCurrency(),"ISK");
    }
*/
}
