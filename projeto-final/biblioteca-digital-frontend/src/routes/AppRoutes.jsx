// Arquivo responsável por mapear as rotas da aplicação

import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Sidebar from '../components/Sidebar';

// Páginas
import UsuarioPage from '../pages/UsuarioPage';
import AutorPage from '../pages/AutorPage';
import CategoriaPage from '../pages/CategoriaPage';

export default function AppRoutes() {
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