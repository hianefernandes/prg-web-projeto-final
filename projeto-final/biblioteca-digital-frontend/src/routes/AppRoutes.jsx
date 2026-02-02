// Arquivo responsável por mapear as rotas da aplicação

// Importa componentes de roteamento do React Router
import { BrowserRouter, Routes, Route } from 'react-router-dom';
// Importa o menu lateral
import Sidebar from '../components/Sidebar';

// Importa as páginas da aplicação
import UsuarioPage from '../pages/UsuarioPage';
import AutorPage from '../pages/AutorPage';
import CategoriaPage from '../pages/CategoriaPage';

// Função que define todas as rotas do sistema
export default function AppRoutes() {
  // Retorna a estrutura de navegação
  return (
    <BrowserRouter>
      <div className="layout">
        {/* Menu lateral fixo */}
        <Sidebar />

        {/* Área onde as páginas são carregadas */}
        <main className="content">
          <Routes>
            <Route path="/usuarios" element={<UsuarioPage />} />
            <Route path="/autores" element={<AutorPage />} />
            <Route path="/categorias" element={<CategoriaPage />} />
          </Routes>
        </main>
      </div>
    </BrowserRouter>
  );
}