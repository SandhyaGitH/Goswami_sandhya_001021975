/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import javax.swing.JOptionPane;
import Business.ProductDirectory;
import Business.Product;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import jdk.nashorn.internal.objects.NativeArray;
/**
 *
 * @author info
 */
public class CreateProductJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateAccontJPanel
     */
    private ProductDirectory prodDir;
    private JPanel panel;
    
    public CreateProductJPanel(ProductDirectory prodDir, JPanel panel) {
        initComponents();
        this.prodDir = prodDir;
        this.panel=panel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHead = new javax.swing.JLabel();
        lblRoutingNo = new javax.swing.JLabel();
        lblAccNo = new javax.swing.JLabel();
        lblBankName = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        txtProdName = new javax.swing.JTextField();
        txtAvailablity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 255));

        lblHead.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHead.setText("Create Product");

        lblRoutingNo.setText("Product Name*");

        lblAccNo.setText("Availiblity*");

        lblBankName.setText("Price*");

        lblBalance.setText("Description");

        btnCreate.setText("Create Account");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(lblHead))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoutingNo)
                            .addComponent(lblAccNo)
                            .addComponent(lblBankName)
                            .addComponent(lblBalance))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAvailablity, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(txtPrice)
                            .addComponent(txtDescription)
                            .addComponent(txtProdName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnCreate)
                        .addGap(26, 26, 26)
                        .addComponent(BackButton)))
                .addContainerGap(305, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblHead)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoutingNo)
                    .addComponent(txtProdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccNo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAvailablity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBankName)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBalance)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(BackButton))
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
             String priceText = txtPrice.getText();
        double price =0;
        try
        {
            price =Double.parseDouble(priceText);
        }catch(NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Please Enter Valid Price");
            return;
        }
                if(txtProdName.getText().equals(""))
                { 
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Product Name");
                    return;
                }
                else 
                {
                    ArrayList<Product> pp = new ArrayList<Product>();
                 pp=   prodDir.getProductDirectory();
                    Product prod ;
                    for(int i=0;i<prodDir.getProductDirectory().size();i++)
                    {
                        prod=pp.get(i);
                        if(prod.getName().equals(txtProdName.getText()))
                        {  
                            JOptionPane.showMessageDialog(null, "Duplicate Product Name");
                            return;}
                       // if(pp[i].get)
                    }
                }
                
           // Double.parseDouble(txtPrice.getText());
          // String availabilityText = txtAvailablity.getText();
           int availability;
           try
           {
               availability =  Integer.parseInt(txtAvailablity.getText());
           }catch(NumberFormatException e){
                e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Please Enter Availability in Numbers Only.");
               return;
           }
           
            Integer.parseInt(txtAvailablity.getText());
            Product prod = prodDir.addProduct();
            prod.setName(txtProdName.getText());
            prod.setAvailNum(availability);
            prod.setPrice(price);
            prod.setDescription(txtDescription.getText());
            
            JOptionPane.showMessageDialog(null, "Account Created Successfully");
            
            txtProdName.setText("");
            txtAvailablity.setText("");
            txtPrice.setText("");
            txtDescription.setText("");
    }//GEN-LAST:event_btnCreateActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        this.panel.remove(this);
        CardLayout layout =(CardLayout) this.panel.getLayout();
        layout.previous(panel);
    }//GEN-LAST:event_BackButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel lblAccNo;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblBankName;
    private javax.swing.JLabel lblHead;
    private javax.swing.JLabel lblRoutingNo;
    private javax.swing.JTextField txtAvailablity;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProdName;
    // End of variables declaration//GEN-END:variables
}


