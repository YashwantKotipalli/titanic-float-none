/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.BookFlight;

import Business.Airline;
import Business.Airplane;
import Business.AirplaneFleet;
import Business.FleetSchedule;
import Business.Person;
import Business.PlaneDetails;
import Business.Seat;
import Business.TravelAgency;
import Interface.*;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class SeatBooking extends javax.swing.JPanel {

    private TravelAgency travelAgency;
    private JPanel userProcessContainer;
    private PlaneDetails planeDetails;

    public SeatBooking( TravelAgency travelAgency,JPanel userProcessContainer , PlaneDetails planeDetails) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.travelAgency = travelAgency;
        this.planeDetails = planeDetails ;
        populateTable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bookSeatButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        seatsTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        custTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(925, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(55, 96, 128));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select Seats For Booking");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 841, -1));

        bookSeatButton.setBackground(new java.awt.Color(0, 0, 0));
        bookSeatButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        bookSeatButton.setText("Book");
        bookSeatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSeatButtonActionPerformed(evt);
            }
        });
        add(bookSeatButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 240, 50));

        seatsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seat", "Price", "FlightId"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(seatsTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 87, 380, 320));

        custTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Id", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(custTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 550, 150));
    }// </editor-fold>//GEN-END:initComponents
    private void intitialTextField() {

    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) seatsTable.getModel();
        dtm.setRowCount(0);
        for(Seat s: planeDetails.getListOfSeats() )
        {
            if(!(s.isBooked()))
            {
                Object row[]=new Object[3];
                row[0]=s;
                row[1]=planeDetails.getPriceOfSeat();
                row[2]=planeDetails.getFlightId();
                dtm.addRow(row);
            }
        }
        dtm = (DefaultTableModel) custTable.getModel();
        dtm.setRowCount(0);
        for(Person p:travelAgency.getPersonDirectory().getListOfPerson())
        {
            Object row[] = new Object[2];
            row[0]=p;
            row[1]=p.getName();
            dtm.addRow(row);
        }
    }



    private void bookSeatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSeatButtonActionPerformed
        // TODO add your handling code here:
         int selectedCustomer = custTable.getSelectedRow();
        
           
         
  //      int selectedSeat= seatsTable.getSelectedRow();
    //     seatsTable.setRowSelectionAllowed(true);
    //     seatsTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        int [] selectedSeat= seatsTable.getSelectedRows();
        Seat seatBooked =null ;
        String multiSeat ="";
        if ((selectedCustomer < 0 ) || (selectedSeat.length < 0))
            JOptionPane.showMessageDialog(null, "Please select a customer from Customer Table and a seat from Seats Table for Booking the seat");
        else
        { 
            for (int i = 0; i < selectedSeat.length; i++) {
            Person p = (Person) custTable.getValueAt(selectedCustomer, 0);
            seatBooked = (Seat) seatsTable.getValueAt(selectedSeat[i], 0);
            multiSeat = multiSeat + " " + seatsTable.getValueAt(selectedSeat[i], 0).toString();
            seatBooked.setPerson(p);
            seatBooked.setBooked(true);
            p.addSeat(seatBooked);
            }
            
            JOptionPane.showMessageDialog(null, "Seat Booked Successfully");
            populateTable();
            
           ConfirmBooking confirmBooking = new ConfirmBooking(travelAgency,userProcessContainer,planeDetails, seatBooked , multiSeat);
           userProcessContainer.add("ConfirmBoking",confirmBooking);
           CardLayout cardLayout= (CardLayout) userProcessContainer.getLayout();
           cardLayout.next(userProcessContainer);
        }
        
    }//GEN-LAST:event_bookSeatButtonActionPerformed

    private void backButtonViewAllPlanesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonViewAllPlanesActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonViewAllPlanesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookSeatButton;
    private javax.swing.JTable custTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable seatsTable;
    // End of variables declaration//GEN-END:variables
}
