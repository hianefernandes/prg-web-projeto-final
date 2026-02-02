// Componente responsável pelo menu lateral
// Ele aparece em todas as páginas

// Importa o componente Link para navegação sem recarregar a página
import { Link } from 'react-router-dom';

// Função que define o menu lateral
export default function Sidebar() {
  // Retorna o JSX do menu
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