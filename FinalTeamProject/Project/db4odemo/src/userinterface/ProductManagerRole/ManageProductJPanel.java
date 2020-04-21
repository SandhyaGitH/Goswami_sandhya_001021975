/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ProductManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Location;
import Business.Organizations.BusinessManagementOrganization;
import Business.Organizations.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InsuranceProductWorkRequest;
import Business.WorkQueue.InsuranceProductWorkRequest.insuranceType;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sandhya goswami
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
        lblEnterpriseName.setText(enterprise.getName());

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
        WorkQueue wq =  userAccount.getWorkQueue();//enterprise.getWorkQueue();
        if (wq != null) {
            for (WorkRequest wr : wq.getWorkRequestList()) {
                if (wr != null) {
                    if (wr.getClass().equals(Business.WorkQueue.InsuranceProductWorkRequest.class)) {
                        InsuranceProductWorkRequest iP = (InsuranceProductWorkRequest) wr;
                        // InsuranceProductWorkRequest isr = wr;
                        Object[] row = new Object[13];
                        row[0] = iP.getNetwork();
                        row[1] = iP.getEnterprise();
                        row[2] = iP.getProductName();
                        row[3] = iP.getInsuranceType();
                        row[4] = iP.getPremuim();
                        row[5] = iP.getProductDescription();
                        row[6] = iP.getCoverageAmount();
                        row[7] = iP.getMessage();
                        row[8] = iP.getStatus();
                        row[9] = iP.getRequestDate();
                        row[10] = iP.getResolveDate();
                        // row[9]=iP.

                        model.addRow(row);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblEnterpriseName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(233, 255, 101));

        menuListJTable.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(51, 51, 0), new java.awt.Color(255, 255, 51)));
        menuListJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Network", "Enterprise", "Name", "Type", "Premium", "Description", "Coverage Amount", "Message", "Status", "Date Requested", "Approved On"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        menuListJTable.setGridColor(new java.awt.Color(204, 255, 204));
        menuListJTable.setSelectionBackground(new java.awt.Color(51, 51, 0));
        jScrollPane1.setViewportView(menuListJTable);

        jLabel2.setText("Product Name");

        nameJTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 0), new java.awt.Color(51, 51, 0), new java.awt.Color(255, 255, 51), new java.awt.Color(255, 255, 51)));

        enterpriseJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        submitJButton.setForeground(new java.awt.Color(255, 255, 255));
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Description");

        Price.setText("Premium");

        backJButton.setBackground(new java.awt.Color(51, 51, 0));
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel12.setText("Type");

        isuranceTypeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        isuranceTypeJComboBox.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 0), new java.awt.Color(51, 51, 0), new java.awt.Color(255, 255, 51), new java.awt.Color(255, 255, 51)));
        isuranceTypeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isuranceTypeJComboBoxActionPerformed(evt);
            }
        });

        txtPrice.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 0), new java.awt.Color(51, 51, 0), new java.awt.Color(255, 255, 51), new java.awt.Color(255, 255, 51)));

        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });

        txtDesc1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 0), new java.awt.Color(51, 51, 0), new java.awt.Color(255, 255, 51), new java.awt.Color(255, 255, 51)));

        requestTestJButton.setBackground(new java.awt.Color(51, 51, 0));
        requestTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        requestTestJButton.setText("Request");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        txtCoverage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 0), new java.awt.Color(51, 51, 0), new java.awt.Color(255, 255, 51), new java.awt.Color(255, 255, 51)));

        Price1.setText("Coverage");

        jLabel5.setText("Message");

        txtMessage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 0), new java.awt.Color(51, 51, 0), new java.awt.Color(255, 255, 51), new java.awt.Color(255, 255, 51)));
        txtMessage.setMaximumSize(new java.awt.Dimension(4, 15));
        txtMessage.setMinimumSize(new java.awt.Dimension(4, 15));
        txtMessage.setPreferredSize(new java.awt.Dimension(6, 18));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Launch New Product");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("My Requested products");

        lblEnterpriseName.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEnterpriseName.setText("jLabel2");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel6.setText("Enterprise");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(submitJButton)
                                .addGap(600, 600, 600)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backJButton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(requestTestJButton)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(Price1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtCoverage, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(isuranceTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(txtDesc1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(310, 310, 310)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblEnterpriseName, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {isuranceTypeJComboBox, txtPrice});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblEnterpriseName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitJButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(isuranceTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2)
                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCoverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Price1)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Price))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(backJButton)
                            .addComponent(requestTestJButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(networkJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Price, Price1, isuranceTypeJComboBox, jLabel12, jLabel2, jLabel4, jLabel5, nameJTextField, txtCoverage, txtDesc1, txtMessage, txtPrice});

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

    private boolean ValidateForm() {
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
        return flag;
    }
    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

        boolean flag = ValidateForm();
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

            if (org != null) {
                enterprise.getWorkQueue().getWorkRequestList().add(request);
                org.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
                JOptionPane.showMessageDialog(null, "saved and sent for approval. Request ID is: " + request);
            } else {
                JOptionPane.showMessageDialog(null, "Could not found the Business organization. Please to Your Enterpsrise admin.");
            }

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEnterpriseName;
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
