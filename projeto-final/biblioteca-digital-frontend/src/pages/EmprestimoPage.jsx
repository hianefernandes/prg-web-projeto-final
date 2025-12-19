// Página responsável pelo controle de empréstimos

import { useEffect, useState } from 'react';
import api from '../services/api';

export default function EmprestimoPage() {
  const [usuarios, setUsuarios] = useState([]);
  const [exemplares, setExemplares] = useState([]);
  const [emprestimos, setEmprestimos] = useState([]);
  const [usuarioId, setUsuarioId] = useState('');
  const [exemplarId, setExemplarId] = useState('');

  useEffect(() => {
    api.get('/usuarios').then(r => setUsuarios(r.data));
    api.get('/exemplares').then(r => setExemplares(r.data));
    api.get('/emprestimos').then(r => setEmprestimos(r.data));
  }, []);

  function salvar() {
    api.post('/emprestimos', {
      usuarioId,
      exemplarId,
      dataEmprestimo: new Date().toISOString().substring(0,10)
    }).then(() => {
      api.get('/emprestimos').then(r => setEmprestimos(r.data));
    });
  }

  return (
    <div>
      <h1>Empréstimos</h1>

      <select onChange={e => setUsuarioId(e.target.value)}>
        <option value="">Usuário</option>
        {usuarios.map(u => (
          <option key={u.id} value={u.id}>{u.nome}</option>
        ))}
      </select>

      <select onChange={e => setExemplarId(e.target.value)}>
        <option value="">Exemplar</option>
        {exemplares.map(e => (
          <option key={e.id} value={e.id}>{e.codigo}</option>
        ))}
      </select>

      <button onClick={salvar}>Registrar</button>

      {emprestimos.map(emp => (
        <div className="card" key={emp.id}>
          Empréstimo #{emp.id}
        </div>
      ))}
    </div>
  );
}