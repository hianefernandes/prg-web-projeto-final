// Página responsável pelo CRUD de Livros

// Importa o hook useEffect para executar ações ao carregar a página
import { useEffect, useState } from 'react';
// Importa a instância do axios configurada
import api from '../services/api';

export default function LivroPage() {
  // Estado para livros
  const [livros, setLivros] = useState([]);
  const [titulo, setTitulo] = useState('');
  const [autorId, setAutorId] = useState('');
  const [categoriaId, setCategoriaId] = useState('');
  const [autores, setAutores] = useState([]);
  const [categorias, setCategorias] = useState([]);

  // Busca livros ao carregar a tela
  // Carrega livros, autores e categorias ao abrir a página
  useEffect(() => {
    api.get('/livros').then(r => setLivros(r.data));
    api.get('/autores').then(r => setAutores(r.data));
    api.get('/categorias').then(r => setCategorias(r.data));
  }, []);

  // Salva novo livro
  function salvarLivro() {
    api.post('/livros', {
      titulo,
      autorId,
      categoriaId
    }).then(() => {
      setTitulo('');
      setAutorId('');
      setCategoriaId('');
      api.get('/livros').then(r => setLivros(r.data));
    });
  }

  return (
    <div>
      <h1>Livros</h1>

      <input
        placeholder="Título do livro"
        value={titulo}
        onChange={e => setTitulo(e.target.value)}
      />

      <select onChange={e => setAutorId(e.target.value)}>
        <option value="">Selecione o autor</option>
        {autores.map(a => (
          <option key={a.id} value={a.id}>{a.nome}</option>
        ))}
      </select>

      <select onChange={e => setCategoriaId(e.target.value)}>
        <option value="">Selecione a categoria</option>
        {categorias.map(c => (
          <option key={c.id} value={c.id}>{c.nome}</option>
        ))}
      </select>

      <button onClick={salvarLivro}>Salvar</button>

      {livros.map(l => (
        <div className="card" key={l.id}>
          {l.titulo}
        </div>
      ))}
    </div>
  );
}