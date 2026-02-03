// Importações do React
// Importa o hook useState, usado para controlar estados (dados) do formulário
import { useState } from 'react';
// Importa o hook useNavigate para redirecionar o usuário entre páginas
import { useNavigate } from 'react-router-dom';
// Importa a instância do axios já configurada para se comunicar com o backend
import api from '../services/api';
// Importa o CSS específico da tela de autenticação (login/cadastro)
import '../styles/auth.css';

// Componente da página de Cadastro
export default function CadastroPage() {

  // Estados do formulário
  const [nome, setNome] = useState(''); // Armazena o nome digitado pelo usuário
  const [email, setEmail] = useState(''); // Armazena o email digitado pelo usuário
  const [erro, setErro] = useState(''); // Armazena mensagens de erro (caso o cadastro falhe)

  const navigate = useNavigate(); // Hook usado para navegar entre páginas

  // Função responsável pelo cadastro
  function cadastrar() {

    // Envia uma requisição POST para o backend
    // criando um novo usuário
    api.post('/usuarios', {
      nome,  // Nome informado no formulário
      email,  // Email informado no formulário
      tipo: 'LEITOR'  // Tipo fixo definido pela regra do sistema
    })
    .then(() => {
      // Caso o cadastro seja feito com sucesso:
      // o usuário é redirecionado para a tela de login
      navigate('/login');
    })
    .catch(() => {
      // Caso ocorra erro (ex: email já cadastrado),
      // exibe uma mensagem para o usuário
      setErro('Erro ao cadastrar (email pode já existir)');
    });
  }

  // Estrutura visual da página
  return (
    <div className="auth-container">
      <div className="auth-card">

        <h1>Cadastro</h1>

        <input
          placeholder="Nome"
          value={nome}
          onChange={e => setNome(e.target.value)}
        />

        <input
          placeholder="Email"
          value={email}
          onChange={e => setEmail(e.target.value)}
        />

        <button onClick={cadastrar}>Cadastrar</button>

        {erro && <p className="erro">{erro}</p>}

      </div>
    </div>
  );
}