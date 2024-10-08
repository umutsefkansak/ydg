package com.obs.service.ımpl;

import com.obs.core.utilities.mappers.SingletonModelMapperServiceImpl;
import com.obs.dto.requests.CreateNotRequest;
import com.obs.dto.requests.UpdateNotRequest;
import com.obs.dto.responses.GetAllNotResponse;
import com.obs.entities.Ders;
import com.obs.entities.Not;
import com.obs.entities.Ogrenci;
import com.obs.repository.DersRepository;
import com.obs.repository.NotRepository;
import com.obs.repository.OgrenciRepository;
import com.obs.service.abstracts.NotService;
import com.obs.service.rules.NotRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotServiceImple implements NotService {

    private NotRepository notRepository;
    private OgrenciRepository ogrenciRepository;
    private DersRepository dersRepository;
    private NotRules notRules;


    @Override
    public void add(CreateNotRequest createNotRequest) {

        boolean ifKayitli = notRules.checkKayitliMi(createNotRequest.getOgrenci_id(), createNotRequest.getDers_id());


        if(ifKayitli == true){
            Not not = new Not();
            Ogrenci ogrenci = ogrenciRepository.findById(createNotRequest.getOgrenci_id()).orElseThrow();
            Ders ders = dersRepository.findById(createNotRequest.getDers_id()).orElseThrow();

            not.setOgrenci(ogrenci);
            not.setDers(ders);
            not.setFinal_not(createNotRequest.getFinal_not());
            not.setOdev_not(createNotRequest.getOdev_not());
            not.setOrt_not(createNotRequest.getOrt_not());
            not.setVize_not(createNotRequest.getVize_not());

            notRepository.save(not);
        }
        else {
            throw new RuntimeException("Öğrenci Bu derse Kayıtlı Değil");
        }

        //Not not = SingletonModelMapperServiceImpl.getInstance().standartMap().map(createNotRequest,Not.class);

    }

    @Override
    public List<GetAllNotResponse> getAll() {

        List<Not> notlar = notRepository.findAll();

        List<GetAllNotResponse> notResponses = notlar.stream()
                .map(not -> SingletonModelMapperServiceImpl.getInstance().standartMap()
                        .map(not,GetAllNotResponse.class)).collect(Collectors.toList());
        return notResponses;
    }



    @Override
    public void update(UpdateNotRequest updateNotRequest) {
        Not not = SingletonModelMapperServiceImpl.getInstance().standartMap().map(updateNotRequest,Not.class);
        notRepository.save(not);
    }

    @Override
    public void deleteById(int id) {
        notRepository.deleteById(id);
    }


}
