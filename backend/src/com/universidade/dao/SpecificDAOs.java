package com.universidade.dao;

import com.universidade.model.Professor;
import com.universidade.model.Aluno;
import com.universidade.model.Fornecedor;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DAO específico para Professor.
 */
class ProfessorDAO extends GenericDAO<Professor> {
    
    public Professor findByMatricula(String matricula) {
        return findAll().stream()
                .filter(p -> p.getMatriculaFuncional().equals(matricula))
                .findFirst()
                .orElse(null);
    }

    public List<Professor> findByDepartamento(String departamento) {
        return findAll().stream()
                .filter(p -> p.getDepartamento().equalsIgnoreCase(departamento))
                .collect(Collectors.toList());
    }
}

/**
 * DAO específico para Aluno.
 */
class AlunoDAO extends GenericDAO<Aluno> {
    
    public Aluno findByMatricula(String matricula) {
        return findAll().stream()
                .filter(a -> a.getMatriculaAcademica().equals(matricula))
                .findFirst()
                .orElse(null);
    }

    public List<Aluno> findByCurso(String curso) {
        return findAll().stream()
                .filter(a -> a.getCurso().equalsIgnoreCase(curso))
                .collect(Collectors.toList());
    }

    public List<Aluno> findByStatus(String status) {
        return findAll().stream()
                .filter(a -> a.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
}

/**
 * DAO específico para Fornecedor.
 */
class FornecedorDAO extends GenericDAO<Fornecedor> {
    
    public Fornecedor findByCodigo(String codigo) {
        return findAll().stream()
                .filter(f -> f.getCodigoFornecedor().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public List<Fornecedor> findByRamo(String ramo) {
        return findAll().stream()
                .filter(f -> f.getRamo().equalsIgnoreCase(ramo))
                .collect(Collectors.toList());
    }
}
