/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ProductManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;

import Business.Restaurant.Restaurant;
import Business.Network.Location;
import Business.Organizations.BusinessManagementOrganization;
import Business.Organizations.Organization;
import Business.Restaurant.Menu;
import Business.Restaurant.MenuDirectory;
//import Business.Role.DeliverManRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InsuranceProductWorkRequest;
import Business.WorkQueue.InsuranceProductWorkRequest.insuranceType;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ManageProductJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Location InNetwork;

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public ManageProductJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount account, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.enterprise = enterprise;
        this.userAccount = account;
        submitJButton.setVisible(false);

        populateNetworkComboBox();
        //  populateEnterpriseComboBox();

        // populateTable();
        networkJComboBox.setVisible(false);
        enterpriseJComboBox.setVisible(false);
        getInNetwork();
        populateTable(enterprise);
        populateIsuranceTypeCombo();

    }

    private void populateIsuranceTypeCombo() {
        isuranceTypeJComboBox.removeAllItems();
        for (insuranceType type : InsuranceProductWorkRequest.insuranceType.values()) {
            //if (!type.getValue().equals(Type.Admin.getValue()))
            isuranceTypeJComboBox.addItem(type);// (type);
        }
    }

    private void getInNetwork() {
        for (Location network : system.getNetworkList()) {
            for (Enterprise entp : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (entp.equals(enterprise)) {
                    InNetwork = network;
                    break;
                }
            }
        }
    }

    private void populateTable(Enterprise enterprise) {
        DefaultTableModel model = (DefaultTableModel) menuListJTable.getModel();

        model.setRowCount(0);

        // { InNetwork.getRestaurantDirectory().}
        WorkQueue wq = enterprise.getWorkQueue();
        if (wq != null) {
            for (WorkRequest wr : wq.getWorkRequestList()) {
                if (wr != null) {
                    if (wr.getClass().equals(Business.WorkQueue.InsuranceProductWorkRequest.class)) {
                        InsuranceProductWorkRequest iP = (InsuranceProductWorkRequest) wr;
                        // InsuranceProductWorkRequest isr = wr;
                        Object[] row = new Object[9];
                        row[0] = iP.getNetwork();
                        row[1] = iP.getEnterprise();
                        row[2] = iP.getProductName();
                        row[3] = iP.getInsuranceType();
                        row[4] = iP.getPremuim();
                        row[5] = iP.getCoverageAmount();
                        row[6] = iP.getProductDescription();
                        row[7] = iP.getMessage();
                        row[8] = iP.getStatus();
                        // row[9]=iP.

                        model.addRow(row);
                    }
                }

            }
        }

    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) menuListJTable.getModel();

        model.setRowCount(0);
        for (Location network : system.getNetworkList()) {
            for (Restaurant restaur : network.getRestaurantDirectory().getRestaurantList()) {
                MenuDirectory mD = restaur.getMenuDirectory();
                if (mD == null) {
                    break;
                } else {
                    // restaurant.getMenuDirectory()==null? null:restaurant.getMenuDirectory().getMenuItemList()
                    for (Menu menu : mD.getMenuItemList()) {
                        if (menu != null) {
                            Object[] row = new Object[6];
                            row[0] = menu.getNetwork();
                            row[1] = menu.getRestaurant();
                            row[2] = menu.getMenuItem();
                            row[3] = menu.getDescription();
                            row[4] = menu.getPrice();
                            row[5] = menu.getIsavailable();

                            model.addRow(row);
                        }
                    }
                }
            }
        }

    }

    private void populateNetworkComboBox() {
        /*  networkJComboBox.removeAllItems();
        for (Location network : system.getNetworkList()) {
            networkJComboBox.addItem(network);
        } */
    }

    private void populateEnterpriseComboBox(Location network) {
        enterpriseJComboBox.removeAllItems();
        enterpriseJComboBox.addItem(enterprise);

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
        menuListJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        enterpriseJComboBox = new javax.swing.JComboBox();
        submitJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        isuranceTypeJComboBox = new javax.swing.JComboBox();
        txtPrice = new javax.swing.JTextField();
        networkJComboBox = new javax.swing.JComboBox();
        txtDesc1 = new javax.swing.JTextField();
        requestTestJButton = new javax.swing.JButton();
        txtCoverage = new javax.swing.JTextField();
        Price1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();

        menuListJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Network", "Enterprise", "Name", "Type", "Premium", "Description", "Coverage Amount", "Message", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(menuListJTable);

        jLabel2.setText("Product Name");

        enterpriseJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Description");

        Price.setText("Premium");

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel12.setText("Type");

        isuranceTypeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        isuranceTypeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isuranceTypeJComboBoxActionPerformed(evt);
            }
        });

        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });

        requestTestJButton.setText("Request");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        Price1.setText("Coverage");

        jLabel5.setText("Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(requestTestJButton)
                                .addGap(59, 59, 59)
                                .addComponent(submitJButton)
                                .addGap(161, 161, 161))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMessage))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(isuranceTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Price1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCoverage, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtDesc1))))
                                .addContainerGap(364, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(isuranceTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Price)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Price1)
                    .addComponent(txtCoverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(submitJButton)
                    .addComponent(requestTestJButton))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ProductManagerAreaJPanel productManagerAreaJPanel = (ProductManagerAreaJPanel) component;
         productManagerAreaJPanel.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed
        // TODO add your handling code here:
        Location network = (Location) networkJComboBox.getSelectedItem();
        if (network != null) {
            populateEnterpriseComboBox(network);
        }
    }//GEN-LAST:event_networkJComboBoxActionPerformed

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

        boolean flag = true;

        if (nameJTextField.getText().equals("")) {  //User have not entered anything. 
            JOptionPane.showMessageDialog(null, "Product Name Can't be empty");
            nameJTextField.requestFocusInWindow();
            nameJTextField.setText("");
            flag = false;
        }
        if (txtDesc1.getText().equals("")) {  //User have not entered anything. 
            JOptionPane.showMessageDialog(null, "Desription Can't be empty");
            txtDesc1.requestFocusInWindow();
            txtDesc1.setText("");
            flag = false;
        }
        if (txtPrice.getText().equals("")) {  //User have not entered anything. 
            JOptionPane.showMessageDialog(null, "Price Can't be empty");
            txtPrice.requestFocusInWindow();
            txtPrice.setText("");
            flag = false;
        }
        if (txtCoverage.getText().equals("")) {  //User have not entered anything. 
            JOptionPane.showMessageDialog(null, "Coverage Amount Can't be empty");
            txtCoverage.requestFocusInWindow();
            txtCoverage.setText("");
            flag = false;
        }
        String regex_Pattern_For_Number = "^[0-9]*";
        Pattern pattern = Pattern.compile(regex_Pattern_For_Number);
        //Pattern pattern = Pattern.compile(regex_Pattern_For_Letter);
        Matcher matcher = pattern.matcher(txtPrice.getText());
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Enter Valid Integer Only for premuim");
            txtPrice.requestFocusInWindow();
            txtPrice.setText("");
            flag = false;
        }
        matcher = pattern.matcher(txtCoverage.getText());
        if (!matcher.matches()) {
            //flag = false;
            JOptionPane.showMessageDialog(null, "Enter Valid Integer Only for Coverage Amount");
            txtCoverage.requestFocusInWindow();
            txtCoverage.setText("");
            flag = false;
        }

        //Employee employee = restaurant.getEmployeeDirectory().createEmployee(name);
        //UserAccount account = system.getUserAccountDirectory().createUserAccount(username, password, null, new CustomerRole());
        if (flag) {
            InsuranceProductWorkRequest request = new InsuranceProductWorkRequest();

            request.setMessage(txtMessage.getText());
            request.setSender(userAccount);
            request.setStatus("Purposed");
            request.setNetwork(InNetwork);
            request.setEnterprise(enterprise);
            request.setProductName(nameJTextField.getText());
            insuranceType type = (insuranceType) isuranceTypeJComboBox.getSelectedItem();
            // if (type.getValue().equals(InsuranceProductWorkRequest.insuranceType.Health.getValue())){
            // organization = new ProductManagementOrganization();
            request.setInsuranceType(type);
            request.setCoverageAmount(txtCoverage.getText());
            request.setPremuim(txtPrice.getText());
            request.setProductDescription(txtDesc1.getText());
            request.setApprovalStage("0");

            Organization org = null;
            for (Organization organization : enterprise.getOrganizaionDirectory().getOrganizationList()) {
                if (organization instanceof BusinessManagementOrganization) {
                    org = organization;
                    break;
                }
            }
            for (WorkRequest workRequest : enterprise.getWorkQueue().getWorkRequestList()) {
                if (workRequest.getClass().equals(InsuranceProductWorkRequest.class)) {
                    InsuranceProductWorkRequest Iworkreq = (InsuranceProductWorkRequest) workRequest;
                    if (Iworkreq.getProductName().equals(nameJTextField.getText())) {
                        JOptionPane.showMessageDialog(null, "Cannot request for duplicate product");
                        return;
                    }
                }
            }
            enterprise.getWorkQueue().getWorkRequestList().add(request);

            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
            }
            JOptionPane.showMessageDialog(null, "saved and sent for approval");
        }
        populateTable(enterprise);

    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void isuranceTypeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isuranceTypeJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isuranceTypeJComboBoxActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        /*
        //        Location network = (Location) networkJComboBox.getSelectedItem();
        //  Restaurant Srestaurant = (Restaurant) enterpriseJComboBox.getSelectedItem();
        String loc=enterprise.getlo();

        boolean flag = true;

        if (usernameJTextField.getText().equals("")){  //User have not entered anything.
            JOptionPane.showMessageDialog(null,"MenuTem Can't be empty");
            usernameJTextField.requestFocusInWindow();
            usernameJTextField.setText("");
            flag = false;
        }
        if (txtDesc1.getText().equals("")){  //User have not entered anything.
            JOptionPane.showMessageDialog(null,"Desription Can't be empty");
            txtDesc1.requestFocusInWindow();
            txtDesc1.setText("");
            flag = false;
        }
        if (txtPrice.getText().equals("")){  //User have not entered anything.
            JOptionPane.showMessageDialog(null,"Price Can't be empty");
            txtPrice.requestFocusInWindow();
            txtPrice.setText("");
            flag = false;
        }
        String regex_Pattern_For_Number = "^[0-9]*";
        Pattern pattern = Pattern.compile(regex_Pattern_For_Number);
        //Pattern pattern = Pattern.compile(regex_Pattern_For_Letter);
        Matcher matcher = pattern.matcher(txtPrice.getText());
        if (!matcher.matches()) {
            flag = false;
            JOptionPane.showMessageDialog(null,"Enter Valid Integer Only for No of Flights");
            txtPrice.requestFocusInWindow();
            txtPrice.setText("");
            flag = false;
        }

        //Employee employee = restaurant.getEmployeeDirectory().createEmployee(name);
        //UserAccount account = system.getUserAccountDirectory().createUserAccount(username, password, null, new CustomerRole());
        if(flag)
        {

            String menuItem = usernameJTextField.getText();
            String description = String.valueOf(txtDesc1.getText());
            String price = txtPrice.getText();
            String available = "Y";//networkJComboBox.getSelectedItem();

            for (Menu menu : restaurant.getMenuDirectory().getMenuItemList()){

                if( menu.getMenuItem().equals(menuItem))
                {
                    JOptionPane.showMessageDialog(null,"Duplicate Username");
                    return;
                }

            }

            //        Employee employee = restaurant.getEmployeeDirectory().createEmployee(name);
            Menu mn = new Menu(InNetwork,restaurant,menuItem,description,price,available);
            // restaurant==null?restaurant=new Restaurant():restaurant;
            MenuDirectory MD = restaurant.getMenuDirectory();
            if(MD==null)
            {MD = new MenuDirectory();}
            MD.addMenuItem(mn);
            restaurant.setMenuDirectory(MD);
            int index= InNetwork.getRestaurantDirectory().getRestaurantList().indexOf(restaurant);
            InNetwork.getRestaurantDirectory().getRestaurantList().set(index,restaurant);//   UserAccount account = system.getUserAccountDirectory().createUserAccount(username, password, null, new CustomerRole());
        }populateTable(restaurant);
         */
    }//GEN-LAST:event_submitJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Price;
    private javax.swing.JLabel Price1;
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JComboBox isuranceTypeJComboBox;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable menuListJTable;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTextField txtCoverage;
    private javax.swing.JTextField txtDesc1;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
