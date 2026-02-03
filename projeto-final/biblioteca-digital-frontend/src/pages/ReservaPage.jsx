// Página responsável pelas reservas de livros

// Importa hooks do React
import { useEffect, useState } from 'react';
// Importa a instância do axios configurada
import api from '../services/api';

// Estados da página
// Lista de reservas já cadastradas
export default function ReservaPage() {
  const [reservas, setReservas] = useState([]);
  // Lista de usuários disponíveis
  const [usuarios, setUsuarios] = useState([]);
  // Lista de usuários disponíveis
  const [livros, setLivros] = useState([]);
  // Usuário selecionado para a reserva
  const [usuarioId, setUsuarioId] = useState('');
  // Livro selecionado para a reserva
  const [livroId, setLivroId] = useState('');

  // Executa quando a página carrega
  useEffect(() => {
    // Busca usuários no backend
    api.get('/usuarios').then(r => setUsuarios(r.data));
    // Busca livros no backend
    api.get('/livros').then(r => setLivros(r.data));
    // Busca reservas já cadastradas
    api.get('/reservas').then(r => setReservas(r.data));
  }, []);

  // Função para salvar nova reserva
  function salvar() {
    // Envia requisição POST para criar uma reserva
    api.post('/reservas', {
      usuarioId,     // ID do usuário selecionado
      livroId,       // ID do livro selecionado
      dataReserva: new Date().toISOString().substring(0,10)
    }).then(() => {
      // Após salvar, atualiza a lista de reservas
      api.get('/reservas').then(r => setReservas(r.data));
    });
  }

  // Estrutura visual da página
  return (
    <div>
      <h1>Reservas</h1>

      <select onChange={e => setUsuarioId(e.target.value)}>
        <option value="">Usuário</option>
        {usuarios.map(u => (
          <option key={u.id} value={u.id}>{u.nome}</option>
        ))}
      </select>

      <select onChange={e => setLivroId(e.target.value)}>
        <option value="">Livro</option>
        {livros.map(l => (
          <option key={l.id} value={l.id}>{l.titulo}</option>
        ))}
      </select>

      <button onClick={salvar}>Reservar</button>

      {reservas.map(r => (
        <div className="card" key={r.id}>
          Reserva #{r.id}
        </div>
      ))}
    </div>
  );
}