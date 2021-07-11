import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import * as Icons from '@ant-design/icons-vue';
import axios from "axios";
//selector --div id=app
axios.defaults.baseURL = process.env.VUE_APP_SERVER;
// axios.interceptors --print logs
axios.interceptors.request.use(function (config) {
    console.log('Request：', config);
    return config;
}, error => {
    return Promise.reject(error);
});
axios.interceptors.response.use(function (response) {
    console.log('Response：', response);
    return response;
}, error => {
    console.log('Error：', error);
    return Promise.reject(error);
});

const app = createApp(App);
app.use(store).use(Antd).use(router).mount('#app');

const icons: any = Icons;
for (const i in icons) {
    app.component(i, icons[i]);
}

console.log('environment:', process.env.NODE_ENV);