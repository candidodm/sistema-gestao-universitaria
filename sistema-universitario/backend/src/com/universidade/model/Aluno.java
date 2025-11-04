package com.universidade.model;

import java.time.LocalDate;

/**
 * Classe que representa um Aluno no sistema universitário.
 * Estende a classe PessoaFisica, incluindo atributos específicos de alunos.
 * 
 * @author Grupo 48 - Projeto Integrador
 * @version 2.0
 */
public class Aluno extends PessoaFisica {
    
    private String matricula;
    private String curso;
    private String turno;
    private int periodo;
    private StatusAluno status;
    private LocalDate dataMatricula;
    private String formaIngresso;
    private String tipoBolsa;
    private double coeficienteRendimento;
    
    /**
     * Enum para representar o status do aluno
     */
    public enum StatusAluno {
        ATIVO("Ativo"),
        TRANCADO("Trancado"),
        FORMADO("Formado"),
        DESISTENTE("Desistente"),
        TRANSFERIDO("Transferido");
        
        private String descricao;
        
        StatusAluno(String descricao) {
            this.descricao = descricao;
        }
        
        public String getDescricao() {
            return descricao;
        }
    }
    
    /**
     * Enum para representar os turnos
     */
    public enum Turno {
        MATUTINO("Matutino"),
        VESPERTINO("Vespertino"),
        NOTURNO("Noturno"),
        INTEGRAL("Integral");
        
        private String descricao;
        
        Turno(String descricao) {
            this.descricao = descricao;
        }
        
        public String getDescricao() {
            return descricao;
        }
    }
    
    /**
     * Construtor padrão
     */
    public Aluno() {
        super();
        this.status = StatusAluno.ATIVO;
        this.coeficienteRendimento = 0.0;
    }
    
    /**
     * Construtor com parâmetros essenciais
     * 
     * @param cpf CPF do aluno
     * @param nome Nome completo
     * @param dataNascimento Data de nascimento
     * @param email E-mail institucional
     * @param telefone Telefone
     * @param matricula Matrícula do aluno
     * @param curso Curso matriculado
     * @param turno Turno das aulas
     */
    public Aluno(String cpf, String nome, LocalDate dataNascimento, String email, 
                String telefone, String matricula, String curso, String turno) {
        super(cpf, nome, dataNascimento, email, telefone);
        this.matricula = matricula;
        this.curso = curso;
        this.turno = turno;
        this.status = StatusAluno.ATIVO;
        this.coeficienteRendimento = 0.0;
    }
    
    // Getters e Setters
    
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
    
    public int getPeriodo() {
        return periodo;
    }
    
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
    public StatusAluno getStatus() {
        return status;
    }
    
    public void setStatus(StatusAluno status) {
        this.status = status;
    }
    
    public LocalDate getDataMatricula() {
        return dataMatricula;
    }
    
    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
    public String getFormaIngresso() {
        return formaIngresso;
    }
    
    public void setFormaIngresso(String formaIngresso) {
        this.formaIngresso = formaIngresso;
    }
    
    public String getTipoBolsa() {
        return tipoBolsa;
    }
    
    public void setTipoBolsa(String tipoBolsa) {
        this.tipoBolsa = tipoBolsa;
    }
    
    public double getCoeficienteRendimento() {
        return coeficienteRendimento;
    }
    
    public void setCoeficienteRendimento(double coeficienteRendimento) {
        this.coeficienteRendimento = coeficienteRendimento;
    }
    
    /**
     * Calcula o tempo de curso em anos
     * 
     * @return anos no curso
     */
    public int calcularTempoCurso() {
        if (dataMatricula == null) {
            return 0;
        }
        LocalDate hoje = LocalDate.now();
        return hoje.getYear() - dataMatricula.getYear();
    }
    
    /**
     * Verifica se o aluno está apto para matrícula no próximo período
     * 
     * @return true se apto, false caso contrário
     */
    public boolean aptoMatricula() {
        return status == StatusAluno.ATIVO && coeficienteRendimento >= 5.0;
    }
    
    /**
     * Realiza a matrícula do aluno no próximo período
     */
    public void matricularProximoPeriodo() {
        if (aptoMatricula()) {
            this.periodo++;
        }
    }
    
    /**
     * Tranca a matrícula do aluno
     */
    public void trancarMatricula() {
        this.status = StatusAluno.TRANCADO;
    }
    
    /**
     * Reativa a matrícula do aluno
     */
    public void reativarMatricula() {
        if (status == StatusAluno.TRANCADO) {
            this.status = StatusAluno.ATIVO;
        }
    }
    
    @Override
    public boolean validarDados() {
        // Validações da classe pai
        if (!super.validarDados()) {
            return false;
        }
        
        // Validar matrícula
        if (matricula == null || matricula.trim().isEmpty()) {
            return false;
        }
        
        // Validar curso
        if (curso == null || curso.trim().isEmpty()) {
            return false;
        }
        
        // Validar turno
        if (turno == null || turno.trim().isEmpty()) {
            return false;
        }
        
        // Validar período
        if (periodo < 1 || periodo > 12) {
            return false;
        }
        
        // Validar data de matrícula
        if (dataMatricula != null && dataMatricula.isAfter(LocalDate.now())) {
            return false;
        }
        
        // Validar coeficiente de rendimento
        if (coeficienteRendimento < 0.0 || coeficienteRendimento > 10.0) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String getInformacoes() {
        return String.format("Aluno: %s | Matrícula: %s | Curso: %s | Período: %dº | Status: %s | CR: %.2f", 
                            getNome(), matricula, curso, periodo, status.getDescricao(), coeficienteRendimento);
    }
    
    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", curso='" + curso + '\'' +
                ", turno='" + turno + '\'' +
                ", periodo=" + periodo +
                ", status=" + status +
                ", dataMatricula=" + dataMatricula +
                ", formaIngresso='" + formaIngresso + '\'' +
                ", email='" + getEmail() + '\'' +
                ", coeficienteRendimento=" + coeficienteRendimento +
                '}';
    }
}
