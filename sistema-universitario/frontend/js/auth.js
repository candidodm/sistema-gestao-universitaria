// Sistema de autenticação simples
const AUTH_KEY = 'sistema_universitario_auth';
const CREDENTIALS = {
    username: 'adm',
    password: 'adm123'
};

// Função para fazer login
function login(username, password) {
    if (username === CREDENTIALS.username && password === CREDENTIALS.password) {
        sessionStorage.setItem(AUTH_KEY, 'true');
        return true;
    }
    return false;
}

// Função para fazer logout
function logout() {
    sessionStorage.removeItem(AUTH_KEY);
    window.location.href = '../login.html';
}

// Verificar se está autenticado
function isAuthenticated() {
    return sessionStorage.getItem(AUTH_KEY) === 'true';
}

// Processar o formulário de login
document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    
    if (loginForm) {
        loginForm.addEventListener('submit', function(e) {
            e.preventDefault();
            
            const username = document.getElementById('username').value;
            const password = document.getElementById('password').value;
            const errorMessage = document.getElementById('errorMessage');
            
            if (login(username, password)) {
                window.location.href = 'index.html';
            } else {
                errorMessage.textContent = 'Usuário ou senha incorretos!';
                errorMessage.classList.add('show');
                
                // Limpar mensagem após 3 segundos
                setTimeout(() => {
                    errorMessage.classList.remove('show');
                }, 3000);
            }
        });
    }
});

// Proteger páginas - verificar autenticação ao carregar
function protectPage() {
    if (!isAuthenticated() && !window.location.pathname.includes('login.html')) {
        window.location.href = '../login.html';
    }
}

// Executar proteção de página se não estiver na página de login
if (!window.location.pathname.includes('login.html')) {
    protectPage();
}
