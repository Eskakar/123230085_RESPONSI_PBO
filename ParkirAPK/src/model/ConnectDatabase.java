/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lab Informatika
 */

import java.sql.*;

public class ConnectDatabase {
    String DBurl = "jdbc:mysql//localhost:3306/parkirapk";
    String DBusername = "root";
    String DBpasword="";
    
    Connection koneksi;
    Statement stm;
    
    public ConnectDatabase(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpasword);
            System.out.println("koneksi ke DB berhasil");
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Koneksi ke DB gagal");
        }
        
    }
    
}
