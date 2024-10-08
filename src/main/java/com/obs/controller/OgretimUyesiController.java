package com.obs.controller;

import com.obs.dto.requests.CreateOgretimUyesiRequest;
import com.obs.dto.requests.UpdateOgretimUyesiRequest;
import com.obs.dto.responses.GetAllOgretimUyesiResponse;
import com.obs.entities.Ogrenci;
import com.obs.service.abstracts.OgretimUyesiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ogretimuyeleri")
@AllArgsConstructor
public class OgretimUyesiController {

    private OgretimUyesiService ogretimUyesiService;


    @GetMapping("/getall")
    public List<GetAllOgretimUyesiResponse> getAll(){
        return ogretimUyesiService.getAll();
    }


    @PostMapping("/add")
    public void add(CreateOgretimUyesiRequest createOgretimUyesiRequest){
        ogretimUyesiService.add(createOgretimUyesiRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateOgretimUyesiRequest updateOgretimUyesiRequest){
        ogretimUyesiService.update(updateOgretimUyesiRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") int id){
        ogretimUyesiService.deleteById(id );
    }

    @GetMapping("/getDansimanlikVerilenOgrencilerById")
    public List<String> getDansimanlikVerilenOgrencilerById(@RequestParam int ogretimuyesi_id){
        return ogretimUyesiService.findDanismanlikVerilenOgrencilerById(ogretimuyesi_id);
    }

    @GetMapping("/getVerilenDerslerById")
    public List<String> getVerilenDerslerById(@RequestParam int ogretimuyesi_id){
        return ogretimUyesiService.findVerilenDerslerById(ogretimuyesi_id);
    }
}
