/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneOffsetTransitionRule;
import java.util.Date;

/**
 *
 * @author Lab Informatika
 */
public class ParkirModel {
    //untuk nega,bil data parkir
    public int id;
    public String namaPemilik;
    public String platNo;
    public String merk;
    public int durasi;
    public Date waktuMasuk;
    public int bayar;
    public String status; //menyimpn status sudah keluar atau masih parkir
    public ParkirModel(int id,String nama,String plat, String merk,int durasi,Date masuk, String status,int bayar){
        this.id = id;
        this.namaPemilik = nama;
        this.merk = merk;
        this.platNo = plat;
        this.durasi = durasi;
        this.waktuMasuk = masuk;
        this.status = status;
        this.bayar = bayar;
    }
    public ParkirModel(int id,String nama,String plat, String merk,Date masuk, String status,int bayar){
        this.id = id;
        this.namaPemilik = nama;
        this.merk = merk;
        this.platNo = plat;
        this.durasi = 0;
        this.waktuMasuk = masuk;
        this.status = status;
        this.bayar = bayar;
    }

}
