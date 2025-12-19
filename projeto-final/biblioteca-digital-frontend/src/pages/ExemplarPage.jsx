// Página responsável pelo CRUD de Exemplares

import { useEffect, useState } from 'react';
import api from '../services/api';

export default function ExemplarPage() {
  const [exemplares, setExemplares] = useState([]);
  const [codigo, setCodigo] = useState('');
  const [livroId, setLivroId] = useState('');
  const [livros, setLivros] = useState([]);

  useEffect(() => {
    api.get('/exemplares').then(r => setExemplares(r.data));
    api.get('/livros').then(r => setLivros(r.data));
  }, []);

  function salvar() {
    api.post('/exemplares', {
      codigo,
      livroId
    }).then(() => {
      setCodigo('');
      setLivroId('');
      api.get('/exemplares').then(r => setExemplares(r.data));
    });
  }

  return (
    <div>
      <h1>Exemplares</h1>

      <input
        placeholder="Código do exemplar"
        value={codigo}
        onChange={e => setCodigo(e.target.value)}
      />

      <select onChange={e => setLivroId(e.target.value)}>
        <option value="">Selecione o livro</option>
        {livros.map(l => (
          <option key={l.id} value={l.id}>{l.titulo}</option>
        ))}
      </select>

      <button onClick={salvar}>Salvar</button>

      {exemplares.map(e => (
        <div className="card" key={e.id}>
          Código: {e.codigo}
        </div>
      ))}
    </div>
  );
}