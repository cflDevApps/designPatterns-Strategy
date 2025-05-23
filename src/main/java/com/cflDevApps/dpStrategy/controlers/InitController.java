package com.cflDevApps.dpStrategy.controlers;

import com.cflDevApps.dpStrategy.dtos.Frete;
import com.cflDevApps.dpStrategy.services.frete.FreteCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * In the Strategy pattern context this class represents the 'Client', it's invoking the 'Context' implemented within
 * FreteCalculator class, also this class is responsible for decide what type of concrete class will be used as Strategy
 * using the 'freteType' data to define it by FreteFactory.
 * */
@Controller
public class InitController {

    @Autowired
    private FreteCalculator freteCalculator;

    @GetMapping("/frete/{type}/{peso}")
    public String home(Model model,
                       @PathVariable("type") String freteType,
                       @PathVariable("peso") String peso){
        model.addAttribute("title", String.format("Calculadora de Frete Iniciado: %s", freteType));

        // Defining the Strategy
        freteCalculator.setStrategy(freteType);

        // Invoking Context to execute the price calculation
        BigDecimal fretePrice = freteCalculator.calculaPreco(Double.parseDouble(peso));

        // Invoking Context to execute the term calculation
        String freteTerm = freteCalculator.calculaPrazo();

        model.addAttribute("price",String.format("Preço: R$ %s", CURRENCY_FORMATTER(fretePrice)));
        model.addAttribute("term", String.format("Prazo de entrega: %s", freteTerm));

        return "index";
    }

    private static String CURRENCY_FORMATTER(BigDecimal value){
        DecimalFormat df = new DecimalFormat("#.##");
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        return df.format(value);
    }




}
