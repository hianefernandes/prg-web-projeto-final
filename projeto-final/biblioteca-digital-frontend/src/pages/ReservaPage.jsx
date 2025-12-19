// Página responsável pelas reservas de livros

import { useEffect, useState } from 'react';
import api from '../services/api';

export default function ReservaPage() {
  const [reservas, setReservas] = useState([]);
  const [usuarios, setUsuarios] = useState([]);
  const [livros, setLivros] = useState([]);
  const [usuarioId, setUsuarioId] = useState('');
  const [livroId, setLivroId] = useState('');

  useEffect(() => {
    api.get('/usuarios').then(r => setUsuarios(r.data));
    api.get('/livros').then(r => setLivros(r.data));
    api.get('/reservas').then(r => setReservas(r.data));
  }, []);

  function salvar() {
    api.post('/reservas', {
      usuarioId,
      livroId,
      dataReserva: new Date().toISOString().substring(0,10)
    }).then(() => {
      api.get('/reservas').then(r => setReservas(r.data));
    });
  }

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