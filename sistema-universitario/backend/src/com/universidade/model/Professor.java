package com.universidade.model;

import java.time.LocalDate;

/**
 * Classe que representa um Professor no sistema universitário.
 * Estende a classe PessoaFisica, incluindo atributos específicos de professores.
 * 
 * @author Grupo 48 - Projeto Integrador
 * @version 2.0
 */
public class Professor extends PessoaFisica {
    
    private String matricula;
    private String departamento;
    private String titulacao;
    private String regimeTrabalho;
    private LocalDate dataAdmissao;
    private String areaEspecializacao;
    private String curriculoLattes;
    private double salario;
    private boolean ativo;
    
    /**
     * Enum para representar as titulações possíveis
     */
    public enum Titulacao {
        GRADUACAO("Graduação"),
        ESPECIALIZACAO("Especialização"),
        MESTRADO("Mestrado"),
        DOUTORADO("Doutorado"),
        POS_DOUTORADO("Pós-Doutorado");
        
        private String descricao;
        
        Titulacao(String descricao) {
            this.descricao = descricao;
        }
        
        public String getDescricao() {
            return descricao;
        }
    }
    
    /**
     * Enum para representar os regimes de trabalho
     */
    public enum RegimeTrabalho {
        DEDICACAO_EXCLUSIVA("Dedicação Exclusiva"),
        TEMPO_INTEGRAL("Tempo Integral (40h)"),
        TEMPO_PARCIAL("Tempo Parcial (20h)"),
        HORISTA("Horista");
        
        private String descricao;
        
        RegimeTrabalho(String descricao) {
            this.descricao = descricao;
        }
        
        public String getDescricao() {
            return descricao;
        }
    }
    
    /**
     * Construtor padrão
     */
    public Professor() {
        super();
        this.ativo = true;
    }
    
    /**
     * Construtor com parâmetros essenciais
     * 
     * @param cpf CPF do professor
     * @param nome Nome completo
     * @param dataNascimento Data de nascimento
     * @param email E-mail institucional
     * @param telefone Telefone
     * @param matricula Matrícula do professor
     * @param departamento Departamento ao qual está vinculado
     * @param titulacao Titulação acadêmica
     */
    public Professor(String cpf, String nome, LocalDate dataNascimento, String email, 
                    String telefone, String matricula, String departamento, String titulacao) {
        super(cpf, nome, dataNascimento, email, telefone);
        this.matricula = matricula;
        this.departamento = departamento;
        this.titulacao = titulacao;
        this.ativo = true;
    }
    
    // Getters e Setters
    
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
    
    public String getAreaEspecializacao() {
        return areaEspecializacao;
    }
    
    public void setAreaEspecializacao(String areaEspecializacao) {
        this.areaEspecializacao = areaEspecializacao;
    }
    
    public String getCurriculoLattes() {
        return curriculoLattes;
    }
    
    public void setCurriculoLattes(String curriculoLattes) {
        this.curriculoLattes = curriculoLattes;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    /**
     * Calcula o tempo de serviço do professor em anos
     * 
     * @return anos de serviço
     */
    public int calcularTempoServico() {
        if (dataAdmissao == null) {
            return 0;
        }
        LocalDate hoje = LocalDate.now();
        return hoje.getYear() - dataAdmissao.getYear();
    }
    
    /**
     * Verifica se o professor está apto para progressão de carreira
     * 
     * @return true se apto, false caso contrário
     */
    public boolean aptoProgressao() {
        return calcularTempoServico() >= 3 && ativo;
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
        
        // Validar departamento
        if (departamento == null || departamento.trim().isEmpty()) {
            return false;
        }
        
        // Validar titulação
        if (titulacao == null || titulacao.trim().isEmpty()) {
            return false;
        }
        
        // Validar data de admissão
        if (dataAdmissao != null && dataAdmissao.isAfter(LocalDate.now())) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String getInformacoes() {
        return String.format("Professor: %s | Matrícula: %s | Departamento: %s | Titulação: %s | Tempo de Serviço: %d anos", 
                            getNome(), matricula, departamento, titulacao, calcularTempoServico());
    }
    
    @Override
    public String toString() {
        return "Professor{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", departamento='" + departamento + '\'' +
                ", titulacao='" + titulacao + '\'' +
                ", regimeTrabalho='" + regimeTrabalho + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                ", areaEspecializacao='" + areaEspecializacao + '\'' +
                ", email='" + getEmail() + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
