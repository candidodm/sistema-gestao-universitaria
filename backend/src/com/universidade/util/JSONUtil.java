package com.universidade.util;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utilitário para conversão entre Objetos e JSON sem dependências externas.
 */
public class JSONUtil {
    
    /**
     * Converte um Map em JSON String
     */
    public static String toJSON(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "{}";
        }
        
        StringBuilder json = new StringBuilder("{");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            json.append("\"").append(entry.getKey()).append("\":");
            json.append(valueToJSON(entry.getValue()));
            
            if (iterator.hasNext()) {
                json.append(",");
            }
        }
        
        json.append("}");
        return json.toString();
    }
    
    /**
     * Converte um valor para JSON
     */
    private static String valueToJSON(Object value) {
        if (value == null) {
            return "null";
        }
        
        if (value instanceof String) {
            return "\"" + escapeJSON((String) value) + "\"";
        }
        
        if (value instanceof Number || value instanceof Boolean) {
            return value.toString();
        }
        
        if (value instanceof LocalDate) {
            return "\"" + ((LocalDate) value).toString() + "\"";
        }
        
        if (value instanceof LocalDateTime) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            return "\"" + ((LocalDateTime) value).format(formatter) + "\"";
        }
        
        if (value instanceof Map) {
            return toJSON((Map<String, Object>) value);
        }
        
        if (value instanceof List) {
            return listToJSON((List<?>) value);
        }
        
        // Para objetos complexos, usar toString
        return "\"" + escapeJSON(value.toString()) + "\"";
    }
    
    /**
     * Converte uma lista para JSON
     */
    private static String listToJSON(List<?> list) {
        if (list == null || list.isEmpty()) {
            return "[]";
        }
        
        StringBuilder json = new StringBuilder("[");
        Iterator<?> iterator = list.iterator();
        
        while (iterator.hasNext()) {
            json.append(valueToJSON(iterator.next()));
            
            if (iterator.hasNext()) {
                json.append(",");
            }
        }
        
        json.append("]");
        return json.toString();
    }
    
    /**
     * Escapa caracteres especiais para JSON
     */
    private static String escapeJSON(String value) {
        if (value == null) {
            return "";
        }
        
        return value.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }
    
    /**
     * Parseia JSON simples para Map
     */
    public static Map<String, String> fromJSON(String json) {
        Map<String, String> map = new HashMap<>();
        
        if (json == null || json.trim().isEmpty()) {
            return map;
        }
        
        // Remove chaves externas
        json = json.trim();
        if (json.startsWith("{")) json = json.substring(1);
        if (json.endsWith("}")) json = json.substring(0, json.length() - 1);
        
        // Parse simples de pares chave-valor
        String[] pairs = json.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        
        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            if (keyValue.length == 2) {
                String key = keyValue[0].trim().replace("\"", "");
                String value = keyValue[1].trim().replace("\"", "");
                map.put(key, value);
            }
        }
        
        return map;
    }
    
    /**
     * Cria JSON de erro
     */
    public static String errorJSON(String mensagem) {
        Map<String, Object> error = new HashMap<>();
        error.put("sucesso", false);
        error.put("mensagem", mensagem);
        return toJSON(error);
    }
    
    /**
     * Cria JSON de sucesso
     */
    public static String successJSON(String mensagem, Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        response.put("sucesso", true);
        response.put("mensagem", mensagem);
        if (data != null) {
            response.putAll(data);
        }
        return toJSON(response);
    }
}
