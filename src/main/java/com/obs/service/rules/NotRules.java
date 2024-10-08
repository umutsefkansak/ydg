package com.obs.service.rules;


import com.obs.entities.DersKayit;
import com.obs.repository.DersKayitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotRules {

    DersKayitRepository dersKayitRepository;
    public boolean checkKayitliMi(int ogrenci_id,int ders_id){
       List<DersKayit> dersKayitlari =  dersKayitRepository.findAll();

       for (int i = 0;i<dersKayitlari.size();i++){
           if(dersKayitlari.get(i).getOgrenci().getOgrenci_id() == ogrenci_id
                   && dersKayitlari.get(i).getDers().getDers_id()==ders_id ){

               System.out.println("Kayitli");
               return true;
           }
       }
        System.out.println("kayıtlı değil");
        return false;
    }
}
