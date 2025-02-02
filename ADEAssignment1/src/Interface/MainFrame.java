/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Business.Person;
/**
 *
 * @author samarth
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private Person person;
    public MainFrame() {
        initComponents();
        person = new Person();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SplitPane = new javax.swing.JSplitPane();
        ControlJpanal = new javax.swing.JPanel();
        Btn_CreateProfile = new javax.swing.JButton();
        Btn_ViewProfile = new javax.swing.JButton();
        DisplayJpanal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btn_CreateProfile.setText("Create");
        Btn_CreateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CreateProfileActionPerformed(evt);
            }
        });

        Btn_ViewProfile.setText("View");
        Btn_ViewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ViewProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ControlJpanalLayout = new javax.swing.GroupLayout(ControlJpanal);
        ControlJpanal.setLayout(ControlJpanalLayout);
        ControlJpanalLayout.setHorizontalGroup(
            ControlJpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlJpanalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlJpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_CreateProfile)
                    .addComponent(Btn_ViewProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ControlJpanalLayout.setVerticalGroup(
            ControlJpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlJpanalLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Btn_CreateProfile)
                .addGap(18, 18, 18)
                .addComponent(Btn_ViewProfile)
                .addContainerGap(398, Short.MAX_VALUE))
        );

        SplitPane.setLeftComponent(ControlJpanal);

        DisplayJpanal.setAutoscrolls(true);

        javax.swing.GroupLayout DisplayJpanalLayout = new javax.swing.GroupLayout(DisplayJpanal);
        DisplayJpanal.setLayout(DisplayJpanalLayout);
        DisplayJpanalLayout.setHorizontalGroup(
            DisplayJpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
        );
        DisplayJpanalLayout.setVerticalGroup(
            DisplayJpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        SplitPane.setRightComponent(DisplayJpanal);

        getContentPane().add(SplitPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_CreateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CreateProfileActionPerformed
               // TODO add your handling code here:
               CreateJPanal CreatPanal = new CreateJPanal(person);
               SplitPane.setRightComponent(CreatPanal);
    }//GEN-LAST:event_Btn_CreateProfileActionPerformed

    private void Btn_ViewProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ViewProfileActionPerformed
        // TODO add your handling code here:
         ViewJPanal ViewPanal = new ViewJPanal(person);
               SplitPane.setRightComponent(ViewPanal);
    }//GEN-LAST:event_Btn_ViewProfileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_CreateProfile;
    private javax.swing.JButton Btn_ViewProfile;
    private javax.swing.JPanel ControlJpanal;
    private javax.swing.JPanel DisplayJpanal;
    private javax.swing.JSplitPane SplitPane;
    // End of variables declaration//GEN-END:variables
}
