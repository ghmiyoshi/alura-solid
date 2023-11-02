package br.com.alura.rh;

import br.com.alura.rh.model.DadosPessoais;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.reajuste.Anuenio;
import br.com.alura.rh.reajuste.Promocao;
import br.com.alura.rh.service.PromocaoService;
import br.com.alura.rh.service.ReajusteService;
import br.com.alura.rh.validacao.ValidacaoPercentualReajuste;
import br.com.alura.rh.validacao.ValidacaoPeriodicidadeEntreReajustes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static br.com.alura.rh.model.Cargo.ANALISTA;

public class Main {

    public static void main(String[] args) {
        var dadosPessoais = new DadosPessoais("Gabriel", "1234", ANALISTA, BigDecimal.TEN);
        var funcionario = new Funcionario(dadosPessoais, LocalDate.of(2022, 11, 2));

        var promocaoService = new PromocaoService();
        promocaoService.promover(funcionario, true);
        System.out.println(funcionario);

        var validacaoPercentualReajuste = new ValidacaoPercentualReajuste();
        validacaoPercentualReajuste.validar(funcionario, BigDecimal.ONE);

        var validacaoPeriodicidadeEntreReajustes = new ValidacaoPeriodicidadeEntreReajustes();
        validacaoPeriodicidadeEntreReajustes.validar(funcionario, BigDecimal.TEN);

        var reajusteService = new ReajusteService(List.of(validacaoPercentualReajuste,
                                                          validacaoPeriodicidadeEntreReajustes));
        reajusteService.reajustarSalarioDoFuncionario(funcionario, BigDecimal.ONE);
        System.out.println(funcionario);

        var promocao = new Promocao(BigDecimal.valueOf(11.98), LocalDate.now());
        var anuenio = new Anuenio(BigDecimal.TEN, LocalDate.now());

        var valorImpostoDeRenda = promocao.valorImpostoDeRenda();
        System.out.println(valorImpostoDeRenda);

        reajusteService.reajuste(anuenio);
        reajusteService.reajuste(promocao);
        reajusteService.reajusteTributavel(promocao);
    }
}
