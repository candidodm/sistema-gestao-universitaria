package com.universidade.model;

/**
 * Classe que representa um Fornecedor no sistema universitário.
 * Estende PessoaJuridica adicionando informações específicas de fornecedor.
 */
public class Fornecedor extends PessoaJuridica {
    private String codigoFornecedor;
    private String areaAtuacao;
    private String ramo;
    private String produtosServicos;
    private String representanteLegal;
    private String condicoesPagamento;

    // Construtor padrão
    public Fornecedor() {
        super();
        gerarCodigoFornecedor();
    }

    // Construtor com parâmetros
    public Fornecedor(String cnpj, String razaoSocial, String nomeFantasia, 
                      String email, String telefone, String areaAtuacao, 
                      String ramo, String produtosServicos, 
                      String representanteLegal, String condicoesPagamento) {
        super(cnpj, razaoSocial, nomeFantasia, email, telefone);
        this.areaAtuacao = areaAtuacao;
        this.ramo = ramo;
        this.produtosServicos = produtosServicos;
        this.representanteLegal = representanteLegal;
        this.condicoesPagamento = condicoesPagamento;
        gerarCodigoFornecedor();
    }

    // Método para gerar código único de fornecedor
    private void gerarCodigoFornecedor() {
        String ano = String.valueOf(java.time.Year.now().getValue());
        String random = String.format("%06d", (int)(Math.random() * 1000000));
        this.codigoFornecedor = "FORN" + ano + random;
    }

    // Método para vincular dados à Pessoa Jurídica
    public void vincularDados() {
        System.out.println("Dados do fornecedor vinculados à Pessoa Jurídica ID: " + this.getId());
    }

    // Getters e Setters
    public String getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(String codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getProdutosServicos() {
        return produtosServicos;
    }

    public void setProdutosServicos(String produtosServicos) {
        this.produtosServicos = produtosServicos;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getCondicoesPagamento() {
        return condicoesPagamento;
    }

    public void setCondicoesPagamento(String condicoesPagamento) {
        this.condicoesPagamento = condicoesPagamento;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "codigoFornecedor='" + codigoFornecedor + '\'' +
                ", areaAtuacao='" + areaAtuacao + '\'' +
                ", ramo='" + ramo + '\'' +
                ", produtosServicos='" + produtosServicos + '\'' +
                ", representanteLegal='" + representanteLegal + '\'' +
                ", condicoesPagamento='" + condicoesPagamento + '\'' +
                ", " + super.toString() +
                '}';
    }
}
