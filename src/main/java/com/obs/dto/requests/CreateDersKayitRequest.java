package com.obs.dto.requests;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDersKayitRequest {

    private int ogrenci_id;
    private int ders_id;
    private Date kayit_tarihi;

}
