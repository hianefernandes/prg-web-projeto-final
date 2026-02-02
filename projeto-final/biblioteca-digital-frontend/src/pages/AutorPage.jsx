
// Importa os hooks useEffect e useState do React
import { useEffect, useState } from 'react';
// Importa a instância do axios configurada para o backend
import api from '../services/api';

// Componente responsável pela página de Autores
export default function AutorPage() {
  // Estado que armazena a lista de autores vindos do backend
  const [autores, setAutores] = useState([]);
  // Estado que controla o valor do input de nome do autor
  const [nome, setNome] = useState('');

  // useEffect executa quando o componente é carregado
  useEffect(() => {
    // Busca todos os autores no backend
    api.get('/autores').then(r => setAutores(r.data));
  }, []);

  // Função responsável por salvar um novo autor
  function salvar() {
    // Envia o nome do autor para o backend
    api.post('/autores', { nome }).then(() => {
      // Limpa o campo após salvar
      setNome('');
      // Atualiza a lista de autores
      api.get('/autores').then(r => setAutores(r.data));
    });
  }

  // JSX renderizado na tela
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