/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.ManageAirlines;

import Business.Airline;
import Business.AirplaneFleet;
import Business.FleetSchedule;
import Business.PlaneDetails;
import Business.TravelAgency;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class ViewAllFlightsPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAllFlightsPanel
     */
    private TravelAgency travelAgency;
    private JPanel userProcessContainer;
    private ArrayList<PlaneDetails> tempList;

    public ViewAllFlightsPanel(TravelAgency travelAgency, JPanel userProcessContainer) {
        this.travelAgency = travelAgency;
        this.userProcessContainer = userProcessContainer;
        tempList = new ArrayList<PlaneDetails>();
        initComponents();
        populateTable();
    }

    public void tempFlightList() {
        for (FleetSchedule fs : travelAgency.getSchedule().getListOfFlightSchedules()) {
            for (PlaneDetails f : fs.getListOfFlight()) {
                tempList.add(f);
            }
        }
    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) listAllPlaneTable.getModel();
        dtm.setRowCount(0);
        for (FleetSchedule fs : travelAgency.getSchedule().getListOfFlightSchedules()) {
            for (PlaneDetails f : fs.getListOfFlight()) {
                Object row[] = new Object[8];
                row[0] = f;
                row[1] = f.getFlightId();
                row[2] = f.getDepatureDate();
                row[3] = f.getDepatureTime();
                row[4] = f.getDepaturePort();
                row[5] = f.getDestinationPort();
                row[6] = f.getPriceOfSeat();
                if (f.isCancelFlag()) {
                    row[7] = "Canceled";
                    dtm.addRow(row);
                } else {
                    row[7] = "Available";
                    dtm.addRow(row);
                }

            }
        }

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
        listAllPlaneTable = new javax.swing.JTable();
        backButtonViewAllPlanes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cancelFlightButton = new javax.swing.JButton();
        viewFlightButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 102, 102));
        setPreferredSize(new java.awt.Dimension(900, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listAllPlaneTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airline", "Flight Id", "Date", "Time", "From", "To", "Price/Seat", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listAllPlaneTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 624, 275));

        backButtonViewAllPlanes.setBackground(new java.awt.Color(0, 0, 0));
        backButtonViewAllPlanes.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        backButtonViewAllPlanes.setForeground(new java.awt.Color(255, 255, 255));
        backButtonViewAllPlanes.setText("Back");
        backButtonViewAllPlanes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonViewAllPlanesActionPerformed(evt);
            }
        });
        add(backButtonViewAllPlanes, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 35, 180, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("List of all the Planes");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 813, -1));

        cancelFlightButton.setBackground(new java.awt.Color(0, 0, 0));
        cancelFlightButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        cancelFlightButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelFlightButton.setText("Cancel Flight");
        cancelFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelFlightButtonActionPerformed(evt);
            }
        });
        add(cancelFlightButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 190, 40));

        viewFlightButton.setBackground(new java.awt.Color(0, 0, 0));
        viewFlightButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        viewFlightButton.setForeground(new java.awt.Color(255, 255, 255));
        viewFlightButton.setText("View");
        viewFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewFlightButtonActionPerformed(evt);
            }
        });
        add(viewFlightButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 190, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonViewAllPlanesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonViewAllPlanesActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonViewAllPlanesActionPerformed

    private void cancelFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelFlightButtonActionPerformed
        // TODO add your handling code here:
        int selectedItem = listAllPlaneTable.getSelectedRow();
        if (selectedItem < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
        } else {
            PlaneDetails planeDetails = (PlaneDetails) listAllPlaneTable.getValueAt(selectedItem, 0);
            planeDetails.setCancelFlag(true);
            populateTable();
        }

//         if(planeDetails.isCancelFlag())
//        {
//            planeDetails.setCancelFlag(false);
//            JOptionPane.showMessageDialog(null,"Flight is Available now");
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(null,"Flight is already Available press CancelFlight to cancel flight");
//        }
    }//GEN-LAST:event_cancelFlightButtonActionPerformed

    private void viewFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewFlightButtonActionPerformed
        // TODO add your handling code here:
        int selectedItem = listAllPlaneTable.getSelectedRow();
        if (selectedItem < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
        } else {
            PlaneDetails planeDetails = (PlaneDetails) listAllPlaneTable.getValueAt(selectedItem, 0);
            ViewScheduledPlanesJPanel viewscheduledFlight = new ViewScheduledPlanesJPanel(planeDetails, userProcessContainer);
            userProcessContainer.add("ViewScheduledFightJPanel", viewscheduledFlight);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
//              Account account = (Account)accountTable.getValueAt(selectedItem, 0);
//               ViewAccountJPanel viewPanel = new ViewAccountJPanel(userProcessContainer, account);
//               userProcessContainer.add("ViewAccountJPanel",viewPanel);
//               CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//               layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_viewFlightButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButtonViewAllPlanes;
    private javax.swing.JButton cancelFlightButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listAllPlaneTable;
    private javax.swing.JButton viewFlightButton;
    // End of variables declaration//GEN-END:variables
}
