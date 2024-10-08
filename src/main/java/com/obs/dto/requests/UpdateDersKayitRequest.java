package com.obs.dto.requests;


import com.obs.entities.Ders;
import com.obs.entities.Ogrenci;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDersKayitRequest{
    private int kayit_id;
    private int ogrenci_id;
    private int ders_id;
    private Date kayit_tarihi;

}
