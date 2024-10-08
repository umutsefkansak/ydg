package com.obs.controller;

import com.obs.dto.requests.CreateNotRequest;
import com.obs.dto.requests.UpdateNotRequest;
import com.obs.dto.responses.GetAllNotResponse;
import com.obs.service.abstracts.NotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notlar")
@AllArgsConstructor
public class NotController {

    private NotService notService;

    @GetMapping("/getall")
    public List<GetAllNotResponse> getAll(){

        return notService.getAll();

    }

    @PostMapping("/add")
    public void add(CreateNotRequest createNotRequest){
        notService.add(createNotRequest);
    }

    @PutMapping("/update")
    public void update(UpdateNotRequest updateNotRequest){
        notService.update(updateNotRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") int id){
        notService.deleteById(id);
    }



}
