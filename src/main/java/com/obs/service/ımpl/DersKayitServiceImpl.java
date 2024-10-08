package com.obs.service.ımpl;

import com.obs.core.utilities.mappers.SingletonModelMapperServiceImpl;
import com.obs.dto.requests.CreateDersKayitRequest;
import com.obs.dto.requests.UpdateDersKayitRequest;
import com.obs.dto.responses.GetAllDersKayitResponse;
import com.obs.entities.Ders;
import com.obs.entities.DersKayit;
import com.obs.entities.Ogrenci;
import com.obs.repository.DersKayitRepository;
import com.obs.repository.DersRepository;
import com.obs.repository.OgrenciRepository;
import com.obs.service.abstracts.DersKayitService;
import com.obs.service.rules.DersKayitRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DersKayitServiceImpl implements DersKayitService {


    private DersKayitRepository dersKayitRepository;
    private DersRepository dersRepository;
    private OgrenciRepository ogrenciRepository;
    private DersKayitRules dersKayitRules;

    @Override
    public void add(CreateDersKayitRequest createDersKayitRequest) {


        boolean ifAlreadyHasDers = dersKayitRules.chechkIfAlreadyHasDers(createDersKayitRequest.getOgrenci_id(),createDersKayitRequest.getDers_id());

        if(ifAlreadyHasDers == false){

            DersKayit dersKayit = new DersKayit();
            Ders ders = dersRepository.findById(createDersKayitRequest.getDers_id()).orElseThrow();
            Ogrenci ogrenci = ogrenciRepository.findById(createDersKayitRequest.getOgrenci_id()).orElseThrow();

            dersKayit.setDers(ders);
            dersKayit.setOgrenci(ogrenci);
            dersKayit.setKayit_tarihi(createDersKayitRequest.getKayit_tarihi());
            dersKayitRepository.save(dersKayit);
        }
        else{
            throw new RuntimeException("Bu derse zaten kayıtlı var");
        }


    }

    @Override
    public List<GetAllDersKayitResponse> getAll() {
        List<DersKayit> dersKayitlari = dersKayitRepository.findAll();

        List<GetAllDersKayitResponse> dersKayitResponses = dersKayitlari.stream()
                .map(dersKayit -> SingletonModelMapperServiceImpl.getInstance().standartMap()
                        .map(dersKayit,GetAllDersKayitResponse.class)).collect(Collectors.toList());

        return dersKayitResponses;
    }



    @Override
    public void update(UpdateDersKayitRequest updateDersKayitRequest) {
        DersKayit dersKayit = SingletonModelMapperServiceImpl.getInstance().standartMap().map(updateDersKayitRequest,DersKayit.class);
        dersKayitRepository.save(dersKayit);
    }

    @Override
    public void deleteById(int id) {
        dersKayitRepository.deleteById(id);
    }




}
