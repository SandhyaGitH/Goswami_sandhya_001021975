/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RegHealthManagerRole;

import userinterface.BusinessManagerRole.*;
import Business.EcoSystem;

import Business.UserAccount.UserAccount;
//import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Organizations.Organization;
import Business.WorkQueue.InsuranceProductWorkRequest;

/**
 *
 * @author raunak
 */
public class HealthInsuManagerWorkAreaJPane extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Organization organization;

    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public HealthInsuManagerWorkAreaJPane(JPanel userProcessContainer, UserAccount account, Organization org, EcoSystem business) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.organization = org;

        populateTable();
        populateBMTable();
        lblentp.setText("Organization: ");
        lblEnterpriseName.setText(org.getName());
        //assignJButton.setVisible(false);
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request.getClass().equals(Business.WorkQueue.InsuranceProductWorkRequest.class)) {
                String approvalStage = ((InsuranceProductWorkRequest) request).getApprovalStage() == null ? "-1" : ((InsuranceProductWorkRequest) request).getApprovalStage();
                if (approvalStage.equals("4")) {
                    Object[] row = new Object[10];
                    row[0] = request;
                    row[1] = request.getSender();//((LabTestWorkRequest) request).getPatient().getAge();
                    //row[2] = "";//((LabTestWorkRequest) request).getPatient().getSex();
                    row[2] = request.getMessage();
                    row[3] = request.getRequestDate(); //getReceiver() == null ? "" : request.getReceiver();

                    row[4] = ((InsuranceProductWorkRequest) request).getProductName();
                    row[5] = ((InsuranceProductWorkRequest) request).getProductDescription();
                    row[6] = request.getStatus();

                    row[7] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                    row[8] = ((InsuranceProductWorkRequest) request);
                    // row[9]=iP.
                    // row[4] = request.getSender().getUsername();

                    //  row[7] = ((LabTestWorkRequest) request).getPatient().getNewDrug();
                    model.addRow(row);
                }
            }
        }
    }

//     public void populateBMTable(){
//         DefaultTableModel model = (DefaultTableModel) BMworkRequestJTable1.getModel();
//
//        model.setRowCount(0);
//
//        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
//          
//            Object[] row = new Object[8];
//            
//            row[0] = request.getSender();//((LabTestWorkRequest) request).getPatient().getAge();
//            //row[2] = "";//((LabTestWorkRequest) request).getPatient().getSex();
//            row[1] = request.getMessage();
//            row[2] = request.getReceiver()==null? "":request.getReceiver();
//            row[3] = request.getStatus();
//            row[4] = ((LabTestWorkRequest) request);
//           // row[4] = request.getSender().getUsername();
//           // row[4] = "";//request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
//            
//          //  row[7] = ((LabTestWorkRequest) request).getPatient().getNewDrug();
//            model.addRow(row);
//        }
//    }
    public void populateBMTable() {
        DefaultTableModel model = (DefaultTableModel) BMworkRequestJTable1.getModel();

        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {

            if (request != null) {
                if (request.getClass().equals(Business.WorkQueue.InsuranceProductWorkRequest.class)) {
                    InsuranceProductWorkRequest iP = (InsuranceProductWorkRequest) request;
                    // InsuranceProductWorkRequest isr = wr;
                    Object[] row = new Object[10];
                    row[0] = iP.getNetwork();
                    row[1] = iP.getEnterprise();
                    row[2] = iP.getProductName();
                    row[3] = iP.getInsuranceType();
                    row[4] = iP.getPremuim();
                    row[5] = iP.getProductDescription();
                    row[6] = iP.getCoverageAmount();
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

        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        BMworkRequestJTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        lblEnterpriseName = new javax.swing.JLabel();
        lblentp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assignJButton.setBackground(new java.awt.Color(0, 0, 51));
        assignJButton.setForeground(new java.awt.Color(255, 255, 255));
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, -1, -1));

        processJButton.setBackground(new java.awt.Color(0, 0, 51));
        processJButton.setForeground(new java.awt.Color(255, 255, 255));
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 220, -1, -1));

        refreshJButton.setBackground(new java.awt.Color(0, 0, 51));
        refreshJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 50, -1, -1));

        BMworkRequestJTable1.setAutoCreateRowSorter(true);
        BMworkRequestJTable1.setBackground(new java.awt.Color(204, 204, 255));
        BMworkRequestJTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 51), new java.awt.Color(255, 255, 51)));
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
        BMworkRequestJTable1.setGridColor(new java.awt.Color(0, 0, 102));
        BMworkRequestJTable1.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jScrollPane4.setViewportView(BMworkRequestJTable1);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 1160, 270));

        workRequestJTable.setAutoCreateRowSorter(true);
        workRequestJTable.setBackground(new java.awt.Color(204, 204, 255));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Request Id", "Sender", "Message", "RequestDate", "Product Name", "Description", "Receiver", "Status", "Request Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.setGridColor(new java.awt.Color(0, 0, 51));
        workRequestJTable.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jScrollPane2.setViewportView(workRequestJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1160, 110));

        lblEnterpriseName.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEnterpriseName.setText("jLabel2");
        add(lblEnterpriseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 330, 30));

        lblentp.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        lblentp.setText("Enterprise:");
        add(lblentp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText(" New Approval Requests :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 240, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText(" My Pending and Processed Requests");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 290, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {

            JOptionPane.showMessageDialog(null, "Select a row first");
            return;
        }

        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);

        if (request.getClass().equals(InsuranceProductWorkRequest.class)) {
            InsuranceProductWorkRequest insReq = (InsuranceProductWorkRequest) request;
            // insReq.getApprovalStage().equals(ui)
            int stage = Integer.parseInt(((InsuranceProductWorkRequest) request).getApprovalStage() == null ? "-1" : ((InsuranceProductWorkRequest) request).getApprovalStage());
            switch (stage) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Proposed");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Pending under a Business manager.");
                    break;
                case 21:
                    ((InsuranceProductWorkRequest) request).setApprovalStage("3");
                    request.setReceiver(userAccount);
                    request.setStatus("Pending under " + userAccount);
                    userAccount.getWorkQueue().getWorkRequestList().add(request);
                    break;
                case 22:
                    JOptionPane.showMessageDialog(null, "Already Internally Rejected by BM");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Already has Forwarded Request to Further Approvals");
                    break;
                case 4:
                    ((InsuranceProductWorkRequest) request).setApprovalStage("5");
                    request.setReceiver(userAccount);
                    request.setStatus("Pending under " + userAccount);
                    userAccount.getWorkQueue().getWorkRequestList().add(request);
                    break;
                case 5:
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Already Pending under Final IRDA approval team. Do you want to reassign it?", "Warning", dialogButton);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        ((InsuranceProductWorkRequest) request).setApprovalStage("5");
                        request.setReceiver(userAccount);
                        request.setStatus("Pending under " + userAccount);
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                    }
                    break;
                case 61:
                    JOptionPane.showMessageDialog(null, "Aproved by IRDA approval team.");
                    break;
                case 62:
                    JOptionPane.showMessageDialog(null, "Rejected by IRDA approval team.");
                    break;
                default:
                    break;

            }
        }

        /*if(request.getReceiver().equals(userAccount)){  JOptionPane.showMessageDialog(null,"Already Assigned");
           return;
             } */
        populateTable();
        populateBMTable();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = BMworkRequestJTable1.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a row first");
            return;
        }

        InsuranceProductWorkRequest request = (InsuranceProductWorkRequest) BMworkRequestJTable1.getValueAt(selectedRow, 9);
        if (request.getStatus().equals("Completed")) {
            JOptionPane.showMessageDialog(null, "Already completed");
            return;
        }
        if (request.getStatus().equals("Rejected")) {
            JOptionPane.showMessageDialog(null, "Already Rejected");
            return;
        }
        // request.setStatus("Processing");

        int stage = Integer.parseInt(((InsuranceProductWorkRequest) request).getApprovalStage() == null ? "-1" : ((InsuranceProductWorkRequest) request).getApprovalStage());

        switch (stage) {
            case 0:
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Already IRDA Policy Manager has Forwarded Request for Further Approvals");
                break;
            case 5:
                ProcessWorkRequestJPanel processWorkRequestJPanel = new ProcessWorkRequestJPanel(userProcessContainer, request, business);
                userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
                break;
            case 61:
                JOptionPane.showMessageDialog(null, "Aproved by IRDA approval team.");
                break;
            case 62:
                JOptionPane.showMessageDialog(null, "Rejected by IRDA approval team.");
                break;
            default:
                break;
        }


    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BMworkRequestJTable1;
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblEnterpriseName;
    private javax.swing.JLabel lblentp;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
