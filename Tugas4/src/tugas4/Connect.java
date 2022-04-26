/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas4;

/**
 *
 * @author hamma_nvx95l8
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;

public class Connect {
    String dbUrl = "jdbc:mysql://localhost/tugasjdbc";
    String dbUsername = "root";
    String dbPassword = "";
   
    Connection con;
    String data[] = new String[2];
    static String[] username;
    Statement statement; 
    
    public Connect() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
        
    }
    void masukanData(String username, String password) {
        try {
            if(!cekUser(username)){
                String query = "INSERT INTO `users`(`username`,`password`) "
                    + "VALUES('" + username + "','" + password + "')";

                statement = con.createStatement();
                statement.executeUpdate(query);

                System.out.println("Masuk Berhasil!");
                JOptionPane.showMessageDialog(null, "Register telah Berhasil!");
            }else{
                JOptionPane.showMessageDialog(null, "Username Sudah Ada!!");
            }
            
        } catch (Exception ex) {
            System.out.println("Eksekusi gagal!");
        }
    }
    
    
    
    boolean cekLogin(String username, String password){
         try {
             String query = "SELECT * FROM `users` WHERE username='"+username+"'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);

            
            while(rs.next()){ 
                data[0] = rs.getString("username"); 
                data[1] = rs.getString("password");
            }
            statement.close();
             System.out.println(data[1].toString());
             System.out.println(password);
            if(data[1].toString().equals(password)){
                return true;
            }else{
                return false;
            }
            
         } catch (Exception e) {
            return false;
         }
       
     }
    
    boolean cekUser(String username){
         try {
             String query = "SELECT * FROM `users` WHERE username='"+username+"'";
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);

            
            while(rs.next()){ 
                data[0] = rs.getString("username"); 
            }
            statement.close();
            data[0].toString();
            return true;
         } catch (Exception e) {
            return false;
         }
       
     }
    
    
}
