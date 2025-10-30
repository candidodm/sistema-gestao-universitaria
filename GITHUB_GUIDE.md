# 📦 Guia de Uso do GitHub

## Como criar e configurar o repositório no GitHub

### 1. Criar o Repositório

1. Acesse [github.com](https://github.com)
2. Faça login na sua conta
3. Clique no botão **"New"** (ou **"+"** → **"New repository"**)
4. Preencha os dados:
   - **Repository name:** `sistema-gestao-universitaria`
   - **Description:** Sistema de Gestão Universitária - Projeto Integrador Grupo 48
   - **Visibility:** Public ou Private (sua escolha)
   - ✅ **Add a README file** (pode desmarcar, vamos adicionar o nosso)
   - ✅ **Add .gitignore:** Java
5. Clique em **"Create repository"**

### 2. Adicionar Colaboradores

1. No repositório criado, vá em **Settings** (Configurações)
2. No menu lateral, clique em **Collaborators** (Colaboradores)
3. Clique em **"Add people"**
4. Digite o username ou email dos membros do grupo
5. Selecione a permissão adequada (geralmente **"Write"** ou **"Maintain"**)
6. Clique em **"Add [username] to this repository"**
7. O membro receberá um convite por email
8. Repita para todos os membros do grupo

### 3. Configurar Git no seu computador

Se ainda não tem o Git instalado:

**Windows:**
- Baixe em: https://git-scm.com/download/win
- Instale com as configurações padrão

**Mac:**
```bash
brew install git
```

**Linux:**
```bash
sudo apt-get install git  # Ubuntu/Debian
sudo yum install git       # CentOS/Fedora
```

### 4. Configurar credenciais

Abra o terminal/prompt e configure:

```bash
git config --global user.name "Seu Nome"
git config --global user.email "seu-email@example.com"
```

### 5. Fazer upload do projeto

**Opção 1: Via linha de comando (recomendado)**

```bash
# Navegue até a pasta do projeto
cd caminho/para/projeto-gestao-universitaria

# Inicialize o repositório Git
git init

# Adicione todos os arquivos
git add .

# Faça o primeiro commit
git commit -m "Fase 2: Implementação completa do sistema"

# Adicione o repositório remoto (substitua SEU-USUARIO)
git remote add origin https://github.com/SEU-USUARIO/sistema-gestao-universitaria.git

# Envie para o GitHub
git branch -M main
git push -u origin main
```

**Opção 2: Via GitHub Desktop (mais fácil)**

1. Baixe o [GitHub Desktop](https://desktop.github.com/)
2. Faça login
3. Clique em **File → Add local repository**
4. Selecione a pasta do projeto
5. Clique em **Publish repository**

### 6. Estrutura de commits recomendada

Use mensagens de commit claras e descritivas:

```bash
# Exemplos de boas mensagens
git commit -m "feat: adiciona classe PessoaFisica"
git commit -m "style: melhora CSS da página de cadastro"
git commit -m "docs: atualiza README com diagramas"
git commit -m "fix: corrige validação de CPF"
```

**Prefixos recomendados:**
- `feat:` nova funcionalidade
- `fix:` correção de bug
- `docs:` documentação
- `style:` formatação/estilo
- `refactor:` refatoração de código
- `test:` testes
- `chore:` tarefas de manutenção

### 7. Trabalhando em equipe

**Antes de começar a trabalhar:**
```bash
git pull origin main
```

**Depois de fazer alterações:**
```bash
git add .
git commit -m "sua mensagem aqui"
git push origin main
```

**Se houver conflitos:**
1. O Git mostrará os arquivos em conflito
2. Abra os arquivos e resolva os conflitos manualmente
3. Depois:
```bash
git add .
git commit -m "resolve conflitos"
git push origin main
```

### 8. Protegendo branches (opcional, mas recomendado)

Para evitar commits diretos na `main`:

1. Vá em **Settings → Branches**
2. Em **Branch protection rules**, clique em **Add rule**
3. Em **Branch name pattern**, digite: `main`
4. Marque:
   - ✅ Require pull request reviews before merging
   - ✅ Require status checks to pass before merging
5. Clique em **Create**

Agora todos terão que criar branches e pull requests:

```bash
# Criar uma nova branch
git checkout -b feat/minha-funcionalidade

# Fazer alterações e commit
git add .
git commit -m "adiciona nova funcionalidade"

# Enviar a branch
git push origin feat/minha-funcionalidade

# No GitHub, criar um Pull Request
```

### 9. Boas práticas

✅ **Sempre faça pull antes de começar**
```bash
git pull origin main
```

✅ **Commits pequenos e frequentes**
- Melhor fazer vários commits pequenos do que um grande

✅ **Não commite arquivos desnecessários**
- Arquivos compilados (.class)
- Dependências (node_modules)
- Arquivos de IDE (.vscode, .idea)
- Use o .gitignore

✅ **Escreva mensagens claras**
- Descreva O QUE mudou e POR QUE

✅ **Revise antes de fazer push**
```bash
git status        # Ver o que mudou
git diff          # Ver as alterações
```

### 10. Comandos úteis

```bash
# Ver status do repositório
git status

# Ver histórico de commits
git log --oneline

# Desfazer último commit (mantém as alterações)
git reset --soft HEAD~1

# Descartar alterações locais
git checkout -- arquivo.txt

# Ver branches
git branch

# Mudar de branch
git checkout nome-da-branch

# Atualizar lista de branches remotas
git fetch

# Clonar repositório
git clone https://github.com/usuario/repo.git
```

### 11. Adicionar README.md ao repositório

O arquivo README.md já está criado. Para garantir que está no repositório:

```bash
git add README.md
git commit -m "docs: adiciona README completo do projeto"
git push origin main
```

### 12. Verificar no GitHub

Após fazer o push:
1. Acesse o repositório no GitHub
2. Verifique se todos os arquivos estão lá
3. Teste se o README.md está sendo exibido corretamente
4. Confirme que todos os colaboradores têm acesso

---

## 🎯 Checklist de entrega

- [ ] Repositório criado no GitHub
- [ ] Todos os membros do grupo adicionados como colaboradores
- [ ] Código Java completo (backend)
- [ ] Interface HTML/CSS completa (frontend)
- [ ] README.md com toda a documentação
- [ ] Diagramas da Fase 1 incluídos
- [ ] Estrutura de pastas organizada
- [ ] Commits com mensagens descritivas
- [ ] .gitignore configurado

---

## 🆘 Problemas comuns

**"Permission denied":**
- Configure suas credenciais SSH ou use HTTPS
- Verifique se você tem permissão no repositório

**"Merge conflict":**
- Sempre faça `git pull` antes de começar
- Resolva conflitos manualmente e faça commit

**"Your branch is behind":**
```bash
git pull origin main
```

**"Changes not staged":**
```bash
git add .
git commit -m "sua mensagem"
```

---

## 📚 Recursos adicionais

- [Documentação oficial do Git](https://git-scm.com/doc)
- [GitHub Guides](https://guides.github.com/)
- [Markdown Guide](https://www.markdownguide.org/)
- [Conventional Commits](https://www.conventionalcommits.org/)

---

**Dica:** Salve este guia para consulta futura! 📝
