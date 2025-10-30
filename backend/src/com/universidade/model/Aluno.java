package com.universidade.model;

import java.time.LocalDate;

/**
 * Classe que representa um Aluno no sistema universitário.
 * Estende PessoaFisica adicionando informações específicas de aluno.
 */
public class Aluno extends PessoaFisica {
    private String matriculaAcademica;
    private String curso;
    private String turno;
    private LocalDate dataIngresso;
    private String formaIngresso;
    private String status;

    // Construtor padrão
    public Aluno() {
        super();
        gerarMatriculaAcademica();
        this.status = "ATIVO";
    }

    // Construtor com parâmetros
    public Aluno(String nomeCompleto, String cpf, LocalDate dataNascimento, 
                 String email, String telefone, String curso, String turno, 
                 LocalDate dataIngresso, String formaIngresso) {
        super(nomeCompleto, cpf, dataNascimento, email, telefone);
        this.curso = curso;
        this.turno = turno;
        this.dataIngresso = dataIngresso;
        this.formaIngresso = formaIngresso;
        this.status = "ATIVO";
        gerarMatriculaAcademica();
    }

    // Método para gerar matrícula acadêmica única
    private void gerarMatriculaAcademica() {
        String ano = String.valueOf(java.time.Year.now().getValue());
        String semestre = (java.time.LocalDate.now().getMonthValue() <= 6) ? "1" : "2";
        String random = String.format("%05d", (int)(Math.random() * 100000));
        this.matriculaAcademica = ano + semestre + random;
    }

    // Método para habilitar aluno aos sistemas acadêmicos
    public void habilitarSistemasAcademicos() {
        System.out.println("Aluno " + this.getNomeCompleto() + 
                          " habilitado nos sistemas acadêmicos com matrícula: " + 
                          this.matriculaAcademica);
    }

    // Método para validar disponibilidade de curso
    public boolean validarCursoDisponivel() {
        // Simulação - em produção consultaria base de dados
        return curso != null && !curso.isEmpty();
    }

    // Getters e Setters
    public String getMatriculaAcademica() {
        return matriculaAcademica;
    }

    public void setMatriculaAcademica(String matriculaAcademica) {
        this.matriculaAcademica = matriculaAcademica;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public String getFormaIngresso() {
        return formaIngresso;
    }

    public void setFormaIngresso(String formaIngresso) {
        this.formaIngresso = formaIngresso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matriculaAcademica='" + matriculaAcademica + '\'' +
                ", curso='" + curso + '\'' +
                ", turno='" + turno + '\'' +
                ", dataIngresso=" + dataIngresso +
                ", formaIngresso='" + formaIngresso + '\'' +
                ", status='" + status + '\'' +
                ", " + super.toString() +
                '}';
    }
}
