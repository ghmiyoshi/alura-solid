package br.com.alura.rh.service;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.validacao.ValidacaoReajuste;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
        validacoes.forEach(validacao -> validacao.validar(funcionario, aumento));
        BigDecimal salarioReajustado = funcionario.getDadosPessoais().getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }

}