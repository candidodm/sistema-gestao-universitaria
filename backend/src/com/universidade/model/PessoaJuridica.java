package com.universidade.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Classe que representa uma Pessoa Jurídica no sistema universitário.
 * Serve como base para Fornecedor.
 */
public class PessoaJuridica {
    private String id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

    // Construtor padrão
    public PessoaJuridica() {
        this.id = UUID.randomUUID().toString();
        this.dataCadastro = LocalDateTime.now();
    }

    // Construtor com parâmetros
    public PessoaJuridica(String cnpj, String razaoSocial, String nomeFantasia, 
                          String email, String telefone) {
        this();
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.email = email;
        this.telefone = telefone;
    }

    // Método de validação de CNPJ
    public boolean validarCNPJ() {
        if (cnpj == null || cnpj.isEmpty()) {
            return false;
        }
        
        // Remove caracteres não numéricos
        String cnpjNumeros = cnpj.replaceAll("[^0-9]", "");
        
        // Verifica se tem 14 dígitos
        if (cnpjNumeros.length() != 14) {
            return false;
        }
        
        // Verifica se todos os dígitos são iguais
        if (cnpjNumeros.matches("(\\d)\\1{13}")) {
            return false;
        }
        
        try {
            int[] numeros = new int[14];
            for (int i = 0; i < 14; i++) {
                numeros[i] = Character.getNumericValue(cnpjNumeros.charAt(i));
            }
            
            // Validação do primeiro dígito verificador
            int[] peso1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int soma = 0;
            for (int i = 0; i < 12; i++) {
                soma += numeros[i] * peso1[i];
            }
            int primeiroDigito = soma % 11;
            primeiroDigito = primeiroDigito < 2 ? 0 : 11 - primeiroDigito;
            
            if (numeros[12] != primeiroDigito) {
                return false;
            }
            
            // Validação do segundo dígito verificador
            int[] peso2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            soma = 0;
            for (int i = 0; i < 13; i++) {
                soma += numeros[i] * peso2[i];
            }
            int segundoDigito = soma % 11;
            segundoDigito = segundoDigito < 2 ? 0 : 11 - segundoDigito;
            
            return numeros[13] == segundoDigito;
            
        } catch (Exception e) {
            return false;
        }
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "id='" + id + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
