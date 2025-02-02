/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerAgentRole;

import userinterface.UnderwriterRole.*;
import userinterface.BusinessManagerRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;

import Business.UserAccount.UserAccount;
//import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Organizations.Organization;
import Business.WorkQueue.CustomerProductWorkRequest;
import Business.WorkQueue.InsuranceProductWorkRequest;

import static Business.SendMail.send;

/**
 *
 * @author raunak
 */
public class CustomerAgentWorkAreaJPane extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;

    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public CustomerAgentWorkAreaJPane(JPanel userProcessContainer, UserAccount account, Organization org, EcoSystem business, Enterprise inEnterprise) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.organization = org;
        this.enterprise=inEnterprise;

        populateTable();
        populateBMTable();
        lblEnterpriseName.setText(inEnterprise.getName());
        // txtSubject.setEnabled(false);
        txtTo.setEnabled(false);
        // txtmessage.setEnabled(false);
        // txtmessage.getParent().setVisible(false);
        SendMailJButton.setEnabled(false);
        //assignJButton.setVisible(false);
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {

            if (request.getClass().equals(Business.WorkQueue.CustomerProductWorkRequest.class)) {
                
                CustomerProductWorkRequest custReq = (CustomerProductWorkRequest)request;
                if(custReq.getApprovalStage().equals("0"))
                        {
                Object[] row = new Object[8];

                row[0] = custReq.getSender();//((LabTestWorkRequest) request).getPatient().getAge();
                //row[2] = "";//((LabTestWorkRequest) request).getPatient().getSex();
                
                row[1] = custReq.getCustomerName();
                row[2]=custReq.getProductName();
                row[3] = request.getReceiver() == null ? "" : request.getReceiver();
                row[4] = request.getStatus();
                row[5] = custReq;
                row[6]=custReq.getRequestDate();
                // row[4] = request.getSender().getUsername();
                // row[4] = "";//request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();

                //  row[7] = ((LabTestWorkRequest) request).getPatient().getNewDrug();
                model.addRow(row);
                        }
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
        SendMailJButton = new javax.swing.JButton();
        txtTo = new javax.swing.JTextField();
        lblTo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtmessage = new javax.swing.JTextArea();
        lblmsg = new javax.swing.JLabel();
        txtSubject = new javax.swing.JTextField();
        lblsubject = new javax.swing.JLabel();
        ContactJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblEnterpriseName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 247, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setAutoCreateRowSorter(true);
        workRequestJTable.setBackground(new java.awt.Color(255, 204, 102));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sender", "Customer Name", "Policy Name", "Receiver", "Status", "Request ID", "Request Date"
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
        workRequestJTable.setGridColor(new java.awt.Color(255, 255, 102));
        workRequestJTable.setSelectionBackground(new java.awt.Color(102, 51, 0));
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 880, 160));

        assignJButton.setBackground(new java.awt.Color(102, 51, 0));
        assignJButton.setForeground(new java.awt.Color(255, 255, 255));
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        processJButton.setBackground(new java.awt.Color(102, 51, 0));
        processJButton.setForeground(new java.awt.Color(255, 255, 255));
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, -1, -1));

        refreshJButton.setBackground(new java.awt.Color(102, 51, 0));
        refreshJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

        BMworkRequestJTable1.setAutoCreateRowSorter(true);
        BMworkRequestJTable1.setBackground(new java.awt.Color(255, 204, 102));
        BMworkRequestJTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 51, 0), new java.awt.Color(255, 204, 51)));
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
        BMworkRequestJTable1.setGridColor(new java.awt.Color(255, 255, 102));
        BMworkRequestJTable1.setSelectionBackground(new java.awt.Color(102, 51, 0));
        jScrollPane4.setViewportView(BMworkRequestJTable1);
        if (BMworkRequestJTable1.getColumnModel().getColumnCount() > 0) {
            BMworkRequestJTable1.getColumnModel().getColumn(9).setResizable(false);
        }

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 880, 270));

        SendMailJButton.setBackground(new java.awt.Color(102, 51, 0));
        SendMailJButton.setForeground(new java.awt.Color(255, 255, 255));
        SendMailJButton.setText("Send");
        SendMailJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendMailJButtonActionPerformed(evt);
            }
        });
        add(SendMailJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 360, 70, -1));

        txtTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtToActionPerformed(evt);
            }
        });
        add(txtTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 60, 210, -1));

        lblTo.setText("  To:");
        add(lblTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 60, 20));

        txtmessage.setColumns(20);
        txtmessage.setRows(5);
        jScrollPane2.setViewportView(txtmessage);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 170, 210, 170));

        lblmsg.setText("Message: ");
        add(lblmsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 170, 60, 20));

        txtSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubjectActionPerformed(evt);
            }
        });
        add(txtSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, 210, -1));

        lblsubject.setText("  Subject:");
        add(lblsubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 100, 70, 20));

        ContactJButton.setBackground(new java.awt.Color(102, 51, 0));
        ContactJButton.setForeground(new java.awt.Color(255, 255, 255));
        ContactJButton.setText("Contact Customer");
        ContactJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactJButtonActionPerformed(evt);
            }
        });
        add(ContactJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 140, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Mail Portal");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 30, 90, -1));

        lblEnterpriseName.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEnterpriseName.setText("jLabel2");
        add(lblEnterpriseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 330, 30));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel2.setText("Enterprise");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 150, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        }

        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 5);
        ((CustomerProductWorkRequest) request).getApprovalStage();
        if (request.getClass().equals(CustomerProductWorkRequest.class)) {
            int stage = Integer.parseInt(((CustomerProductWorkRequest) request).getApprovalStage() == null ? "-1" : ((CustomerProductWorkRequest) request).getApprovalStage());
            switch (stage) {
                case 11:
                    int dialogButton1 = JOptionPane.YES_NO_OPTION;
                    int dialogResult1 = JOptionPane.showConfirmDialog(null, "Order Cancelled by customer. Cannot process.", "Warning", dialogButton1);
                    if (dialogResult1 == JOptionPane.YES_OPTION) {
                        // JOptionPane.showMessageDialog(null, "");
                    }
                    break;
                case 0:
                    request.setReceiver(userAccount);
                    request.setStatus("Pending under " + userAccount);
                    ((CustomerProductWorkRequest) request).setApprovalStage("2");
                    userAccount.getWorkQueue().getWorkRequestList().add(request);
                    break;
                case 2:
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Already Pending under a Customer Agent. Do you want to reassign it?", "Warning", dialogButton);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        request.setReceiver(userAccount);
                        request.setStatus("Pending under " + userAccount);
                        ((InsuranceProductWorkRequest) request).setApprovalStage("2");
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                        // remove queuefrom 
                    }
                    break;
                case 21:
                    JOptionPane.showMessageDialog(null, "Already Documentation completed");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Already under UnderWriter");
                    break;
                case 31:
                    JOptionPane.showMessageDialog(null, "Already underwriter  has Processed the Application");
                    break;
                case 32:
                    JOptionPane.showMessageDialog(null, "Already Underwriter has raised risk");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Pending under Billing Agent.");
                    break;
                case 41:
                    JOptionPane.showMessageDialog(null, "Billing Done/Poliy Issued.");
                    break;
                case 42:
                    JOptionPane.showMessageDialog(null, "Cancelled by billing Agent");
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

        CustomerProductWorkRequest request = (CustomerProductWorkRequest) BMworkRequestJTable1.getValueAt(selectedRow, 9);

        // request.setStatus("Approved by BM");
        ProcessWorkRequestJPanel processWorkRequestJPanel = new ProcessWorkRequestJPanel(userProcessContainer, request, business);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void SendMailJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendMailJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = BMworkRequestJTable1.getSelectedRow();

        if (selectedRow < 0) {

            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        }
        String user = "test.sathwiknet@gmail.com";
        String pass = "Rct@2020";
        //CustomerProductWorkRequest request = (CustomerProductWorkRequest) BMworkRequestJTable1.getValueAt(selectedRow, 9);
        // if()
        send(txtTo.getText(), txtSubject.getText(), txtmessage.getText(), user, pass);
        txtTo.setText("");
        txtSubject.setText("");
        txtmessage.setText("");
        SendMailJButton.setEnabled(false);
    }//GEN-LAST:event_SendMailJButtonActionPerformed

    private void ContactJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = BMworkRequestJTable1.getSelectedRow();

        if (selectedRow < 0) {

            JOptionPane.showMessageDialog(null, "Select a Customer to be contacted");
            return;
        }

        CustomerProductWorkRequest request = (CustomerProductWorkRequest) BMworkRequestJTable1.getValueAt(selectedRow, 9);
        if (request.getCustomerMailId() == null || request.getCustomerMailId().equals("")) {
            JOptionPane.showMessageDialog(null, "Customer contact details not available.");
            return;
        } else {
            String mailid = request.getCustomerMailId();
            txtTo.setText(mailid);
            SendMailJButton.setEnabled(true);
        }

        //lblmsg.setVisible(true);
    }//GEN-LAST:event_ContactJButtonActionPerformed

    private void txtSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubjectActionPerformed

    private void txtToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtToActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BMworkRequestJTable1;
    private javax.swing.JButton ContactJButton;
    private javax.swing.JButton SendMailJButton;
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblEnterpriseName;
    private javax.swing.JLabel lblTo;
    private javax.swing.JLabel lblmsg;
    private javax.swing.JLabel lblsubject;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtTo;
    private javax.swing.JTextArea txtmessage;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
