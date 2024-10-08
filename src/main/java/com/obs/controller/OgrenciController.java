package com.obs.controller;


import com.obs.dto.requests.CreateOgrenciRequest;
import com.obs.dto.requests.UpdateOgrenciRequest;
import com.obs.dto.responses.GetAllOgrenciResponse;
import com.obs.dto.responses.GetOgrenciById;
import com.obs.service.abstracts.OgrenciService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ogrenciler")
@AllArgsConstructor
public class OgrenciController {

    private OgrenciService ogrenciService;

    @GetMapping("/getall")
    public List<GetAllOgrenciResponse> getAll(){
        return ogrenciService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public GetOgrenciById getOgrenciById(@PathVariable("id") int id){
        return ogrenciService.getOgrenciById(id);
    }

    @PostMapping("/add")
    public void add(CreateOgrenciRequest createOgrenciRequest){
        ogrenciService.add(createOgrenciRequest);
    }

    @PutMapping("/update")
    public void update(UpdateOgrenciRequest updateOgrenciRequest){
        ogrenciService.update(updateOgrenciRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") int id){
        ogrenciService.deleteById(id);
    }

    @GetMapping("/getDanismanByOgrenciId")
    public String getDanismanByOgrenciId(@RequestParam int ogrenci_id){
        return ogrenciService.findDanismanByOgrenciId(ogrenci_id);
    }

    @GetMapping("/getKayitliDersByOgrenciId")
    public List<String> getDersByOgrenciId(@RequestParam int ogrenci_id){
        return ogrenciService.findDersKayitByOgrenciId(ogrenci_id);
    }

    @GetMapping("/getNotByOgrenciId")
    public List<String> getNotByOgrenciId(@RequestParam int ogrenci_id){
        return ogrenciService.findNotByOgrenciId(ogrenci_id);
    }
}
