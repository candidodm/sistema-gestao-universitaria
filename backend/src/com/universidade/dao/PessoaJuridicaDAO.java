package com.universidade.dao;

import com.universidade.model.PessoaJuridica;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DAO específico para Pessoa Jurídica.
 */
public class PessoaJuridicaDAO extends GenericDAO<PessoaJuridica> {
    
    // Método para buscar pessoa jurídica por CNPJ
    public PessoaJuridica findByCNPJ(String cnpj) {
        return findAll().stream()
                .filter(pj -> pj.getCnpj().equals(cnpj))
                .findFirst()
                .orElse(null);
    }

    // Método para verificar se CNPJ já está cadastrado
    public boolean cnpjExists(String cnpj) {
        return findByCNPJ(cnpj) != null;
    }

    // Método para buscar por razão social
    public List<PessoaJuridica> findByRazaoSocial(String razaoSocial) {
        return findAll().stream()
                .filter(pj -> pj.getRazaoSocial().toLowerCase()
                        .contains(razaoSocial.toLowerCase()))
                .collect(Collectors.toList());
    }
}
