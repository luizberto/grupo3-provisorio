import axios from 'axios';

const api = axios.create({
    baseURL: "http://18.210.124.171:8080/" //alterar para a sua API
});

export default api;