package com.cflDevApps.dpStrategy.controlers;

import com.cflDevApps.dpStrategy.dtos.Frete;
import com.cflDevApps.dpStrategy.services.frete.FreteCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

        Frete frete = freteCalculator.calcularFrete(freteType, Double.parseDouble(peso));

        model.addAttribute("price",String.format("Preço: %s", frete.getPrice().toString()));
        model.addAttribute("term", String.format("Prazo de entrega: %s", frete.getTerm()));

        return "index";
    }




}
