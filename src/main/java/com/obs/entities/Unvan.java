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
@Table(name = "unvanlar")
public class Unvan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unvan_id")
    private int unvan_id;


    @Column(name = "unvan_ad")
    private String unvan_ad;


    @OneToMany(mappedBy = "unvan")
    private List<OgretimUyesi> ogretimuyeleri;


}
