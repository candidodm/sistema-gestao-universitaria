# 🤝 Guia de Contribuição

Obrigado por considerar contribuir com o Sistema de Gestão Universitária!

## 📋 Como Contribuir

### 1. Fork do Repositório
```bash
# Faça um fork no GitHub e clone seu fork
git clone https://github.com/SEU-USUARIO/sistema-gestao-universitaria.git
cd sistema-gestao-universitaria
```

### 2. Crie uma Branch
```bash
# Crie uma branch para sua feature/correção
git checkout -b feature/minha-contribuicao
```

### 3. Faça suas Alterações
- Escreva código limpo e bem documentado
- Siga os padrões de código existentes
- Adicione comentários quando necessário

### 4. Teste suas Alterações
```bash
# Backend
cd backend/src
javac com/universidade/**/*.java
java com.universidade.server.APIServer

# Frontend
Abra frontend/pages/cadastro-pf-connected.html no navegador
```

### 5. Commit suas Mudanças
```bash
git add .
git commit -m "feat: adiciona nova funcionalidade X"
```

**Padrão de Commits:**
- `feat:` Nova funcionalidade
- `fix:` Correção de bug
- `docs:` Alteração em documentação
- `style:` Formatação de código
- `refactor:` Refatoração de código
- `test:` Adição de testes

### 6. Push e Pull Request
```bash
git push origin feature/minha-contribuicao
```

Depois crie um Pull Request no GitHub explicando suas mudanças.

## 🎯 Áreas para Contribuir

- 🐛 Correção de bugs
- ✨ Novas funcionalidades
- 📝 Melhorias na documentação
- 🎨 Melhorias na interface
- ⚡ Otimizações de performance
- 🧪 Testes automatizados

## 📝 Padrões de Código

### Java
- Use nomes descritivos para variáveis e métodos
- Siga convenções Java (camelCase)
- Adicione JavaDoc para métodos públicos
- Mantenha classes coesas e com responsabilidade única

### JavaScript
- Use `const` e `let`, evite `var`
- Funções assíncronas devem usar `async/await`
- Adicione comentários JSDoc
- Use camelCase para variáveis e funções

### HTML/CSS
- Use indentação de 4 espaços
- Nomes de classes em kebab-case
- Mantenha CSS organizado por seções

## 🔍 Revisão de Código

Todos os Pull Requests serão revisados. Certifique-se de:
- ✅ Código compila sem erros
- ✅ Funcionalidade está testada
- ✅ Documentação está atualizada
- ✅ Commits seguem o padrão

## 💬 Dúvidas?

Abra uma Issue no GitHub com suas dúvidas ou sugestões!

---

**Obrigado por contribuir! 🎉**
