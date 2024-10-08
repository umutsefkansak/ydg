package com.obs.controller;


import com.obs.dto.requests.CreateBolumRequest;
import com.obs.service.abstracts.BolumService;
import com.obs.dto.responses.GetAllBolumResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bolumler")
@AllArgsConstructor
public class BolumController {

    private BolumService bolumService;


    @GetMapping("/getall")
    public List<GetAllBolumResponse> getAll(){
        return bolumService.getAll();
    }
}
