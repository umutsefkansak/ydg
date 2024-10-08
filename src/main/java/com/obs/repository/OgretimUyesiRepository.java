package com.obs.repository;

import com.obs.entities.Ogrenci;
import com.obs.entities.OgretimUyesi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OgretimUyesiRepository extends JpaRepository<OgretimUyesi,Integer> {

    @Query(value = "select ogrenci_ad,ogrenci_soyad,ogrenci_eposta,ogrenci_sinif,ogrenci_ortalama from ogrenciler o where o.danisman_id = :ogretimuyesi_id",nativeQuery = true)
    List<String> findDanismanlikVerilenOgrencilerById(@Param("ogretimuyesi_id") int ogretimuyesi_id);


    @Query(value = "SELECT ders_kod,ders_ad from dersler d where d.ogretimuyesi_id=:ogretimuyesi_id",nativeQuery = true)
    List<String> findVerilenDerslerById(@Param("ogretimuyesi_id") int ogretimuyesi_id);
}
