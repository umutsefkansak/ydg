package com.obs.dto.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUnvanResponse {

    private int unvan_id;
    private String unvan_ad;

}
