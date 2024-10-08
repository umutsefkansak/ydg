package com.obs.service.ımpl;

import com.obs.core.utilities.mappers.SingletonModelMapperServiceImpl;
import com.obs.dto.requests.CreateFakulteRequest;
import com.obs.dto.responses.GetFakulteResponse;
import com.obs.entities.Fakulte;
import com.obs.repository.FakulteRepository;
import com.obs.service.abstracts.FakulteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FakulteServiceImpl implements FakulteService {

    private FakulteRepository fakulteRepository;


    @Override
    public List<GetFakulteResponse> getAll() {

        List<Fakulte> fakulteler = fakulteRepository.findAll();

        List<GetFakulteResponse> fakulteResponses = fakulteler.stream()
                .map(fakulte -> SingletonModelMapperServiceImpl.getInstance().standartMap()
                        .map(fakulte,GetFakulteResponse.class)).collect(Collectors.toList());

        return fakulteResponses;
    }

    @Override
    public void add(CreateFakulteRequest createFakulteRequest) {
        Fakulte fakulte = SingletonModelMapperServiceImpl.getInstance().standartMap().map(createFakulteRequest,Fakulte.class);
        fakulteRepository.save(fakulte);


    }
}
