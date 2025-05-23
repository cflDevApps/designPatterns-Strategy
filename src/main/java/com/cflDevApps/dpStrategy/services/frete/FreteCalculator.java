package com.cflDevApps.dpStrategy.services.frete;

import com.cflDevApps.dpStrategy.contracts.FreteStrategy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


/**
 * In the Strategy pattern approach this class implements the 'Context', it received from 'Client' (InitController)
 * the Strategy that will be used and the input that necessary to execute the Strategy selected.
 */
@Data
@Service
public class FreteCalculator {


    private final FreteFactory freteFactory;

    private FreteStrategy freteCalculatorStrategy;

    @Autowired
    public FreteCalculator(FreteFactory freteFactory){
        this.freteFactory = freteFactory;
    }

    public void setStrategy(String freteType){
        this.freteCalculatorStrategy = this.freteFactory.createFreteStrategy(freteType);
    }

    public BigDecimal calculaPreco(double pesoKg){
        return this.freteCalculatorStrategy.calcularPreco(pesoKg);
    }

    public String calculaPrazo(){
        return this.freteCalculatorStrategy.calcularPrazoEntrega();
    }

}
