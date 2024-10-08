package com.obs.repository;

import com.obs.entities.Ogrenci;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci,Integer> {


    @Query(value = "select ogretimuyesi_ad,ogretimuyesi_soyad from ogrenciler o INNER JOIN ogretimuyeleri ou on o.danisman_id = ou.ogretimuyesi_id where o.ogrenci_id = :ogrenci_id",nativeQuery = true)
    String findDanismanByOgrenciId(@Param("ogrenci_id") int ogrenci_id);

    @Query(value = "SELECT d.ders_ad FROM dersler d INNER JOIN derskayitlari dk ON d.ders_id =dk.ders_id INNER JOIN ogrenciler o ON o.ogrenci_id = dk.ogrenci_id where o.ogrenci_id = :ogrenci_id",nativeQuery = true)
    List<String> findDersKayitByOgrenciId(@Param("ogrenci_id") int ogrenci_id);

    @Query(value = "select d.ders_ad,n.vize_not,n.final_not,n.ort_not FROM dersler d inner join notlar n ON d.ders_id = n.ders_id WHERE n.ogrenci_id = :ogrenci_id" ,nativeQuery = true)
    List<String> findNotByOgrenciId(@Param("ogrenci_id") int ogrenci_id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE notlar SET ort_not = vize_not*0.4+final_not*0.6",nativeQuery = true)
    void updateOrtalamaByOgrenciId(@Param("ogrenci_id") int ogrenci_id);
}
