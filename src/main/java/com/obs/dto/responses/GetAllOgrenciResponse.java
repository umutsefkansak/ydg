package com.obs.dto.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOgrenciResponse {

    private String ogrenci_ad;
    private String ogrenci_soyad;
    private String bolum_ad;
    private int ogrenci_sinif;
    private float ogrenci_ortalama;


}
