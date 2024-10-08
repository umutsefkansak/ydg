package com.obs.dto.requests;

import com.obs.entities.Bolum;
import com.obs.entities.Unvan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOgretimUyesiRequest {

    private int ogretimuyesi_id;
    private String ogretimuyesi_ad;
    private String ogretimuyesi_soyad;
    private float ogretimuyesi_tc;
    private String ogretimuyesi_eposta;
    private int unvan_id;
    private int bolum_id;

}
