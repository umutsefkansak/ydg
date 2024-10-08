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
@Table(name = "ogretimuyeleri")
public class OgretimUyesi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ogretimuyesi_id")
    private int ogretimuyesi_id;

    @Column(name = "ogretimuyesi_ad")
    private String ogretimuyesi_ad;


    @Column(name = "ogretimuyesi_soyad")
    private String ogretimuyesi_soyad;

    @Column(name = "ogretimuyesi_tc")
    private float ogretimuyesi_tc;

    @Column(name = "ogretimuyesi_eposta")
    private String ogretimuyesi_eposta;


    @ManyToOne
    @JoinColumn(name = "unvan_id",nullable = false)
    private Unvan unvan;

    @ManyToOne
    @JoinColumn(name = "bolum_id",nullable = false)
    private Bolum bolum;


    @OneToMany(mappedBy = "ogretimuyesi")
    private List<Ders> dersler;

    @OneToMany(mappedBy = "danisman")
    private List<Ogrenci> ogrenciler;
}
