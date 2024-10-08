package com.obs.service.abstracts;

import com.obs.dto.requests.CreateFakulteRequest;
import com.obs.dto.responses.GetFakulteResponse;

import java.util.List;

public interface FakulteService {

    List<GetFakulteResponse> getAll();
    void add(CreateFakulteRequest createFakulteRequest);
}
