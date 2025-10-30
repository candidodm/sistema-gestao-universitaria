# 🎓 Sistema de Gestão Universitária

> **Projeto Integrador - Grupo 48**  
> Sistema orientado a objetos para gestão de dados de uma universidade

![Status](https://img.shields.io/badge/status-ativo-success)
![Java](https://img.shields.io/badge/Java-17+-orange)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?logo=css3&logoColor=white)

---

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Fase 1: Modelagem](#fase-1-modelagem)
  - [Diagrama de Casos de Uso](#diagrama-de-casos-de-uso)
  - [Descrição dos Casos de Uso](#descrição-dos-casos-de-uso)
  - [Diagrama de Classes](#diagrama-de-classes)
- [Fase 2: Implementação](#fase-2-implementação)
  - [Protótipos](#protótipos)
  - [Tecnologias Utilizadas](#tecnologias-utilizadas)
  - [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar](#como-executar)
- [Funcionalidades](#funcionalidades)
- [Equipe](#equipe)

---

## 📖 Sobre o Projeto

O Sistema de Gestão Universitária é uma solução completa para gerenciamento de dados acadêmicos, contemplando cadastro e manutenção de diferentes tipos de pessoas que interagem com o ecossistema institucional.

O projeto foi desenvolvido em duas fases:
- **Fase 1**: Modelagem UML (Casos de Uso e Diagrama de Classes)
- **Fase 2**: Prototipação e Implementação (Frontend + Backend)

**Nota da Fase 1**: 9.8/10 ⭐

---

## 🎯 Fase 1: Modelagem

### Diagrama de Casos de Uso

O sistema possui 5 casos de uso principais, todos executados pelo **Administrador**:

```
┌─────────────────────────────────────────────────────┐
│        Universidade - Sistema de Gestão             │
│                                                      │
│    ┌──────────────────────┐                         │
│    │ Cadastrar Pessoa     │                         │
│    │      Física          │                         │
│    └──────────────────────┘                         │
│            │         │                               │
│            │         │                               │
│    ┌───────▼─┐   ┌──▼──────────┐                   │
│    │Cadastrar│   │  Cadastrar  │                   │
│    │Professor│   │   Alunos    │                   │
│    └─────────┘   └─────────────┘                   │
│                                                      │
│    ┌──────────────────────┐                         │
│    │ Cadastrar Pessoa     │                         │
│    │     Jurídica         │                         │
│    └──────────────────────┘                         │
│            │                                         │
│            │                                         │
│    ┌───────▼──────────┐                            │
│    │    Cadastrar     │                            │
│    │   Fornecedores   │                            │
│    └──────────────────┘                            │
│                                                      │
│  Administrador                                      │
└─────────────────────────────────────────────────────┘
```

**Relacionamentos:**
- Cadastrar Professor **estende** Cadastrar Pessoa Física
- Cadastrar Aluno **estende** Cadastrar Pessoa Física
- Cadastrar Fornecedor **estende** Cadastrar Pessoa Jurídica

---

### Descrição dos Casos de Uso

#### 1️⃣ Cadastrar Pessoa Física

**Objetivo:** Registrar uma nova pessoa física no sistema

**Pré-condições:**
- Administrador autenticado
- Sistema disponível e estável

**Fluxo Principal:**
1. Administrador seleciona "Cadastrar Pessoa Física"
2. Sistema abre formulário com campos: nome completo, CPF, data de nascimento, e-mail, telefone
3. Administrador preenche os campos obrigatórios
4. Sistema valida os dados (formatos e consistência)
5. Sistema salva os dados
6. Sistema exibe confirmação de sucesso
7. Sistema gera e mostra o ID único

**Fluxos Alternativos:**
- **Dados inválidos**: Sistema destaca campos problemáticos e solicita correção
- **CPF já cadastrado**: Sistema exibe aviso e oferece visualizar cadastro existente

**Pós-condições:**
- Nova pessoa física registrada com ID único
- Data/hora do cadastro gravadas
- Dados disponíveis para os demais módulos

---

#### 2️⃣ Cadastrar Pessoa Jurídica

**Objetivo:** Registrar uma nova empresa/organização no sistema

**Pré-condições:**
- Administrador autenticado
- Sistema disponível

**Fluxo Principal:**
1. Selecionar "Cadastrar Pessoa Jurídica"
2. Sistema abre formulário com: razão social, nome fantasia, CNPJ, e-mail, telefone
3. Preencher os campos obrigatórios
4. Sistema valida as informações, com atenção especial ao CNPJ
5. Salvar os dados
6. Exibir confirmação de sucesso
7. Gerar e mostrar o ID único da PJ

**Fluxos Alternativos:**
- **CNPJ inválido**: Campo destacado com mensagem de erro
- **Dados incompletos**: Sistema indica campos obrigatórios faltantes

**Pós-condições:**
- Nova pessoa jurídica cadastrada com ID único
- Registro de data/hora armazenado
- Dados prontos para uso por outros módulos

---

#### 3️⃣ Cadastrar Professor

**Objetivo:** Vincular o papel Professor a uma pessoa física já cadastrada

**Pré-condições:**
- Administrador autenticado
- Pessoa física do professor já existe no sistema
- Sistema operante

**Fluxo Principal:**
1. Selecionar "Cadastrar Professor"
2. Informar CPF ou ID da pessoa física
3. Sistema localiza e exibe os dados da pessoa
4. Sistema abre formulário complementar (departamento, titulação, regime de trabalho, data de admissão)
5. Preencher os campos e enviar
6. Sistema valida as informações
7. Vincular os dados ao registro da PF
8. Gerar a matrícula funcional do professor
9. Exibir confirmação de sucesso

**Fluxos Alternativos:**
- **Pessoa física não encontrada**: Oferece cadastrar nova PF ou cancelar
- **Professor já cadastrado**: Oferece visualizar, atualizar ou cancelar

**Pós-condições:**
- Dados do professor vinculados à PF
- Matrícula funcional criada (formato: PROFAAAAnnnnnn)
- Registro de data/hora armazenado

---

#### 4️⃣ Cadastrar Aluno

**Objetivo:** Vincular um candidato aprovado como Aluno

**Pré-condições:**
- Administrador autenticado
- Pessoa física do aluno já cadastrada
- Sistema operacional

**Fluxo Principal:**
1. Selecionar "Cadastrar Aluno"
2. Informar CPF ou ID da PF
3. Sistema localiza e exibe a pessoa
4. Abre formulário acadêmico (curso, turno, data e forma de ingresso, status)
5. Preencher e enviar
6. Sistema valida curso/turno e formato de matrícula
7. Vincular os dados à PF
8. Gerar matrícula acadêmica
9. Exibir confirmação

**Fluxos Alternativos:**
- **Pessoa física não encontrada**: Oferece cadastrar nova PF
- **Curso indisponível**: Oferece selecionar outro curso ou cancelar

**Pós-condições:**
- PF vinculada ao perfil Aluno com matrícula acadêmica (formato: AAAASnnnnn)
- Aluno habilitado nos sistemas acadêmicos
- Status: ATIVO

---

#### 5️⃣ Cadastrar Fornecedor

**Objetivo:** Registrar empresa parceira como Fornecedor

**Pré-condições:**
- Administrador autenticado
- Pessoa jurídica do fornecedor já cadastrada
- Sistema operacional

**Fluxo Principal:**
1. Selecionar "Cadastrar Fornecedor"
2. Informar CNPJ ou ID da PJ
3. Sistema localiza e exibe os dados da empresa
4. Abre formulário de fornecedor (ramo, produtos/serviços, representante legal, condições de pagamento)
5. Preencher e enviar
6. Sistema valida as informações
7. Vincular os dados à PJ
8. Gerar código de fornecedor
9. Exibir confirmação

**Fluxos Alternativos:**
- **Pessoa jurídica não encontrada**: Oferece cadastrar nova PJ
- **Fornecedor já cadastrado**: Oferece visualizar, atualizar ou cancelar

**Pós-condições:**
- Dados de fornecedor vinculados à PJ
- Código de fornecedor gerado (formato: FORNAAAAnnnnnn)
- Registro de data/hora armazenado

---

### Diagrama de Classes

```
┌─────────────────────────┐
│     ADMINISTRADOR       │
│─────────────────────────│
│ - id: String            │
│ - nomeCompleto: String  │
│ - email: String         │
│ - telefone: String      │
│ - dataCadastro: DateTime│
│─────────────────────────│
│ + cadastrar()           │
│ + atualizar()           │
│ + validarDados()        │
└─────────────────────────┘
          │
          │ gerencia
          │
    ┌─────┴─────┐
    │           │
┌───▼──────────────────┐  ┌────▼─────────────────┐
│   PESSOA FÍSICA      │  │  PESSOA JURÍDICA     │
│──────────────────────│  │──────────────────────│
│ - id: String         │  │ - id: String         │
│ - nomeCompleto: Str  │  │ - cnpj: String       │
│ - cpf: String        │  │ - razaoSocial: Str   │
│ - dataNascimento:Date│  │ - nomeFantasia: Str  │
│ - email: String      │  │ - email: String      │
│ - telefone: String   │  │ - telefone: String   │
│──────────────────────│  │──────────────────────│
│ + validarCPF()       │  │ + validarCNPJ()      │
└──────────────────────┘  └──────────────────────┘
    │              │              │
    │              │              │
┌───▼───────┐  ┌──▼──────┐  ┌───▼──────────┐
│ PROFESSOR │  │  ALUNO  │  │  FORNECEDOR  │
│───────────│  │─────────│  │──────────────│
│ - matric. │  │ - matric│  │ - codigo     │
│   Funcional│  │   Acad. │  │ - area       │
│ - depto   │  │ - curso │  │ - ramo       │
│ - titulaç.│  │ - turno │  │ - produtos   │
│ - regime  │  │ - data  │  │ - repres.    │
│ - dataAdm.│  │   Ingr. │  │ - condiçoes  │
│───────────│  │ - forma │  │──────────────│
│ + gerar   │  │   Ingr. │  │ + gerar      │
│   Matricu.│  │ - status│  │   Codigo()   │
│ + vincular│  │─────────│  │ + vincular   │
│   Dados() │  │ + gerar │  │   Dados()    │
└───────────┘  │   Matric│  └──────────────┘
               │ + habilit│
               │   Sistemas│
               │ + validar│
               │   Curso()│
               └──────────┘
```

**Relacionamentos:**
- **Herança**: Professor e Aluno herdam de Pessoa Física
- **Herança**: Fornecedor herda de Pessoa Jurídica
- **Associação**: Administrador gerencia todas as entidades

---

## 🚀 Fase 2: Implementação

### Protótipos

Os protótipos foram desenvolvidos com foco em **usabilidade**, **responsividade** e **acessibilidade**.

#### Telas Implementadas:

1. **Dashboard Principal**
   - Menu com cards interativos
   - Navegação intuitiva
   - Design moderno e clean

2. **Cadastro de Pessoa Física**
   - Validação de CPF em tempo real
   - Máscaras de entrada
   - Feedback visual de validação

3. **Cadastro de Pessoa Jurídica**
   - Validação de CNPJ
   - Campos específicos de empresa
   - Mensagens de sucesso

4. **Cadastro de Professor**
   - Busca por CPF vinculado
   - Campos acadêmicos específicos
   - Geração automática de matrícula funcional

5. **Cadastro de Aluno**
   - Seleção de curso e turno
   - Validação de disponibilidade
   - Geração de matrícula acadêmica

6. **Cadastro de Fornecedor**
   - Busca por CNPJ vinculado
   - Informações comerciais
   - Código de fornecedor automático

---

### Tecnologias Utilizadas

#### Backend
- **Java 17+**
  - Programação Orientada a Objetos
  - Classes modeladas conforme Fase 1
  - Validações robustas (CPF, CNPJ)
  - Padrão DAO (Data Access Object)
  - Padrão Service Layer

#### Frontend
- **HTML5**
  - Semântica adequada
  - Acessibilidade (ARIA labels)
  - SEO friendly
  
- **CSS3**
  - Design moderno e responsivo
  - Mobile-first approach
  - Animações suaves
  - CSS Variables
  
- **JavaScript (Vanilla)**
  - Validações client-side
  - Máscaras de entrada
  - Comunicação com backend
  - DOM manipulation

#### Ferramentas
- **Git/GitHub** - Controle de versão
- **Markdown** - Documentação
- **Figma** - Protótipos (conceituais)

---

### Estrutura do Projeto

```
projeto-gestao-universitaria/
│
├── README.md                          # Este arquivo
│
├── docs/                              # Documentação
│   ├── diagramas/
│   │   ├── caso-de-uso.png
│   │   └── diagrama-classes.png
│   └── prototipos/
│       └── fluxos-navegacao.md
│
├── backend/                           # Código Java
│   └── src/
│       └── com/
│           └── universidade/
│               ├── model/             # Entidades
│               │   ├── Administrador.java
│               │   ├── PessoaFisica.java
│               │   ├── PessoaJuridica.java
│               │   ├── Professor.java
│               │   ├── Aluno.java
│               │   └── Fornecedor.java
│               │
│               ├── dao/               # Camada de dados
│               │   ├── GenericDAO.java
│               │   ├── PessoaFisicaDAO.java
│               │   ├── PessoaJuridicaDAO.java
│               │   └── SpecificDAOs.java
│               │
│               ├── service/           # Lógica de negócio
│               │   ├── PessoaFisicaService.java
│               │   └── PessoaJuridicaService.java
│               │
│               └── controller/        # Controladores
│                   └── CadastroController.java
│
└── frontend/                          # Interface Web
    ├── index.html                     # Dashboard principal
    │
    ├── css/
    │   └── styles.css                 # Estilos globais
    │
    ├── js/
    │   └── script.js                  # Funções JavaScript
    │
    └── pages/                         # Páginas de cadastro
        ├── cadastro-pf.html
        ├── cadastro-pj.html
        ├── cadastro-professor.html
        ├── cadastro-aluno.html
        └── cadastro-fornecedor.html
```

---

## 💻 Como Executar

### Pré-requisitos

- Java JDK 17 ou superior
- Navegador web moderno (Chrome, Firefox, Edge)
- Git (para clonar o repositório)

### Passos

1. **Clone o repositório**
```bash
git clone https://github.com/seu-usuario/sistema-gestao-universitaria.git
cd sistema-gestao-universitaria
```

2. **Compile o backend Java**
```bash
cd backend/src
javac com/universidade/model/*.java
javac com/universidade/dao/*.java
javac com/universidade/service/*.java
javac com/universidade/controller/*.java
```

3. **Execute o frontend**
- Abra o arquivo `frontend/index.html` no navegador
- Ou use um servidor local:
```bash
cd frontend
python -m http.server 8000
# Acesse: http://localhost:8000
```

---

## ✨ Funcionalidades

### Implementadas

✅ Cadastro completo de Pessoa Física  
✅ Cadastro completo de Pessoa Jurídica  
✅ Vinculação de Professor  
✅ Vinculação de Aluno  
✅ Vinculação de Fornecedor  
✅ Validação de CPF e CNPJ  
✅ Máscaras de entrada  
✅ Feedback visual de validação  
✅ Design responsivo  
✅ Geração automática de IDs e matrículas  

### Próximas Versões

🔜 Persistência em banco de dados  
🔜 Autenticação de usuários  
🔜 Busca e listagem de cadastros  
🔜 Edição de registros  
🔜 Relatórios em PDF  
🔜 API REST completa  

---

## 👥 Equipe

**Projeto Integrador - Grupo 48**

Desenvolvido como parte do curso de Análise e Desenvolvimento de Sistemas.

---

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos.

---

## 📞 Contato

Para dúvidas ou sugestões sobre o projeto, entre em contato através dos canais da instituição.

---

<div align="center">

**Sistema de Gestão Universitária** © 2025  
Projeto Integrador - Senac

⭐ Nota Fase 1: 9.8/10

</div>
