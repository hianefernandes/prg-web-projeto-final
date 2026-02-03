// Importações do React Router
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

// Páginas públicas
import LoginPage from '../pages/LoginPage';
import CadastroPage from '../pages/CadastroPage';

// Layout
import Sidebar from '../components/Sidebar';

// Páginas do sistema
import UsuarioPage from '../pages/UsuarioPage';
import LivroPage from '../pages/LivroPage';

// Componente que protege as rotas
function RotaPrivada({ children }) {
  const logado = localStorage.getItem('usuarioLogado');
  return logado ? children : <Navigate to="/login" />;
}

// Layout padrão do sistema (Sidebar + conteúdo)
function LayoutSistema() {
  return (
    <div className="layout">
      <Sidebar />

      <main className="content">
        <Routes>
          <Route path="/usuarios" element={<UsuarioPage />} />
          <Route path="/livros" element={<LivroPage />} />
        </Routes>
      </main>
    </div>
  );
}

// Rotas principais
export default function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>

        {/* Rotas públicas */}
        <Route path="/login" element={<LoginPage />} />
        <Route path="/cadastro" element={<CadastroPage />} />

        {/* Rotas privadas */}
        <Route
          path="/*"
          element={
            <RotaPrivada>
              <LayoutSistema />
            </RotaPrivada>
          }
        />

      </Routes>
    </BrowserRouter>
  );
}