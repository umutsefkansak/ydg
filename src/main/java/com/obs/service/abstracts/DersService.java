package com.obs.service.abstracts;

import com.obs.dto.requests.CreateDersRequest;
import com.obs.dto.requests.UpdateDersRequest;
import com.obs.dto.requests.UpdateOgrenciRequest;
import com.obs.dto.responses.GetAllDersResponse;

import java.util.List;

public interface DersService{

    List<GetAllDersResponse> getAll();
    void add(CreateDersRequest createDersRequest);
    void update(UpdateDersRequest updateDersRequest);
    void deleteById(int id);

}
