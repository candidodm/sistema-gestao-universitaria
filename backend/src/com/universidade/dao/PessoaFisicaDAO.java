package com.universidade.dao;

import com.universidade.model.PessoaFisica;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DAO específico para Pessoa Física.
 */
public class PessoaFisicaDAO extends GenericDAO<PessoaFisica> {
    
    // Método para buscar pessoa física por CPF
    public PessoaFisica findByCPF(String cpf) {
        return findAll().stream()
                .filter(pf -> pf.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    // Método para verificar se CPF já está cadastrado
    public boolean cpfExists(String cpf) {
        return findByCPF(cpf) != null;
    }

    // Método para buscar por nome
    public List<PessoaFisica> findByNome(String nome) {
        return findAll().stream()
                .filter(pf -> pf.getNomeCompleto().toLowerCase()
                        .contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }
}
