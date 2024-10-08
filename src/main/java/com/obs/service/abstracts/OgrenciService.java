package com.obs.service.abstracts;

import com.obs.dto.requests.CreateOgrenciRequest;
import com.obs.dto.requests.UpdateOgrenciRequest;
import com.obs.dto.responses.GetAllOgrenciResponse;
import com.obs.dto.responses.GetOgrenciById;


import java.util.List;

public interface OgrenciService {

    List<GetAllOgrenciResponse> getAll();
    GetOgrenciById getOgrenciById(int id);
    void add(CreateOgrenciRequest createOgrenciRequest);
    void update(UpdateOgrenciRequest updateOgrenciRequest);
    void deleteById(int id);
    String findDanismanByOgrenciId(int ogrenci_id);
    List<String> findDersKayitByOgrenciId(int ogrenci_id);
    List<String> findNotByOgrenciId(int ogrenci_id);
}
