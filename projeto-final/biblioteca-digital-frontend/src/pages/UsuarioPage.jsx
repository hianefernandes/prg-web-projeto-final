// Página responsável pelo CRUD de usuários

// Importa o hook useEffect para executar ações ao carregar a página
import { useEffect, useState } from 'react';
// Importa a instância do axios configurada
import api from '../services/api';

export default function UsuarioPage() {
  // Estado para armazenar a lista de usuários
  const [usuarios, setUsuarios] = useState([]);
  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');

  // Executa quando a página é carregada
  useEffect(() => {
    carregarUsuarios();
  }, []);

  // Busca usuários no backend
  function carregarUsuarios() {
    // Faz requisição GET para o backend
    api.get('/usuarios')
      // Salva os usuários retornados no estado
      .then(response => setUsuarios(response.data));
  }

  // Envia novo usuário
  function salvarUsuario() {
    api.post('/usuarios', {
      nome,
      email,
      tipo: 'LEITOR'
    }).then(() => {
      setNome('');
      setEmail('');
      carregarUsuarios();
    });
  }

  // Exclui usuário
  function deletarUsuario(id) {
    api.delete(`/usuarios/${id}`)
      .then(() => carregarUsuarios());
  }

  return (
    <div>
      <h1>Usuários</h1>

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

      <button onClick={salvarUsuario}>Salvar</button>

      {usuarios.map(usuario => (
        <div className="card" key={usuario.id}>
          <p>{usuario.nome}</p>
          <p>{usuario.email}</p>
          <button onClick={() => deletarUsuario(usuario.id)}>
            Excluir
          </button>
        </div>
      ))}
    </div>
  );
}