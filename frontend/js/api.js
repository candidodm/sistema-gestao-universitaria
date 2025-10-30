// API.js - Módulo de comunicação com o backend Java

const API_BASE_URL = 'http://localhost:8080/api';

/**
 * Configuração para requisições fetch
 */
const fetchConfig = {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    },
    mode: 'cors'
};

/**
 * Cadastrar Pessoa Física no backend Java
 */
async function cadastrarPessoaFisica(dados) {
    try {
        console.log('📤 Enviando para backend:', dados);
        
        const response = await fetch(`${API_BASE_URL}/pessoa-fisica`, {
            ...fetchConfig,
            body: JSON.stringify(dados)
        });

        const resultado = await response.json();
        console.log('📥 Resposta do backend:', resultado);
        
        return resultado;
    } catch (error) {
        console.error('❌ Erro na comunicação com backend:', error);
        return {
            sucesso: false,
            mensagem: 'Erro ao conectar com o servidor: ' + error.message
        };
    }
}

/**
 * Cadastrar Pessoa Jurídica no backend Java
 */
async function cadastrarPessoaJuridica(dados) {
    try {
        console.log('📤 Enviando para backend:', dados);
        
        const response = await fetch(`${API_BASE_URL}/pessoa-juridica`, {
            ...fetchConfig,
            body: JSON.stringify(dados)
        });

        const resultado = await response.json();
        console.log('📥 Resposta do backend:', resultado);
        
        return resultado;
    } catch (error) {
        console.error('❌ Erro na comunicação com backend:', error);
        return {
            sucesso: false,
            mensagem: 'Erro ao conectar com o servidor: ' + error.message
        };
    }
}

/**
 * Cadastrar Professor no backend Java
 */
async function cadastrarProfessor(dados) {
    try {
        console.log('📤 Enviando para backend:', dados);
        
        const response = await fetch(`${API_BASE_URL}/professor`, {
            ...fetchConfig,
            body: JSON.stringify(dados)
        });

        const resultado = await response.json();
        console.log('📥 Resposta do backend:', resultado);
        
        return resultado;
    } catch (error) {
        console.error('❌ Erro na comunicação com backend:', error);
        return {
            sucesso: false,
            mensagem: 'Erro ao conectar com o servidor: ' + error.message
        };
    }
}

/**
 * Cadastrar Aluno no backend Java
 */
async function cadastrarAluno(dados) {
    try {
        console.log('📤 Enviando para backend:', dados);
        
        const response = await fetch(`${API_BASE_URL}/aluno`, {
            ...fetchConfig,
            body: JSON.stringify(dados)
        });

        const resultado = await response.json();
        console.log('📥 Resposta do backend:', resultado);
        
        return resultado;
    } catch (error) {
        console.error('❌ Erro na comunicação com backend:', error);
        return {
            sucesso: false,
            mensagem: 'Erro ao conectar com o servidor: ' + error.message
        };
    }
}

/**
 * Cadastrar Fornecedor no backend Java
 */
async function cadastrarFornecedor(dados) {
    try {
        console.log('📤 Enviando para backend:', dados);
        
        const response = await fetch(`${API_BASE_URL}/fornecedor`, {
            ...fetchConfig,
            body: JSON.stringify(dados)
        });

        const resultado = await response.json();
        console.log('📥 Resposta do backend:', resultado);
        
        return resultado;
    } catch (error) {
        console.error('❌ Erro na comunicação com backend:', error);
        return {
            sucesso: false,
            mensagem: 'Erro ao conectar com o servidor: ' + error.message
        };
    }
}

/**
 * Exibir mensagem de loading
 */
function mostrarLoading(show) {
    const loading = document.getElementById('loading');
    const formActions = document.querySelector('.form-actions');
    
    if (loading && formActions) {
        if (show) {
            loading.classList.add('show');
            formActions.style.display = 'none';
        } else {
            loading.classList.remove('show');
            formActions.style.display = 'flex';
        }
    }
}

/**
 * Exibir alerta
 */
function mostrarAlerta(mensagem, tipo) {
    const alert = document.getElementById('alert');
    if (alert) {
        alert.textContent = mensagem;
        alert.className = `alert alert-${tipo} show`;
        
        setTimeout(() => {
            alert.classList.remove('show');
        }, 5000);
        
        window.scrollTo({ top: 0, behavior: 'smooth' });
    }
}

/**
 * Exibir mensagem de sucesso personalizada
 */
function mostrarSucesso(dados) {
    const successMessage = document.getElementById('successMessage');
    
    if (successMessage) {
        // Atualizar campos específicos conforme o tipo
        if (dados.id) document.getElementById('pessoaId')?.setText(dados.id);
        if (dados.pessoa?.nomeCompleto) document.getElementById('pessoaNome')?.setText(dados.pessoa.nomeCompleto);
        if (dados.pessoa?.cpf) document.getElementById('pessoaCPF')?.setText(dados.pessoa.cpf);
        if (dados.empresa?.id) document.getElementById('empresaId')?.setText(dados.empresa.id);
        if (dados.empresa?.razaoSocial) document.getElementById('empresaRazao')?.setText(dados.empresa.razaoSocial);
        if (dados.empresa?.cnpj) document.getElementById('empresaCNPJ')?.setText(dados.empresa.cnpj);
        if (dados.matriculaFuncional) document.getElementById('matricula')?.setText(dados.matriculaFuncional);
        if (dados.matriculaAcademica) document.getElementById('matricula')?.setText(dados.matriculaAcademica);
        if (dados.codigoFornecedor) document.getElementById('codigo')?.setText(dados.codigoFornecedor);
        
        // Mostrar mensagem de sucesso
        successMessage.classList.add('show');
        
        // Esconder formulário
        const form = document.querySelector('form');
        if (form) form.style.display = 'none';
        
        window.scrollTo({ top: 0, behavior: 'smooth' });
    }
}

/**
 * Testar conexão com o backend
 */
async function testarConexao() {
    try {
        const response = await fetch(`${API_BASE_URL}/pessoa-fisica`, {
            method: 'GET',
            mode: 'cors'
        });
        
        console.log('✅ Backend está respondendo!');
        return true;
    } catch (error) {
        console.warn('⚠️ Backend não está respondendo. Execute o servidor Java.');
        console.warn('💡 Para iniciar: cd backend/src && javac com/universidade/**/*.java && java com.universidade.server.APIServer');
        return false;
    }
}

// Testar conexão ao carregar a página
document.addEventListener('DOMContentLoaded', () => {
    testarConexao();
});

// Exportar funções se estiver usando módulos
if (typeof module !== 'undefined' && module.exports) {
    module.exports = {
        cadastrarPessoaFisica,
        cadastrarPessoaJuridica,
        cadastrarProfessor,
        cadastrarAluno,
        cadastrarFornecedor,
        mostrarLoading,
        mostrarAlerta,
        mostrarSucesso
    };
}
