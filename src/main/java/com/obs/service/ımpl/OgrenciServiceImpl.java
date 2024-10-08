package com.obs.service.ımpl;

import com.obs.core.utilities.mappers.SingletonModelMapperServiceImpl;
import com.obs.dto.requests.CreateOgrenciRequest;
import com.obs.dto.requests.UpdateOgrenciRequest;
import com.obs.dto.responses.GetAllOgrenciResponse;
import com.obs.dto.responses.GetOgrenciById;
import com.obs.entities.Ogrenci;
import com.obs.repository.OgrenciRepository;
import com.obs.service.abstracts.OgrenciService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OgrenciServiceImpl implements OgrenciService {

    private OgrenciRepository ogrenciRepository;


    @Override
    public List<GetAllOgrenciResponse> getAll() {
        List<Ogrenci> ogreciler = ogrenciRepository.findAll();

        List<GetAllOgrenciResponse> ogrenciResponses = ogreciler.stream()
                .map(ogrenci -> SingletonModelMapperServiceImpl.getInstance().standartMap()
                        .map(ogrenci,GetAllOgrenciResponse.class)).collect(Collectors.toList());

        return ogrenciResponses;
    }

    @Override
    public GetOgrenciById getOgrenciById(int id) {
        Ogrenci ogrenci = ogrenciRepository.findById(id).orElseThrow();

        GetOgrenciById getOgrenciById = SingletonModelMapperServiceImpl.getInstance().looseMap().map(ogrenci,GetOgrenciById.class);
        return getOgrenciById;
    }


    @Override
    public void add(CreateOgrenciRequest createOgrenciRequest) {
        Ogrenci ogrenci = SingletonModelMapperServiceImpl.getInstance().looseMap().map(createOgrenciRequest,Ogrenci.class);
        ogrenciRepository.save(ogrenci);
    }

    @Override
    public void update(UpdateOgrenciRequest updateOgrenciRequest) {
        Ogrenci ogrenci = SingletonModelMapperServiceImpl.getInstance().looseMap().map(updateOgrenciRequest,Ogrenci.class);
        ogrenciRepository.save(ogrenci);
    }

    @Override
    public void deleteById(int id) {
        ogrenciRepository.deleteById(id);
    }

    @Override
    public String findDanismanByOgrenciId(int ogrenci_id) {
        return ogrenciRepository.findDanismanByOgrenciId(ogrenci_id);
    }

    @Override
    public List<String> findDersKayitByOgrenciId(int ogrenci_id){



        return ogrenciRepository.findDersKayitByOgrenciId(ogrenci_id);
    }
    @Override
    public List<String> findNotByOgrenciId(int ogrenci_id) {
        ogrenciRepository.updateOrtalamaByOgrenciId(ogrenci_id);
        return ogrenciRepository.findNotByOgrenciId(ogrenci_id);
    }


}
