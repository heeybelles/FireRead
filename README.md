# FireauthApp 📱🔥

Aplicativo Android nativo desenvolvido em **Kotlin** com integração ao ecossistema **Firebase** (Firebase Authentication e Cloud Firestore). O app implementa autenticação completa de usuários e cadastro/listagem de produtos com arquitetura organizada e interface intuitiva.

---

## 🚀 Sobre o Projeto

O **FireauthApp** foi construído com o objetivo de oferecer um fluxo ágil e seguro de autenticação de usuários integrado ao armazenamento em nuvem em tempo real. A interface conta com padrão visual moderno, componentes Material Design, botões destacados em azul e campos acessíveis com identificadores padronizados.

---

## ✨ Funcionalidades

### 🔐 Autenticação (Firebase Auth)
- **Login de Usuário:** Acesso rápido utilizando e-mail e senha cadastrados.
- **Cadastro de Conta:** Criação de novos usuários com validação direta no Firebase.
- **Recuperação de Senha:** Envio de e-mail de redefinição de senha com um clique.

### 📦 Gestão de Produtos (Cloud Firestore)
- **Cadastro de Produtos:** Formulário para inserção de Nome, Categoria e Preço.
- **Listagem de Produtos:** Visualização em `RecyclerView` estilizado com `MaterialCardView`, exibindo as informações formatadas (moeda em R$).
- **Navegação Dinâmica:** Transição suave entre as telas de login, cadastro e listagem.

---

## 🏗️ Estrutura e Arquitetura

O projeto adota uma separação clara em pacotes para facilitar a manutenibilidade:

```text
com.example.fireauthapp/
├── model/
│   └── Produto.kt                 # Entidade de dados do produto
├── adapter/
│   └── ProdutoAdapter.kt          # Adaptador do RecyclerView
└── view/
    ├── LoginActivity.kt           # Tela de autenticação e recuperação
    ├── MainActivity.kt            # Tela principal de cadastro de produto
    └── ListaProdutosActivity.kt   # Tela de listagem de produtos
```

### 🏷️ Padrões de Nomenclatura Adotados
- **Campos de Entrada (`edt...`):** `edtEmail`, `edtSenha`, `edtNome`, `edtCategoria`, `edtPreco`.
- **Botões (`btn...`):** `btnLogin`, `btnCadastrar`, `btnRecuperar`, `btnSalvar`, `btnVerLista`, `btnVoltar`.

---

## 🎨 Interface e Experiência do Usuário (UI/UX)

- **Cores dos Botões:** Paleta personalizada com tons de azul (`#1976D2`, `#0288D1`) e texto contrastante em branco.
- **Campos de Texto:** Estados de foco interativos com bordas arredondadas (`selector_edit_text.xml`) e uso de `hint` descritivo.
- **Responsividade:** Telas envolvidas em `ScrollView` para adaptação em diferentes tamanhos de dispositivos e com o teclado virtual aberto.
- **Cards:** Itens da listagem apresentados em `MaterialCardView` com elevação sutil e espaçamento consistente.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** [Kotlin](https://kotlinlang.org/)
- **Plataforma:** Android (SDK 24 a 34)
- **Backend as a Service:** [Firebase](https://firebase.google.com/)
  - Firebase Authentication (login e registro)
  - Cloud Firestore (banco de dados NoSQL)
- **UI Toolkit:** Android Jetpack (Material Components, ConstraintLayout, RecyclerView)

---

## ⚙️ Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/FireauthLogin.git
   ```

2. **Abra o projeto no Android Studio:**
   - Selecione a opção **Open an Existing Project** e aponte para a pasta do repositório.

3. **Configure o Firebase:**
   - Adicione o arquivo `google-services.json` obtido no Firebase Console dentro da pasta `app/`.

4. **Sincronize e Execute:**
   - Aguarde o Gradle Sync e execute em um emulador ou aparelho físico conectado.

---

## 👥 Desenvolvedores

Projeto desenvolvido com dedicação por:

- **Eduarda**
- **Zeus**

---

<p align="center">Feito com 💙 para fins acadêmicos e práticos de desenvolvimento Android.</p>
