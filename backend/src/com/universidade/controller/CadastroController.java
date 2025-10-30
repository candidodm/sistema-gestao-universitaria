package com.universidade.controller;

import com.universidade.model.*;
import com.universidade.service.PessoaFisicaService;
import com.universidade.service.PessoaJuridicaService;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador principal que expõe APIs para o frontend.
 * Simula um servidor REST básico.
 */
public class CadastroController {
    private PessoaFisicaService pessoaFisicaService;
    private PessoaJuridicaService pessoaJuridicaService;

    public CadastroController() {
        this.pessoaFisicaService = new PessoaFisicaService();
        this.pessoaJuridicaService = new PessoaJuridicaService();
    }

    // ==================== PESSOA FÍSICA ====================
    
    public Map<String, Object> cadastrarPessoaFisica(Map<String, String> dados) {
        try {
            String nomeCompleto = dados.get("nomeCompleto");
            String cpf = dados.get("cpf");
            LocalDate dataNascimento = LocalDate.parse(dados.get("dataNascimento"));
            String email = dados.get("email");
            String telefone = dados.get("telefone");
            
            return pessoaFisicaService.criar(nomeCompleto, cpf, dataNascimento, 
                                            email, telefone);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("sucesso", false);
            response.put("mensagem", "Erro ao processar dados: " + e.getMessage());
            return response;
        }
    }

    public Map<String, Object> buscarPessoaFisicaPorCPF(String cpf) {
        Map<String, Object> response = new HashMap<>();
        PessoaFisica pf = pessoaFisicaService.buscarPorCPF(cpf);
        
        if (pf != null) {
            response.put("sucesso", true);
            response.put("pessoa", pf);
        } else {
            response.put("sucesso", false);
            response.put("mensagem", "Pessoa física não encontrada");
        }
        
        return response;
    }

    // ==================== PESSOA JURÍDICA ====================
    
    public Map<String, Object> cadastrarPessoaJuridica(Map<String, String> dados) {
        try {
            String cnpj = dados.get("cnpj");
            String razaoSocial = dados.get("razaoSocial");
            String nomeFantasia = dados.get("nomeFantasia");
            String email = dados.get("email");
            String telefone = dados.get("telefone");
            
            return pessoaJuridicaService.criar(cnpj, razaoSocial, nomeFantasia, 
                                              email, telefone);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("sucesso", false);
            response.put("mensagem", "Erro ao processar dados: " + e.getMessage());
            return response;
        }
    }

    public Map<String, Object> buscarPessoaJuridicaPorCNPJ(String cnpj) {
        Map<String, Object> response = new HashMap<>();
        PessoaJuridica pj = pessoaJuridicaService.buscarPorCNPJ(cnpj);
        
        if (pj != null) {
            response.put("sucesso", true);
            response.put("empresa", pj);
        } else {
            response.put("sucesso", false);
            response.put("mensagem", "Pessoa jurídica não encontrada");
        }
        
        return response;
    }

    // ==================== PROFESSOR ====================
    
    public Map<String, Object> cadastrarProfessor(Map<String, String> dados) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // Primeiro verificar se a PF existe
            String cpf = dados.get("cpf");
            PessoaFisica pf = pessoaFisicaService.buscarPorCPF(cpf);
            
            if (pf == null) {
                response.put("sucesso", false);
                response.put("mensagem", "Pessoa física não cadastrada");
                response.put("acao", "cadastrar_pf_primeiro");
                return response;
            }
            
            // Criar professor
            Professor professor = new Professor(
                pf.getNomeCompleto(),
                pf.getCpf(),
                pf.getDataNascimento(),
                pf.getEmail(),
                pf.getTelefone(),
                dados.get("departamento"),
                dados.get("titulacao"),
                dados.get("regimeTrabalho"),
                LocalDate.parse(dados.get("dataAdmissao"))
            );
            
            professor.vincularDados();
            
            response.put("sucesso", true);
            response.put("mensagem", "Professor cadastrado com sucesso");
            response.put("matriculaFuncional", professor.getMatriculaFuncional());
            response.put("professor", professor);
            
        } catch (Exception e) {
            response.put("sucesso", false);
            response.put("mensagem", "Erro ao processar dados: " + e.getMessage());
        }
        
        return response;
    }

    // ==================== ALUNO ====================
    
    public Map<String, Object> cadastrarAluno(Map<String, String> dados) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // Primeiro verificar se a PF existe
            String cpf = dados.get("cpf");
            PessoaFisica pf = pessoaFisicaService.buscarPorCPF(cpf);
            
            if (pf == null) {
                response.put("sucesso", false);
                response.put("mensagem", "Pessoa física não cadastrada");
                response.put("acao", "cadastrar_pf_primeiro");
                return response;
            }
            
            // Criar aluno
            Aluno aluno = new Aluno(
                pf.getNomeCompleto(),
                pf.getCpf(),
                pf.getDataNascimento(),
                pf.getEmail(),
                pf.getTelefone(),
                dados.get("curso"),
                dados.get("turno"),
                LocalDate.parse(dados.get("dataIngresso")),
                dados.get("formaIngresso")
            );
            
            if (!aluno.validarCursoDisponivel()) {
                response.put("sucesso", false);
                response.put("mensagem", "Curso indisponível para matrícula");
                return response;
            }
            
            aluno.habilitarSistemasAcademicos();
            
            response.put("sucesso", true);
            response.put("mensagem", "Aluno cadastrado com sucesso");
            response.put("matriculaAcademica", aluno.getMatriculaAcademica());
            response.put("aluno", aluno);
            
        } catch (Exception e) {
            response.put("sucesso", false);
            response.put("mensagem", "Erro ao processar dados: " + e.getMessage());
        }
        
        return response;
    }

    // ==================== FORNECEDOR ====================
    
    public Map<String, Object> cadastrarFornecedor(Map<String, String> dados) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // Primeiro verificar se a PJ existe
            String cnpj = dados.get("cnpj");
            PessoaJuridica pj = pessoaJuridicaService.buscarPorCNPJ(cnpj);
            
            if (pj == null) {
                response.put("sucesso", false);
                response.put("mensagem", "Pessoa jurídica não cadastrada");
                response.put("acao", "cadastrar_pj_primeiro");
                return response;
            }
            
            // Criar fornecedor
            Fornecedor fornecedor = new Fornecedor(
                pj.getCnpj(),
                pj.getRazaoSocial(),
                pj.getNomeFantasia(),
                pj.getEmail(),
                pj.getTelefone(),
                dados.get("areaAtuacao"),
                dados.get("ramo"),
                dados.get("produtosServicos"),
                dados.get("representanteLegal"),
                dados.get("condicoesPagamento")
            );
            
            fornecedor.vincularDados();
            
            response.put("sucesso", true);
            response.put("mensagem", "Fornecedor cadastrado com sucesso");
            response.put("codigoFornecedor", fornecedor.getCodigoFornecedor());
            response.put("fornecedor", fornecedor);
            
        } catch (Exception e) {
            response.put("sucesso", false);
            response.put("mensagem", "Erro ao processar dados: " + e.getMessage());
        }
        
        return response;
    }
}
