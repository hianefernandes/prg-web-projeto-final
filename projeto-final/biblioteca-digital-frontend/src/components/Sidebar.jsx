// Componente responsável pelo menu lateral
// Ele aparece em todas as páginas

import { Link } from 'react-router-dom';

export default function Sidebar() {
  return (
    <aside className="sidebar">
      <h2>Biblioteca</h2>

      {/* Links de navegação */}
      <nav>
        <Link to="/usuarios">Usuários</Link>
        <Link to="/autores">Autores</Link>
        <Link to="/categorias">Categorias</Link>
        <Link to="/livros">Livros</Link>
        <Link to="/exemplares">Exemplares</Link>
        <Link to="/emprestimos">Empréstimos</Link>
        <Link to="/reservas">Reservas</Link>
        <Link to="/avaliacoes">Avaliações</Link>
      </nav>
    </aside>
  );
}