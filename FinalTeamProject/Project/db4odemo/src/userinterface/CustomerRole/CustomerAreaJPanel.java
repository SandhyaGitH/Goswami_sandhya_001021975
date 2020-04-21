/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Location;
import Business.Organizations.CustomerAgentOrganization;
import Business.Restaurant.Menu;
import Business.Restaurant.MenuDirectory;
import Business.Restaurant.Restaurant;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.Organizations.Organization;
import Business.Organizations.RegulatoryPolicyManagementOrganization;
import Business.WorkQueue.CustomerProductWorkRequest;
import Business.WorkQueue.InsuranceProductWorkRequest;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class CustomerAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;

    private UserAccount userAccount;
    private EcoSystem system;

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public CustomerAreaJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;

        this.userAccount = account;
        this.system = system;
        //valueLabel.setText(enterprise.getName());
        populateRequestTable();

        populateMenuTable();
    }

    private void populateMenuTable() {
        DefaultTableModel model = (DefaultTableModel) BMworkRequestJTable.getModel();

        model.setRowCount(0);
        for (Location network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.InsuranceCompany)) {
                    // for (Enterprise ent : enterprise.getOrganizaionDirectory().getOrganizationList()) {
                    for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
                        if (request != null) {
                            if (request.getClass().equals(Business.WorkQueue.InsuranceProductWorkRequest.class)) {
                                InsuranceProductWorkRequest iP = (InsuranceProductWorkRequest) request;
                                // InsuranceProductWorkRequest isr = wr;
                                if (iP.getApprovalStage() == null ? false : iP.getApprovalStage().equals("61")) {
                                    Object[] row = new Object[10];
                                    row[0] = iP.getNetwork();
                                    row[1] = iP.getEnterprise();
                                    row[3] = iP.getProductName();
                                    row[2] = iP.getInsuranceType();
                                    row[4] = iP.getPremuim();
                                    row[5] = iP.getCoverageAmount();
                                    row[6] = iP.getProductDescription();
                                    //row[7] = iP.getMessage();
                                    // row[8] = iP.getStatus();
                                    row[7] = iP;

                                    // row[9]=iP.
                                    model.addRow(row);
                                }
                            }
                        }
                        // }
                    }
                }
                /*  MenuDirectory mD = enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.InsuranceCompany);
                if (mD == null) {
                    break;
                } else {
                    for (Menu menu : mD.getMenuItemList()) {
                        if (menu != null) {
                            Object[] row = new Object[6];

                            row[0] = menu.getMenuItem();
                            row[1] = menu.getDescription();
                            row[2] = menu.getPrice();
                            row[3] = menu.getRestaurant();
                            row[4] = menu.getNetwork();

                            row[5] = menu.getIsavailable();

                            model.addRow(row);
                        }
                    }
                }
                 */
            }
        }

    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request.getClass().equals(CustomerProductWorkRequest.class)) {
                CustomerProductWorkRequest orderedProduct = (CustomerProductWorkRequest) request;
                Object[] row = new Object[4];
                row[0] = orderedProduct.getProductName();
                row[1] = orderedProduct.getInsuranceType();
                row[2] = orderedProduct.getStatus();
                // String result = ((LabTestWorkRequest) orderedProduct).getTestResult();
                // row[3] = result == null ? "Waiting" : result;

                model.addRow(row);
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

        requestTestJButton = new javax.swing.JButton();
        refreshTestJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        BMworkRequestJTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(240, 166, 232));

        requestTestJButton.setBackground(new java.awt.Color(51, 0, 51));
        requestTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        requestTestJButton.setText("Add to Cart");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        refreshTestJButton.setBackground(new java.awt.Color(51, 0, 51));
        refreshTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Insurance", "Insurance Type", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class
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
        jScrollPane2.setViewportView(workRequestJTable);

        BMworkRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Network", "Enterprise", "Type", "Name", "Premium", "Description", "Coverage Amount", "Request"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        jScrollPane4.setViewportView(BMworkRequestJTable);
        if (BMworkRequestJTable.getColumnModel().getColumnCount() > 0) {
            BMworkRequestJTable.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(requestTestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshTestJButton)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(319, 319, 319))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(refreshTestJButton)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requestTestJButton)
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
        String menuItemName = "";
        Restaurant restaurant;
        int selectedRow = BMworkRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a row first.");
            return;
        }
        if (selectedRow >= 0) {
            //menuItemName = BMworkRequestJTable.getValueAt(selectedRow, 0).toString();
            // Enterprise enterprise = (Enterprise) BMworkRequestJTable.getValueAt(selectedRow, 1);
            InsuranceProductWorkRequest request = (InsuranceProductWorkRequest) BMworkRequestJTable.getValueAt(selectedRow, 7);
            //  InsuranceProductWorkRequest custRequest = (InsuranceProductWorkRequest) BMworkRequestJTable.getValueAt(selectedRow, 7);
            if (request.getClass().equals(InsuranceProductWorkRequest.class)) {
                CustomerProductWorkRequest custRequest = new CustomerProductWorkRequest();
                custRequest.setApprovalStage(request.getApprovalStage());
                custRequest.setCoverageAmount(request.getCoverageAmount());
                custRequest.setEnterprise(request.getEnterprise());
                custRequest.setInsuranceType(request.getInsuranceType());
                custRequest.setNetwork(request.getNetwork());
                custRequest.setPremuim(request.getPremuim());
                custRequest.setProductDescription(request.getProductDescription());
                custRequest.setProductName(request.getProductName());
                //custRequest.setRequestDate(daet);
                custRequest.setSender(userAccount);

                custRequest.setApprovalStage("0");

                Organization org = null;

                for (Location network : system.getNetworkList()) {
                    for (Enterprise entp : network.getEnterpriseDirectory().getEnterpriseList()) {
                        if (entp.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.InsuranceBroker.getValue())) {
                            entp.getWorkQueue().getWorkRequestList().add(custRequest);
                            for (Organization organization : entp.getOrganizaionDirectory().getOrganizationList()) {
                                if (organization instanceof CustomerAgentOrganization) {
                                    org = organization;
                                    break;
                                }

                            }
                        }
                    }
                }

                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(custRequest);
                    custRequest.setStatus("Order Placed");
                    userAccount.getWorkQueue().getWorkRequestList().add(custRequest);
                } else {
                    JOptionPane.showMessageDialog(null, "Soory!! cannot place your order at this time.Could not found the further approval organization.");
                }
            }
        }
        populateRequestTable();


    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateRequestTable();

    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BMworkRequestJTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
