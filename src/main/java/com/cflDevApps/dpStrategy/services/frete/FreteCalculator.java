package com.cflDevApps.dpStrategy.services.frete;

import com.cflDevApps.dpStrategy.contracts.FreteStrategy;
import com.cflDevApps.dpStrategy.dtos.Frete;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Data
@Service
public class FreteCalculator {

    private final FreteFactory freteFactory;

    @Autowired
    public FreteCalculator(FreteFactory freteFactory){
        this.freteFactory = freteFactory;
    }

    public Frete calcularFrete(String freteType, double pesoKg){
        FreteStrategy freteCalculatorStrategy = this.freteFactory.getStrategy(freteType);
        BigDecimal price = freteCalculatorStrategy.calcularPreco(pesoKg);
        String term = freteCalculatorStrategy.calcularPrazoEntrega();
        return new Frete(price, term);
    }

}
