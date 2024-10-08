package com.obs.dto.responses;


import com.obs.entities.Ders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOgretimUyesiResponse {

    private String ogretimuyesi_ad;
    private String ogretimuyesi_soyad;
    private String ogretimuyesi_eposta;
    private String  unvan_ad;
    private String bolum_ad;

}
