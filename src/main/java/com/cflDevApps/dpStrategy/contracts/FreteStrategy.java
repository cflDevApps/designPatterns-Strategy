package com.cflDevApps.dpStrategy.contracts;

import java.math.BigDecimal;

public interface FreteStrategy {
    BigDecimal calcularPreco(double pesoEmKg);
    String calcularPrazoEntrega();
}
