package com.cflDevApps.dpStrategy.services.frete;

import com.cflDevApps.dpStrategy.contracts.FreteStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("padrao")
public class FretePadrao implements FreteStrategy {

    @Override
    public BigDecimal calcularPreco(double pesoEmKg) {
        BigDecimal price = new BigDecimal(5);
        BigDecimal tax = new BigDecimal(pesoEmKg * 1);
        return price.add(tax);
    }

    @Override
    public String calcularPrazoEntrega() {
        return "5-7 dias úteis";
    }
}
