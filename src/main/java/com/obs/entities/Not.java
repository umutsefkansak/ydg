package com.obs.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "notlar")

public class Not implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "not_id")
    private int not_id;


    @ManyToOne
    @JoinColumn(name = "ogrenci_id")
    private Ogrenci ogrenci;


    @ManyToOne
    @JoinColumn(name = "ders_id")
    private Ders ders;

    @Column(name = "vize_not")
    private int vize_not;

    @Column(name = "final_not")
    private Integer final_not;

    @Column(name = "odev_not")
    private Integer odev_not;

    @Column(name = "ort_not")
    private Integer ort_not;



}
