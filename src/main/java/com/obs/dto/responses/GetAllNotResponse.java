package com.obs.dto.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllNotResponse {

    private String ogrenci_ad;
    private String  ders_ad;
    private int vize_not;
    private int final_not;
    private int odev_not;
    private int ort_not;

}
