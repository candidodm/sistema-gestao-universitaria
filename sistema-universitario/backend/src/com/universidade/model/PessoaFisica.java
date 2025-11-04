package com.universidade.model;

import java.time.LocalDate;
import com.universidade.util.ValidadorCPF;

/**
 * Classe que representa uma Pessoa Física no sistema.
 * Estende a classe abstrata Pessoa.
 * 
 * @author Grupo 48 - Projeto Integrador
 * @version 2.0
 */
public class PessoaFisica extends Pessoa {
    
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String nomePai;
    private String nomeMae;
    private String rg;
    private String observacoes;
    
    /**
     * Construtor padrão
     */
    public PessoaFisica() {
        super();
    }
    
    /**
     * Construtor com parâmetros essenciais
     * 
     * @param cpf CPF da pessoa
     * @param nome Nome completo
     * @param dataNascimento Data de nascimento
     * @param email E-mail
     * @param telefone Telefone
     */
    public PessoaFisica(String cpf, String nome, LocalDate dataNascimento, String email, String telefone) {
        super(email, telefone);
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    // Getters e Setters
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getNomePai() {
        return nomePai;
    }
    
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }
    
    public String getNomeMae() {
        return nomeMae;
    }
    
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }
    
    public String getRg() {
        return rg;
    }
    
    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public String getObservacoes() {
        return observacoes;
    }
    
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    /**
     * Calcula a idade da pessoa física
     * 
     * @return idade em anos
     */
    public int calcularIdade() {
        if (dataNascimento == null) {
            return 0;
        }
        LocalDate hoje = LocalDate.now();
        return hoje.getYear() - dataNascimento.getYear();
    }
    
    @Override
    public boolean validarDados() {
        // Validar CPF
        if (cpf == null || !ValidadorCPF.validar(cpf)) {
            return false;
        }
        
        // Validar nome
        if (nome == null || nome.trim().isEmpty() || nome.length() < 3) {
            return false;
        }
        
        // Validar data de nascimento
        if (dataNascimento == null || dataNascimento.isAfter(LocalDate.now())) {
            return false;
        }
        
        // Validar email
        if (email == null || !email.contains("@")) {
            return false;
        }
        
        // Validar telefone
        if (telefone == null || telefone.length() < 10) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String getInformacoes() {
        return String.format("Pessoa Física: %s | CPF: %s | Idade: %d anos | Email: %s", 
                            nome, cpf, calcularIdade(), email);
    }
    
    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
