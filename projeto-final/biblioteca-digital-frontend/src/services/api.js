// Importa a biblioteca axios para requisições HTTP
import axios from 'axios';

// Cria uma instância do axios com configurações padrão
const api = axios.create({
  // URL base da API backend (Spring Boot)
  baseURL: 'http://localhost:8080'
});

// Exporta a instância para ser usada em outros arquivos
export default api;