package br.com.concepts.builder;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Pessoa {

    private final String nome;
    private final String sobrenome;
    private final String cpf;
    private String rg;
    private String telefone;
    private String profissao;
    private LocalDate dataNascimento;
    private String email;

    public static class Builder {

        // Campos obrigatórios
        private final String nome;
        private final String sobrenome;
        private final String cpf;

        // Campos Opcionais
        private String rg;
        private String telefone;
        private String profissao;
        private LocalDate dataNascimento;
        private String email;

        // Construtor com os parâmetros obrigatórios
        public Builder(String nome, String sobrenome, String cpf) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
        }

        // Builders específicos de cada campo, permitindo chamada encadeada pois retorna o this.
        public Builder rg(String valor) {
            rg = valor;
            return this;
        }

        public Builder telefone(String valor) {
            telefone = valor;
            return this;
        }

        public Builder profissao(String valor) {
            profissao = valor;
            return this;
        }

        public Builder dataNascimento(LocalDate valor) {
            dataNascimento = valor;
            return this;
        }

        public Builder email(String valor) {
            email = valor;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(this);
        }
    }

    // Garante a criação do objeto com os parametros obrigatorios e com os opcionais desejados
    private Pessoa(Builder builder) {
        nome = builder.nome;
        sobrenome = builder.sobrenome;
        cpf = builder.cpf;
        rg = builder.rg;
        telefone = builder.telefone;
        profissao = builder.profissao;
        dataNascimento = builder.dataNascimento;
        email = builder.email;
    }
}
