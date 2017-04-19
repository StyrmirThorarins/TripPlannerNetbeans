/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Search;
import Model.Basket;
import Model.DEPRECIATED_Preference;
import Model.*;
import Model.User;
import ViewModel.SearchVM;
import hotel3h.Hotel;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultListModel;
import model.Trip;

/**
 *
 * @author Hobby
 */
public class JPanelSearch extends javax.swing.JPanel {
    
        User user;
        Basket basket;
        
    
    private Controller.Search search;

    /**
     * Creates new form JPanelSearch, fake user generated with id of -99, used for testing
     */
    public JPanelSearch() {
        initComponents();
        
        this.setupConfig();
        user = new User(-99);

        
        
    }
    
    /***
     * Creates new form JPanelSearch, searches for user by id on creation
     * @param userID id of user that is searched for
     */
    public JPanelSearch(int userID) {
        initComponents();
        
        this.setupConfig();
        user = new User(userID);

        
        
    }
    
    /***
     * Creates new form JPanelSearch,created with selected user
     * @param user selected user
     */
    public JPanelSearch(User user) {
        initComponents();
        
        this.setupConfig();
        this.user = user;
        
        
    }
    
    /***
     * user generated configuration for JPanelSearch
     */
    private void setupConfig(){
        search = new Search();
        
        Date curDate = Date.valueOf(LocalDate.now());
        String curDateS = curDate.toString();
        this.jFormattedTextFieldDateStart.setText(curDateS);
        this.jFormattedTextFieldDateEnd.setText(curDateS);
        
        basket = new Basket();
        UpdateSelectPanels();
    }
    
    
    private void UpdateSelectPanels(){
        this.UpdateSelectPanels(this.basket);
    }
    
    private void UpdateSelectPanels(Basket basket){
        List<Flight> flights = basket.getFlights();
        DefaultListModel<String> flightsModel = null;
        for (Flight flight : flights) {
            flightsModel.addElement(flight.getName());
        }
        this.jListSearchResultsFlights.setModel(flightsModel);
        
        List<Hotel> hotels = basket.getHotels();
        DefaultListModel<String> hotelsModel = null;
        for (Hotel hotel : hotels) {
            hotelsModel.addElement(hotel.getName());
        }
        this.jListSearchResultsHotels.setModel(hotelsModel);
        
        
        List<Trip> trips = basket.getTrips();
        DefaultListModel<String> tripsModel = null;
        for (Trip trip : trips) {
            tripsModel.addElement(trip.getName());
        }
        this.jListSearchResultsTrips.setModel(tripsModel);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jCheckBoxFlights = new javax.swing.JCheckBox();
        jCheckBoxHotels = new javax.swing.JCheckBox();
        jCheckBoxTrips = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextFieldDateStart = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDateEnd = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMinimumPrice = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMaximumPrice = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSearchResultsFlights = new javax.swing.JList<>();
        jButtonToBasket = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextFieldNumberOfCustomers = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListSearchResultsTrips = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListSearchResultsHotels = new javax.swing.JList<>();

        jCheckBoxFlights.setText("Flights");

        jCheckBoxHotels.setText("Hotels");
        jCheckBoxHotels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxHotelsActionPerformed(evt);
            }
        });

        jCheckBoxTrips.setText("Trips");

        jLabel1.setText("Search For:");

        jLabel2.setText("Date Start");

        jLabel3.setText("Date End");

        jLabel4.setText("Minimum Price");

        jLabel5.setText("Maximum Price");

        jFormattedTextFieldDateStart.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        jFormattedTextFieldDateStart.setToolTipText("yyyy-MM-dd");

        jFormattedTextFieldDateEnd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        jFormattedTextFieldDateEnd.setToolTipText("yyyy-MM-dd");

        jFormattedTextFieldMinimumPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextFieldMinimumPrice.setText("0.0");

        jFormattedTextFieldMaximumPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextFieldMaximumPrice.setText("0.0");
        jFormattedTextFieldMaximumPrice.setToolTipText("");

        jLabel6.setText("Currency Type");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISK", "EUR", "GBP", "$" }));

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jListSearchResultsFlights.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListSearchResultsFlights);

        jButtonToBasket.setText("Add Selected To Basket");
        jButtonToBasket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonToBasketActionPerformed(evt);
            }
        });

        jLabel7.setText("Number of cutomers");
        jLabel7.setToolTipText("");

        jFormattedTextFieldNumberOfCustomers.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldNumberOfCustomers.setText("0");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Capital area", "Eastern region", "Western region", "Northern region", "Southern region", "Highlands of Iceland" }));

        jLabel8.setText("Area");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Golden Circle", "Horse Trips", "Volcano", "Glaciers", "Beer Trips", "Food Trips" }));

        jLabel9.setText("Preferences");
        jLabel9.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jListSearchResultsTrips.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jListSearchResultsTrips);

        jListSearchResultsHotels.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListSearchResultsHotels);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxHotels)
                            .addComponent(jCheckBoxTrips)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jCheckBoxFlights))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jFormattedTextFieldNumberOfCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jFormattedTextFieldDateEnd)
                                        .addComponent(jFormattedTextFieldMinimumPrice)
                                        .addComponent(jFormattedTextFieldDateStart)
                                        .addComponent(jFormattedTextFieldMaximumPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(76, 76, 76)
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButtonSearch)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonToBasket))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBoxFlights))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jFormattedTextFieldNumberOfCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jCheckBoxHotels)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxTrips)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jFormattedTextFieldDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jFormattedTextFieldDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jFormattedTextFieldMaximumPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jFormattedTextFieldMinimumPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSearch)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonToBasket)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxHotelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxHotelsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxHotelsActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed

        ViewModel.SearchVM vm = new SearchVM();
        vm.setUser(user);
        
        String minDate = this.jFormattedTextFieldDateEnd.getText();
        vm.setDateStart(Date.valueOf(minDate));
        String maxDate = this.jFormattedTextFieldDateStart.getText();
        vm.setDateEnd(Date.valueOf(maxDate));
        
        String minPrice = this.jFormattedTextFieldMinimumPrice.getText();
        vm.setPriceRangeMin(Double.valueOf(minPrice));
        String maxPrice = this.jFormattedTextFieldMaximumPrice.getText();
        vm.setPriceRangeMax(Double.valueOf(maxPrice));
        
        String numberOfCustomers = this.jFormattedTextFieldNumberOfCustomers.getText();
        vm.setPeople(Integer.valueOf(numberOfCustomers));
        
        String curency = this.jComboBox1.getItemAt(this.jComboBox1.getSelectedIndex());
        vm.setCurrencyType(curency);
        
        Boolean searchFlights = this.jCheckBoxFlights.isSelected();
        Boolean searchHotels  = this.jCheckBoxHotels.isSelected();
        Boolean searchTrips   = this.jCheckBoxTrips.isSelected();
        
        String area = this.jComboBox2.getItemAt(this.jComboBox2.getSelectedIndex());
        vm.setArea(area);
        
        String prefrence = this.jComboBox3.getItemAt(this.jComboBox3.getSelectedIndex());
        vm.setPref(prefrence);
        
        //search.SearchAll(dateEnd, day, priceRangeMax, priceRangeMax, currencyType, PROPERTIES, preferences, true, true, true);
        basket = search.SearchAll(vm,searchFlights,searchHotels,searchTrips);
        UpdateSelectPanels(basket);
        
        
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonToBasketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonToBasketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonToBasketActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonToBasket;
    private javax.swing.JCheckBox jCheckBoxFlights;
    private javax.swing.JCheckBox jCheckBoxHotels;
    private javax.swing.JCheckBox jCheckBoxTrips;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JFormattedTextField jFormattedTextFieldDateEnd;
    private javax.swing.JFormattedTextField jFormattedTextFieldDateStart;
    private javax.swing.JFormattedTextField jFormattedTextFieldMaximumPrice;
    private javax.swing.JFormattedTextField jFormattedTextFieldMinimumPrice;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumberOfCustomers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListSearchResultsFlights;
    private javax.swing.JList<String> jListSearchResultsHotels;
    private javax.swing.JList<String> jListSearchResultsTrips;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
