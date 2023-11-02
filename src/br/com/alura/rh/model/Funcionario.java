package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {

    private DadosPessoais dadosPessoais;
    private LocalDate dataUltimoReajuste;

    public Funcionario(final DadosPessoais dadosPessoais, final LocalDate dataUltimoReajuste) {
        this.dadosPessoais = dadosPessoais;
        this.dataUltimoReajuste = dataUltimoReajuste;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public LocalDate getDataUltimoReajuste() {
        return dataUltimoReajuste;
    }

    public void atualizarSalario(final BigDecimal novoSalario) {
        this.dadosPessoais.setSalario(novoSalario);
        this.dataUltimoReajuste = LocalDate.now();
    }

    public void promover(final Cargo novoCargo) {
        this.dadosPessoais.setCargo(novoCargo);
    }

    @Override
    public String toString() {
        return String.format("Nome: %s Cargo: %s Salario: %s", this.dadosPessoais.getNome(),
                             this.dadosPessoais.getCargo(), this.dadosPessoais.getSalario());
    }
}
