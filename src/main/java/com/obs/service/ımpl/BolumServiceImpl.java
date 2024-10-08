package com.obs.service.ımpl;

import com.obs.core.utilities.mappers.SingletonModelMapperServiceImpl;
import com.obs.entities.Bolum;
import com.obs.repository.BolumRepository;
import com.obs.service.abstracts.BolumService;
import com.obs.dto.responses.GetAllBolumResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BolumServiceImpl implements BolumService {

    private BolumRepository bolumRepository;

    @Override
    public List<GetAllBolumResponse> getAll() {
        List<Bolum> bolumler = bolumRepository.findAll();

        List<GetAllBolumResponse> bolumResponses = bolumler.stream()
                .map(bolum ->SingletonModelMapperServiceImpl.getInstance().standartMap()
                        .map(bolum, GetAllBolumResponse.class)).collect(Collectors.toList());


        return bolumResponses;
    }


}
