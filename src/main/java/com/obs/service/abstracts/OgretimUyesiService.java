package com.obs.service.abstracts;

import com.obs.dto.requests.CreateOgretimUyesiRequest;
import com.obs.dto.requests.UpdateOgretimUyesiRequest;
import com.obs.dto.responses.GetAllOgrenciResponse;
import com.obs.dto.responses.GetAllOgretimUyesiResponse;
import com.obs.entities.Ogrenci;

import java.util.List;

public interface OgretimUyesiService {

    List<GetAllOgretimUyesiResponse> getAll();
    void add(CreateOgretimUyesiRequest createOgretimUyesiRequest);

    void update(UpdateOgretimUyesiRequest updateOgretimUyesiRequest);
    void deleteById(int id);

    List<String> findDanismanlikVerilenOgrencilerById(int ogretimuyesi_id);

    List<String> findVerilenDerslerById(int ogretimuyesi_id);
}
