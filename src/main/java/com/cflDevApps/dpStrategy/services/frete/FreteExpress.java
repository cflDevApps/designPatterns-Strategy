package com.cflDevApps.dpStrategy.services.frete;

import com.cflDevApps.dpStrategy.contracts.FreteStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * In the Strategy pattern this is one of the concrete implementation for Strategy
 * interface FreteStrategy
 */
@Service("express")
public class FreteExpress implements FreteStrategy {

    @Override
    public BigDecimal calcularPreco(double pesoEmKg) {
        BigDecimal price = new BigDecimal(10);
        BigDecimal tax = new BigDecimal(pesoEmKg * 2.5);
        return price.add(tax);
    }

    @Override
    public String calcularPrazoEntrega() {
        return "1-2 dias úteis";
    }
}
