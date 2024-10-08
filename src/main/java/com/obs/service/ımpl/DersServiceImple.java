package com.obs.service.ımpl;

import com.obs.core.utilities.mappers.SingletonModelMapperServiceImpl;
import com.obs.dto.requests.CreateDersRequest;
import com.obs.dto.requests.UpdateDersRequest;
import com.obs.dto.responses.GetAllDersResponse;
import com.obs.entities.Ders;
import com.obs.repository.DersRepository;
import com.obs.service.abstracts.DersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DersServiceImple implements DersService {

    private DersRepository dersRepository;


    @Override
    public List<GetAllDersResponse> getAll() {

        List<Ders> dersler = dersRepository.findAll();
        List<GetAllDersResponse> dersResponses = dersler.stream()
                .map(ders -> SingletonModelMapperServiceImpl.getInstance().standartMap().
                        map(ders,GetAllDersResponse.class)).collect(Collectors.toList());

        return dersResponses;
    }



    @Override
    public void add(CreateDersRequest createDersRequest) {
        Ders ders = SingletonModelMapperServiceImpl.getInstance().looseMap().map(createDersRequest,Ders.class);
        dersRepository.save(ders);
    }

    @Override
    public void update(UpdateDersRequest updateDersRequest) {
        Ders ders = SingletonModelMapperServiceImpl.getInstance().standartMap().map(updateDersRequest,Ders.class);
        dersRepository.save(ders);
    }

    @Override
    public void deleteById(int id) {
        dersRepository.deleteById(id);
    }
}
