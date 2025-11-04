package com.universidade.model;

import java.time.LocalDate;

/**
 * Classe que representa um Fornecedor no sistema universitário.
 * Estende a classe PessoaJuridica, incluindo atributos específicos de fornecedores.
 * 
 * @author Grupo 48 - Projeto Integrador
 * @version 2.0
 */
public class Fornecedor extends PessoaJuridica {
    
    private String setorAtuacao;
    private String tipoProdutoServico;
    private String produtosServicos;
    private String condicoesPagamento;
    private int prazoEntrega;
    private String nomeContato;
    private String telefoneContato;
    private String emailContato;
    private boolean aprovado;
    private double avaliacaoMedia;
    
    /**
     * Enum para representar os setores de atuação
     */
    public enum SetorAtuacao {
        TECNOLOGIA("Tecnologia e Informática"),
        MOBILIARIO("Mobiliário e Equipamentos"),
        MATERIAL_ESCRITORIO("Material de Escritório"),
        LIMPEZA("Limpeza e Conservação"),
        ALIMENTACAO("Alimentação"),
        MANUTENCAO("Manutenção e Reparos"),
        SEGURANCA("Segurança"),
        SERVICOS_GERAIS("Serviços Gerais"),
        LIVROS_DIDATICOS("Livros e Material Didático"),
        LABORATORIO("Equipamentos de Laboratório"),
        OUTROS("Outros");
        
        private String descricao;
        
        SetorAtuacao(String descricao) {
            this.descricao = descricao;
        }
        
        public String getDescricao() {
            return descricao;
        }
    }
    
    /**
     * Enum para representar o tipo de fornecimento
     */
    public enum TipoProdutoServico {
        PRODUTOS("Produtos"),
        SERVICOS("Serviços"),
        AMBOS("Produtos e Serviços");
        
        private String descricao;
        
        TipoProdutoServico(String descricao) {
            this.descricao = descricao;
        }
        
        public String getDescricao() {
            return descricao;
        }
    }
    
    /**
     * Construtor padrão
     */
    public Fornecedor() {
        super();
        this.aprovado = false;
        this.avaliacaoMedia = 0.0;
    }
    
    /**
     * Construtor com parâmetros essenciais
     * 
     * @param cnpj CNPJ do fornecedor
     * @param razaoSocial Razão social
     * @param nomeFantasia Nome fantasia
     * @param email E-mail
     * @param telefone Telefone
     * @param setorAtuacao Setor de atuação
     * @param tipoProdutoServico Tipo de fornecimento
     */
    public Fornecedor(String cnpj, String razaoSocial, String nomeFantasia, String email, 
                     String telefone, String setorAtuacao, String tipoProdutoServico) {
        super(cnpj, razaoSocial, nomeFantasia, email, telefone);
        this.setorAtuacao = setorAtuacao;
        this.tipoProdutoServico = tipoProdutoServico;
        this.aprovado = false;
        this.avaliacaoMedia = 0.0;
    }
    
    // Getters e Setters
    
    public String getSetorAtuacao() {
        return setorAtuacao;
    }
    
    public void setSetorAtuacao(String setorAtuacao) {
        this.setorAtuacao = setorAtuacao;
    }
    
    public String getTipoProdutoServico() {
        return tipoProdutoServico;
    }
    
    public void setTipoProdutoServico(String tipoProdutoServico) {
        this.tipoProdutoServico = tipoProdutoServico;
    }
    
    public String getProdutosServicos() {
        return produtosServicos;
    }
    
    public void setProdutosServicos(String produtosServicos) {
        this.produtosServicos = produtosServicos;
    }
    
    public String getCondicoesPagamento() {
        return condicoesPagamento;
    }
    
    public void setCondicoesPagamento(String condicoesPagamento) {
        this.condicoesPagamento = condicoesPagamento;
    }
    
    public int getPrazoEntrega() {
        return prazoEntrega;
    }
    
    public void setPrazoEntrega(int prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }
    
    public String getNomeContato() {
        return nomeContato;
    }
    
    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }
    
    public String getTelefoneContato() {
        return telefoneContato;
    }
    
    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }
    
    public String getEmailContato() {
        return emailContato;
    }
    
    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }
    
    public boolean isAprovado() {
        return aprovado;
    }
    
    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
    
    public double getAvaliacaoMedia() {
        return avaliacaoMedia;
    }
    
    public void setAvaliacaoMedia(double avaliacaoMedia) {
        this.avaliacaoMedia = avaliacaoMedia;
    }
    
    /**
     * Aprova o fornecedor para realizar transações
     */
    public void aprovar() {
        if (validarDados()) {
            this.aprovado = true;
        }
    }
    
    /**
     * Reprova o fornecedor
     */
    public void reprovar() {
        this.aprovado = false;
    }
    
    /**
     * Adiciona uma avaliação ao fornecedor
     * 
     * @param nota Nota de 0 a 10
     */
    public void adicionarAvaliacao(double nota) {
        if (nota >= 0 && nota <= 10) {
            // Lógica simplificada - em produção, seria mais complexa
            this.avaliacaoMedia = (this.avaliacaoMedia + nota) / 2;
        }
    }
    
    /**
     * Verifica se o fornecedor é confiável com base na avaliação
     * 
     * @return true se confiável, false caso contrário
     */
    public boolean isConfiavel() {
        return aprovado && avaliacaoMedia >= 7.0;
    }
    
    @Override
    public boolean validarDados() {
        // Validações da classe pai
        if (!super.validarDados()) {
            return false;
        }
        
        // Validar setor de atuação
        if (setorAtuacao == null || setorAtuacao.trim().isEmpty()) {
            return false;
        }
        
        // Validar tipo de produto/serviço
        if (tipoProdutoServico == null || tipoProdutoServico.trim().isEmpty()) {
            return false;
        }
        
        // Validar descrição de produtos/serviços
        if (produtosServicos == null || produtosServicos.trim().isEmpty()) {
            return false;
        }
        
        // Validar condições de pagamento
        if (condicoesPagamento == null || condicoesPagamento.trim().isEmpty()) {
            return false;
        }
        
        // Validar nome do contato
        if (nomeContato == null || nomeContato.trim().isEmpty()) {
            return false;
        }
        
        // Validar prazo de entrega
        if (prazoEntrega < 0) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String getInformacoes() {
        return String.format("Fornecedor: %s | CNPJ: %s | Setor: %s | Tipo: %s | Avaliação: %.2f | Aprovado: %s", 
                            getNomeFantasia(), getCnpj(), setorAtuacao, tipoProdutoServico, 
                            avaliacaoMedia, aprovado ? "Sim" : "Não");
    }
    
    @Override
    public String toString() {
        return "Fornecedor{" +
                "razaoSocial='" + getRazaoSocial() + '\'' +
                ", nomeFantasia='" + getNomeFantasia() + '\'' +
                ", cnpj='" + getCnpj() + '\'' +
                ", setorAtuacao='" + setorAtuacao + '\'' +
                ", tipoProdutoServico='" + tipoProdutoServico + '\'' +
                ", condicoesPagamento='" + condicoesPagamento + '\'' +
                ", prazoEntrega=" + prazoEntrega +
                ", nomeContato='" + nomeContato + '\'' +
                ", email='" + getEmail() + '\'' +
                ", aprovado=" + aprovado +
                ", avaliacaoMedia=" + avaliacaoMedia +
                '}';
    }
}
