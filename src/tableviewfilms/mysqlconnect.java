/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewfilms;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;



/**
 *
 * @author Mohamed
 */
public class mysqlconnect {

   

    
    Connection conn = null;
    public static Connection ConnectDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) 
                    DriverManager.getConnection("jdbc:mysql://localhost/cimatun","root",""); 
            JOptionPane.showMessageDialog(null,"ConnectionEstablished");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    public static ObservableList<films> getDatafilms(){
        
        Connection conn = ConnectDb();
       
        ObservableList<films> list = FXCollections.observableArrayList();
       try{
       PreparedStatement ps = conn.prepareCall("select * from films");
       ResultSet rs = ps.executeQuery();
       while(rs.next()){
  list.add(new films(Integer.parseInt(rs.getString("id")),Integer.parseInt(rs.getString("duration")),rs.getString("title"),rs.getString("about"),rs.getString("cover"),rs.getString("gallery"),rs.getString("trailer"),rs.getString("country"),rs.getString("categorie"),rs.getString("date")));
  
                  }
       }
       catch(Exception e){
           
       }
         
        
        return list;
    }
} 
