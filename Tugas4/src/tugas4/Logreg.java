/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas4;

/**
 *
 * @author hamma_nvx95l8
 */
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;


public class Logreg extends JFrame {
    JLabel lUsername = new JLabel("Username");
    JLabel lPassword = new JLabel("Password");
    
    
    JTextField fUsername = new JTextField();
    JPasswordField fPassword = new JPasswordField();
    
    JButton btnLogin = new JButton("Login");
    JButton btnRegister = new JButton("Register");
 
    
    public Logreg(){
        setTitle("Login and Register");
        setLayout(null);
        
        add(lUsername);
        add(lPassword);
        
        add(fUsername);
        add(fPassword);
        
        add(btnLogin);
        add(btnRegister);
        
        lUsername.setBounds(30,60,100,20);
        fUsername.setBounds(120,60,150,20);
        lPassword.setBounds(30,140,100,20);
        fPassword.setBounds(120,140,150,20);
        
        btnRegister.setBounds(60,220,160,40);
        btnLogin.setBounds(60,270,160,40);
        
        setSize(300, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        btnLogin.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               Connect cn = new Connect();
               String user = fUsername.getText();
               if(cn.cekUser(user) && user != "" && cn.cekLogin(user ,String.valueOf(fPassword.getPassword()))){
                   JOptionPane.showMessageDialog(null, "Login Berhasil");
               }else if(user.isEmpty() || String.valueOf(fPassword.getPassword()).isEmpty()){
                   JOptionPane.showMessageDialog(null, "Jangan Dikosongkan");
               }
               else if(!cn.cekUser(user)){
                   JOptionPane.showMessageDialog(null, "Username yang dimasukan Salah");
               }
               else{
                   JOptionPane.showMessageDialog(null, "Password yang dimasukan Salah");
               }
           }
       });
        
         btnRegister.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               Connect cn = new Connect();
               String userr = fUsername.getText();
               String pass = String.valueOf(fPassword.getPassword());
               if(!userr.isEmpty() && !pass.isEmpty()){
                   cn.masukanData(userr, pass);
               }
               else if(userr.isEmpty() || pass.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Jangan DiKosongkan");
               }
           }
           
       });
    }
}
