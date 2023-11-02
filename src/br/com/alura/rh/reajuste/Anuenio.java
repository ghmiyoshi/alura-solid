package br.com.alura.rh.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Anuenio implements Reajuste {

    private BigDecimal valor;
    private LocalDate data;

    public Anuenio(final BigDecimal valor, final LocalDate data) {
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
}
