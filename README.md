# 🧠 Design Patterns: Strategy + Factory

Este repositório demonstra o uso dos padrões de projeto **Strategy** e **Factory** em um exemplo prático: uma **calculadora de frete para e-commerce**. A aplicação foi desenvolvida em Java, seguindo os princípios do design orientado a objetos.

---

## 📌 Objetivo

O objetivo deste projeto é:

- Demonstrar como o padrão **Strategy** pode ser usado para encapsular diferentes comportamentos (estratégias) de cálculo de frete.
- Integrar com o padrão **Factory**, permitindo a **criação dinâmica** da estratégia com base na escolha do tipo de entrega (por exemplo, retirada na loja, entrega padrão ou expressa).

---

## 🧹 Sobre o Padrão Strategy

O **Strategy Pattern** permite definir uma família de algoritmos, encapsular cada um deles e torná-los intercambiáveis. O algoritmo selecionado pode variar conforme a necessidade **sem modificar a classe que o utiliza**.

> 💡 **Uso ideal**: quando há várias variações de um comportamento e você quer **evitar `if-else` ou `switch-case`** espalhados pelo código.

### 🎯 No projeto

Criamos a interface:

```java
public interface FreteStrategy {
    double calcularPreco(double pesoEmKg);
    String calcularPrazoEntrega();
}
```

E as estratégias concretas:

- `FretePadrao`: entrega econômica
- `FreteExpresso`: entrega rápida
- `FreteRetiradaLoja`: cliente busca na loja

A classe de contexto (`CalculadoraFrete`) recebe a estratégia desejada e a utiliza:

```java
@Service
public class FreteCalculator {

    private final FreteFactory freteFactory;

    private FreteStrategy freteCalculatorStrategy;

    @Autowired
    public FreteCalculator(FreteFactory freteFactory) {
        this.freteFactory = freteFactory;
    }

    public void setStrategy(String freteType) {
        this.freteCalculatorStrategy = this.freteFactory.getStrategy(freteType);
    }

    public BigDecimal calculaPreco(double pesoKg) {
        return this.freteCalculatorStrategy.calcularPreco(pesoKg);
    }

    public String calculaPrazo() {
        return this.freteCalculatorStrategy.calcularPrazoEntrega();
    }

}
```

---

## 🏠 Sobre o Padrão Factory

O **Factory Pattern** tem como propósito delegar a responsabilidade de criação de objetos a uma classe especializada, facilitando a **instanciação dinâmica** e promovendo o princípio da **inversão de dependência**.

> 💡 **Uso ideal**: quando você precisa criar objetos **sem expor a lógica de criação diretamente no código do cliente**.

### 🏠 No projeto

Criamos a classe `FreteFactory`:

```java
@Service
public class FreteFactory {

    private final Map<String, FreteStrategy> calculatorsMap;

    @Autowired
    public FreteFactory(Map<String, FreteStrategy> calculatorsMap) {
        this.calculatorsMap = calculatorsMap;
    }

    public FreteStrategy createFreteStrategy(String freteType){
        FreteStrategy freteStrategy =  this.calculatorsMap.get(freteType);
        if(freteStrategy == null)
            throw new RuntimeException(String.format("Invalid Frete type: %s", freteType));

        return freteStrategy;
    }
}
```

Com isso, o código cliente pode selecionar dinamicamente a estratégia:

```java
String freteType = "express";
FreteCalculator freteCalculator = new FreteCalculator(new FreteFactory());
freteCalculator.setStrategy(freteType);
```

---

## 💻 Execução

### 1. Clone o repositório

```bash
git clone https://github.com/cflDevApps/designPatterns-Strategy.git
cd designPatterns-Strategy
```

### 2. Compile e execute

Recomendado usar uma IDE como **IntelliJ** ou **Eclipse**, ou compilar diretamente via terminal:

```bash
javac *.java
java Main
```

---

## 🧪 Exemplos de Saída Esperada

```text
Frete Padrão: R$8.5 - Prazo: Entrega em 5 a 7 dias útis
Frete Expresso: R$18.75 - Prazo: Entrega em 1 a 2 dias útis
Retirada na Loja: R$0.0 - Prazo: Retirar imediatamente após confirmação
```

---

## 🔍 Padrões Aplicados

| Padrão       | Papel no projeto                          |
|--------------|--------------------------------------------|
| Strategy     | Permite trocar o comportamento de frete sem alterar o consumidor (`CalculadoraFrete`) |
| Factory      | Cria dinamicamente a estratégia com base no tipo de frete selecionado                |

---

## 📚 Aprendizados

### Com uso do Strategy garantimos o uso de boas práticas de design orientado a objetos como pincipios SOLID como:
- Single Responsability 
- Open Close 

### Criação flexível de estratégias usando multiplos padroes de projetos como Factory + Strategy

---

## 📂 Estrutura de Arquivos

```
├── FreteStrategy.java
├── FretePadrao.java
├── FreteExpresso.java
├── FreteRetiradaLoja.java
├── FreteFactory.java
├── CalculadoraFrete.java
└── Main.java
```

---

## ✍️ Autor

**Cristiano Fernandes de Lima**  
[linkedin.com/in/cristiano-fernandes-de-lima](https://www.linkedin.com/in/cristiano-fernandes-de-lima)

---

## ✅ Melhorias Futuras

- Adicionar testes unitários com JUnit
- Suporte a fretes internacionais com taxas adicionais
- Leitura de tipo de frete via JSON ou entrada do usuário

---
