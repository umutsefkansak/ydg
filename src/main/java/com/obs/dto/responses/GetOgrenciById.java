package com.obs.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOgrenciById {
    private int ogrenci_id;
    private String ogrenci_ad;
    private String ogrenci_soyad;
    private float ogrenci_tc;
    private String ogrenci_eposta;
    private int ogrenci_sinif;
    private float ogrenci_ortalama;
    private Date ogrenci_dtarihi;
    private String ogrenci_tel;
    private int bolum_id;
    private int danisman_id;
}
