/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.Customer.Customer;
import Business.Customer.CustomerDirectory;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Restaurant.Restaurant;
import Business.Network.Location;
import Business.Role.CustomerRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ManageCustomerJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public ManageCustomerJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateTable();
        populateNetworkComboBox();
        Reslable.setVisible(false);
        enterpriseJComboBox.setVisible(false);
        UpdatejButton.setEnabled(false);
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) enterpriseJTable.getModel();

        model.setRowCount(0);
        //  for (Location network : system.getNetworkList()) {
        //  for (Restaurant restaurant : network.getRestaurantDirectory().getRestaurantList()) {
        for (Customer cust : system.getCustomerDirectory().getCustomerList()) {
            Object[] row = new Object[8];
            row[0] = cust;
            row[1] = cust.getName();//restaurant.getName();
            // network.getName();
            row[2] = cust.getUsername();
            row[3] = cust.getCustomerEmail();
            row[4] = cust.getPhoneNumber();
            row[5] = cust.getAddress();

            model.addRow(row);
        }
        //
        // }
    }

    private void populateNetworkComboBox() {
        networkJComboBox.removeAllItems();

        for (Location network : system.getNetworkList()) {
            networkJComboBox.addItem(network);
        }
    }

    private void populateEnterpriseComboBox(Location network) {
        enterpriseJComboBox.removeAllItems();

        for (Restaurant restaurant : network.getRestaurantDirectory().getRestaurantList()) {
            enterpriseJComboBox.addItem(restaurant);
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
        enterpriseJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        networkJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        usernameJTextField = new javax.swing.JTextField();
        Reslable = new javax.swing.JLabel();
        enterpriseJComboBox = new javax.swing.JComboBox();
        submitJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passwordJPasswordField = new javax.swing.JPasswordField();
        backJButton = new javax.swing.JButton();
        AddressTextbox = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        UpdatejButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        eMailIdJTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PhoneJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 151, 238));

        enterpriseJTable.setBackground(new java.awt.Color(204, 102, 255));
        enterpriseJTable.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 0, 51), new java.awt.Color(255, 51, 204)));
        enterpriseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Customer", "Customer Name", "Username", "Email", "Contact Number", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enterpriseJTable.setGridColor(new java.awt.Color(153, 51, 255));
        enterpriseJTable.setSelectionBackground(new java.awt.Color(51, 0, 51));
        jScrollPane1.setViewportView(enterpriseJTable);

        jLabel1.setText("Network");

        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Username");

        Reslable.setText("Restaurant");

        enterpriseJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        submitJButton.setBackground(new java.awt.Color(51, 0, 51));
        submitJButton.setForeground(new java.awt.Color(255, 255, 255));
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Password");

        jLabel5.setText("Name");

        backJButton.setBackground(new java.awt.Color(51, 0, 51));
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel12.setText("Address");

        jButton1.setBackground(new java.awt.Color(51, 0, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        UpdatejButton.setBackground(new java.awt.Color(51, 0, 51));
        UpdatejButton.setForeground(new java.awt.Color(255, 255, 255));
        UpdatejButton.setText("Update");
        UpdatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatejButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Email Id");

        jLabel6.setText("Phone");

        jLabel7.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        jLabel7.setText("Manage customer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordJPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AddressTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(submitJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(backJButton)
                                            .addComponent(UpdatejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Reslable, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(29, 29, 29)
                                        .addComponent(PhoneJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(eMailIdJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddressTextbox, nameJTextField, networkJComboBox, passwordJPasswordField, usernameJTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(usernameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(eMailIdJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(PhoneJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordJPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(UpdatejButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddressTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(submitJButton)
                    .addComponent(backJButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Reslable))
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed

        Location network = (Location) networkJComboBox.getSelectedItem();
        if (network != null) {
            populateEnterpriseComboBox(network);
        }


    }//GEN-LAST:event_networkJComboBoxActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed

        Restaurant restaurant = (Restaurant) enterpriseJComboBox.getSelectedItem();
        boolean flag = ValidateForm("Submit");

        // String name=
        if (flag) {
            String name = nameJTextField.getText();
            String username = usernameJTextField.getText();
            String password = String.valueOf(passwordJPasswordField.getPassword());
            String address = AddressTextbox.getText();
            String emailId = eMailIdJTextField.getText();
            String phoneNumber = PhoneJTextField.getText();

            String location = ((Location) networkJComboBox.getSelectedItem()).getName();
            //Employee employee = restaurant.getEmployeeDirectory().createEmployee(name);
            //UserAccount account = system.getUserAccountDirectory().createUserAccount(username, password, null, new CustomerRole());

            for (UserAccount account : system.getUserAccountDirectory().getUserAccountList()) {
                if (account.getUsername().equals(username)) {
                    JOptionPane.showMessageDialog(null, "Duplicate Username");
                    return;
                }

            }

            // Customer customer = new Customer(location, name, username, address, "5");
            Customer customer = new Customer();
            customer.setName(name);
            customer.setUsername(username);
            customer.setLocation(location);
            customer.setAddress(address);
            customer.setCustomerRating("5");
            customer.setCustomerEmail(emailId);
            customer.setPhoneNumber(phoneNumber);

            CustomerDirectory cd = system.getCustomerDirectory();
            cd.createCustomer(customer);

            //  system.getCustomerDirectory().getCustomerList().add(customer);
            //.getCustomerList().add(customer);
            // CustomerList.add(customer);
            UserAccount account = system.getUserAccountDirectory().createUserAccount(username, password, null, new CustomerRole());

        }
        populateTable();

    }//GEN-LAST:event_submitJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        // SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        // sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed
    private void ResetAllTextboxs() {
        Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        passwordJPasswordField.setBorder(border);
        usernameJTextField.setBorder(border);
        nameJTextField.setBorder(border);
        AddressTextbox.setBorder(border);
        eMailIdJTextField.setBorder(border);
        PhoneJTextField.setBorder(border);
        usernameJTextField.setText("");
        nameJTextField.setText("");
        AddressTextbox.setText("");
        eMailIdJTextField.setText("");
        PhoneJTextField.setText("");
        passwordJPasswordField.setEnabled(true);
        usernameJTextField.setEnabled(true);
        submitJButton.setEnabled(true);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        //ResetAllTextboxs();
        int selectedRow = enterpriseJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a customer to view the details.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Customer cust = (Customer) enterpriseJTable.getValueAt(selectedRow, 0);
            usernameJTextField.setText(cust.getUsername());
            nameJTextField.setText(cust.getName());
            AddressTextbox.setText(cust.getAddress());
            eMailIdJTextField.setText(cust.getCustomerEmail());
            PhoneJTextField.setText(cust.getPhoneNumber());
            passwordJPasswordField.setEnabled(false);
            for (Location network : system.getNetworkList()) {
                if (network.getName().equals(cust.getLocation())) {
                    networkJComboBox.setSelectedItem(network);
                    break;
                }
            }
            // passwordJPasswordField
            //passwordJPasswordField.setText(cust.g);
            UpdatejButton.setEnabled(true);
            usernameJTextField.setEnabled(false);
            passwordJPasswordField.setEnabled(false);
            submitJButton.setEnabled(false);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void UpdatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatejButtonActionPerformed
        // TODO add your handling code here:

        // Customer  cust = (Customer) enterpriseJTable.getValueAt(selectedRow, 3);
        int selectedRow = enterpriseJTable.getSelectedRow();
        Customer cust = new Customer();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from table first to view details.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            cust = (Customer) enterpriseJTable.getValueAt(selectedRow, 0);
        }
        //  Restaurant restaurant = (Restaurant) enterpriseJComboBox.getSelectedItem();
        boolean flag = ValidateForm("Update");

        // String name=
        if (flag) {
            String name = nameJTextField.getText();
            String username = usernameJTextField.getText();
            // String password = String.valueOf(passwordJPasswordField.getPassword());
            String address = AddressTextbox.getText();

            String location = ((Location) networkJComboBox.getSelectedItem()).getName();

            Customer customer = new Customer(location, name, username, address, "5", eMailIdJTextField.getText(), PhoneJTextField.getText(),
                    cust.getCustomerIdStr());

            int k = system.getCustomerDirectory().getCustomerList().indexOf(cust);
            system.getCustomerDirectory().getCustomerList().set(k, customer);
            UpdatejButton.setEnabled(false);

            JOptionPane.showMessageDialog(null, "updated successfully!");
            populateTable();
            ResetAllTextboxs();
    }//GEN-LAST:event_UpdatejButtonActionPerformed
    }

    private boolean ValidateEmailId(String emailId) {
        Pattern P = Pattern.compile("^[A-Za-z0-9+_.-]+@[a-zA-Z0-9]+.[a-zA-Z0-9]+$");
        Matcher m = P.matcher(emailId);
        boolean result = m.matches();
        return result;
    }

    private boolean ValidatePassword(String password) {
        // Pattern P = Pattern.compile("^((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6})+$"  );
        Pattern P = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}$");
        Matcher m = P.matcher(password);
        boolean result = m.matches();
        return result;
    }

    private boolean ValidatePhoneNumber(String phoneNumber) {
        // Pattern P = Pattern.compile("^((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6})+$"  );
        Pattern P = Pattern.compile("\\d{10}$");
        Matcher m = P.matcher(phoneNumber);
        boolean result = m.matches();
        return result;
    }

    private boolean ValidateForm(String callingButton) {
        boolean flag = true;
        Border border = BorderFactory.createLineBorder(Color.WHITE, 3);

        if (nameJTextField.getText().equals("")) {  //User have not entered anything. 
            JOptionPane.showMessageDialog(null, "Customer Name Can't be empty");
            nameJTextField.requestFocusInWindow();
            //nameJTextField.setText("");
            border = BorderFactory.createLineBorder(Color.RED, 1);
            nameJTextField.setBorder(border);
            flag = false;
        } else {
            border = BorderFactory.createLineBorder(Color.WHITE, 1);
            nameJTextField.setBorder(border);
        }
        if (usernameJTextField.getText().equals("")) {  //User have not entered anything. 
            JOptionPane.showMessageDialog(null, "Customer UserName Can't be empty");
            usernameJTextField.requestFocusInWindow();
            //usernameJTextField.setText("");
            border = BorderFactory.createLineBorder(Color.RED, 1);
            usernameJTextField.setBorder(border);
            flag = false;
        } else {
            border = BorderFactory.createLineBorder(Color.WHITE, 1);
            usernameJTextField.setBorder(border);
        }

        if (AddressTextbox.getText().equals("")) {  //User have not entered anything. 
            JOptionPane.showMessageDialog(null, "Customer Address Can't be empty");
            AddressTextbox.requestFocusInWindow();
            AddressTextbox.setText("");
            border = BorderFactory.createLineBorder(Color.RED, 1);
            AddressTextbox.setBorder(border);
            flag = false;
        } else {
            border = BorderFactory.createLineBorder(Color.WHITE, 1);
            AddressTextbox.setBorder(border);
        }

        if (String.valueOf(eMailIdJTextField.getText()).equals("")) {  //User have not entered anything. 
            JOptionPane.showMessageDialog(null, "Email Address Can't be empty");
            eMailIdJTextField.requestFocusInWindow();
            eMailIdJTextField.setText("");
            border = BorderFactory.createLineBorder(Color.RED, 1);
            eMailIdJTextField.setBorder(border);
            flag = false;
        } else {
            border = BorderFactory.createLineBorder(Color.WHITE, 1);
            eMailIdJTextField.setBorder(border);
        }

        if (ValidateEmailId(eMailIdJTextField.getText()) != true) {

            border = BorderFactory.createLineBorder(Color.RED, 2);
            eMailIdJTextField.setBorder(border);
            JOptionPane.showMessageDialog(null, "Invalid Email Format.");
            flag = false;
        } else {
            border = BorderFactory.createLineBorder(Color.WHITE, 1);
            eMailIdJTextField.setBorder(border);
        }
        if (String.valueOf(PhoneJTextField.getText()).equals("")) {  //User have not entered anything. 
            JOptionPane.showMessageDialog(null, "Phone Number Can't be empty");
            PhoneJTextField.requestFocusInWindow();
            PhoneJTextField.setText("");
            border = BorderFactory.createLineBorder(Color.RED, 2);
            PhoneJTextField.setBorder(border);
            flag = false;
        } else {
            border = BorderFactory.createLineBorder(Color.WHITE, 1);
            PhoneJTextField.setBorder(border);
        }

        if (ValidatePhoneNumber(PhoneJTextField.getText()) != true) {

            border = BorderFactory.createLineBorder(Color.RED, 2);
            PhoneJTextField.setBorder(border);
            JOptionPane.showMessageDialog(null, "Invalid Phone Number Format.");
            flag = false;
        } else {
            border = BorderFactory.createLineBorder(Color.WHITE, 1);
            PhoneJTextField.setBorder(border);
        }
        if (!callingButton.equals("Update")) {
            if (ValidatePassword(passwordJPasswordField.getText()) != true) {

                border = BorderFactory.createLineBorder(Color.RED, 2);
                passwordJPasswordField.setBorder(border);
                JOptionPane.showMessageDialog(null, "Invalid Password Format.");
                flag = false;
            } else {
                border = BorderFactory.createLineBorder(Color.WHITE, 1);
                passwordJPasswordField.setBorder(border);
            }
            if (String.valueOf(passwordJPasswordField.getPassword()).equals("")) {  //User have not entered anything. 
                JOptionPane.showMessageDialog(null, "Customer Password Can't be empty");
                passwordJPasswordField.requestFocusInWindow();
                passwordJPasswordField.setText("");
                border = BorderFactory.createLineBorder(Color.RED, 1);
                passwordJPasswordField.setBorder(border);
                flag = false;
            } else {
                border = BorderFactory.createLineBorder(Color.WHITE, 1);
                passwordJPasswordField.setBorder(border);
            }
        }
        return flag;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressTextbox;
    private javax.swing.JTextField PhoneJTextField;
    private javax.swing.JLabel Reslable;
    private javax.swing.JButton UpdatejButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField eMailIdJTextField;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JTable enterpriseJTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JPasswordField passwordJPasswordField;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTextField usernameJTextField;
    // End of variables declaration//GEN-END:variables
}
