package com.rpegorov.exeldatatobd.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long company_id;
    @Enumerated(EnumType.STRING)
    private DataType dataType;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private Long date;
}
