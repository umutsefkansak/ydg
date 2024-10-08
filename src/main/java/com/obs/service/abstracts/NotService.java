package com.obs.service.abstracts;

import com.obs.dto.requests.CreateNotRequest;
import com.obs.dto.requests.UpdateNotRequest;
import com.obs.dto.responses.GetAllNotResponse;

import java.util.List;

public interface NotService {

    List<GetAllNotResponse> getAll();
    void add(CreateNotRequest createNotRequest);
    void update(UpdateNotRequest updateNotRequest);
    void deleteById(int id);

}
