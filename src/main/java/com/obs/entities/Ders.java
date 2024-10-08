package com.obs.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dersler")

public class Ders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ders_id")
    private int ders_id;


    @Column(name = "ders_kod")
    private String ders_kod;

    @Column(name = "ders_ad")
    private String ders_ad;

    @Column(name = "ders_akts")
    private int ders_akts;

    @Column(name = "ders_kredi")
    private int ders_kredi;

    @ManyToOne
    @JoinColumn(name = "ogretimuyesi_id")
    private OgretimUyesi ogretimuyesi;

    @OneToMany(mappedBy = "ders")
    private List<DersKayit> ders_kayitlari;

    @OneToMany(mappedBy = "ders")
    private List<Not> notlar;


}
