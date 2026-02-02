// Página responsável: avaliações de livros

// Importa hooks do React
import { useEffect, useState } from 'react';
// Importa a API
import api from '../services/api';

// Página responsável pelas avaliações dos livros
export default function AvaliacaoPage() {
  // Estados principais
  const [avaliacoes, setAvaliacoes] = useState([]);
  const [nota, setNota] = useState('');
  const [comentario, setComentario] = useState('');

  // Estados auxiliares
  const [usuarios, setUsuarios] = useState([]);
  const [livros, setLivros] = useState([]);
  const [usuarioId, setUsuarioId] = useState('');
  const [livroId, setLivroId] = useState('');

  // Carrega avaliações, usuários e livros ao abrir a página
  useEffect(() => {
    api.get('/avaliacoes').then(r => setAvaliacoes(r.data));
    api.get('/usuarios').then(r => setUsuarios(r.data));
    api.get('/livros').then(r => setLivros(r.data));
  }, []);

  // Salva uma nova avaliação
  function salvar() {
    api.post('/avaliacoes', {
      nota,
      comentario,
      usuarioId,
      livroId
    }).then(() => {
      // Limpa os campos
      setNota('');
      setComentario('');
      // Atualiza a lista
      api.get('/avaliacoes').then(r => setAvaliacoes(r.data));
    });
  }

  return (
    <div>
      <h1>Avaliações</h1>

      <input
        placeholder="Nota (1 a 5)"
        value={nota}
        onChange={e => setNota(e.target.value)}
      />

      <input
        placeholder="Comentário"
        value={comentario}
        onChange={e => setComentario(e.target.value)}
      />

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

      <button onClick={salvar}>Avaliar</button>

      {avaliacoes.map(a => (
        <div className="card" key={a.id}>
          Nota: {a.nota} ⭐
        </div>
      ))}
    </div>
  );
}