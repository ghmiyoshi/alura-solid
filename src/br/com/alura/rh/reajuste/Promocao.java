package br.com.alura.rh.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Promocao implements ReajusteTributavel {

    private BigDecimal valor;
    private LocalDate data;

    public Promocao(BigDecimal valor, LocalDate data) {
        this.valor = valor;
        this.data = data;
    }

    @Override
    public LocalDate data() {
        return data;
    }

    @Override
    public BigDecimal valor() {
        return valor;
    }

    @Override
    public BigDecimal valorImpostoDeRenda() {
        return this.valor.multiply(BigDecimal.valueOf(0.1));
    }

}
