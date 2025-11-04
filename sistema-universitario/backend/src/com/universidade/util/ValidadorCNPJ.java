package com.universidade.util;

/**
 * Classe utilitária para validação de CNPJ.
 * 
 * @author Grupo 48 - Projeto Integrador
 * @version 2.0
 */
public class ValidadorCNPJ {
    
    /**
     * Valida um número de CNPJ
     * 
     * @param cnpj CNPJ a ser validado
     * @return true se o CNPJ for válido, false caso contrário
     */
    public static boolean validar(String cnpj) {
        if (cnpj == null) {
            return false;
        }
        
        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("[^0-9]", "");
        
        // Verifica se tem 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }
        
        // Verifica se todos os dígitos são iguais
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }
        
        try {
            // Calcula o primeiro dígito verificador
            int tamanho = cnpj.length() - 2;
            String numeros = cnpj.substring(0, tamanho);
            String digitos = cnpj.substring(tamanho);
            
            int soma = 0;
            int pos = tamanho - 7;
            
            for (int i = tamanho; i >= 1; i--) {
                soma += Integer.parseInt(String.valueOf(numeros.charAt(tamanho - i))) * pos--;
                if (pos < 2) {
                    pos = 9;
                }
            }
            
            int resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
            
            if (resultado != Integer.parseInt(String.valueOf(digitos.charAt(0)))) {
                return false;
            }
            
            // Calcula o segundo dígito verificador
            tamanho = tamanho + 1;
            numeros = cnpj.substring(0, tamanho);
            soma = 0;
            pos = tamanho - 7;
            
            for (int i = tamanho; i >= 1; i--) {
                soma += Integer.parseInt(String.valueOf(numeros.charAt(tamanho - i))) * pos--;
                if (pos < 2) {
                    pos = 9;
                }
            }
            
            resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
            
            return resultado == Integer.parseInt(String.valueOf(digitos.charAt(1)));
            
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Formata um CNPJ com pontos, barra e hífen
     * 
     * @param cnpj CNPJ sem formatação
     * @return CNPJ formatado (00.000.000/0000-00)
     */
    public static String formatar(String cnpj) {
        if (cnpj == null) {
            return "";
        }
        
        cnpj = cnpj.replaceAll("[^0-9]", "");
        
        if (cnpj.length() != 14) {
            return cnpj;
        }
        
        return cnpj.substring(0, 2) + "." + 
               cnpj.substring(2, 5) + "." + 
               cnpj.substring(5, 8) + "/" + 
               cnpj.substring(8, 12) + "-" + 
               cnpj.substring(12, 14);
    }
}
