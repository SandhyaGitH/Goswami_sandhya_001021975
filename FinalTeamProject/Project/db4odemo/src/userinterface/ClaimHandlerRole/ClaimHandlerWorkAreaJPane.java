/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ClaimHandlerRole;

import Business.EcoSystem;

import Business.UserAccount.UserAccount;

import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Organizations.Organization;
import Business.WorkQueue.CustomerProductWorkRequest;
import Business.WorkQueue.HospitalPaymentSettlementWorkRequest;

import java.awt.Color;
import java.util.Date;

/**
 *
 * @author raunak
 */
public class ClaimHandlerWorkAreaJPane extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Organization organization;

    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public ClaimHandlerWorkAreaJPane(JPanel userProcessContainer, UserAccount account, Organization org, EcoSystem business) {
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
        DefaultTableModel model = (DefaultTableModel) workRequesttable.getModel();
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {

            if (request.getClass().equals(Business.WorkQueue.HospitalPaymentSettlementWorkRequest.class)) {

                HospitalPaymentSettlementWorkRequest pHR = (HospitalPaymentSettlementWorkRequest) request;
                if (pHR.getApprovalStage().equals("0") && !pHR.getApprovalStage().equals("")) {
                    Object[] row = new Object[8];

                    row[0] = pHR.getSender();//((LabTestWorkRequest) request).getPatient().getAge();
                    //row[2] = "";//((LabTestWorkRequest) request).getPatient().getSex();
                    row[1] = pHR.getHospitalName();
                    // row[2] = request.getReceiver() == null ? "" : request.getReceiver();
                    row[2] = pHR.getPolicy();
                    row[3] = pHR.getPolicy().getCustomerName();
                    row[4] = pHR.getStatus();
                    row[5] = request;
                    row[6] = pHR.getRequestDate();
                    // row[4] = request.getSender().getUsername();
                    // row[4] = "";//request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();

                    //  row[7] = ((LabTestWorkRequest) request).getPatient().getNewDrug();
                    model.addRow(row);
                }
            }
        }
    }

    public void populateBMTable() {
        DefaultTableModel model = (DefaultTableModel) CMworkRequestJTable1.getModel();

        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {

            if (request != null) {
                if (request.getClass().equals(Business.WorkQueue.HospitalPaymentSettlementWorkRequest.class)) {
                    HospitalPaymentSettlementWorkRequest iP = (HospitalPaymentSettlementWorkRequest) request;
                    // InsuranceProductWorkRequest isr = wr;
                    Object[] row = new Object[10];
                    row[0] = iP.getSettlementRequestIdStr();
                    row[1] = iP.getPolicy().getCustomerName();
                    row[2] = iP.getPolicy().getEnterpriseName();
                    row[3] = iP.getDiagnosis();
                    row[4] = iP.getBillAmout();
                    //row[5] = iP.;
                    // row[6] = iP.getProductDescription(); 
                    // row[7] = iP.getMessage();
                    row[5] = iP.getStatus();
                    row[6] = iP;
                    row[7] = iP.getRequestDate();
                    row[8] = iP.getTestResult();

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

        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        workRequesttable = new javax.swing.JTable();
        RejectJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        messgaetextarea = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        CMworkRequestJTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assignJButton.setBackground(new java.awt.Color(102, 51, 0));
        assignJButton.setForeground(new java.awt.Color(255, 255, 255));
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 100, -1));

        processJButton.setBackground(new java.awt.Color(102, 51, 0));
        processJButton.setForeground(new java.awt.Color(255, 255, 255));
        processJButton.setText("Approve");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, -1, -1));

        refreshJButton.setBackground(new java.awt.Color(102, 51, 0));
        refreshJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        workRequesttable.setAutoCreateRowSorter(true);
        workRequesttable.setBackground(new java.awt.Color(255, 255, 153));
        workRequesttable.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 51, 0), new java.awt.Color(255, 153, 51)));
        workRequesttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sender", "Hospital Name", "Policy", "Customer", "Status", "Request", "RequestDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequesttable.setGridColor(new java.awt.Color(102, 51, 0));
        workRequesttable.setSelectionBackground(new java.awt.Color(153, 51, 0));
        jScrollPane4.setViewportView(workRequesttable);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 790, 140));

        RejectJButton.setBackground(new java.awt.Color(102, 51, 0));
        RejectJButton.setForeground(new java.awt.Color(255, 255, 255));
        RejectJButton.setText("Reject");
        RejectJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RejectJButtonActionPerformed(evt);
            }
        });
        add(RejectJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 220, 70, -1));

        messgaetextarea.setColumns(20);
        messgaetextarea.setRows(5);
        messgaetextarea.setText("Type your message here");
        jScrollPane2.setViewportView(messgaetextarea);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 190, 160));

        CMworkRequestJTable1.setAutoCreateRowSorter(true);
        CMworkRequestJTable1.setBackground(new java.awt.Color(255, 255, 153));
        CMworkRequestJTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 51, 0), new java.awt.Color(255, 255, 102)));
        CMworkRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RequestId", "Customer Name", "Enterprise", "Daignosis", "Bill amount", "Status", "Request", "RequestDate", "Message"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CMworkRequestJTable1.setGridColor(new java.awt.Color(102, 51, 0));
        CMworkRequestJTable1.setSelectionBackground(new java.awt.Color(102, 51, 0));
        jScrollPane5.setViewportView(CMworkRequestJTable1);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 990, 170));

        jLabel1.setBackground(new java.awt.Color(102, 51, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 0));
        jLabel1.setText(" Pending and Processed Claims");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 270, 20));

        jLabel2.setBackground(new java.awt.Color(102, 51, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 51, 0));
        jLabel2.setText(" Claim Requests");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));
    }// </editor-fold>//GEN-END:initComponents

    private int sumClaimedAmount(String custUserName) {
        int TotalClaimedTillNow = 0;
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if (wr.getClass().equals(HospitalPaymentSettlementWorkRequest.class)) {
                if (wr != null) {
                    if (((HospitalPaymentSettlementWorkRequest) wr).getApprovalStage().equals("21")
                            && ((HospitalPaymentSettlementWorkRequest) wr).getPolicy().getCustomerName().equals(custUserName)) {
                        TotalClaimedTillNow = TotalClaimedTillNow + Integer.parseInt(((HospitalPaymentSettlementWorkRequest) wr).getBillAmout());
                    }
                }
            }
        }
        return TotalClaimedTillNow;
    }

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequesttable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        }

        WorkRequest request = (WorkRequest) workRequesttable.getValueAt(selectedRow, 5);
        if (request.getClass().equals(HospitalPaymentSettlementWorkRequest.class)) {
            int stage = Integer.parseInt(((HospitalPaymentSettlementWorkRequest) request).getApprovalStage() == null ? "-1" : ((HospitalPaymentSettlementWorkRequest) request).getApprovalStage());
            switch (stage) {
                case 11:
                    JOptionPane.showMessageDialog(null, "Claim Request rolled back by the hospital.");
                    break;
                case 0:
                    request.setReceiver(userAccount);
                    request.setStatus("Pending under " + userAccount);
                    ((HospitalPaymentSettlementWorkRequest) request).setApprovalStage("2");
                    userAccount.getWorkQueue().getWorkRequestList().add(request);
                    break;
                case 2:
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Already Pending under a Claim Hadler. Do you want to reassign it?", "Warning", dialogButton);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        request.setReceiver(userAccount);
                        request.setStatus("Pending under" + userAccount);
                        ((HospitalPaymentSettlementWorkRequest) request).setApprovalStage("2");
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                    }
                    break;
                case 21:
                    JOptionPane.showMessageDialog(null, "Already  Approved");
                    break;
                case 22:
                    JOptionPane.showMessageDialog(null, "Cannot Approve Rejected Request");
                    break;

                default:
                    break;

            }
        }
        populateTable();
        populateBMTable();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = CMworkRequestJTable1.getSelectedRow();

        if (selectedRow < 0) {

            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        }

        HospitalPaymentSettlementWorkRequest request = (HospitalPaymentSettlementWorkRequest) CMworkRequestJTable1.getValueAt(selectedRow, 6);

        if (request.getClass().equals(HospitalPaymentSettlementWorkRequest.class)) {
            int stage = Integer.parseInt(((HospitalPaymentSettlementWorkRequest) request).getApprovalStage());
            switch (stage) {
                case 11:
                    JOptionPane.showMessageDialog(null, "Hospital has Cancelled Request");
                    break;
                case 0:
                    break;
                case 2:
                    int CoveredAmount = Integer.parseInt(((HospitalPaymentSettlementWorkRequest) request).getPolicy().getCustProdWQ().getCoverageAmount());
                    int ClaimedAmount = sumClaimedAmount(((HospitalPaymentSettlementWorkRequest) request).getPolicy().getCustomerName()) + Integer.parseInt(((HospitalPaymentSettlementWorkRequest) request).getBillAmout());
                    if (CoveredAmount < ClaimedAmount) {
                        request.setTestResult("Total Claimed amount against this policy has crossed the limit.");
                        request.setStatus("Claim Rejected. No Insurance Balance");
                        ((HospitalPaymentSettlementWorkRequest) request).setApprovalStage("22");
                        JOptionPane.showMessageDialog(null, "Policy has reached to its Covered Amount.");
                        populateBMTable();
                        populateTable();
                        return;
                    }
                    if (messgaetextarea.getText().length() > 100) {
                        JOptionPane.showMessageDialog(null, "Message limit is 100 words only");
                        return;
                    }
                    request.setTestResult(messgaetextarea.getText());
                    request.setStatus("Claim Approved.");
                    ((HospitalPaymentSettlementWorkRequest) request).setApprovalStage("21");
                    JOptionPane.showMessageDialog(null, "Claim Approved.");
                    Date dt = new Date();
                    request.setResolveDate(dt);
                    break;
                case 21:
                    JOptionPane.showMessageDialog(null, "Already Claim Approved.");
                    break;
                case 22:
                    JOptionPane.showMessageDialog(null, "Already Claim Rejected.");
                    break;
                default:
                    break;

            }
        }
        populateBMTable();
        populateTable();
    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateBMTable();
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void RejectJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RejectJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = CMworkRequestJTable1.getSelectedRow();

        if (selectedRow < 0) {

            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        }

        HospitalPaymentSettlementWorkRequest request = (HospitalPaymentSettlementWorkRequest) CMworkRequestJTable1.getValueAt(selectedRow, 6);

        if (request.getClass().equals(HospitalPaymentSettlementWorkRequest.class)) {
            int stage = Integer.parseInt(((HospitalPaymentSettlementWorkRequest) request).getApprovalStage());
            switch (stage) {
                case 11:
                    JOptionPane.showMessageDialog(null, "Hospital has Cancelled Request");
                    break;
                case 0:
                    break;
                case 2:
                    if (messgaetextarea.getText().length() > 100) {
                        JOptionPane.showMessageDialog(null, "Message limit is 100 words only");
                        return;
                    }
                    request.setTestResult(messgaetextarea.getText());
                    request.setStatus("Claim Rejected.");
                    ((HospitalPaymentSettlementWorkRequest) request).setApprovalStage("22");
                    JOptionPane.showMessageDialog(null, "Claim Rejected.");
                    break;
                case 21:
                    JOptionPane.showMessageDialog(null, "Already Claim Approved.");
                    break;
                case 22:
                    JOptionPane.showMessageDialog(null, "Already Claim Rejected.");
                    break;
                default:
                    break;

            }
        }
        populateBMTable();
        populateTable();
    }//GEN-LAST:event_RejectJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CMworkRequestJTable1;
    private javax.swing.JButton RejectJButton;
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea messgaetextarea;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequesttable;
    // End of variables declaration//GEN-END:variables
}
