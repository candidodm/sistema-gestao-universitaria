package com.universidade.model;

import java.time.LocalDate;
import com.universidade.util.ValidadorCNPJ;

/**
 * Classe que representa uma Pessoa Jurídica no sistema.
 * Estende a classe abstrata Pessoa.
 * 
 * @author Grupo 48 - Projeto Integrador
 * @version 2.0
 */
public class PessoaJuridica extends Pessoa {
    
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private LocalDate dataAbertura;
    private String inscricaoEstadual;
    private String ramoAtividade;
    private String observacoes;
    
    /**
     * Construtor padrão
     */
    public PessoaJuridica() {
        super();
    }
    
    /**
     * Construtor com parâmetros essenciais
     * 
     * @param cnpj CNPJ da empresa
     * @param razaoSocial Razão social
     * @param nomeFantasia Nome fantasia
     * @param email E-mail
     * @param telefone Telefone
     */
    public PessoaJuridica(String cnpj, String razaoSocial, String nomeFantasia, String email, String telefone) {
        super(email, telefone);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }
    
    // Getters e Setters
    
    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getRazaoSocial() {
        return razaoSocial;
    }
    
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
    public LocalDate getDataAbertura() {
        return dataAbertura;
    }
    
    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
    
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
    
    public String getRamoAtividade() {
        return ramoAtividade;
    }
    
    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }
    
    public String getObservacoes() {
        return observacoes;
    }
    
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    /**
     * Calcula o tempo de atividade da empresa em anos
     * 
     * @return anos de atividade
     */
    public int calcularTempoAtividade() {
        if (dataAbertura == null) {
            return 0;
        }
        LocalDate hoje = LocalDate.now();
        return hoje.getYear() - dataAbertura.getYear();
    }
    
    @Override
    public boolean validarDados() {
        // Validar CNPJ
        if (cnpj == null || !ValidadorCNPJ.validar(cnpj)) {
            return false;
        }
        
        // Validar razão social
        if (razaoSocial == null || razaoSocial.trim().isEmpty() || razaoSocial.length() < 3) {
            return false;
        }
        
        // Validar nome fantasia
        if (nomeFantasia == null || nomeFantasia.trim().isEmpty()) {
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
        return String.format("Pessoa Jurídica: %s | CNPJ: %s | Ramo: %s | Email: %s", 
                            nomeFantasia, cnpj, ramoAtividade, email);
    }
    
    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", ramoAtividade='" + ramoAtividade + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
