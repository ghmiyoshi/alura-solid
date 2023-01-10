package br.com.alura.rh.validacao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();

        long mesesDoUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if (mesesDoUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajustes deve ser de no minimo 6 meses");
        }
    }

}
