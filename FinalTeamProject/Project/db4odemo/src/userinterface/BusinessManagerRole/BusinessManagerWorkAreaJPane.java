/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.BusinessManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Organizations.Organization;
import Business.WorkQueue.InsuranceProductWorkRequest;

/**
 *
 * @author Sandhya Goswami
 */
public class BusinessManagerWorkAreaJPane extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise inEnterprise;

    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public BusinessManagerWorkAreaJPane(JPanel userProcessContainer, UserAccount account, Organization org, EcoSystem business, Enterprise enterprise) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.organization = org;
        this.inEnterprise = enterprise;

        populateTable();
        populateUsersPendingTable();
        populateAllProductsable();
        lblEnterpriseName.setText(inEnterprise.getName());
        //assignJButton.setVisible(false);
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {

            if (request.getClass().equals(Business.WorkQueue.InsuranceProductWorkRequest.class)) {
                String approvalStage = ((InsuranceProductWorkRequest) request).getApprovalStage() == null ? "-1" : ((InsuranceProductWorkRequest) request).getApprovalStage();
                if (approvalStage.equals("0")) {
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

    public void populateUsersPendingTable() {
        DefaultTableModel model = (DefaultTableModel) AllPendingRequests.getModel();

        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {

            if (request != null) {
                if (request.getClass().equals(Business.WorkQueue.InsuranceProductWorkRequest.class)) {
                    InsuranceProductWorkRequest iP = (InsuranceProductWorkRequest) request;
                    // InsuranceProductWorkRequest isr = wr;
                    Object[] row = new Object[12];
                    row[0] = iP.getNetwork();
                    row[1] = iP.getEnterprise();
                    row[2] = iP.getProductName();
                    row[3] = iP.getInsuranceType().getValue();
                    row[4] = iP.getPremuim();
                    row[5] =  iP.getProductDescription() ;
                    row[6] =iP.getCoverageAmount();
                    row[7] = iP.getMessage();
                    row[8] = iP.getStatus();
                    row[9] = iP;
                    row[10] = request.getRequestDate();
                    // row[9]=iP.

                    model.addRow(row);
                }
            }

        }

    }

    
    
     public void populateAllProductsable() {
        DefaultTableModel model = (DefaultTableModel) AllInsuraces.getModel();

        model.setRowCount(0);

        for (WorkRequest request : inEnterprise.getWorkQueue().getWorkRequestList()) {

            if (request != null) {
                if (request.getClass().equals(Business.WorkQueue.InsuranceProductWorkRequest.class)) {
                    InsuranceProductWorkRequest iP = (InsuranceProductWorkRequest) request;
                    if(iP.getApprovalStage()==null)
                    {
                        iP.setApprovalStage("-1");
                    }
                    if(iP.getApprovalStage().equals("61"))
                    {  // InsuranceProductWorkRequest isr = wr;
                    Object[] row = new Object[12];
                    row[0] = iP.getNetwork();
                    row[1] = iP.getEnterprise();
                    row[2] = iP.getProductName();
                    row[3] = iP.getInsuranceType();
                    row[4] = iP.getPremuim();
                    row[5] =  iP.getProductDescription();
                    row[6] =iP.getCoverageAmount();
                    row[7] = iP.getMessage();
                    row[8] = iP.getStatus();
                    row[9] = iP;
                    row[10] = request.getRequestDate();
                    // row[9]=iP.

                    model.addRow(row);
                    }
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
        AllPendingRequests = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblEnterpriseName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        AllInsuraces = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(233, 255, 101));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setAutoCreateRowSorter(true);
        workRequestJTable.setBackground(new java.awt.Color(255, 255, 153));
        workRequestJTable.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 0), new java.awt.Color(255, 255, 51)));
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
        workRequestJTable.setGridColor(new java.awt.Color(255, 255, 102));
        workRequestJTable.setSelectionBackground(new java.awt.Color(51, 51, 0));
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(6).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(8).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1100, 120));

        assignJButton.setBackground(new java.awt.Color(51, 51, 0));
        assignJButton.setForeground(new java.awt.Color(255, 255, 255));
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, -1, -1));

        processJButton.setBackground(new java.awt.Color(51, 51, 0));
        processJButton.setForeground(new java.awt.Color(255, 255, 255));
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 230, -1, -1));

        refreshJButton.setBackground(new java.awt.Color(51, 51, 0));
        refreshJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 60, -1, -1));

        AllPendingRequests.setAutoCreateRowSorter(true);
        AllPendingRequests.setBackground(new java.awt.Color(255, 255, 102));
        AllPendingRequests.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 0), new java.awt.Color(255, 255, 51)));
        AllPendingRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Network", "Enterprise", "Name", "Type", "Premium", "Description", "Coverage Amount", "Message", "Status", "Request ID", "RequestDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AllPendingRequests.setGridColor(new java.awt.Color(255, 255, 102));
        AllPendingRequests.setSelectionBackground(new java.awt.Color(51, 51, 0));
        jScrollPane4.setViewportView(AllPendingRequests);
        if (AllPendingRequests.getColumnModel().getColumnCount() > 0) {
            AllPendingRequests.getColumnModel().getColumn(9).setResizable(false);
        }

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1100, 170));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText(" All Products(Insurance Plans)");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 320, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel2.setText("Enterprise");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

        lblEnterpriseName.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEnterpriseName.setText("jLabel2");
        add(lblEnterpriseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 330, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText(" New Business Product Request :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 230, -1));

        AllInsuraces.setAutoCreateRowSorter(true);
        AllInsuraces.setBackground(new java.awt.Color(255, 255, 102));
        AllInsuraces.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 0), new java.awt.Color(255, 255, 51)));
        AllInsuraces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Network", "Enterprise", "Name", "Type", "Premium", "Description", "Coverage Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        AllInsuraces.setGridColor(new java.awt.Color(255, 255, 102));
        AllInsuraces.setSelectionBackground(new java.awt.Color(51, 51, 0));
        jScrollPane5.setViewportView(AllInsuraces);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 1100, 170));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText(" Pending and Processed Requests  :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 320, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        }

        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        if (request.getClass().equals(InsuranceProductWorkRequest.class)) {
            int stage = Integer.parseInt(((InsuranceProductWorkRequest) request).getApprovalStage() == null ? "-1" : ((InsuranceProductWorkRequest) request).getApprovalStage());
            switch (stage) {
                case 0:
                    request.setReceiver(userAccount);
                    request.setStatus("Pending under " + userAccount);
                    ((InsuranceProductWorkRequest) request).setApprovalStage("1");
                    userAccount.getWorkQueue().getWorkRequestList().add(request);
                    break;
                case 1:
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Already Pending under a Business manager. Do you want to reassign it?", "Warning", dialogButton);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        request.setReceiver(userAccount);
                        request.setStatus("Pending under " + userAccount);
                        ((InsuranceProductWorkRequest) request).setApprovalStage("1");
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
                    JOptionPane.showMessageDialog(null, "Already Aproved by IRDA approval team.");
                    break;
                case 62:
                    JOptionPane.showMessageDialog(null, "Already Rejected by IRDA approval team.");
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
        populateUsersPendingTable();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = AllPendingRequests.getSelectedRow();

        if (selectedRow < 0) {

            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        }

        InsuranceProductWorkRequest request = (InsuranceProductWorkRequest) AllPendingRequests.getValueAt(selectedRow, 9);
         if(request.getApprovalStage()!=null)
         {
        if(request.getApprovalStage().equals("1"))
         { 
        // request.setStatus("Approved by BM");
        ProcessWorkRequestJPanel processWorkRequestJPanel = new ProcessWorkRequestJPanel(userProcessContainer, request, business);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
         }
         else 
         {
             JOptionPane.showMessageDialog(null, "Already action has taken");
            return;
         }
         }

    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AllInsuraces;
    private javax.swing.JTable AllPendingRequests;
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblEnterpriseName;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
