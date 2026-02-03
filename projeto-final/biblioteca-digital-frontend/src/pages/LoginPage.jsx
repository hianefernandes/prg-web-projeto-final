// Importa hooks do React
import { useState } from 'react';
// Importa navegação
import { useNavigate, Link } from 'react-router-dom';
// Importa api axios
import api from '../services/api';
// Importa CSS da autenticação
import '../styles/auth.css';

export default function LoginPage() {

  // Estados para armazenar email e mensagem de erro
  const [email, setEmail] = useState('');
  const [erro, setErro] = useState('');

  // Hook para redirecionar páginas
  const navigate = useNavigate();

  // Função chamada ao clicar em "Entrar"
  function login() {

    // Busca todos os usuários
    api.get('/usuarios')
      .then(response => {

        // Procura usuário com email digitado
        const usuario = response.data.find(u => u.email === email);

        // Se encontrar
        if (usuario) {
          // Salva login no navegador
          localStorage.setItem('usuarioLogado', 'true');
          // Redireciona para usuários
          navigate('/usuarios');
        } else {
          // Se não encontrar, mostra erro
          setErro('Email não encontrado');
        }
      });
  }

  return (
    <div className="auth-container">
      <div className="auth-card">

        <h1>Biblioteca Digital</h1>

        <input
          placeholder="Email"
          value={email}
          onChange={e => setEmail(e.target.value)}
        />

        <button onClick={login}>Entrar</button>

        {erro && <p className="erro">{erro}</p>}

        <p>
          Não tem conta? <Link to="/cadastro">Cadastre-se</Link>
        </p>

      </div>
    </div>
  );
}