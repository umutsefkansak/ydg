package com.obs.dto.requests;

import com.obs.entities.Ders;
import com.obs.entities.Ogrenci;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNotRequest {

    private int not_id;
    private int ogrenci_id;
    private int ders_id;
    private int vize_not;
    private Integer final_not;
    private Integer odev_not;
    private Integer ort_not;




}
