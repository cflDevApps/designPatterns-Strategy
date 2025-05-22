package com.cflDevApps.dpStrategy.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Frete {
    private BigDecimal price;
    private String term;
}
