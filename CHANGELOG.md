# 📝 Changelog

Todas as mudanças notáveis neste projeto serão documentadas neste arquivo.

O formato é baseado em [Keep a Changelog](https://keepachangelog.com/pt-BR/1.0.0/),
e este projeto adere ao [Semantic Versioning](https://semver.org/lang/pt-BR/).

## [2.0.0] - 2025-10-30 (Fase 2)

### ✨ Adicionado
- Servidor HTTP completo em Java (APIServer.java)
- APIs REST para todas as entidades
- Integração real frontend ↔ backend
- Arquivo `api.js` com funções de comunicação
- Página `cadastro-pf-connected.html` conectada ao backend
- Utilitário JSONUtil para conversão JSON nativa
- Documentação completa em Markdown (6 arquivos)
- Guia de execução passo a passo
- Guia de uso do GitHub
- Arquivo .gitignore configurado

### 🔧 Melhorado
- Validação de CPF com algoritmo completo
- Validação de CNPJ com algoritmo completo
- Interface responsiva e moderna
- Feedback visual aprimorado
- Tratamento de erros robusto

### 📚 Documentação
- README.md completo com diagramas
- COMO_EXECUTAR.md (guia de execução)
- INTEGRACAO_COMPLETA.md (arquitetura)
- GITHUB_GUIDE.md (guia do GitHub)
- RESUMO_ENTREGA.md (checklist)
- APRESENTACAO.md (visualização)

## [1.0.0] - 2025-10-15 (Fase 1)

### ✨ Adicionado
- 6 classes do modelo de domínio
  - Administrador
  - PessoaFisica
  - PessoaJuridica
  - Professor (herda PessoaFisica)
  - Aluno (herda PessoaFisica)
  - Fornecedor (herda PessoaJuridica)
- Padrão DAO implementado
  - GenericDAO
  - PessoaFisicaDAO
  - PessoaJuridicaDAO
  - SpecificDAOs
- Camada de serviço
  - PessoaFisicaService
  - PessoaJuridicaService
- Controller REST
  - CadastroController
- Frontend inicial
  - 7 páginas HTML
  - styles.css
  - script.js com validações
- Diagramas UML
  - Diagrama de Classes
  - Diagrama de Casos de Uso
  - Diagrama de Sequência

### 🎯 Resultado
- Nota: 9.8/10
- Feedback: "Excelente modelagem e documentação"

---

## 🔗 Links

- [Repositório no GitHub](https://github.com/seu-usuario/sistema-gestao-universitaria)
- [Issues](https://github.com/seu-usuario/sistema-gestao-universitaria/issues)
- [Pull Requests](https://github.com/seu-usuario/sistema-gestao-universitaria/pulls)

## 🏷️ Tipos de Mudanças

- `✨ Adicionado` para novas funcionalidades
- `🔧 Melhorado` para mudanças em funcionalidades existentes
- `🐛 Corrigido` para correções de bugs
- `⚠️ Descontinuado` para funcionalidades que serão removidas
- `🗑️ Removido` para funcionalidades removidas
- `🔒 Segurança` para correções de vulnerabilidades
- `📚 Documentação` para mudanças na documentação
