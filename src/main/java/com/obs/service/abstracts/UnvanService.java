package com.obs.service.abstracts;

import com.obs.dto.responses.GetAllUnvanResponse;

import java.util.List;

public interface UnvanService {

    List<GetAllUnvanResponse> getAll();
}
