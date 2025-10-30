package com.universidade.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Classe que representa um Administrador do sistema universitário.
 * Responsável por realizar cadastros e validações.
 */
public class Administrador {
    private String id;
    private String nomeCompleto;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

    // Construtor padrão
    public Administrador() {
        this.id = UUID.randomUUID().toString();
        this.dataCadastro = LocalDateTime.now();
    }

    // Construtor com parâmetros
    public Administrador(String nomeCompleto, String email, String telefone) {
        this();
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.telefone = telefone;
    }

    // Método para cadastrar uma nova pessoa física
    public PessoaFisica cadastrarPessoaFisica(String nomeCompleto, String cpf, 
                                              java.time.LocalDate dataNascimento, 
                                              String email, String telefone) {
        PessoaFisica pf = new PessoaFisica(nomeCompleto, cpf, dataNascimento, email, telefone);
        if (!pf.validarCPF()) {
            System.err.println("CPF inválido!");
            return null;
        }
        System.out.println("Pessoa Física cadastrada com sucesso! ID: " + pf.getId());
        return pf;
    }

    // Método para cadastrar uma nova pessoa jurídica
    public PessoaJuridica cadastrarPessoaJuridica(String cnpj, String razaoSocial, 
                                                  String nomeFantasia, String email, 
                                                  String telefone) {
        PessoaJuridica pj = new PessoaJuridica(cnpj, razaoSocial, nomeFantasia, email, telefone);
        if (!pj.validarCNPJ()) {
            System.err.println("CNPJ inválido!");
            return null;
        }
        System.out.println("Pessoa Jurídica cadastrada com sucesso! ID: " + pj.getId());
        return pj;
    }

    // Método para cadastrar um professor
    public Professor cadastrarProfessor(String nomeCompleto, String cpf, 
                                       java.time.LocalDate dataNascimento, String email, 
                                       String telefone, String departamento, 
                                       String titulacao, String regimeTrabalho, 
                                       java.time.LocalDate dataAdmissao) {
        Professor professor = new Professor(nomeCompleto, cpf, dataNascimento, email, 
                                           telefone, departamento, titulacao, 
                                           regimeTrabalho, dataAdmissao);
        if (!professor.validarCPF()) {
            System.err.println("CPF inválido!");
            return null;
        }
        professor.vincularDados();
        System.out.println("Professor cadastrado com sucesso! Matrícula: " + 
                          professor.getMatriculaFuncional());
        return professor;
    }

    // Método para cadastrar um aluno
    public Aluno cadastrarAluno(String nomeCompleto, String cpf, 
                               java.time.LocalDate dataNascimento, String email, 
                               String telefone, String curso, String turno, 
                               java.time.LocalDate dataIngresso, String formaIngresso) {
        Aluno aluno = new Aluno(nomeCompleto, cpf, dataNascimento, email, telefone, 
                               curso, turno, dataIngresso, formaIngresso);
        if (!aluno.validarCPF()) {
            System.err.println("CPF inválido!");
            return null;
        }
        if (!aluno.validarCursoDisponivel()) {
            System.err.println("Curso indisponível!");
            return null;
        }
        aluno.habilitarSistemasAcademicos();
        System.out.println("Aluno cadastrado com sucesso! Matrícula: " + 
                          aluno.getMatriculaAcademica());
        return aluno;
    }

    // Método para cadastrar um fornecedor
    public Fornecedor cadastrarFornecedor(String cnpj, String razaoSocial, 
                                         String nomeFantasia, String email, 
                                         String telefone, String areaAtuacao, 
                                         String ramo, String produtosServicos, 
                                         String representanteLegal, 
                                         String condicoesPagamento) {
        Fornecedor fornecedor = new Fornecedor(cnpj, razaoSocial, nomeFantasia, email, 
                                              telefone, areaAtuacao, ramo, 
                                              produtosServicos, representanteLegal, 
                                              condicoesPagamento);
        if (!fornecedor.validarCNPJ()) {
            System.err.println("CNPJ inválido!");
            return null;
        }
        fornecedor.vincularDados();
        System.out.println("Fornecedor cadastrado com sucesso! Código: " + 
                          fornecedor.getCodigoFornecedor());
        return fornecedor;
    }

    // Método para atualizar dados
    public void atualizarDados() {
        System.out.println("Atualizando dados do administrador: " + this.nomeCompleto);
    }

    // Método para validar dados
    public boolean validarDados(String dados) {
        return dados != null && !dados.trim().isEmpty();
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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
        return "Administrador{" +
                "id='" + id + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
