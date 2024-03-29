package br.com.alura.rh.validacao;

import br.com.alura.rh.exception.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

    @Override
    public void validar(final Funcionario funcionario, final BigDecimal aumento) {
        var percentualReajuste = aumento.divide(funcionario.getDadosPessoais().getSalario(), RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(BigDecimal.valueOf(0.4)) > 0) {
            throw new ValidacaoException("Reajuste não pode ser superior a 40% do salário");
        }
    }
}
