package com.universidade.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe genérica DAO para gerenciar armazenamento em memória.
 * Simula um banco de dados usando estruturas de dados em memória.
 */
public class GenericDAO<T> {
    private Map<String, T> storage;

    public GenericDAO() {
        this.storage = new HashMap<>();
    }

    // Método para salvar um objeto
    public void save(String id, T object) {
        storage.put(id, object);
    }

    // Método para buscar um objeto por ID
    public T findById(String id) {
        return storage.get(id);
    }

    // Método para listar todos os objetos
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    // Método para atualizar um objeto
    public void update(String id, T object) {
        if (storage.containsKey(id)) {
            storage.put(id, object);
        }
    }

    // Método para deletar um objeto
    public void delete(String id) {
        storage.remove(id);
    }

    // Método para verificar se existe
    public boolean exists(String id) {
        return storage.containsKey(id);
    }

    // Método para contar registros
    public int count() {
        return storage.size();
    }

    // Método para limpar todos os registros
    public void clear() {
        storage.clear();
    }
}
