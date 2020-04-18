/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.BillingAgentRole;

import userinterface.UnderwriterRole.*;
import userinterface.BusinessManagerRole.*;
import Business.EcoSystem;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Organizations.Organization;
import Business.WorkQueue.CustomerProductWorkRequest;
import Business.WorkQueue.InsuranceProductWorkRequest;

/**
 *
 * @author raunak
 */
public class BillingAgentWorkAreaJPane extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Organization organization;

    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public BillingAgentWorkAreaJPane(JPanel userProcessContainer, UserAccount account, Organization org, EcoSystem business) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.organization = org;

        populateTable();
        populateBMTable();
        //assignJButton.setVisible(false);
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {

            if (request.getClass().equals(Business.WorkQueue.CustomerProductWorkRequest.class)) {
                Object[] row = new Object[8];

                row[0] = request.getSender();//((LabTestWorkRequest) request).getPatient().getAge();
                //row[2] = "";//((LabTestWorkRequest) request).getPatient().getSex();
                row[1] = request.getMessage();
                row[2] = request.getReceiver() == null ? "" : request.getReceiver();
                row[3] = request.getStatus();
                row[4] = ((CustomerProductWorkRequest) request);
                // row[4] = request.getSender().getUsername();
                // row[4] = "";//request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();

                //  row[7] = ((LabTestWorkRequest) request).getPatient().getNewDrug();
                model.addRow(row);
            }
        }
    }

    public void populateBMTable() {
        DefaultTableModel model = (DefaultTableModel) BMworkRequestJTable1.getModel();

        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {

            if (request != null) {
                if (request.getClass().equals(Business.WorkQueue.CustomerProductWorkRequest.class)) {
                    CustomerProductWorkRequest iP = (CustomerProductWorkRequest) request;
                    // InsuranceProductWorkRequest isr = wr;
                    Object[] row = new Object[10];
                    row[0] = iP.getNetwork();
                    row[1] = iP.getEnterprise();
                    row[2] = iP.getProductName();
                    row[3] = iP.getInsuranceType();
                    row[4] = iP.getPremuim();
                    row[5] = iP.getCoverageAmount();
                    row[6] = iP.getProductDescription();
                    row[7] = iP.getMessage();
                    row[8] = iP.getStatus();
                    row[9] = iP;
                    // row[9]=iP.

                    model.addRow(row);
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
        workRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        BMworkRequestJTable1 = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sender", "Message", "Receiver", "Status", "Request Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 570, 96));

        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, -1));

        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, -1, -1));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, -1));

        BMworkRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Network", "Enterprise", "Name", "Type", "Premium", "Description", "Coverage Amount", "Message", "Status", "Request"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(BMworkRequestJTable1);
        if (BMworkRequestJTable1.getColumnModel().getColumnCount() > 0) {
            BMworkRequestJTable1.getColumnModel().getColumn(9).setResizable(false);
        }

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 880, 110));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        }

        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 4);
        if (request.getClass().equals(CustomerProductWorkRequest.class)) {
            int stage = Integer.parseInt(((CustomerProductWorkRequest) request).getApprovalStage() == null ? "-1" : ((InsuranceProductWorkRequest) request).getApprovalStage());
            switch (stage) {
                case 0:
                    request.setReceiver(userAccount);
                    request.setStatus("Pending under" + userAccount);
                    ((CustomerProductWorkRequest) request).setApprovalStage("1");
                    userAccount.getWorkQueue().getWorkRequestList().add(request);
                    break;
                case 1:
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Already Pending under a Business manager. Do you want to reassign it?", "Warning", dialogButton);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        request.setReceiver(userAccount);
                        request.setStatus("Pending under" + userAccount);
                        ((CustomerProductWorkRequest) request).setApprovalStage("1");
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                    }
                    break;
                case 21:
                    JOptionPane.showMessageDialog(null, "Already Sent to IRDA");
                    break;
                case 22:
                    JOptionPane.showMessageDialog(null, "Already Internally Rejected by BM");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Already Pending under a IRDA Policy Manager");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Already IRDA Policy Manager has Forwarded Request for Further Approvals");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Pending under Final IRDA approval team.");
                    break;
                case 61:
                    JOptionPane.showMessageDialog(null, "Aproved by IRDA approval team.");
                case 62:
                    JOptionPane.showMessageDialog(null, "Rejected by IRDA approval team.");
                    break;
                default:
                    break;

            }
            /* if (request.getReceiver().equals(userAccount)) {
            JOptionPane.showMessageDialog(null, "Already Assigned");
            return;
        } else if (request.getStatus().equals("Completed")) {
            JOptionPane.showMessageDialog(null, "Already Completed");
            return;
        } */
        }
        populateTable();
        populateBMTable();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = BMworkRequestJTable1.getSelectedRow();

        if (selectedRow < 0) {

            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        }

        InsuranceProductWorkRequest request = (InsuranceProductWorkRequest) BMworkRequestJTable1.getValueAt(selectedRow, 9);

        // request.setStatus("Approved by BM");
        ProcessWorkRequestJPanel processWorkRequestJPanel = new ProcessWorkRequestJPanel(userProcessContainer, request, business);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BMworkRequestJTable1;
    private javax.swing.JButton assignJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
