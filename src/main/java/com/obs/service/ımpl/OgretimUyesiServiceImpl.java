package com.obs.service.ımpl;

import com.obs.core.utilities.mappers.SingletonModelMapperServiceImpl;
import com.obs.dto.requests.CreateOgretimUyesiRequest;
import com.obs.dto.requests.UpdateOgretimUyesiRequest;
import com.obs.dto.responses.GetAllOgretimUyesiResponse;
import com.obs.entities.OgretimUyesi;
import com.obs.repository.OgretimUyesiRepository;
import com.obs.service.abstracts.OgretimUyesiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OgretimUyesiServiceImpl implements OgretimUyesiService {


    private OgretimUyesiRepository ogretimUyesiRepository;


    @Override
    public List<GetAllOgretimUyesiResponse> getAll() {
        List<OgretimUyesi> ogretimUyeleri = ogretimUyesiRepository.findAll();

        List<GetAllOgretimUyesiResponse> ogretimUyesiResponses = ogretimUyeleri.stream()
                .map(ogretimUyesi -> SingletonModelMapperServiceImpl.getInstance().standartMap()
                        .map(ogretimUyesi,GetAllOgretimUyesiResponse.class)).collect(Collectors.toList());

        return ogretimUyesiResponses;
    }

    @Override
    public void add(CreateOgretimUyesiRequest createOgretimUyesiRequest) {
        OgretimUyesi ogretimUyesi = SingletonModelMapperServiceImpl.getInstance().standartMap().map(createOgretimUyesiRequest,OgretimUyesi.class);

        ogretimUyesiRepository.save(ogretimUyesi);
    }

    @Override
    public void update(UpdateOgretimUyesiRequest updateOgretimUyesiRequest) {
        OgretimUyesi ogretimUyesi = SingletonModelMapperServiceImpl.getInstance().standartMap().map(updateOgretimUyesiRequest,OgretimUyesi.class);
        ogretimUyesiRepository.save(ogretimUyesi);
    }

    @Override
    public void deleteById(int id) {
        ogretimUyesiRepository.deleteById(id);
    }

    @Override
    public List<String> findDanismanlikVerilenOgrencilerById(int ogretimuyesi_id) {
        return ogretimUyesiRepository.findDanismanlikVerilenOgrencilerById(ogretimuyesi_id);
    }

    @Override
    public List<String> findVerilenDerslerById(int ogretimuyesi_id) {
        return ogretimUyesiRepository.findVerilenDerslerById(ogretimuyesi_id);
    }
}
