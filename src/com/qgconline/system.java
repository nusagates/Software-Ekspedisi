/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qgconline;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author WINDOWS
 */
public class system {

    static JFrame l, b;
    static Connection con;
    static Statement stmt;

    public static JFrame login() {
        l = new JFrame();
        panel p=new panel();
        l.getContentPane().add(panel.login);
        l.pack();
        l.setLocationRelativeTo(null);
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l.setVisible(true);
        return l;
    }
   public static void pelanggan() throws SQLException{
      koneksi();
       DefaultListModel lis=new DefaultListModel();
       ResultSet rs=stmt.executeQuery("SELECT * FROM Pelanggan");
       while(rs.next()){
           String a=rs.getString("KodePelanggan");
           String b=rs.getString("NamaPelanggan");
           String c=rs.getString("Alamat");
           lis.addElement("("+a+") "+b+" - "+c);
       }
       pelanggan.plgn.setModel(lis);
       
      
      
   }

    public static void koneksi() throws SQLException {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
            stmt = (Statement) con.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(system.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
