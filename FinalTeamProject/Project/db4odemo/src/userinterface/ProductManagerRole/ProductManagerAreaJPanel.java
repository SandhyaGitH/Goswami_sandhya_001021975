/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ProductManagerRole;

import Business.CustomerPolicy.Policy;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organizations.ProductManagementOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InsuranceProductWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ProductManagerAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ProductManagementOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem system;

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public ProductManagerAreaJPanel(JPanel userProcessContainer, UserAccount account, ProductManagementOrganization organization, Enterprise enterprise, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        valueLabel.setText(enterprise.getName());
        this.system = system;

        //requestTestJButton.setVisible(false);
        populateRequestTable();
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
            if (request != null) {
                if (request.getClass().equals(Business.WorkQueue.InsuranceProductWorkRequest.class)) {
                    InsuranceProductWorkRequest iP = (InsuranceProductWorkRequest) request;
                    // InsuranceProductWorkRequest isr = wr;
                    if (iP.getEnterprise().getName().equals(enterprise.getName())
                            && (iP.getApprovalStage() == null ? true : iP.getApprovalStage().equals("61"))) {
                        Object[] row = new Object[9];
                        //row[0] = iP.getNetwork();
                        row[0] = iP.getEnterprise();
                        row[1] = iP.getProductName();
                        row[2] = iP.getInsuranceType();
                        row[3] = iP.getProductDescription();
                        row[4] = iP.getPremuim();
                        row[5] = iP.getCoverageAmount();
                        row[6] = iP;

                        /*
                        Object[] row = new Object[4];
                        row[0] = iP.getMessage();
                        row[1] = iP.getReceiver();
                        row[2] = iP.getStatus();
                        String result = iP.getTestResult();
                        row[3] = result == null ? "Waiting" : result;
                         */
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
        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        Propose = new javax.swing.JButton();
        valueLabel1 = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(233, 255, 101));

        workRequestJTable.setBackground(new java.awt.Color(255, 255, 204));
        workRequestJTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0)));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Enterprise", "Name", "Insurance Type", "Description", "Premuim", "Covered Amount", "p"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.setGridColor(new java.awt.Color(255, 255, 204));
        workRequestJTable.setSelectionBackground(new java.awt.Color(51, 51, 0));
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(6).setMaxWidth(1);
        }

        refreshTestJButton.setBackground(new java.awt.Color(51, 51, 0));
        refreshTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        valueLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        valueLabel.setText("<value>");

        Propose.setBackground(new java.awt.Color(51, 51, 0));
        Propose.setForeground(new java.awt.Color(255, 255, 255));
        Propose.setText("Propose Product");
        Propose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProposeActionPerformed(evt);
            }
        });

        valueLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        valueLabel1.setText("Insurances");

        DeleteButton.setBackground(new java.awt.Color(51, 51, 0));
        DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Propose))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(refreshTestJButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 62, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(valueLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(refreshTestJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Propose)
                    .addComponent(DeleteButton))
                .addGap(58, 58, 58))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateRequestTable();

    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void ProposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProposeActionPerformed
        // TODO add your handling code here:
        ManageProductJPanel manageProductJPanel = new ManageProductJPanel(userProcessContainer, enterprise, userAccount, system);
        userProcessContainer.add("manageMenuJPanel", manageProductJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_ProposeActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            //if()
            WorkRequest workRequest = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 6);
            if (workRequest.getClass().equals(InsuranceProductWorkRequest.class)) {
                
                for(Policy policy : system.getCustPolicyDirectory().getPolicyList())
                {
                    if(policy.getInsuranceName().equals(((InsuranceProductWorkRequest)workRequest).getProductName()))
                    {JOptionPane.showMessageDialog(null, "Cannot Delete. Insurance is assoiciated with many customer policies.");
                    return;
                    }
                }
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to remove it!", "Warning", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    InsuranceProductWorkRequest uA = (InsuranceProductWorkRequest) workRequestJTable.getValueAt(selectedRow, 6);
                    int index = enterprise.getWorkQueue().getWorkRequestList().indexOf(uA);
                    enterprise.getWorkQueue().getWorkRequestList().remove(index);
                    populateRequestTable();

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from table first.", "Warning", JOptionPane.WARNING_MESSAGE);

        }
       // populateRequestTable();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton Propose;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JLabel valueLabel1;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
