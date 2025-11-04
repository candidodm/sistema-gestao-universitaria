package com.universidade.model;

import java.time.LocalDateTime;

/**
 * Classe abstrata que representa uma pessoa no sistema universitário.
 * Serve como classe base para PessoaFisica e PessoaJuridica.
 * 
 * @author Grupo 48 - Projeto Integrador
 * @version 2.0
 */
public abstract class Pessoa {
    
    // Atributos comuns a todas as pessoas
    protected String email;
    protected String telefone;
    protected String endereco;
    protected String cidade;
    protected String estado;
    protected String cep;
    protected LocalDateTime dataCadastro;
    protected LocalDateTime dataAtualizacao;
    protected boolean ativo;
    
    /**
     * Construtor padrão da classe Pessoa
     */
    public Pessoa() {
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
        this.ativo = true;
    }
    
    /**
     * Construtor com parâmetros básicos
     * 
     * @param email E-mail da pessoa
     * @param telefone Telefone da pessoa
     */
    public Pessoa(String email, String telefone) {
        this();
        this.email = email;
        this.telefone = telefone;
    }
    
    // Getters e Setters
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
        this.dataAtualizacao = LocalDateTime.now();
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
        this.dataAtualizacao = LocalDateTime.now();
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
        this.dataAtualizacao = LocalDateTime.now();
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
        this.dataAtualizacao = LocalDateTime.now();
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
        this.dataAtualizacao = LocalDateTime.now();
    }
    
    public String getCep() {
        return cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
        this.dataAtualizacao = LocalDateTime.now();
    }
    
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    
    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
        this.dataAtualizacao = LocalDateTime.now();
    }
    
    /**
     * Método abstrato para validar os dados da pessoa
     * Deve ser implementado pelas classes filhas
     * 
     * @return true se os dados são válidos, false caso contrário
     */
    public abstract boolean validarDados();
    
    /**
     * Método abstrato para obter informações resumidas da pessoa
     * 
     * @return String com informações resumidas
     */
    public abstract String getInformacoes();
    
    @Override
    public String toString() {
        return "Pessoa{" +
                "email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", ativo=" + ativo +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
