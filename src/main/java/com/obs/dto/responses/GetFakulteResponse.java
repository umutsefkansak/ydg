package com.obs.dto.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetFakulteResponse {
    private int fakulte_id;
    private String fakulte_ad;
}
