package com.universidade.service;

import com.universidade.dao.PessoaFisicaDAO;
import com.universidade.model.PessoaFisica;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Serviço para gerenciar Pessoa Física.
 */
public class PessoaFisicaService {
    private PessoaFisicaDAO dao;

    public PessoaFisicaService() {
        this.dao = new PessoaFisicaDAO();
    }

    // Criar nova pessoa física
    public Map<String, Object> criar(String nomeCompleto, String cpf, 
                                     LocalDate dataNascimento, String email, 
                                     String telefone) {
        Map<String, Object> response = new HashMap<>();
        
        // Validar CPF
        PessoaFisica pf = new PessoaFisica();
        pf.setCpf(cpf);
        if (!pf.validarCPF()) {
            response.put("sucesso", false);
            response.put("mensagem", "CPF inválido");
            return response;
        }
        
        // Verificar duplicidade
        if (dao.cpfExists(cpf)) {
            response.put("sucesso", false);
            response.put("mensagem", "CPF já cadastrado");
            response.put("pessoa", dao.findByCPF(cpf));
            return response;
        }
        
        // Criar nova pessoa física
        PessoaFisica novaPF = new PessoaFisica(nomeCompleto, cpf, dataNascimento, 
                                               email, telefone);
        dao.save(novaPF.getId(), novaPF);
        
        response.put("sucesso", true);
        response.put("mensagem", "Pessoa física cadastrada com sucesso");
        response.put("id", novaPF.getId());
        response.put("pessoa", novaPF);
        
        return response;
    }

    // Buscar por ID
    public PessoaFisica buscarPorId(String id) {
        return dao.findById(id);
    }

    // Buscar por CPF
    public PessoaFisica buscarPorCPF(String cpf) {
        return dao.findByCPF(cpf);
    }

    // Buscar por nome
    public List<PessoaFisica> buscarPorNome(String nome) {
        return dao.findByNome(nome);
    }

    // Listar todas
    public List<PessoaFisica> listarTodas() {
        return dao.findAll();
    }

    // Atualizar
    public Map<String, Object> atualizar(String id, String nomeCompleto, 
                                        String cpf, LocalDate dataNascimento, 
                                        String email, String telefone) {
        Map<String, Object> response = new HashMap<>();
        
        PessoaFisica pf = dao.findById(id);
        if (pf == null) {
            response.put("sucesso", false);
            response.put("mensagem", "Pessoa física não encontrada");
            return response;
        }
        
        pf.setNomeCompleto(nomeCompleto);
        pf.setCpf(cpf);
        pf.setDataNascimento(dataNascimento);
        pf.setEmail(email);
        pf.setTelefone(telefone);
        
        dao.update(id, pf);
        
        response.put("sucesso", true);
        response.put("mensagem", "Pessoa física atualizada com sucesso");
        response.put("pessoa", pf);
        
        return response;
    }

    // Deletar
    public Map<String, Object> deletar(String id) {
        Map<String, Object> response = new HashMap<>();
        
        if (!dao.exists(id)) {
            response.put("sucesso", false);
            response.put("mensagem", "Pessoa física não encontrada");
            return response;
        }
        
        dao.delete(id);
        
        response.put("sucesso", true);
        response.put("mensagem", "Pessoa física removida com sucesso");
        
        return response;
    }
}
