package com.universidade.server;

import com.sun.net.httpserver.*;
import com.universidade.controller.CadastroController;
import com.universidade.util.JSONUtil;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class APIServer {
    private static final int PORT = 8080;
    private static final CadastroController controller = new CadastroController();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        
        server.createContext("/api/pessoa-fisica", APIServer::handlePessoaFisica);
        server.createContext("/api/pessoa-juridica", APIServer::handlePessoaJuridica);
        server.createContext("/api/professor", APIServer::handleProfessor);
        server.createContext("/api/aluno", APIServer::handleAluno);
        server.createContext("/api/fornecedor", APIServer::handleFornecedor);
        
        server.setExecutor(null);
        server.start();
        
        System.out.println("\n===========================================");
        System.out.println("🚀 Servidor iniciado na porta " + PORT);
        System.out.println("===========================================");
        System.out.println("🔌 API Base: http://localhost:" + PORT + "/api/");
        System.out.println("===========================================");
        System.out.println("\n✅ Servidor pronto para receber requisições!\n");
    }

    private static void handlePessoaFisica(HttpExchange exchange) throws IOException {
        addCORSHeaders(exchange);
        
        if ("OPTIONS".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(200, -1);
            return;
        }

        if ("POST".equals(exchange.getRequestMethod())) {
            try {
                String body = readRequestBody(exchange);
                Map<String, String> dados = JSONUtil.fromJSON(body);
                
                Map<String, Object> resultado = controller.cadastrarPessoaFisica(dados);
                String jsonResponse = JSONUtil.toJSON(resultado);
                
                sendResponse(exchange, 200, jsonResponse);
                System.out.println("✅ Pessoa Física cadastrada: " + dados.get("nomeCompleto"));
                
            } catch (Exception e) {
                String error = JSONUtil.errorJSON("Erro: " + e.getMessage());
                sendResponse(exchange, 500, error);
                System.err.println("❌ Erro: " + e.getMessage());
            }
        } else {
            sendResponse(exchange, 405, JSONUtil.errorJSON("Método não permitido"));
        }
    }

    private static void handlePessoaJuridica(HttpExchange exchange) throws IOException {
        addCORSHeaders(exchange);
        
        if ("OPTIONS".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(200, -1);
            return;
        }

        if ("POST".equals(exchange.getRequestMethod())) {
            try {
                String body = readRequestBody(exchange);
                Map<String, String> dados = JSONUtil.fromJSON(body);
                
                Map<String, Object> resultado = controller.cadastrarPessoaJuridica(dados);
                String jsonResponse = JSONUtil.toJSON(resultado);
                
                sendResponse(exchange, 200, jsonResponse);
                System.out.println("✅ Pessoa Jurídica cadastrada: " + dados.get("razaoSocial"));
                
            } catch (Exception e) {
                String error = JSONUtil.errorJSON("Erro: " + e.getMessage());
                sendResponse(exchange, 500, error);
                System.err.println("❌ Erro: " + e.getMessage());
            }
        } else {
            sendResponse(exchange, 405, JSONUtil.errorJSON("Método não permitido"));
        }
    }

    private static void handleProfessor(HttpExchange exchange) throws IOException {
        addCORSHeaders(exchange);
        
        if ("OPTIONS".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(200, -1);
            return;
        }

        if ("POST".equals(exchange.getRequestMethod())) {
            try {
                String body = readRequestBody(exchange);
                Map<String, String> dados = JSONUtil.fromJSON(body);
                
                Map<String, Object> resultado = controller.cadastrarProfessor(dados);
                String jsonResponse = JSONUtil.toJSON(resultado);
                
                sendResponse(exchange, 200, jsonResponse);
                System.out.println("✅ Professor cadastrado - CPF: " + dados.get("cpf"));
                
            } catch (Exception e) {
                String error = JSONUtil.errorJSON("Erro: " + e.getMessage());
                sendResponse(exchange, 500, error);
                System.err.println("❌ Erro: " + e.getMessage());
            }
        } else {
            sendResponse(exchange, 405, JSONUtil.errorJSON("Método não permitido"));
        }
    }

    private static void handleAluno(HttpExchange exchange) throws IOException {
        addCORSHeaders(exchange);
        
        if ("OPTIONS".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(200, -1);
            return;
        }

        if ("POST".equals(exchange.getRequestMethod())) {
            try {
                String body = readRequestBody(exchange);
                Map<String, String> dados = JSONUtil.fromJSON(body);
                
                Map<String, Object> resultado = controller.cadastrarAluno(dados);
                String jsonResponse = JSONUtil.toJSON(resultado);
                
                sendResponse(exchange, 200, jsonResponse);
                System.out.println("✅ Aluno cadastrado - CPF: " + dados.get("cpf"));
                
            } catch (Exception e) {
                String error = JSONUtil.errorJSON("Erro: " + e.getMessage());
                sendResponse(exchange, 500, error);
                System.err.println("❌ Erro: " + e.getMessage());
            }
        } else {
            sendResponse(exchange, 405, JSONUtil.errorJSON("Método não permitido"));
        }
    }

    private static void handleFornecedor(HttpExchange exchange) throws IOException {
        addCORSHeaders(exchange);
        
        if ("OPTIONS".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(200, -1);
            return;
        }

        if ("POST".equals(exchange.getRequestMethod())) {
            try {
                String body = readRequestBody(exchange);
                Map<String, String> dados = JSONUtil.fromJSON(body);
                
                Map<String, Object> resultado = controller.cadastrarFornecedor(dados);
                String jsonResponse = JSONUtil.toJSON(resultado);
                
                sendResponse(exchange, 200, jsonResponse);
                System.out.println("✅ Fornecedor cadastrado - CNPJ: " + dados.get("cnpj"));
                
            } catch (Exception e) {
                String error = JSONUtil.errorJSON("Erro: " + e.getMessage());
                sendResponse(exchange, 500, error);
                System.err.println("❌ Erro: " + e.getMessage());
            }
        } else {
            sendResponse(exchange, 405, JSONUtil.errorJSON("Método não permitido"));
        }
    }

    private static void addCORSHeaders(HttpExchange exchange) {
        Headers headers = exchange.getResponseHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }

    private static String readRequestBody(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        
        int nRead;
        byte[] data = new byte[1024];
        
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        
        buffer.flush();
        return buffer.toString(StandardCharsets.UTF_8.name());
    }

    private static void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(statusCode, bytes.length);
        
        OutputStream os = exchange.getResponseBody();
        os.write(bytes);
        os.close();
    }
}
