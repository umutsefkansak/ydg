package com.obs.dto.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDersRequest {

    private String ders_kod;
    private String ders_ad;
    private int ders_akts;
    private int ders_kredi;
    private int ogretimuyesi_id;

}
