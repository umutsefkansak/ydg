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
@Table(name = "fakulteler")
public class Fakulte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fakulte_id")
    private int fakulte_id;

    @Column(name = "fakulte_ad")
    private String fakulte_ad;

    @OneToMany(mappedBy = "fakulte")
    private List<Bolum> bolumler;
}
