package userinterface.AdministrativeRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem system;

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public AdminWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system=system;
        valueLabel.setText(enterprise.getName());
        setBackGroundColor();
        jLabelheader.setText(enterprise.getEnterpriseType().getValue());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        manageOrganizationJButton = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        userJButton = new javax.swing.JButton();
        jPanelheader = new javax.swing.JPanel();
        jPanelheader1 = new javax.swing.JPanel();
        jPanelheader2 = new javax.swing.JPanel();
        jPanelheader3 = new javax.swing.JPanel();
        sidebar = new javax.swing.JPanel();
        entTypelabl = new javax.swing.JPanel();
        jPanelheader7 = new javax.swing.JPanel();
        jLabelheader = new javax.swing.JLabel();

        setName("JpanelMainAdmin"); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("My Work Area -Adminstrative Role");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(330, 60, 411, 29);

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(255, 255, 255));
        enterpriseLabel.setText("EnterPrise :");
        jDesktopPane1.add(enterpriseLabel);
        enterpriseLabel.setBounds(410, 110, 106, 22);

        valueLabel.setForeground(new java.awt.Color(255, 255, 255));
        valueLabel.setText("<value>");
        jDesktopPane1.add(valueLabel);
        valueLabel.setBounds(540, 110, 180, 20);

        manageOrganizationJButton.setText("Manage Organization");
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });
        jDesktopPane1.add(manageOrganizationJButton);
        manageOrganizationJButton.setBounds(470, 150, 170, 30);

        manageEmployeeJButton.setText("Manage Employee");
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });
        jDesktopPane1.add(manageEmployeeJButton);
        manageEmployeeJButton.setBounds(470, 190, 170, 30);

        userJButton.setText("Manage User");
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });
        jDesktopPane1.add(userJButton);
        userJButton.setBounds(470, 230, 170, 30);

        add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1150, 570));

        jPanelheader.setBackground(new java.awt.Color(255, 255, 102));

        jPanelheader1.setBackground(new java.awt.Color(255, 255, 102));
        jPanelheader.add(jPanelheader1);

        add(jPanelheader, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 1130, 10));

        jPanelheader2.setBackground(new java.awt.Color(255, 255, 102));

        jPanelheader3.setBackground(new java.awt.Color(255, 255, 102));
        jPanelheader2.add(jPanelheader3);

        add(jPanelheader2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, 1150, 10));

        sidebar.setBackground(new java.awt.Color(255, 255, 102));
        add(sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 80, 10, 570));

        jLabelheader.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelheader.setText("<value>");
        jPanelheader7.add(jLabelheader);
        jLabelheader.getAccessibleContext().setAccessibleDescription("");

        entTypelabl.add(jPanelheader7);

        add(entTypelabl, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 34, 510, 40));
    }// </editor-fold>//GEN-END:initComponents
 private void setBackGroundColor() {
        if (enterprise != null) {
            Color c = jDesktopPane1.getBackground();
            if (enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.InsuranceCompany)) {
                c = new Color(51, 51, 0);// darkgreen
                //Jpp
                // jPanel1.setBackground(c);

            }
            if (enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.InsuranceBroker.getValue())) {
                c = new Color(102, 51, 0); // mustrud dark
                // jPanel1.setBackground(c);

            }
            if (enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.InsuranceRegulator.getValue())) {
                c = new Color(0, 0, 51); // dark blue
                // jPanel1.setBackground(c);

            }
            if (enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Hospitals.getValue())) {
                c = new Color(102, 0, 0); // dark red

            }
            jDesktopPane1.setBackground(c);
            manageOrganizationJButton.setBackground(c);
            manageEmployeeJButton.setBackground(c);
            userJButton.setBackground(c);
            //  entTypelabl.setBackground(c);
            manageOrganizationJButton.setForeground(Color.WHITE);
            manageEmployeeJButton.setForeground(Color.WHITE);
            userJButton.setForeground(Color.WHITE);
            jLabelheader.setForeground(c);
            sidebar.setBackground(c);
        }
    }
    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        // TODO add your handling code here:
        ManageUserAccountJPanel muajp = new ManageUserAccountJPanel(userProcessContainer, enterprise,  system);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButtonActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed

        ManageEmployeeJPanel manageEmployeeJPanel = new ManageEmployeeJPanel(userProcessContainer, enterprise.getOrganizaionDirectory(),enterprise);
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        ManageOrganizationJPanel manageOrganizationJPanel = new ManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizaionDirectory(), enterprise);
        userProcessContainer.add("manageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel entTypelabl;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelheader;
    private javax.swing.JPanel jPanelheader;
    private javax.swing.JPanel jPanelheader1;
    private javax.swing.JPanel jPanelheader2;
    private javax.swing.JPanel jPanelheader3;
    private javax.swing.JPanel jPanelheader7;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JPanel sidebar;
    private javax.swing.JButton userJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables

}
