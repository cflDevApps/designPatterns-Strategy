package com.cflDevApps.dpStrategy.services.frete;

import com.cflDevApps.dpStrategy.contracts.FreteStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * This is class that implement the Factory pattern to extract the logic
 * to create the Strategy object that will be used by in the 'Context'
 */
@Service
public class FreteFactory {

    private final Map<String, FreteStrategy> calculatorsMap;

    @Autowired
    public FreteFactory(Map<String, FreteStrategy> calculatorsMap) {
        this.calculatorsMap = calculatorsMap;
    }


    public FreteStrategy getStrategy(String freteType){
        FreteStrategy freteStrategy =  this.calculatorsMap.get(freteType);
        if(freteStrategy == null)
            throw new RuntimeException(String.format("Invalid Frete type: %s", freteType));

        return freteStrategy;
    }
}
