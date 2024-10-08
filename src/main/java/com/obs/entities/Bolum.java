package com.obs.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bolumler")
public class Bolum {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bolum_id")
    private int bolum_id;

    @Column(name = "bolum_ad")
    private String bolum_ad;


    @ManyToOne
    @JoinColumn(name = "fakulte_id")
    private Fakulte fakulte;

    @OneToMany(mappedBy = "bolum")
    private List<OgretimUyesi> ogretimUyeleri;

    @OneToMany(mappedBy = "bolum")
    private List<Ogrenci> ogrenciler;
}
