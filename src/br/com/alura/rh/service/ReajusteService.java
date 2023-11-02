package br.com.alura.rh.service;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.reajuste.Reajuste;
import br.com.alura.rh.reajuste.ReajusteTributavel;
import br.com.alura.rh.validacao.ValidacaoReajuste;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(final List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(final Funcionario funcionario, final BigDecimal aumento) {
        validacoes.forEach(validacao -> validacao.validar(funcionario, aumento));
        var salarioReajustado = funcionario.getDadosPessoais().getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }

    public void reajuste(final Reajuste reajuste) {
        System.out.println(String.format("Data: %s Valor: %s", reajuste.data(), reajuste.valor()));
    }

    public void reajusteTributavel(final ReajusteTributavel reajusteTributavel) {
        System.out.println(String.format("Data: %s Valor: %s Imposto de renda: %s", reajusteTributavel.data(),
                                         reajusteTributavel.valor(), reajusteTributavel.valorImpostoDeRenda()));
    }
}
