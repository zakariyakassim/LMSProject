import axios from 'axios'
require('es6-promise').polyfill();
require('isomorphic-fetch');
//import apiconnection from "./axios-instance-config";
const path = "http://172.17.25.173:8081/api";
export default {

    postAccount(data) {
        return axios.post('/accounts', data)
    },
    get(url) {
        return fetch(url, {
                method: 'GET',
                headers: {
                    Accept: 'application/json',
                },
            },
        )
    },
    getAccount() {
        return fetch('http://172.17.25.173:8080/dvds', {
                //mode: 'no-cors',
                method: 'GET',
              //  credentials: 'include',
                headers: {
                    Accept: 'application/json',
                },
            },
        )
      /*  return axios.get(path+'/accounts', {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        }) */
    },
    getZak() {
        return "zak"
    }
}
