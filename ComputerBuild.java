/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leena
 */
public class ComputerBuild extends javax.swing.JFrame {
    String url = "jdbc:mysql://localhost:3306/Computer_Builds?serverTimezone=UTC";
    String user = "root";
    String pass = "";
    Connection conn;
    PreparedStatement ps;
    Statement stmt;

    
    //Creates new form Computer_Build
     
    public ComputerBuild() {
        initComponents();
        retrieveForComboBox();
        table_update();
    }
    
    public void retrieveForComboBox(){
         try{
                            conn = DriverManager.getConnection(url,user,pass);
		            stmt = conn.createStatement();
		            ResultSet pp = stmt.executeQuery("SELECT Name FROM processor_products");
                            while(pp.next()){
                                processor_list.addItem(pp.getString(1));
                            }
                            ResultSet pss = stmt.executeQuery("Select Name from power_supply");
                            while(pss.next()){
                                power_supply_list.addItem(pss.getString(1));
                            }
                            ResultSet mb = stmt.executeQuery("Select Name from motherboard");
                            while(mb.next()){
                                motherboard_list.addItem(mb.getString(1));
                            }
                            ResultSet ram = stmt.executeQuery("Select name from ram");
                            while(ram.next()){
                                ram_list.addItem(ram.getString(1));
                            }
                            ResultSet strg = stmt.executeQuery("Select name from storage");
                            while(strg.next()){
                                storage_list.addItem(strg.getString(1));
                            }
                            ResultSet clr = stmt.executeQuery("Select name from cooler");
                            while(clr.next()){
                                cooler_list.addItem(clr.getString(1));
                            }
                            ResultSet cse = stmt.executeQuery("Select name from case_products");
                            while(cse.next()){
                                case_list.addItem(cse.getString(1));
                            }                     
        }
        catch(SQLException e){
            System.out.println(e);
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

        Your_Build = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Processor = new javax.swing.JLabel();
        processor_list = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        power_supply_list = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        motherboard_list = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ram_list = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        storage_list = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cooler_list = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        case_list = new javax.swing.JComboBox<>();
        CreateBuild = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Your_Build.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Your_Build.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Your_Build.setText("Your Build");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pick Your Parts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        Processor.setText("Processor");

        processor_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processor_listActionPerformed(evt);
            }
        });

        jLabel1.setText("Power Supply");

        power_supply_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                power_supply_listActionPerformed(evt);
            }
        });

        jLabel2.setText("Motherboard");

        jLabel3.setText("RAM");

        jLabel4.setText("Storage");

        jLabel5.setText("Cooler");

        jLabel6.setText("Case");

        CreateBuild.setText("Create Build");
        CreateBuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateBuildActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(69, 69, 69))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(power_supply_list, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(case_list, 0, 224, Short.MAX_VALUE)
                                    .addComponent(cooler_list, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ram_list, 0, 224, Short.MAX_VALUE)
                                    .addComponent(storage_list, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(CreateBuild)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Processor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(motherboard_list, javax.swing.GroupLayout.Alignment.TRAILING, 0, 224, Short.MAX_VALUE)
                                    .addComponent(processor_list, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Processor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(processor_list))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motherboard_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ram_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(storage_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cooler_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(power_supply_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(case_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(CreateBuild)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Processor", "Motherboard", "Ram", "Storage", "Cooler", "Power Supply", "Case"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("Parts");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Your_Build)
                .addGap(288, 288, 288))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Your_Build)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void processor_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processor_listActionPerformed
       
    }//GEN-LAST:event_processor_listActionPerformed

    private void power_supply_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_power_supply_listActionPerformed

    }//GEN-LAST:event_power_supply_listActionPerformed
    private void table_update(){
        try{
            int c;
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            ps = conn.prepareStatement("select * from build");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            c = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                for(int i=0;i<c;i++){
                    v.add(rs.getString("Processor"));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3));
                    v.add(rs.getString(4));
                    v.add(rs.getString(5));
                    v.add(rs.getString(6));
                    v.add(rs.getString(7));               
                }
                df.addRow(v);
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }
    private void CreateBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBuildActionPerformed
        String processor = processor_list.getSelectedItem().toString();
        String motherboard = motherboard_list.getSelectedItem().toString();
        String ram = ram_list.getSelectedItem().toString();
        String storage = storage_list.getSelectedItem().toString();
        String cooler = cooler_list.getSelectedItem().toString();
        String powersupply = power_supply_list.getSelectedItem().toString();
        String pccase = case_list.getSelectedItem().toString();
        try{
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            ps = conn.prepareStatement("insert into build values(?,?,?,?,?,?,?,?)");
            ps.setString(1, processor);
            ps.setString(2, motherboard);
            ps.setString(3, ram);
            ps.setString(4, storage);
            ps.setString(5, cooler);
            ps.setString(6, powersupply);
            ps.setString(7, pccase);
            ps.setString(8, null);
            ps.executeUpdate();
            ResultSet rs = stmt.executeQuery("select * from compatibility where id = (select max(id) from compatibility)");
            rs.next();           
            if(("yes".equals(rs.getString(2)))&&("no".equals(rs.getString(3)))){
                try{
                    CallableStatement cstmt = conn.prepareCall("{call totalprice()}");
                    cstmt.execute();
                    ResultSet rrs = cstmt.getResultSet();
                    rrs.next();
                    JOptionPane.showMessageDialog(this,"Your parts are compatible with each other.\n\nYour build cost is "+rrs.getString(1),"Success!",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(SQLException e){
                    System.out.println(e);
                }
            }
            else if(("yes".equals(rs.getString(2)))&&("yes".equals(rs.getString(3)))){
                try{
                    CallableStatement cstmt = conn.prepareCall("{call totalprice()}");
                    cstmt.execute();
                    rs = cstmt.getResultSet();
                    rs.next();
                    JOptionPane.showMessageDialog(this,"Your parts are compatible with each other.\nNote: You're using more RAM than your motherboard supports. This is not an compatibility issue but you'll be left over with unused RAM.\n\nYour build cost is "+rs.getString(1),"Success!",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(SQLException e){
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Your parts are NOT compatible with each other.\nMake sure that the Processor and Motherboard share the same Socket.","Try again!",JOptionPane.ERROR_MESSAGE);
                try{
                    CallableStatement cstmt = conn.prepareCall("{call dropbuild()}");
                    cstmt.execute();                   
                }
                catch(SQLException e){
                    System.out.println(e);
                }
            }
            table_update();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_CreateBuildActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    
    }//GEN-LAST:event_jTable1MouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new KnowYourParts().setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(ComputerBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComputerBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComputerBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComputerBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ComputerBuild().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateBuild;
    private javax.swing.JLabel Processor;
    private javax.swing.JLabel Your_Build;
    private javax.swing.JComboBox<String> case_list;
    private javax.swing.JComboBox<String> cooler_list;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> motherboard_list;
    private javax.swing.JComboBox<String> power_supply_list;
    private javax.swing.JComboBox<String> processor_list;
    private javax.swing.JComboBox<String> ram_list;
    private javax.swing.JComboBox<String> storage_list;
    // End of variables declaration//GEN-END:variables
}
