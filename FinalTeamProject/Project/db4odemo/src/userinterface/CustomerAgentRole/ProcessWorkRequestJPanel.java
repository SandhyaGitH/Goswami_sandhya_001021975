/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerAgentRole;

import userinterface.UnderwriterRole.*;
import userinterface.BusinessManagerRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Location;
import Business.Organizations.Organization;
import Business.Organizations.RegulatoryPolicyManagementOrganization;
import Business.Organizations.UnderWriterOrganization;
import Business.WorkQueue.CustomerProductWorkRequest;
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
        rejectJButton.setVisible(false);

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

        submitJButton.setText("Approve");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Comments");

        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(resultJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(158, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rejectJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(submitJButton)
                        .addGap(73, 73, 73))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(resultJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitJButton)
                    .addComponent(backJButton)
                    .addComponent(rejectJButton))
                .addContainerGap(169, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CustomerAgentWorkAreaJPane dwjp = (CustomerAgentWorkAreaJPane) component;
        dwjp.populateTable();
        dwjp.populateBMTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        if (request.getClass().equals(CustomerProductWorkRequest.class)) {
            if (request.getClass().equals(CustomerProductWorkRequest.class)) {
                int stage = Integer.parseInt(((CustomerProductWorkRequest) request).getApprovalStage());
                switch (stage) {
                    case 11:
                        JOptionPane.showMessageDialog(null, "Customer has Cancelled Request");
                        break;
                    case 0:
                        break;
                    case 2:

                        Organization org = null;

                        for (Location network : system.getNetworkList()) {
                            for (Enterprise entp : network.getEnterpriseDirectory().getEnterpriseList()) {
                                if (entp.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.InsuranceBroker.getValue())) {
                                    entp.getWorkQueue().getWorkRequestList().add(request);
                                    for (Organization organization : entp.getOrganizaionDirectory().getOrganizationList()) {
                                        if (organization instanceof UnderWriterOrganization) {
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
                            request.setStatus("Documentation Done");
                            ((CustomerProductWorkRequest) request).setApprovalStage("21");
                            JOptionPane.showMessageDialog(null, "Sent for underwriting");
                            resultJTextField.setText("");
                            // userAccount.getWorkQueue().getWorkRequestList().add(request);
                        }else {
                            JOptionPane.showMessageDialog(null, "Could not found the UnderWriter organization. Please create it first");
                        }

                        break;
                    case 21:
                        JOptionPane.showMessageDialog(null, "Already Documentation Completed");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Already under UnderWriter");
                        break;
                    case 31:
                        JOptionPane.showMessageDialog(null, "Already underwriter  has Processed the Application");
                        break;
                    case 32:
                        JOptionPane.showMessageDialog(null, "Underwriter has raised a risk");
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Pending under Billing Agent.");
                        break;
                    case 41:
                        JOptionPane.showMessageDialog(null, "Billing Done/Poliy Issued.");
                    case 42:
                        JOptionPane.showMessageDialog(null, "Cancelled by billing Agent");
                        break;
                    default:
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
                        break;

                }
            }

        }


    }//GEN-LAST:event_rejectJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton rejectJButton;
    private javax.swing.JTextField resultJTextField;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
