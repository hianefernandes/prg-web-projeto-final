import { useEffect, useState } from 'react';
import api from '../services/api';

export default function AutorPage() {
  const [autores, setAutores] = useState([]);
  const [nome, setNome] = useState('');

  useEffect(() => {
    api.get('/autores').then(r => setAutores(r.data));
  }, []);

  function salvar() {
    api.post('/autores', { nome }).then(() => {
      setNome('');
      api.get('/autores').then(r => setAutores(r.data));
    });
  }

  return (
    <div>
      <h1>Autores</h1>

      <input
        placeholder="Nome do autor"
        value={nome}
        onChange={e => setNome(e.target.value)}
      />

      <button onClick={salvar}>Salvar</button>

      {autores.map(a => (
        <div className="card" key={a.id}>
          {a.nome}
        </div>
      ))}
    </div>
  );
}