package com.obs.service.rules;

import com.obs.entities.Ders;
import com.obs.repository.DersRepository;
import com.obs.repository.OgrenciRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DersKayitRules {

    OgrenciRepository ogrenciRepository;
    DersRepository dersRepository;
    public boolean chechkIfAlreadyHasDers(int ogrenci_id,int kayit_yapilacak_ders){

        List<String> kayitliDersler = ogrenciRepository.findDersKayitByOgrenciId(ogrenci_id);
        Ders kayitYapilacakDers = dersRepository.findById(kayit_yapilacak_ders).orElseThrow();

        for(int i = 0 ; i<kayitliDersler.size();i++){
            if(kayitliDersler.get(i).equals(kayitYapilacakDers.getDers_ad())){
                return true;
            }
        }
        return false;
    }
}
