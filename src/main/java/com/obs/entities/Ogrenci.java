package com.obs.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ogrenciler")
public class Ogrenci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ogrenci_id")
    private int ogrenci_id;

    @Column(name = "ogrenci_ad")
    private String ogrenci_ad;

    @Column(name = "ogrenci_soyad")
    private String ogrenci_soyad;

    @Column(name = "ogrenci_tc")
    private float ogrenci_tc;

    @Column(name = "ogrenci_eposta")
    private String ogrenci_eposta;

    @Column(name = "ogrenci_sinif")
    private int ogrenci_sinif;

    @Column(name = "ogrenci_ortalama")
    private float ogrenci_ortalama;

    @Column(name = "ogrenci_dtarihi")
    private Date ogrenci_dtarihi;

    @Column(name = "ogrenci_tel")
    private String ogrenci_tel;


    @ManyToOne
    @JoinColumn(name = "bolum_id", nullable = false)
    private Bolum bolum;

    @ManyToOne
    @JoinColumn(name = "danisman_id", nullable = false)
    private OgretimUyesi danisman;


    @OneToMany(mappedBy = "ogrenci")
    private List<DersKayit> ders_kayitlari;

    @OneToMany(mappedBy = "ogrenci")
    private List<Not> notlar;

}
