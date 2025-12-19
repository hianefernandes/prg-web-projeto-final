import { useEffect, useState } from 'react';
import api from '../services/api';

export default function CategoriaPage() {
  const [categorias, setCategorias] = useState([]);
  const [nome, setNome] = useState('');

  useEffect(() => {
    api.get('/categorias').then(r => setCategorias(r.data));
  }, []);

  function salvar() {
    api.post('/categorias', { nome }).then(() => {
      setNome('');
      api.get('/categorias').then(r => setCategorias(r.data));
    });
  }

  return (
    <div>
      <h1>Categorias</h1>

      <input
        placeholder="Nome da categoria"
        value={nome}
        onChange={e => setNome(e.target.value)}
      />

      <button onClick={salvar}>Salvar</button>

      {categorias.map(c => (
        <div className="card" key={c.id}>
          {c.nome}
        </div>
      ))}
    </div>
  );
}