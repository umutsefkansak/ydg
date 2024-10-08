package com.obs.dto.requests;

import com.obs.entities.Ders;
import com.obs.entities.Ogrenci;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNotRequest {

    private int ogrenci_id;
    private int ders_id;
    private int vize_not;
    private Integer final_not;
    private Integer odev_not;
    private Integer ort_not;



}
