/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RegPolicyManagerRole;

//import userinterface.BusinessManagerRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organizations.HealthInsuranceRegulatoryOrganization;
import Business.Organizations.LifeInsuranceRegulatoryOrganization;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Organizations.Organization;
import Business.Organizations.VehicleInsuranceRegulatoryOrganization;
import Business.WorkQueue.InsuranceProductWorkRequest;

/**
 *
 * @author raunak
 */
public class RegPolicyManagerWorkAreaJPane extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;

    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public RegPolicyManagerWorkAreaJPane(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization org, EcoSystem business) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.organization = org;
        this.enterprise = enterprise;
        lblEnterpriseName.setText(enterprise.getName());
        populateAllRequestTable();
        populateMyPendingTable();
        
        //assignJButton.setVisible(false);
        processJButton.setVisible(false);
    }

    public void populateAllRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequeststable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request.getClass().equals(Business.WorkQueue.InsuranceProductWorkRequest.class)) {
                String approvalStage = ((InsuranceProductWorkRequest) request).getApprovalStage() == null ? "-1" : ((InsuranceProductWorkRequest) request).getApprovalStage();
                if (approvalStage.equals("21")) {
                    Object[] row = new Object[10];
                    row[0] = request;
                    row[1] = request.getSender();//((LabTestWorkRequest) request).getPatient().getAge();
                    //row[2] = "";//((LabTestWorkRequest) request).getPatient().getSex();
                    row[2] = request.getMessage();
                    row[3] = request.getRequestDate(); //getReceiver() == null ? "" : request.getReceiver();

                    row[4] = ((InsuranceProductWorkRequest) request).getProductName();
                    row[5] = ((InsuranceProductWorkRequest) request).getProductDescription();
                    row[6] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();

                    row[7] = request.getStatus();
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
    public void populateMyPendingTable() {
        DefaultTableModel model = (DefaultTableModel) BMworkRequestJTable1.getModel();

        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {

            if (request != null) {
                if (request.getClass().equals(Business.WorkQueue.InsuranceProductWorkRequest.class)) {
                    InsuranceProductWorkRequest iP = (InsuranceProductWorkRequest) request;
                    // InsuranceProductWorkRequest isr = wr;
                    Object[] row = new Object[11];
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
                    row[10]= iP.getRequestDate();
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
        ForwardJButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        BMworkRequestJTable1 = new javax.swing.JTable();
        lblEnterpriseName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequeststable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

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
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 60, -1, -1));

        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, -1, -1));

        refreshJButton.setBackground(new java.awt.Color(0, 0, 51));
        refreshJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 60, -1, -1));

        ForwardJButton.setBackground(new java.awt.Color(0, 0, 51));
        ForwardJButton.setForeground(new java.awt.Color(255, 255, 255));
        ForwardJButton.setText("Forward");
        ForwardJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForwardJButtonActionPerformed(evt);
            }
        });
        add(ForwardJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 250, -1, -1));

        BMworkRequestJTable1.setAutoCreateRowSorter(true);
        BMworkRequestJTable1.setBackground(new java.awt.Color(204, 204, 255));
        BMworkRequestJTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 51), new java.awt.Color(255, 255, 51)));
        BMworkRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Network", "Enterprise", "Name", "Type", "Premium", "Description", "Coverage Amount", "Message", "Status", "Request", "Request Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BMworkRequestJTable1.setGridColor(new java.awt.Color(0, 0, 51));
        BMworkRequestJTable1.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jScrollPane4.setViewportView(BMworkRequestJTable1);
        if (BMworkRequestJTable1.getColumnModel().getColumnCount() > 0) {
            BMworkRequestJTable1.getColumnModel().getColumn(9).setResizable(false);
        }

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 1160, 240));

        lblEnterpriseName.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEnterpriseName.setText("jLabel2");
        add(lblEnterpriseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 370, 30));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel2.setText("Enterprise");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText(" My Pending and Processed Requests");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 290, -1));

        workRequeststable.setAutoCreateRowSorter(true);
        workRequeststable.setBackground(new java.awt.Color(204, 204, 255));
        workRequeststable.setModel(new javax.swing.table.DefaultTableModel(
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
        workRequeststable.setGridColor(new java.awt.Color(0, 0, 51));
        workRequeststable.setSelectionBackground(new java.awt.Color(0, 0, 51));
        jScrollPane2.setViewportView(workRequeststable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1160, 110));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText(" New Approval Requests :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 240, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequeststable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        }

        WorkRequest request = (WorkRequest) workRequeststable.getValueAt(selectedRow, 0);
        /* if (request.getReceiver().equals(userAccount)) {
            JOptionPane.showMessageDialog(null, "Already Assigned");
            return;
        } else if (request.getStatus().equals("Assigned to HR team")) {
            JOptionPane.showMessageDialog(null, "Already Forwarded");
            return;
        } else if (request.getStatus().equals("Assigned to LIR team")) {
            JOptionPane.showMessageDialog(null, "Already Forwarded");
            return;
        } else if (request.getStatus().equals("Assigned to VR team")) {
            JOptionPane.showMessageDialog(null, "Already Forwarded");
            return;
        } */

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
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Already Pending under a IRDA Policy Manager. Do you want to reassign it?", "Warning", dialogButton);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        ((InsuranceProductWorkRequest) request).setApprovalStage("3");
                        request.setReceiver(userAccount);
                        request.setStatus("Pending under " + userAccount);
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Already IRDA Policy Manager has Forwarded Request for Further Approvals");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Pending under Final IRDA approval team.");
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

        populateAllRequestTable();
        populateMyPendingTable();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = BMworkRequestJTable1.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        }

        LabTestWorkRequest request = (LabTestWorkRequest) BMworkRequestJTable1.getValueAt(selectedRow, 4);
        if (request.getStatus().equals("Completed")) {
            JOptionPane.showMessageDialog(null, "Already compeleted");
            return;
        }
        if (request.getStatus().equals("Rejected")) {
            JOptionPane.showMessageDialog(null, "Already Rejected");
            return;
        }
        request.setStatus("Processing");

        ProcessWorkRequestJPanel processWorkRequestJPanel = new ProcessWorkRequestJPanel(userProcessContainer, request, business);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateAllRequestTable();
        populateMyPendingTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void ForwardJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForwardJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = BMworkRequestJTable1.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "select a row.");
            return;
        }

        WorkRequest request = (WorkRequest) BMworkRequestJTable1.getValueAt(selectedRow, 9);

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

                    Organization org = null;
                    OUTER:
                    for (Organization organisation : enterprise.getOrganizaionDirectory().getOrganizationList()) {
                        switch (((InsuranceProductWorkRequest) request).getInsuranceType()) {
                            case Health:
                                if (organisation instanceof HealthInsuranceRegulatoryOrganization) {
                                    org = organisation;
                                    request.setStatus("Assigned to HR team");
                                    break OUTER;
                                }
                                break;
                            case Life:
                                if (organisation instanceof LifeInsuranceRegulatoryOrganization) {
                                    org = organisation;
                                    request.setStatus("Assigned to LIR team");
                                    break OUTER;
                                }
                                break;
                            case Vehicle:
                                if (organisation instanceof VehicleInsuranceRegulatoryOrganization) {
                                    org = organisation;
                                    request.setStatus("Assigned to VR team");
                                    break OUTER;
                                }
                                break;
                            default:
                                break;
                        }
                    }

                    if (org != null) {
                        org.getWorkQueue().getWorkRequestList().add(request);
                        JOptionPane.showMessageDialog(null, request.getStatus());
                        request.setReceiver(userAccount);
                        ((InsuranceProductWorkRequest) request).setApprovalStage("4");
                        //  userAccount.getWorkQueue().getWorkRequestList().add(request);
                         //   JOptionPane.showMessageDialog(null, request.getStatus());
                    }
                    else   JOptionPane.showMessageDialog(null, "Could not found the organization. Please contact to Enterprise admin");

                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Already IRDA Policy Manager has Forwarded Request for Further Approvals");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Pending under Final IRDA approval team.");
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

        populateAllRequestTable();
        populateMyPendingTable();

    }//GEN-LAST:event_ForwardJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BMworkRequestJTable1;
    private javax.swing.JButton ForwardJButton;
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblEnterpriseName;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequeststable;
    // End of variables declaration//GEN-END:variables
}
