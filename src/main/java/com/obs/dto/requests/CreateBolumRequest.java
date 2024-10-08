package com.obs.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBolumRequest {
    private String bolum_ad;
    private int fakulte_id;
}
