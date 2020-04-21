/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.Enterprise.Enterprise;
import Business.Organizations.Organization;
import Business.Organizations.Organization.Type;
import Business.Organizations.OrganizationDirectory;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ManageOrganizationJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    private Enterprise enterprise;

    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageOrganizationJPanel(JPanel userProcessContainer, OrganizationDirectory directory, Enterprise enterpris) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        this.enterprise = enterpris;
        lblEnterpriseName.setText(enterprise.getName());
        setBackGroundColor();
        lblWecomenote.setVisible(false);
        populateTable();
        populateCombo();
    }

    private void setBackGroundColor() {
        if (enterprise != null) {
            Color c = new Color(0, 0, 0);
            Color basecolor = jPanel1.getBackground();
            //Color GridBg;
            //Color 
            if (enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.InsuranceCompany)) {
                c = new Color(51, 51, 0);// darkgreen
                basecolor= new Color(233,255,101);
               

            }
            if (enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.InsuranceBroker.getValue())) {
                c = new Color(102, 51, 0); // mustrud dark
                // jPanel1.setBackground(c);
                basecolor= new Color(255,255,204);

            }
            if (enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.InsuranceRegulator.getValue())) {
                c = new Color(0, 0, 51); // dark blue
                // jPanel1.setBackground(c);
                basecolor= new Color(204,204,255);

            }
            if (enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Hospitals.getValue())) {
                c = new Color(102, 0, 0); // dark red
                // jDesktopPane1.setBackground(c);
                basecolor= new Color(255,204,204);

            }
            addJButton.setBackground(c);
            addJButton.setForeground(Color.WHITE);
            backJButton.setBackground(c);
            backJButton.setForeground(Color.WHITE);
            jPanel1.setBackground(basecolor);
             Border border = BorderFactory.createEtchedBorder(c,Color.YELLOW );
             organizationJTable.setSelectionBackground(c);
            organizationJTable.setBorder(border);
        }
    }

    private void populateCombo() {
        organizationJComboBox.removeAllItems();
        Enterprise.EnterpriseType entpType = enterprise.getEnterpriseType();
        switch (entpType) {
            case InsuranceCompany:
                for (Type type : Organization.Type.values()) {
                    if (type.getValue().equals(Type.BusinessManagement.getValue())
                            || type.getValue().equals(Type.ProductManagement.getValue())) {
                        organizationJComboBox.addItem(type);// (type);
                    }
                }
                break;

            case InsuranceBroker:
                for (Type type : Organization.Type.values()) {
                    if (type.getValue().equals(Type.CustomerAgent.getValue())
                            || type.getValue().equals(Type.BillingAgent.getValue())
                            || type.getValue().equals(Type.UnderWriter.getValue())
                            || type.getValue().equals(Type.PolicyIssuance.getValue())
                            ||type.getValue().equals(Type.ClaimHandler.getValue())
                            ) {
                        organizationJComboBox.addItem(type);// (type);
                    }
                }
                break;
            case InsuranceRegulator:
                for (Type type : Organization.Type.values()) {
                    if (type.getValue().equals(Type.RegPolicyManagement.getValue())
                            || type.getValue().equals(Type.HealthInsRegulatory.getValue())
                            || type.getValue().equals(Type.LifeInsRegulatory.getValue())
                            || type.getValue().equals(Type.VehicleInsRegulatory.getValue())) {
                        organizationJComboBox.addItem(type);// (type);
                    }
                }
                case Hospitals:
                for (Type type : Organization.Type.values()) {
                    if (type.getValue().equals(Type.PaymentManagement.getValue())
                           ) {
                        organizationJComboBox.addItem(type);// (type);
                    }
                }
            default:
                break;
        }

    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        model.setRowCount(0);
        for (Organization organization : directory.getOrganizationList()) {
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();

            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        lblEnterpriseName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblWecomenote = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Organization Type ");

        backJButton.setBackground(new java.awt.Color(102, 51, 0));
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);
        if (organizationJTable.getColumnModel().getColumnCount() > 0) {
            organizationJTable.getColumnModel().getColumn(0).setResizable(false);
            organizationJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        addJButton.setBackground(new java.awt.Color(102, 51, 0));
        addJButton.setForeground(new java.awt.Color(255, 255, 255));
        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        lblEnterpriseName.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEnterpriseName.setText("jLabel2");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel6.setText("Enterprise :");

        lblWecomenote.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblWecomenote.setText("Wecome !!");
        lblWecomenote.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblEnterpriseName, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblWecomenote, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(backJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addJButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 483, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEnterpriseName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblWecomenote))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addJButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(organizationJComboBox)
                        .addComponent(backJButton)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed

        Type type = (Type) organizationJComboBox.getSelectedItem();
        directory.createOrganization(type);
        populateTable();
    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEnterpriseName;
    private javax.swing.JLabel lblWecomenote;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
