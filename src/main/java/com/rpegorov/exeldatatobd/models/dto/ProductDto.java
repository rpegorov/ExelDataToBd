package com.rpegorov.exeldatatobd.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long company_id;
    private DataType dataType;
    private ProductType productType;
    private Long date;

}
