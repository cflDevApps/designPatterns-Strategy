package com.cflDevApps.dpStrategy.contracts;

import java.math.BigDecimal;

/**
 * In the Strategy pattern context this Interface represent the generic abstraction of the strategies that
 * should implement and this is used by the Context(FreteCalculator) to execute the selected strategy
 */
public interface FreteStrategy {
    BigDecimal calcularPreco(double pesoEmKg);
    String calcularPrazoEntrega();
}
