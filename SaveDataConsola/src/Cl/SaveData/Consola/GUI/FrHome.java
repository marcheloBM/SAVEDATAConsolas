/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Cl.SaveData.Consola.GUI;

import Cl.SaveData.Consola.FUN.Directorio;
import Cl.SaveData.Consola.Conf.*;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author march
 */
public class FrHome extends javax.swing.JFrame {

    Directorio d = new Directorio();
    static String urlUSB;
    
    /**
     * Creates new form FrHome
     */
    public FrHome() {
        initComponents();
        setLocationRelativeTo(null);
        
        USB();
        txtUSB.setText("");
        txtArchivo.setText("");
        limpiado();
    }

    public void limpiado(){
        jRadioButton1.setSelected(false);
        jRadioButton1.setText("No Hay SAVEDATA PS2");
        jRadioButton1.setForeground(Color.RED);
        jRadioButton2.setSelected(false);
        jRadioButton2.setText("No Hay SAVEDATA PS1");
        jRadioButton2.setForeground(Color.RED);
        jRadioButton3.setSelected(false);
        jRadioButton3.setText("No Hay SAVEDATA PS3");
        jRadioButton3.setForeground(Color.RED);
        jRadioButton4.setSelected(false);
        jRadioButton4.setText("No Hay SAVEDATA PSP");
        jRadioButton4.setForeground(Color.RED);
        jRadioButton5.setSelected(false);
        jRadioButton5.setText("No Hay SAVEDATA PSP");
        jRadioButton5.setForeground(Color.RED);
        jRadioButton6.setSelected(false);
        jRadioButton6.setText("No Hay SAVEDATA PS4 Apolo");
        jRadioButton6.setForeground(Color.RED);
        jRadioButton7.setSelected(false);
        jRadioButton7.setText("No Hay SAVEDATA PS4");
        jRadioButton7.setForeground(Color.RED);
        jRadioButton8.setSelected(false);
        jRadioButton8.setText("No Hay SAVEDATA PSVita Apolo");
        jRadioButton8.setForeground(Color.RED);
        jRadioButton9.setSelected(false);
        jRadioButton9.setText("No Hay SAVEDATA PSVita");
        jRadioButton9.setForeground(Color.RED);
        jRadioButton10.setSelected(false);
        jRadioButton10.setText("No Hay SAVEDATA PSP Adrenaline");
        jRadioButton10.setForeground(Color.RED);
        btnPS3.setEnabled(false);
        btnPSP.setEnabled(false);
        btnPS4.setEnabled(false);
        btnPSVita.setEnabled(false);
        btnAll.setEnabled(false);
    }
    
    public void USB(){
        File unidades[] = File.listRoots();
        jcbUSB.removeAllItems();
        for(int i=0;i<unidades.length;i++){
//            System.out.println(unidades[i]);
//            System.out.println(FileSystemView.getFileSystemView().getSystemDisplayName (unidades[i]));
            String unidad=FileSystemView.getFileSystemView().getSystemDisplayName (unidades[i]);
            if(unidad.length()!=0){
                jcbUSB.addItem(FileSystemView.getFileSystemView().getSystemDisplayName (unidades[i]));
            }
        }
    }
    
    public void Contenido(String usb, List<String> rutas){
        String mensaje ="Carpetas Disponibles";
        for (String ruta : rutas) {
            Path rutaAVerificar = Paths.get(usb+""+ruta);
            try {
                if (d.rutaExiste(rutaAVerificar)) {
//                    System.out.println("La ruta " + rutaAVerificar + " existe.");
                    if (d.carpetaTieneContenido(rutaAVerificar)) {
//                        System.out.println("La carpeta " + rutaAVerificar + " tiene contenido.");
//                        txtArchivo.setText("Hay Archivos");
                        jTextArea1.setText(mensaje=mensaje+"\nHay Archivos:"+rutaAVerificar);
                       ContenidoPS3(""+ruta);
                    } else {
//                        System.out.println("La carpeta " + rutaAVerificar + " está vacía.");
//                        txtArchivo.setText("No hay Archivos");
                        jTextArea1.setText(mensaje=mensaje+"\nEstá Vacía:"+rutaAVerificar);
                    }
                } else {
//                    System.out.println("La ruta " + rutaAVerificar + " no existe.");
//                    txtArchivo.setText("No hay Carpetas");
                    jTextArea1.setText(mensaje=mensaje+"\nNo Hay Carpetas:"+rutaAVerificar);
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("El USB no Contiene nada de nada");
            }
        }
    }
    
    public void ContenidoPS3(String rutaCarpeta){
        System.out.println(rutaCarpeta);
        if(rutaCarpeta.equals(Confi.PS3PS2)){
            jRadioButton1.setSelected(true);
            jRadioButton1.setText("Hay SAVEDATA PS2");
            jRadioButton1.setForeground(Color.GREEN);
            btnPS3.setEnabled(true);
            btnAll.setEnabled(true);
        }
        if(rutaCarpeta.equals(Confi.PS3PS1)){
            jRadioButton2.setSelected(true);
            jRadioButton2.setText("Hay SAVEDATA PS1");
            jRadioButton2.setForeground(Color.GREEN);
            btnPS3.setEnabled(true);
            btnAll.setEnabled(true);
        }
        if(rutaCarpeta.equals(Confi.PS3PS3)){
            jRadioButton3.setSelected(true);
            jRadioButton3.setText("Hay SAVEDATA PS3");
            jRadioButton3.setForeground(Color.GREEN);
            btnPS3.setEnabled(true);
            btnAll.setEnabled(true);
        }
        if(rutaCarpeta.equals(Confi.PS3PSP)){
            jRadioButton4.setSelected(true);
            jRadioButton4.setText("Hay SAVEDATA PSP");
            jRadioButton4.setForeground(Color.GREEN);
            jRadioButton5.setSelected(true);
            jRadioButton5.setText("Hay SAVEDATA PSP");
            jRadioButton5.setForeground(Color.GREEN);
            btnPS3.setEnabled(true);
            btnPSP.setEnabled(true);
            btnAll.setEnabled(true);
        }
        if(rutaCarpeta.equals(Confi.PS4Apolo)){
            jRadioButton6.setSelected(true);
            jRadioButton6.setText("Hay SAVEDATA PS4 Apolo");
            jRadioButton6.setForeground(Color.GREEN);
            btnPS4.setEnabled(true);
            btnAll.setEnabled(true);
        }
        if(rutaCarpeta.equals(Confi.PS4PS4)){
            jRadioButton7.setSelected(true);
            jRadioButton7.setText("Hay SAVEDATA PS4");
            jRadioButton7.setForeground(Color.GREEN);
            btnPS4.setEnabled(true);
            btnAll.setEnabled(true);
        }
        if(rutaCarpeta.equals(Confi.PSVApolo)){
            jRadioButton8.setSelected(true);
            jRadioButton8.setText("Hay SAVEDATA PSVita Apolo");
            jRadioButton8.setForeground(Color.GREEN);
            btnPSVita.setEnabled(true);
            btnAll.setEnabled(true);
        }
        if(rutaCarpeta.equals(Confi.PSVita)){
            jRadioButton9.setSelected(true);
            jRadioButton9.setText("Hay SAVEDATA PSVita");
            jRadioButton9.setForeground(Color.GREEN);
            btnPSVita.setEnabled(true);
            btnAll.setEnabled(true);
        }
        if(rutaCarpeta.equals(Confi.PSPAdrenaline)){
            jRadioButton10.setSelected(true);
            jRadioButton10.setText("Hay SAVEDATA PSP Adrenaline");
            jRadioButton10.setForeground(Color.GREEN);
            btnPSVita.setEnabled(true);
            btnAll.setEnabled(true);
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

        jcbUSB = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        txtUSB = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        btnPS3 = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        btnPSP = new javax.swing.JButton();
        btnPS4 = new javax.swing.JButton();
        btnPSVita = new javax.swing.JButton();
        btnAll = new javax.swing.JButton();
        txtArchivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));

        jcbUSB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton5.setText("Seleccionar USB");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtUSB.setText("jLabel2");

        jPanel1.setName(""); // NOI18N

        jLabel1.setText("SAVEDATA PS3");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jRadioButton1.setText("SAVEDATA PS2");

        btnPS3.setText("Copiar PS3");
        btnPS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPS3ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("SAVEDATA PS1");

        jRadioButton3.setText("SAVEDATA PS3");

        jRadioButton4.setText("SAVEDATA PSP");

        jLabel2.setText("SAVEDATA PSP");

        jRadioButton5.setText("SAVEDATA PSP");

        jLabel3.setText("SAVEDATA PS4");

        jRadioButton6.setText("SAVEDATA Apolo");

        jRadioButton7.setText("SAVEDATA PS4");

        jLabel4.setText("SAVEDATA PSVita");

        jRadioButton8.setText("SAVEDATA Apolo");

        jRadioButton9.setText("SAVEDATA PSVita");

        jRadioButton10.setText("SAVEDATA PSP Adrenaline");

        btnPSP.setText("Copiar PSP");
        btnPSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPSPActionPerformed(evt);
            }
        });

        btnPS4.setText("Copiar PS4");
        btnPS4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPS4ActionPerformed(evt);
            }
        });

        btnPSVita.setText("Copiar PSVita");
        btnPSVita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPSVitaActionPerformed(evt);
            }
        });

        btnAll.setText("Copiar All");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jLabel1)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButton6)
                    .addComponent(jLabel4)
                    .addComponent(jRadioButton8)
                    .addComponent(jRadioButton9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton10))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPSVita)
                            .addComponent(btnPS4)
                            .addComponent(btnPSP)
                            .addComponent(btnPS3)
                            .addComponent(btnAll))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(btnPS3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton5)
                            .addComponent(btnPSP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton7)
                            .addComponent(btnPS4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton10)
                            .addComponent(btnPSVita))))
                .addGap(28, 28, 28)
                .addComponent(btnAll)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        txtArchivo.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcbUSB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addComponent(txtUSB)
                            .addComponent(txtArchivo))
                        .addContainerGap(602, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbUSB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(txtUSB)
                .addGap(4, 4, 4)
                .addComponent(txtArchivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String usbselect=(String) jcbUSB.getSelectedItem();
        String usbselect2=usbselect.substring(usbselect.length() - 4);
        urlUSB=usbselect2.replaceAll("[()]","");
        //        txtUSB.setText("Unidad USB Seleccionada "+usbselect);
        txtUSB.setText(usbselect);
        //jButton1.setEnabled(true);
        //jButton2.setEnabled(true);
        //jButton3.setEnabled(true);
        Contenido(urlUSB,Confi.AllRutas);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnPS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPS3ActionPerformed
        // TODO add your handling code here:
        String mensaje ="Rutas de PS3 Copiadas";
        for (String ruta : Confi.AllPS3) {
            try {
                d.copiarDirectorio(Paths.get(urlUSB+""+ruta), Paths.get(System.getProperty("user.dir")+"/SAVEDATA"+ruta));
                jTextArea1.setText(mensaje=mensaje+"\nCopiado:/SAVEDATA"+ruta);
            } catch (IOException ex) {
                Logger.getLogger(FrHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnPS3ActionPerformed

    private void btnPSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPSPActionPerformed
        // TODO add your handling code here:
        String mensaje ="Rutas de PSP Copiadas";
        for (String ruta : Confi.AllPSP) {
            try {
                d.copiarDirectorio(Paths.get(urlUSB+""+ruta), Paths.get(System.getProperty("user.dir")+"/SAVEDATA"+ruta));
                jTextArea1.setText(mensaje=mensaje+"\nCopiado:/SAVEDATA"+ruta);
            } catch (IOException ex) {
                Logger.getLogger(FrHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPSPActionPerformed

    private void btnPS4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPS4ActionPerformed
        // TODO add your handling code here:
        String mensaje ="Rutas de PSP Copiadas";
        for (String ruta : Confi.AllPS4) {
            try {
                d.copiarDirectorio(Paths.get(urlUSB+""+ruta), Paths.get(System.getProperty("user.dir")+"/SAVEDATA"+ruta));
                jTextArea1.setText(mensaje=mensaje+"\nCopiado:/SAVEDATA"+ruta);
            } catch (IOException ex) {
                Logger.getLogger(FrHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPS4ActionPerformed

    private void btnPSVitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPSVitaActionPerformed
        // TODO add your handling code here:
        String mensaje ="Rutas de PSP Copiadas";
        for (String ruta : Confi.AllPSVita) {
            try {
                d.copiarDirectorio(Paths.get(urlUSB+""+ruta), Paths.get(System.getProperty("user.dir")+"/SAVEDATA"+ruta));
                jTextArea1.setText(mensaje=mensaje+"\nCopiado:/SAVEDATA"+ruta);
            } catch (IOException ex) {
                Logger.getLogger(FrHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPSVitaActionPerformed

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
            java.util.logging.Logger.getLogger(FrHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnPS3;
    private javax.swing.JButton btnPS4;
    private javax.swing.JButton btnPSP;
    private javax.swing.JButton btnPSVita;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> jcbUSB;
    private javax.swing.JLabel txtArchivo;
    private javax.swing.JLabel txtUSB;
    // End of variables declaration//GEN-END:variables
}
