# 🎓 Sistema Acadêmico Simplificado — POO & Padrões de Projeto

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Instituição](https://img.shields.io/badge/Instituição-UniAteneu-green.svg)](https://uniateneu.edu.br/)

Projeto prático desenvolvido como parte da **Atividade Integradora** da disciplina de **Laboratório de Programação Orientada a Objetos** na UniAteneu. 

O sistema simula o fluxo completo de matrícula acadêmica, abrangendo cadastro, aplicação de regras de desconto, pagamento via sistema legado, disparo de notificações em tempo real e emissão de comprovantes polimórficos.

---

## 📌 Sumário
- [Sobre o Projeto](#-sobre-o-projeto)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Padrões de Projeto Aplicados](#-padrões-de-projeto-aplicados)
- [Estrutura do Repositório e Divisão de Tarefas](#-estrutura-do-repositório-e-divisão-de-tarefas)
- [Como Compilar e Executar](#-como-compilar-e-executar)
- [Análise Técnica (Etapa 8)](#-análise-técnica-etapa-8)
- [Informações Acadêmicas](#-informações-acadêmicas)

---

## 🛠️ Sobre o Projeto

O objetivo principal deste projeto é aplicar os conceitos fundamentais de **Programação Orientada a Objetos (POO)** e **Design Patterns (GoF)** na prática. O fluxo do sistema opera da seguinte forma:

1. O sistema carrega as configurações globais (**Singleton**).
2. Calcula o valor final com base em políticas dinâmicas de desconto (**Strategy**).
3. Adapta os valores em reais para centavos e envia para processamento no sistema antigo (**Adapter**).
4. Notifica todos os serviços interessados após a confirmação da matrícula (**Observer**).
5. Gera comprovantes de matrícula em formatos variados (**Factory Method**).
6. Simplifica toda a orquestração do fluxo para a aplicação através de um ponto de entrada único (**Facade**).

---

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java (JDK 21)
* **Ambiente de Desenvolvimento:** VS Code
* **Conceitos de POO:** Encapsulamento, Herança, Polimorfismo, Abstração, Baixo Acoplamento e Injeção de Dependência.

---

## 🧩 Padrões de Projeto Aplicados

| Padrão | Categoria | Finalidade no Sistema |
| :--- | :--- | :--- |
| **Singleton** | Criacional | Garante uma única instância da classe `Configuracao` em toda a aplicação. |
| **Strategy** | Comportamental | Permite alternar dinamicamente entre diferentes políticas de desconto (`DescontoEstudante`, `SemDesconto`). |
| **Observer** | Comportamental | Dispara notificações automáticas (`AvisoEmail`, `Auditoria`) após a realização de uma matrícula. |
| **Adapter** | Estrutural | Converte a interface moderna em reais (`double`) para o formato exigido pelo `SistemaLegado` em centavos (`int`). |
| **Factory Method** | Criacional | Delega às subclasses a criação e formatação de comprovantes (`ComprovanteTexto`, `ComprovanteResumido`). |
| **Facade** | Estrutural | A classe `FachadaAcademica` simplifica a interação entre os subsistemas de desconto, pagamento, notificação e comprovante. |

---

## 📂 Estrutura do Repositório e Divisão de Tarefas

> **Nota de Organização da Equipe:**  
> A **Etapa 1** (modelagem inicial das classes `Aluno.java` e `Curso.java`) ficou sob responsabilidade de outro integrante da equipe. Este repositório foca na construção e integração das **Etapas 2 a 7**, juntamente com a estrutura final do projeto.

```text
src/
├── Configuracao.java           # Singleton (Configurações do sistema)
├── Curso.java                  # Modelagem do Curso (Etapa 1 - Integrante)
├── Aluno.java                  # Modelagem do Aluno (Etapa 1 - Integrante)
├── Desconto.java               # Strategy (Interfaces e políticas de desconto)
├── ObservadorMatricula.java   # Observer (Interface e observadores de eventos)
├── SistemaLegado.java          # Adapter (Sistema legado e adaptador de pagamento)
├── Comprovante.java            # Factory Method (Fábrica e tipos de comprovantes)
├── ServicoMatricula.java       # Serviço principal do domínio
├── FachadaAcademica.java       # Facade (Fachada para simplificação do uso)
└── Main.java                   # Ponto de entrada e teste de execução
```

---

## 💻 Como Compilar e Executar

### Pré-requisitos
* Java Development Kit (JDK 21 ou superior) instalado.
* Git para clonar o repositório.

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/JLpensador/NOME-DO-REPOSITORIO.git
   cd NOME-DO-REPOSITORIO
   ```

2. **Compile o código-fonte:**
   Crie a pasta de compilação `out` e compile todas as classes do diretório `src`:
   ```bash
   javac -encoding UTF-8 -d out src/*.java
   ```

3. **Execute o programa:**
   ```bash
   java -cp out Main
   ```

### Saída Esperada no Console
```text
Sistema Acadêmico
Legado registrou: 180 centavos
E-mail: Ana matriculado em Java
Auditoria: Ana matriculado em Java
Matrícula: Ana/Java/ R$ 180.0
Cursos do aluno: 1
```

---

## 📊 Análise Técnica (Etapa 8)

<details>
<summary><b>🔍 Clique para expandir as respostas do questionário de análise técnica</b></summary>

1. **Singleton:** Implementado na classe `Configuracao` via construtor privado, atributo estático `INSTANCIA` e método `getInstancia()`.
2. **Encapsulamento e Validação:** Atributos definidos como `private final` e validações com exceções (`IllegalArgumentException`) nos construtores das entidades `Aluno` e `Curso`.
3. **Relação Aluno e Curso:** Associação unidirecional (agregação fraca) via `List<Curso>`.
4. **Uso de Coleções:** Utilização de `ArrayList` em `Aluno` (armazenar cursos) e em `ServicoMatricula` (gerenciar a lista de observadores).
5. **Papel da Interface Desconto:** Estabelecer um contrato genérico (`aplicar`) para desacoplar as políticas de preços do serviço de matrícula (**Strategy**).
6. **Extensibilidade de Desconto:** Para incluir 20% de desconto, basta criar uma nova classe que implemente `Desconto`, sem alterar `ServicoMatricula`.
7. **Observer (Produtor e Receptor):** `ServicoMatricula` dispara o evento; `AvisoEmail` e `Auditoria` recebem as notificações.
8. **Adapter:** O `AdaptadorPagamento` converte reais (`double`) para centavos (`int`) exigidos pela classe `SistemaLegado`.
9. **Factory Method:** O método `criar()` na classe abstrata `CriadorComprovante`.
10. **Facade:** `FachadaAcademica` simplifica a execução do `Main`, reduzindo múltiplas chamadas complexas a um único método (`matricularEEmitir`).

</details>

---

## 📚 Informações Acadêmicas

* **Instituição:** Centro Universitário Ateneu (UniAteneu)
* **Curso:** Engenharia de Software
* **Disciplina:** Laboratório de Programação Orientada a Objetos
* **Ambiente:** JDK 21 / VS Code
* **Atividade:** Atividade Integradora — Aulas 01 a 08

---
*Desenvolvido para fins educacionais Por João Luiz B. Morais e Joel Costa Silva.*
