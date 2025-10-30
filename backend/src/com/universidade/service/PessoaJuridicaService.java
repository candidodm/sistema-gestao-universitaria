package com.universidade.service;

import com.universidade.dao.PessoaJuridicaDAO;
import com.universidade.model.PessoaJuridica;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Serviço para gerenciar Pessoa Jurídica.
 */
public class PessoaJuridicaService {
    private PessoaJuridicaDAO dao;

    public PessoaJuridicaService() {
        this.dao = new PessoaJuridicaDAO();
    }

    // Criar nova pessoa jurídica
    public Map<String, Object> criar(String cnpj, String razaoSocial, 
                                     String nomeFantasia, String email, 
                                     String telefone) {
        Map<String, Object> response = new HashMap<>();
        
        // Validar CNPJ
        PessoaJuridica pj = new PessoaJuridica();
        pj.setCnpj(cnpj);
        if (!pj.validarCNPJ()) {
            response.put("sucesso", false);
            response.put("mensagem", "CNPJ inválido");
            return response;
        }
        
        // Verificar duplicidade
        if (dao.cnpjExists(cnpj)) {
            response.put("sucesso", false);
            response.put("mensagem", "CNPJ já cadastrado");
            response.put("empresa", dao.findByCNPJ(cnpj));
            return response;
        }
        
        // Criar nova pessoa jurídica
        PessoaJuridica novaPJ = new PessoaJuridica(cnpj, razaoSocial, nomeFantasia, 
                                                   email, telefone);
        dao.save(novaPJ.getId(), novaPJ);
        
        response.put("sucesso", true);
        response.put("mensagem", "Pessoa jurídica cadastrada com sucesso");
        response.put("id", novaPJ.getId());
        response.put("empresa", novaPJ);
        
        return response;
    }

    // Buscar por ID
    public PessoaJuridica buscarPorId(String id) {
        return dao.findById(id);
    }

    // Buscar por CNPJ
    public PessoaJuridica buscarPorCNPJ(String cnpj) {
        return dao.findByCNPJ(cnpj);
    }

    // Buscar por razão social
    public List<PessoaJuridica> buscarPorRazaoSocial(String razaoSocial) {
        return dao.findByRazaoSocial(razaoSocial);
    }

    // Listar todas
    public List<PessoaJuridica> listarTodas() {
        return dao.findAll();
    }

    // Atualizar
    public Map<String, Object> atualizar(String id, String cnpj, String razaoSocial, 
                                        String nomeFantasia, String email, 
                                        String telefone) {
        Map<String, Object> response = new HashMap<>();
        
        PessoaJuridica pj = dao.findById(id);
        if (pj == null) {
            response.put("sucesso", false);
            response.put("mensagem", "Pessoa jurídica não encontrada");
            return response;
        }
        
        pj.setCnpj(cnpj);
        pj.setRazaoSocial(razaoSocial);
        pj.setNomeFantasia(nomeFantasia);
        pj.setEmail(email);
        pj.setTelefone(telefone);
        
        dao.update(id, pj);
        
        response.put("sucesso", true);
        response.put("mensagem", "Pessoa jurídica atualizada com sucesso");
        response.put("empresa", pj);
        
        return response;
    }

    // Deletar
    public Map<String, Object> deletar(String id) {
        Map<String, Object> response = new HashMap<>();
        
        if (!dao.exists(id)) {
            response.put("sucesso", false);
            response.put("mensagem", "Pessoa jurídica não encontrada");
            return response;
        }
        
        dao.delete(id);
        
        response.put("sucesso", true);
        response.put("mensagem", "Pessoa jurídica removida com sucesso");
        
        return response;
    }
}
