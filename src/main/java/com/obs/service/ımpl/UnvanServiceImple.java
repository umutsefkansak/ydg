package com.obs.service.ımpl;

import com.obs.core.utilities.mappers.SingletonModelMapperServiceImpl;
import com.obs.dto.responses.GetAllUnvanResponse;
import com.obs.entities.Unvan;
import com.obs.repository.UnvanRepository;
import com.obs.service.abstracts.UnvanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UnvanServiceImple implements UnvanService {

    private UnvanRepository unvanRepository;



    @Override
    public List<GetAllUnvanResponse> getAll() {

        List<Unvan> unvanlar = unvanRepository.findAll();

        List<GetAllUnvanResponse> unvanResponses = unvanlar.stream()
                .map(unvan -> SingletonModelMapperServiceImpl.getInstance().standartMap()
                        .map(unvan,GetAllUnvanResponse.class)).collect(Collectors.toList());

        return unvanResponses;
    }
}
