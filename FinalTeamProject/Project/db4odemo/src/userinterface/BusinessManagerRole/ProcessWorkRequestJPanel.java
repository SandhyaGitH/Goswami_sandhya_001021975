/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.BusinessManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Location;
import Business.Organizations.Organization;
import Business.Organizations.RegulatoryPolicyManagementOrganization;
import Business.WorkQueue.InsuranceProductWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class ProcessWorkRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    InsuranceProductWorkRequest request;
    EcoSystem system;

    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public ProcessWorkRequestJPanel(JPanel userProcessContainer, InsuranceProductWorkRequest request, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.system = system;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        resultJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        rejectJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(233, 255, 101));

        submitJButton.setBackground(new java.awt.Color(51, 51, 0));
        submitJButton.setForeground(new java.awt.Color(255, 255, 255));
        submitJButton.setText("Approve");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Comments");

        resultJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultJTextFieldActionPerformed(evt);
            }
        });

        backJButton.setBackground(new java.awt.Color(51, 51, 0));
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        rejectJButton.setBackground(new java.awt.Color(51, 51, 0));
        rejectJButton.setForeground(new java.awt.Color(255, 255, 255));
        rejectJButton.setText("Reject");
        rejectJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rejectJButton)
                        .addGap(18, 18, 18)
                        .addComponent(submitJButton))
                    .addComponent(resultJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rejectJButton)
                    .addComponent(submitJButton)
                    .addComponent(backJButton))
                .addContainerGap(181, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        BusinessManagerWorkAreaJPane dwjp = (BusinessManagerWorkAreaJPane) component;
        dwjp.populateTable();
        dwjp.populateUsersPendingTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        if (request.getClass().equals(InsuranceProductWorkRequest.class)) {
            if (request.getClass().equals(InsuranceProductWorkRequest.class)) {
                int stage = Integer.parseInt(((InsuranceProductWorkRequest) request).getApprovalStage());
                switch (stage) {

                    case 21:
                        JOptionPane.showMessageDialog(null, "Already Sent to IRDA");
                        break;
                    case 22:
                        JOptionPane.showMessageDialog(null, "Already Internally Rejected by BM");
                        break;
                    default:

                        Organization org = null;

                        for (Location network : system.getNetworkList()) {
                            for (Enterprise entp : network.getEnterpriseDirectory().getEnterpriseList()) {
                                // if (entp.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.InsuranceRegulator.getValue())) {
                                if (entp.getEnterpriseType().equals(Enterprise.EnterpriseType.InsuranceRegulator)) {
                                    entp.getWorkQueue().getWorkRequestList().add(request);
                                    for (Organization organization : entp.getOrganizaionDirectory().getOrganizationList()) {
                                        if (organization instanceof RegulatoryPolicyManagementOrganization) {
                                            org = organization;
                                            break;
                                        }

                                    }
                                }
                            }
                        }
                        /*
        enterprise.getWorkQueue().getWorkRequestList().add(request);
                         */
                        if (org != null) {
                            org.getWorkQueue().getWorkRequestList().add(request);
                            request.setTestResult(resultJTextField.getText());
                            request.setStatus("Approved By BM");
                            ((InsuranceProductWorkRequest) request).setApprovalStage("21");
                            // userAccount.getWorkQueue().getWorkRequestList().add(request);
                            JOptionPane.showMessageDialog(null, "Sent to IRDA");
                            resultJTextField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Could not found the further organization. Please contact to Regularoty Enterprise");
                        }

                        break;

                }
            }

        }

        /*  if (request.getStatus().equals("Approved By BM")) {
            JOptionPane.showMessageDialog(null, "Already sent to IRDA for approval");
            return;
        }
        if (request.getStatus().equals("Rejected")) {
            JOptionPane.showMessageDialog(null, "Already Rejected");
            return;
        } */

    }//GEN-LAST:event_submitJButtonActionPerformed

    private void rejectJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectJButtonActionPerformed
        // TODO add your handling code here:
        if (request.getClass().equals(InsuranceProductWorkRequest.class)) {
            if (request.getClass().equals(InsuranceProductWorkRequest.class)) {
                int stage = Integer.parseInt(((InsuranceProductWorkRequest) request).getApprovalStage());
                switch (stage) {

                    case 21:
                        JOptionPane.showMessageDialog(null, "Already Sent to IRDA");
                        break;
                    case 22:
                        JOptionPane.showMessageDialog(null, "Already Internally Rejected by BM");
                        break;
                    default:
                        request.setTestResult(resultJTextField.getText());
                        request.setStatus("Rejected");
                        ((InsuranceProductWorkRequest) request).setApprovalStage("22");
                        JOptionPane.showMessageDialog(null, "Rejected.");
                        break;

                }
            }

        }


    }//GEN-LAST:event_rejectJButtonActionPerformed

    private void resultJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultJTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton rejectJButton;
    private javax.swing.JTextField resultJTextField;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
