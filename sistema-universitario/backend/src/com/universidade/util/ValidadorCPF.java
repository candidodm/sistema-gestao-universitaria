package com.universidade.util;

/**
 * Classe utilitária para validação de CPF.
 * 
 * @author Grupo 48 - Projeto Integrador
 * @version 2.0
 */
public class ValidadorCPF {
    
    /**
     * Valida um número de CPF
     * 
     * @param cpf CPF a ser validado
     * @return true se o CPF for válido, false caso contrário
     */
    public static boolean validar(String cpf) {
        if (cpf == null) {
            return false;
        }
        
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");
        
        // Verifica se tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        
        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        
        try {
            // Calcula o primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (10 - i);
            }
            int resto = 11 - (soma % 11);
            int digito1 = (resto == 10 || resto == 11) ? 0 : resto;
            
            // Verifica o primeiro dígito
            if (digito1 != Integer.parseInt(String.valueOf(cpf.charAt(9)))) {
                return false;
            }
            
            // Calcula o segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (11 - i);
            }
            resto = 11 - (soma % 11);
            int digito2 = (resto == 10 || resto == 11) ? 0 : resto;
            
            // Verifica o segundo dígito
            return digito2 == Integer.parseInt(String.valueOf(cpf.charAt(10)));
            
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Formata um CPF com pontos e hífen
     * 
     * @param cpf CPF sem formatação
     * @return CPF formatado (000.000.000-00)
     */
    public static String formatar(String cpf) {
        if (cpf == null) {
            return "";
        }
        
        cpf = cpf.replaceAll("[^0-9]", "");
        
        if (cpf.length() != 11) {
            return cpf;
        }
        
        return cpf.substring(0, 3) + "." + 
               cpf.substring(3, 6) + "." + 
               cpf.substring(6, 9) + "-" + 
               cpf.substring(9, 11);
    }
}
