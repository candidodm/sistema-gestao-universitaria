# 🎓 Sistema de Gestão Universitária

**Projeto Integrador - Desenvolvimento de Sistemas Orientado a Objetos**  
**Grupo 48**  
**Senac - 2024**

---

## 📋 Sumário

- [Visão Geral](#visão-geral)
- [Fase 1: Modelagem UML](#fase-1-modelagem-uml)
- [Fase 2: Prototipação e Implementação](#fase-2-prototipação-e-implementação)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Como Executar](#como-executar)
- [Funcionalidades](#funcionalidades)
- [Credenciais de Acesso](#credenciais-de-acesso)
- [Equipe](#equipe)

---

## 🎯 Visão Geral

Sistema desenvolvido para gerenciar o cadastro de diferentes tipos de pessoas que interagem com uma universidade, incluindo:

- 👤 **Pessoas Físicas** - Cadastro base de indivíduos
- 🏢 **Pessoas Jurídicas** - Cadastro de empresas e organizações
- 👨‍🏫 **Professores** - Corpo docente da instituição
- 🎓 **Alunos** - Estudantes matriculados
- 📦 **Fornecedores** - Empresas parceiras e prestadoras de serviços

O sistema utiliza conceitos de Orientação a Objetos, incluindo:
- **Herança**: Classes especializadas herdam de classes base
- **Polimorfismo**: Métodos abstratos implementados de forma específica
- **Encapsulamento**: Atributos protegidos com getters e setters
- **Abstração**: Classe base abstrata `Pessoa`

---

## 📐 Fase 1: Modelagem UML

### Diagrama de Caso de Uso

O sistema possui 5 casos de uso principais, todos executados pelo **Administrador**:

```
┌─────────────────────────────────────────────────────────┐
│                    Sistema Universitário                 │
│                                                          │
│  ┌──────────────┐                                       │
│  │              │                                       │
│  │ Administrador│───────▶ (Cadastrar Pessoa Física)    │
│  │              │                                       │
│  │              │───────▶ (Cadastrar Pessoa Jurídica)  │
│  │              │                                       │
│  │              │───────▶ (Cadastrar Professor)        │
│  │              │                                       │
│  │              │───────▶ (Cadastrar Aluno)            │
│  │              │                                       │
│  │              │───────▶ (Cadastrar Fornecedor)       │
│  └──────────────┘                                       │
│                                                          │
└─────────────────────────────────────────────────────────┘
```

### Descrição dos Casos de Uso

#### 1. Cadastrar Pessoa Física

**Pré-condição**: O administrador deve estar autenticado no sistema.

**Cenário Principal:**
1. O administrador seleciona a opção "Cadastrar Pessoa Física"
2. O sistema exibe o formulário de cadastro
3. O administrador preenche: CPF, nome, data de nascimento, email, telefone
4. O sistema valida os dados (CPF válido, campos obrigatórios preenchidos)
5. O sistema cadastra a pessoa física e exibe mensagem de sucesso

**Cenários Alternativos:**
- **A1**: CPF inválido - O sistema exibe mensagem de erro e solicita correção
- **A2**: Dados incompletos - O sistema destaca campos obrigatórios não preenchidos

**Pós-condição**: Pessoa física cadastrada no banco de dados.

---

#### 2. Cadastrar Pessoa Jurídica

**Pré-condição**: O administrador deve estar autenticado no sistema.

**Cenário Principal:**
1. O administrador seleciona a opção "Cadastrar Pessoa Jurídica"
2. O sistema exibe o formulário de cadastro
3. O administrador preenche: CNPJ, razão social, nome fantasia, email, telefone
4. O sistema valida os dados (CNPJ válido, campos obrigatórios)
5. O sistema cadastra a pessoa jurídica e exibe mensagem de sucesso

**Cenários Alternativos:**
- **A1**: CNPJ inválido - O sistema exibe mensagem de erro e solicita correção
- **A2**: Email inválido - O sistema valida formato do email e solicita correção

**Pós-condição**: Pessoa jurídica cadastrada no banco de dados.

---

#### 3. Cadastrar Professor

**Pré-condição**: O administrador deve estar autenticado no sistema.

**Cenário Principal:**
1. O administrador seleciona a opção "Cadastrar Professor"
2. O sistema exibe o formulário com dados pessoais e profissionais
3. O administrador preenche dados pessoais (CPF, nome, email) e profissionais (matrícula, departamento, titulação, regime de trabalho)
4. O sistema valida todos os dados
5. O sistema cadastra o professor e exibe mensagem de sucesso

**Cenários Alternativos:**
- **A1**: CPF já cadastrado - O sistema verifica duplicidade e alerta o administrador
- **A2**: Matrícula duplicada - O sistema sugere nova matrícula automaticamente

**Pós-condição**: Professor cadastrado e vinculado ao departamento.

---

#### 4. Cadastrar Aluno

**Pré-condição**: O administrador deve estar autenticado no sistema.

**Cenário Principal:**
1. O administrador seleciona a opção "Cadastrar Aluno"
2. O sistema exibe o formulário com dados pessoais e acadêmicos
3. O administrador preenche dados pessoais e acadêmicos (curso, turno, período, status)
4. O sistema valida os dados e verifica disponibilidade de vagas
5. O sistema cadastra o aluno e gera a matrícula

**Cenários Alternativos:**
- **A1**: Curso sem vagas - O sistema informa e sugere lista de espera
- **A2**: Dados acadêmicos incompletos - O sistema destaca campos obrigatórios

**Pós-condição**: Aluno matriculado no curso selecionado.

---

#### 5. Cadastrar Fornecedor

**Pré-condição**: O administrador deve estar autenticado no sistema.

**Cenário Principal:**
1. O administrador seleciona a opção "Cadastrar Fornecedor"
2. O sistema exibe o formulário com dados da empresa e de fornecimento
3. O administrador preenche CNPJ, razão social, setor de atuação, produtos/serviços
4. O sistema valida os dados
5. O sistema cadastra o fornecedor com status "Aguardando Aprovação"

**Cenários Alternativos:**
- **A1**: CNPJ já cadastrado - O sistema verifica e exibe dados existentes
- **A2**: Documentação pendente - O sistema marca para revisão posterior

**Pós-condição**: Fornecedor cadastrado aguardando aprovação.

---

### Diagrama de Classes

```
                    ┌─────────────────┐
                    │    <<abstract>> │
                    │      Pessoa     │
                    ├─────────────────┤
                    │ - email         │
                    │ - telefone      │
                    │ - endereco      │
                    │ - cidade        │
                    │ - estado        │
                    │ - cep           │
                    ├─────────────────┤
                    │ + validarDados()│
                    │ + getInfo()     │
                    └────────┬────────┘
                             │
                ┌────────────┴───────────┐
                │                        │
       ┌────────▼────────┐      ┌───────▼────────┐
       │  PessoaFisica   │      │ PessoaJuridica │
       ├─────────────────┤      ├────────────────┤
       │ - cpf           │      │ - cnpj         │
       │ - nome          │      │ - razaoSocial  │
       │ - dataNasc      │      │ - nomeFantasia │
       ├─────────────────┤      ├────────────────┤
       │ + calcularIdade()│      │ + calcularTempo()│
       └────────┬────────┘      └───────┬────────┘
                │                        │
       ┌────────┴────────┐      ┌───────┴────────┐
       │                 │      │                │
┌──────▼──────┐  ┌──────▼──────┐  ┌──────────▼──────┐
│   Professor │  │    Aluno    │  │   Fornecedor    │
├─────────────┤  ├─────────────┤  ├─────────────────┤
│ - matricula │  │ - matricula │  │ - setorAtuacao  │
│ - depto     │  │ - curso     │  │ - produtos      │
│ - titulacao │  │ - turno     │  │ - condicoes     │
│ - regime    │  │ - periodo   │  │ - prazoEntrega  │
├─────────────┤  ├─────────────┤  ├─────────────────┤
│ + calcular  │  │ + matricular│  │ + aprovar()     │
│   Tempo()   │  │   Periodo() │  │ + avaliar()     │
└─────────────┘  └─────────────┘  └─────────────────┘
```

**Relacionamentos:**
- **Herança**: PessoaFisica e PessoaJuridica herdam de Pessoa
- **Especialização**: Professor e Aluno herdam de PessoaFisica
- **Especialização**: Fornecedor herda de PessoaJuridica

---

## 🖥️ Fase 2: Prototipação e Implementação

### Protótipos Desenvolvidos

O sistema possui 5 interfaces completas e funcionais:

#### 1. 🔐 Tela de Login
- Autenticação do administrador
- Validação de credenciais
- Mensagens de erro personalizadas

#### 2. 🏠 Página Principal (Dashboard)
- Menu de navegação com cards
- Acesso rápido aos 5 módulos de cadastro
- Informações do usuário logado

#### 3. 👤 Cadastro de Pessoa Física
- Formulário com validação de CPF
- Campos: CPF, nome, data de nascimento, email, telefone, endereço
- Máscaras de formatação automática
- Validação em tempo real

#### 4. 🏢 Cadastro de Pessoa Jurídica
- Formulário com validação de CNPJ
- Campos: CNPJ, razão social, nome fantasia, email, telefone, endereço
- Seleção de ramo de atividade
- Validação em tempo real

#### 5. 👨‍🏫 Cadastro de Professor
- Seções: Dados Pessoais e Dados Profissionais
- Campos: CPF, nome, matrícula, departamento, titulação, regime de trabalho
- Seleção de área de especialização
- Campo para Currículo Lattes

#### 6. 🎓 Cadastro de Aluno
- Seções: Dados Pessoais, Dados Acadêmicos e Endereço
- Campos: CPF, nome, matrícula, curso, turno, período, status
- Informações de ingresso e bolsa
- Dados de filiação (pai e mãe)

#### 7. 📦 Cadastro de Fornecedor
- Seções: Dados da Empresa, Informações de Fornecimento e Endereço
- Campos: CNPJ, setor de atuação, produtos/serviços
- Condições de pagamento e prazo de entrega
- Dados de contato do representante

---

## 📁 Estrutura do Projeto

```
sistema-universitario/
│
├── frontend/                       # Interface do usuário
│   ├── css/
│   │   └── styles.css             # Estilos globais
│   │
│   ├── js/
│   │   ├── auth.js                # Autenticação e login
│   │   └── validacoes.js          # Validações e formatações
│   │
│   ├── pages/                     # Páginas de cadastro
│   │   ├── pessoa-fisica.html
│   │   ├── pessoa-juridica.html
│   │   ├── professor.html
│   │   ├── aluno.html
│   │   └── fornecedor.html
│   │
│   ├── login.html                 # Página de login
│   └── index.html                 # Página principal
│
├── backend/                       # Lógica de negócio
│   └── src/
│       └── com/universidade/
│           ├── model/            # Classes do modelo
│           │   ├── Pessoa.java   # Classe abstrata base
│           │   ├── PessoaFisica.java
│           │   ├── PessoaJuridica.java
│           │   ├── Professor.java
│           │   ├── Aluno.java
│           │   └── Fornecedor.java
│           │
│           └── util/             # Classes utilitárias
│               ├── ValidadorCPF.java
│               └── ValidadorCNPJ.java
│
├── docs/                         # Documentação
│   └── diagramas/               # Diagramas UML
│
└── README.md                     # Este arquivo
```

---

## 🛠️ Tecnologias Utilizadas

### Frontend
- **HTML5** - Estruturação das páginas
- **CSS3** - Estilização e layout responsivo
- **JavaScript** - Interatividade e validações
  - Validação de CPF/CNPJ
  - Máscaras de formatação
  - Sistema de autenticação

### Backend
- **Java 11+** - Linguagem de programação
  - Programação Orientada a Objetos
  - Classes abstratas e herança
  - Encapsulamento e polimorfismo
  - Validações de negócio

### Padrões e Conceitos
- **MVC** (Model-View-Controller)
- **POO** (Programação Orientada a Objetos)
- **SOLID** (Princípios de design de software)
- **UML** (Unified Modeling Language)

---

## ⚙️ Funcionalidades

### Sistema de Login
- ✅ Autenticação de administrador
- ✅ Validação de credenciais
- ✅ Mensagens de erro personalizadas
- ✅ Proteção de rotas (redirecionamento automático)
- ✅ Logout seguro

### Validações Implementadas
- ✅ CPF (algoritmo oficial da Receita Federal)
- ✅ CNPJ (algoritmo oficial da Receita Federal)
- ✅ E-mail (formato válido)
- ✅ Telefone (formato brasileiro)
- ✅ Campos obrigatórios
- ✅ Datas (não futuras para nascimento)

### Formatação Automática
- ✅ CPF: 000.000.000-00
- ✅ CNPJ: 00.000.000/0000-00
- ✅ Telefone: (00) 00000-0000
- ✅ CEP: 00000-000

### Interface do Usuário
- ✅ Design responsivo (mobile-friendly)
- ✅ Feedback visual em tempo real
- ✅ Mensagens de sucesso/erro
- ✅ Navegação intuitiva
- ✅ Animações suaves
- ✅ Ícones representativos

---

## 🔐 Credenciais de Acesso

### Administrador do Sistema
```
Usuário: adm
Senha: adm123
```

> ⚠️ **Nota**: Em ambiente de produção, as credenciais devem ser armazenadas de forma segura usando hash e salt.

---

## 📊 Diagrama de Classes Detalhado

### Hierarquia de Classes

```java
// Classe abstrata base
public abstract class Pessoa {
    protected String email;
    protected String telefone;
    protected String endereco;
    // ...
    public abstract boolean validarDados();
    public abstract String getInformacoes();
}

// Pessoa Física
public class PessoaFisica extends Pessoa {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    // ...
    public int calcularIdade() { /* ... */ }
}

// Pessoa Jurídica
public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    // ...
    public int calcularTempoAtividade() { /* ... */ }
}

// Professor (herda de PessoaFisica)
public class Professor extends PessoaFisica {
    private String matricula;
    private String departamento;
    private String titulacao;
    // ...
    public int calcularTempoServico() { /* ... */ }
}

// Aluno (herda de PessoaFisica)
public class Aluno extends PessoaFisica {
    private String matricula;
    private String curso;
    private String turno;
    // ...
    public void matricularProximoPeriodo() { /* ... */ }
}

// Fornecedor (herda de PessoaJuridica)
public class Fornecedor extends PessoaJuridica {
    private String setorAtuacao;
    private String tipoProdutoServico;
    // ...
    public void aprovar() { /* ... */ }
}
```

## 👥 Equipe

**Grupo 48 - Projeto Integrador**

- Desenvolvimento do sistema
- Modelagem UML
- Documentação técnica
- Prototipação de interfaces

---

## 📚 Referências

- [Java Documentation](https://docs.oracle.com/en/java/)
- [MDN Web Docs](https://developer.mozilla.org/)
- [UML Guide](https://www.uml.org/)
- [Design Patterns](https://refactoring.guru/design-patterns)

---

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais como parte do Projeto Integrador do curso de Desenvolvimento de Sistemas Orientado a Objetos.

---

## 📞 Contato

Para dúvidas ou sugestões sobre o projeto, entre em contato com a equipe do Grupo 48.

---

**© 2024 Sistema de Gestão Universitária - Grupo 48**
