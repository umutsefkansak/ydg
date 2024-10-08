package com.obs.controller;




import com.obs.dto.requests.CreateDersRequest;
import com.obs.dto.requests.UpdateDersRequest;
import com.obs.dto.responses.GetAllDersResponse;
import com.obs.service.abstracts.DersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dersler")
@AllArgsConstructor
public class DersController {

    private DersService dersService;


    @GetMapping("/getall")
    public List<GetAllDersResponse> getAll(){
        return dersService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateDersRequest createDersRequest){
        dersService.add(createDersRequest);
    }


    @PutMapping("/update")
    public void update(UpdateDersRequest updateDersRequest){
        dersService.update(updateDersRequest);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") int id){
        dersService.deleteById(id);
    }


}
