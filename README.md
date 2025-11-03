# 🏭 Sistema de Manutenção Industrial - Almoxarifado

## 📌 Contexto
Na **WEG**, o setor de manutenção industrial precisa de um sistema confiável para controlar o **almoxarifado** da fábrica.  
Atualmente, a gestão de materiais, fornecedores e requisições é feita manualmente ou em planilhas, o que gera problemas como:
- Falhas no controle de estoque
- Atrasos no atendimento de requisições
- Falta de rastreabilidade de entradas e saídas  

Para resolver isso, será desenvolvido um **protótipo funcional em Java com JPA**, estruturado em camadas, que permita gerenciar fornecedores, materiais, notas de entrada e requisições.  
Esse protótipo será a base para futuros sistemas corporativos mais robustos, podendo futuramente se integrar a sensores de estoque automatizados e sistemas ERP.  

---

## ⚙️ Funcionalidades Mínimas
- ✅ **Separação de responsabilidades**: camadas Model, Repository, Service e Controller
- ✅ **Persistência de dados com JPA** (MySQL)  
- ✅ **Padrões de projeto**: Repository para acesso a dados 
- ✅ **Controle de estoque** integrado às entradas e requisições

---

## 📂 Funcionalidades do Sistema

### 1️⃣ Cadastro de Fornecedores
- Dados: **nome, CNPJ**  
- Regras:  
  - CNPJ único (não duplicado)  
  - Nome e CNPJ obrigatórios  
- Apenas administradores podem cadastrar fornecedores (em futuras versões com controle de usuários).  

---

### 2️⃣ Cadastro de Materiais
- Dados: **nome, unidade de medida (kg, m, peça), quantidade inicial em estoque**  
- Regras:  
  - Nome único por material  
  - Quantidade inicial ≥ 0  
- Estoque atualizado automaticamente a partir das notas de entrada e requisições.  

---

### 3️⃣ Registro de Notas de Entrada
- Associa **fornecedor, data de entrada e materiais comprados**  
- Cada material recebe uma quantidade que será adicionada ao estoque  
- Validações:  
  - Fornecedor deve existir no cadastro  
  - Quantidade ≥ 0  
- Efeito: **estoque atualizado automaticamente**  

---

### 4️⃣ Criação de Requisição de Material
- Dados: **setor solicitante, data, lista de materiais e quantidades**  
- Regras:  
  - Quantidade solicitada ≤ estoque disponível  
  - Status inicial: **PENDENTE**  
- Associa materiais e quantidades à requisição.  

---

### 5️⃣ Atendimento de Requisições
- Apenas requisições com status **PENDENTE** podem ser atendidas  
- Validações:  
  - Conferir se há estoque suficiente  
- Efeitos:  
  - Estoque reduzido  
  - Status atualizado para **ATENDIDA**  
  - Se não houver estoque → erro e status mantido **PENDENTE** 

---

## 🛠️ Tecnologias Utilizadas
- Java  
- JPA
- SPRING BOOT
- MySQL  
- Padrão MVC   
