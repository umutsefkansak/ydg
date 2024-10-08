package com.obs.controller;


import com.obs.dto.responses.GetAllUnvanResponse;
import com.obs.service.abstracts.UnvanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/unvanlar")
@AllArgsConstructor
public class UnvanController {

    private UnvanService unvanService;


    @GetMapping("/getall")
    public List<GetAllUnvanResponse> getAll(){
        return unvanService.getAll();
    }

}
