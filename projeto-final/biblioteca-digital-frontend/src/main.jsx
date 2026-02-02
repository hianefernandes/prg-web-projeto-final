// Importa a biblioteca React
import React from 'react';
// Importa o ReactDOM para renderizar a aplicação no navegador
import ReactDOM from 'react-dom/client';
// Importa o componente principal da aplicação
import App from './App';
// Importa o arquivo de estilos globais
import './styles/global.css';

// Cria a raiz da aplicação React dentro da div com id="root"
ReactDOM.createRoot(document.getElementById('root')).render(
  // StrictMode ajuda a identificar problemas durante o desenvolvimento
  <React.StrictMode>
    <App />
  </React.StrictMode>
);