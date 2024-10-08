package com.obs.service.abstracts;

import com.obs.dto.requests.CreateDersKayitRequest;
import com.obs.dto.requests.UpdateDersKayitRequest;
import com.obs.dto.responses.GetAllDersKayitResponse;

import java.util.List;

public interface DersKayitService {

    List<GetAllDersKayitResponse> getAll();
    void add(CreateDersKayitRequest createDersKayitRequest);
    void update(UpdateDersKayitRequest updateDersKayitRequest);
    void deleteById(int id);

}
