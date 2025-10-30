package com.universidade.model;

import java.time.LocalDate;

/**
 * Classe que representa um Professor no sistema universitário.
 * Estende PessoaFisica adicionando informações específicas de professor.
 */
public class Professor extends PessoaFisica {
    private String matriculaFuncional;
    private String departamento;
    private String titulacao;
    private String regimeTrabalho;
    private LocalDate dataAdmissao;

    // Construtor padrão
    public Professor() {
        super();
        gerarMatriculaFuncional();
    }

    // Construtor com parâmetros
    public Professor(String nomeCompleto, String cpf, LocalDate dataNascimento, 
                     String email, String telefone, String departamento, 
                     String titulacao, String regimeTrabalho, LocalDate dataAdmissao) {
        super(nomeCompleto, cpf, dataNascimento, email, telefone);
        this.departamento = departamento;
        this.titulacao = titulacao;
        this.regimeTrabalho = regimeTrabalho;
        this.dataAdmissao = dataAdmissao;
        gerarMatriculaFuncional();
    }

    // Método para gerar matrícula funcional única
    private void gerarMatriculaFuncional() {
        String ano = String.valueOf(java.time.Year.now().getValue());
        String random = String.format("%06d", (int)(Math.random() * 1000000));
        this.matriculaFuncional = "PROF" + ano + random;
    }

    // Método para vincular dados à Pessoa Física
    public void vincularDados() {
        System.out.println("Dados do professor vinculados à Pessoa Física ID: " + this.getId());
    }

    // Getters e Setters
    public String getMatriculaFuncional() {
        return matriculaFuncional;
    }

    public void setMatriculaFuncional(String matriculaFuncional) {
        this.matriculaFuncional = matriculaFuncional;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getRegimeTrabalho() {
        return regimeTrabalho;
    }

    public void setRegimeTrabalho(String regimeTrabalho) {
        this.regimeTrabalho = regimeTrabalho;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "matriculaFuncional='" + matriculaFuncional + '\'' +
                ", departamento='" + departamento + '\'' +
                ", titulacao='" + titulacao + '\'' +
                ", regimeTrabalho='" + regimeTrabalho + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                ", " + super.toString() +
                '}';
    }
}
