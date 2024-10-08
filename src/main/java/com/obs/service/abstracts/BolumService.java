package com.obs.service.abstracts;

import com.obs.dto.requests.CreateBolumRequest;
import com.obs.dto.responses.GetAllBolumResponse;

import java.util.List;

public interface BolumService {
    List<GetAllBolumResponse> getAll();

}
