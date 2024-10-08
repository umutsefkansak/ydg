package com.obs.controller;

import com.obs.dto.requests.CreateDersKayitRequest;
import com.obs.dto.requests.UpdateDersKayitRequest;
import com.obs.dto.responses.GetAllDersKayitResponse;
import com.obs.service.abstracts.DersKayitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/derskayitlari")
@AllArgsConstructor
public class DersKayitController {

    private DersKayitService dersKayitService;



    @GetMapping("/getall")
    public List<GetAllDersKayitResponse> getAll(){
        return dersKayitService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateDersKayitRequest createDersKayitRequest){
        dersKayitService.add(createDersKayitRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateDersKayitRequest updateDersKayitRequest){
        dersKayitService.update(updateDersKayitRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") int id) {
      dersKayitService.deleteById(id);
    }




}
