/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import model.Flight;
import hotel3h.Hotel;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import model.Trip;
import javax.swing.JOptionPane;
import hotel3h.Hotel;
import model.Trip;

/**
 *
 * @author Hobby
 */
public class JPanelBasket extends javax.swing.JPanel {

    
    private Model.Basket basket;
    private DefaultListModel basketFlightList;
    private DefaultListModel basketHotelList;
    private DefaultListModel basketTripList;
    /**
     * Creates new form JPanelBasket
     */
    public JPanelBasket() {
        initComponents();
        this.jLabel2.setVisible(false);
        this.jComboBoxOldBaskets.setVisible(false);
        this.jButtonReturnToCurrentBasket.setVisible(false);
        
        this.basket = new Model.Basket();
        basketFlightList = new DefaultListModel();
        basketHotelList = new DefaultListModel();
        basketTripList = new DefaultListModel();
        addToBasket();
    }
    
    public JPanelBasket(Model.Basket basket) {
        initComponents();        
                        
        this.jLabel2.setVisible(false);
        this.jComboBoxOldBaskets.setVisible(false);
        this.jButtonReturnToCurrentBasket.setVisible(false);
        
        this.basket = basket;                
        basketFlightList = new DefaultListModel();
        basketHotelList = new DefaultListModel();
        basketTripList = new DefaultListModel();
        addToBasket();
    }    

    private void addToBasket(){
        //basketList = new DefaultListModel();
        //basketList.addElement("one");
        //basketList.addElement("two");        
        
        //create lists
        for(Flight flight: basket.getFlights()){
            basketFlightList.addElement(flight.getDeparture_from() + " " + flight.getArrival_to() + flight.getTicket_price());
        }
        for(Hotel hotel: basket.getHotels()){
            basketHotelList.addElement(hotel.getName());
        }
        for(Trip trip: basket.getTrips()){
            basketTripList.addElement(trip.getName() + " " + trip.getPrice());
        }        
        
        //update lists on GUI
        jListBasketFlights.setModel(basketFlightList);
        jListBasketHotels.setModel(basketHotelList);
        jListBasketTrips.setModel(basketTripList);
        
        getTotalSum();
    }
    
    private void getTotalSum(){
        /*
            private List<Flight> flights;
            private List<Hotel> hotels;
            private List<Trip> trips;/*        
        */
        
        double sum = 0.0;                
        
        //add together price
        for(Flight flight: basket.getFlights()){
            sum += flight.getTicket_price();
        }
        for(Hotel hotel: basket.getHotels()){
            //sum += hotel.getRooms().
            sum += 0;
        }
        for(Trip trip: basket.getTrips()){
            sum += trip.getPrice();
        }          
        
        this.jLabelTotalPrice.setText(String.valueOf(sum));
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListBasketFlights = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonRemoveSelected = new javax.swing.JButton();
        jButtonBuy = new javax.swing.JButton();
        jComboBoxOldBaskets = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButtonReturnToCurrentBasket = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelTotalPrice = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListBasketHotels = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListBasketTrips = new javax.swing.JList<>();

        jListBasketFlights.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListBasketFlights);

        jLabel1.setText("Items in the basket");

        jButtonRemoveSelected.setText("Remove Selected");
        jButtonRemoveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveSelectedActionPerformed(evt);
            }
        });

        jButtonBuy.setText("Buy All in Basket");
        jButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyActionPerformed(evt);
            }
        });

        jComboBoxOldBaskets.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("View Old Purchase");

        jButtonReturnToCurrentBasket.setText("Return to Current Basket");

        jLabel3.setText("Total Price of Basket:");

        jLabelTotalPrice.setText("PRICE");

        jListBasketHotels.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListBasketHotels);

        jListBasketTrips.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jListBasketTrips);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonReturnToCurrentBasket)
                                    .addGap(192, 192, 192)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxOldBaskets, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(26, 26, 26)
                            .addComponent(jLabelTotalPrice)
                            .addGap(364, 364, 364)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonRemoveSelected, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addComponent(jButtonBuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxOldBaskets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jButtonReturnToCurrentBasket, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemoveSelected)
                    .addComponent(jLabel3)
                    .addComponent(jLabelTotalPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuy)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuyActionPerformed
        JOptionPane.showMessageDialog (null, "Your purchase is complete, for the total price of $" + this.jLabelTotalPrice.getText() + ", thank you!", "Purchase Complete", JOptionPane.INFORMATION_MESSAGE);
       
    }//GEN-LAST:event_jButtonBuyActionPerformed

    private void jButtonRemoveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveSelectedActionPerformed
        int[] list = this.jListBasketFlights.getSelectedIndices();                
        
        for (int index : list){            
            //System.out.println(String.valueOf(index));
            //basketList.removeElementAt(index);
        }
        
        
        this.jListBasketFlights.removeAll();
    }//GEN-LAST:event_jButtonRemoveSelectedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuy;
    private javax.swing.JButton jButtonRemoveSelected;
    private javax.swing.JButton jButtonReturnToCurrentBasket;
    private javax.swing.JComboBox<String> jComboBoxOldBaskets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelTotalPrice;
    private javax.swing.JList<String> jListBasketFlights;
    private javax.swing.JList<String> jListBasketHotels;
    private javax.swing.JList<String> jListBasketTrips;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
