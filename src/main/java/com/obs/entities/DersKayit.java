package com.obs.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "derskayitlari")
public class DersKayit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kayit_id")
    private int kayit_id;


    @ManyToOne
    @JoinColumn(name = "ogrenci_id")
    private Ogrenci ogrenci;

    @ManyToOne
    @JoinColumn(name = "ders_id")
    private Ders ders;

    @Column(name = "kayit_tarihi")
    private Date kayit_tarihi;
}
