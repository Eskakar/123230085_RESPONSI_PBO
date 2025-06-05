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
import java.util.ArrayList;
import java.util.List;

public class ModelDBParkir {
    private Connection conn;
    public ModelDBParkir(){
    ResultSet rs_allParkir;
        try{
            String url  = "jdbc:mysql//localhost:3306/parkirapk";
            String username = "root";
            String pasword="";
            conn = DriverManager.getConnection(url,username,pasword);
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    //tambah data orang parkir
    public void tambahParkir(ParkirModel p){
        String querry = "insert into parkir (nama_pemilik,plat_nomor,merk,waktu_masuk,status) VALUES(?,?,?,Date now(),?)";
        try(PreparedStatement stmt = conn.prepareStatement(querry)){
            stmt.setString(1, p.namaPemilik);
            stmt.setString(2, p.platNo);
            stmt.setString(3, p.merk);
            stmt.setString(5, "Parkir");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    // edit status parkir dan durasi
    public void editParkirStatus(ParkirModel p){
        String querry = "UPDATE parkir SET status=?,durasi=?,bayar=? WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(querry)){
            stmt.setString(1, p.status);
            stmt.setInt(2,p.durasi);
            stmt.setInt(3,p.bayar);
            stmt.setInt(4, p.id);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    // edit data kendaraan
    public void editParkirData(ParkirModel p){
        String querry = "UPDATE parkir SET status=?,durasi=?,nama_pemilik = ?,plat_nomor = ?,merk = ?,waktu_masuk = ?, bayar=? WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(querry)){
            stmt.setString(1, p.status);
            stmt.setInt(2,p.durasi);
            stmt.setString(3, p.namaPemilik);
            stmt.setString(4, p.platNo);
            stmt.setString(5, p.merk);
            stmt.setDate(6, (Date) p.waktuMasuk);
            stmt.setInt(7, p.bayar);
            stmt.setInt(8, p.id);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //ambil semua data kendaraan sedang parkir
    public List<ParkirModel> dataParkir = new ArrayList<>(){
        String querry = "SELECT * FROM transaksi WHERE status = 'parkir'";
        try(Statement stmt = conn.createStatement();
            rs_allParkir = stmt.executeQuery(querry)){
            while(rs_allParkir.next()){
                ModelDBParkir p = new ModelDBParkir();
            };
        }catch(SQLException e){
                System.out.println(e);
        }       
    }
        
    
}
