package com.obs.controller;

import com.obs.dto.requests.CreateDersRequest;
import com.obs.dto.requests.CreateFakulteRequest;
import com.obs.dto.responses.GetFakulteResponse;
import com.obs.service.abstracts.FakulteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fakulteler")
@AllArgsConstructor
public class FakulteController {

    private FakulteService fakulteService;


    @GetMapping("/getall")
    public List<GetFakulteResponse> getAll(){
        return fakulteService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody CreateFakulteRequest createFakulteRequest){
        fakulteService.add(createFakulteRequest);
    }



}
