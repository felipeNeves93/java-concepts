package br.com.concepts.builder;

import java.time.LocalDate;

public class Main {
    public static void main(String... args) {

        // Pela ausência de construtores publicos, se obriga a utilização do builder.
        // A classe será imutável pela ausência de setters.

        // Os parâmetros obrigatorios são passados no construtor do builder.
        // Os demais são opcionais. Nesse exemplo, só setei dataNascimento e profissão.
        Pessoa pessoa = new Pessoa.Builder("Felipe", "Neves", "00000000")
                .dataNascimento(LocalDate.of(1993, 4, 21))
                .profissao("Programador")
                .build();

        //Felipe
        System.out.println(pessoa.getNome());

        // Null
        System.out.println(pessoa.getEmail());
    }
}
