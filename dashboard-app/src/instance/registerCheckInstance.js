
import axios from 'axios';

const registerCheckInstance = axios.create({
  baseURL: 'http://localhost:8080', 
  headers: {
    'Content-Type': 'application/json',
  },
});

registerCheckInstance.interceptors.request.use(
  (config) => {
    const token = btoa('user:pass'); 
    config.headers.Authorization = `Basic ${token}`;
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default registerCheckInstance;