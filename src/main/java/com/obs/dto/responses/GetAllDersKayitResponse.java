package com.obs.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDersKayitResponse {
    private String ogrenci_ad;
    private String ders_ad;
    private Date kayit_tarihi;
}
