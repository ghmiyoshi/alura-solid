package br.com.alura.rh.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Reajuste {

    LocalDate data();

    BigDecimal valor();

}
