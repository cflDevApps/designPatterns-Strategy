package com.cflDevApps.dpStrategy.services.frete;

import com.cflDevApps.dpStrategy.contracts.FreteStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("loja")
public class FreteLoja implements FreteStrategy {

    @Override
    public BigDecimal calcularPreco(double pesoEmKg) {
        return new BigDecimal(0);
    }

    @Override
    public String calcularPrazoEntrega() {
        return "Retirada Física";
    }
}
