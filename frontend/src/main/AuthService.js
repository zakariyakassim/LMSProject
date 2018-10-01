import decode from 'jwt-decode';
import {checkResponseStatus} from './responseHandler';
import headers from './headers';

export default{
    logIn(auth) {
     localStorage.auth = JSON.stringify(auth);
    },
	
	logOut(){
		delete localStorage.auth;
	},

    loggedIn() {
       return localStorage.auth && fetch (
	   'http://localhost:8080/api/login',
		   {headers:headers()})
		   .then(checkResponseStatus)
		   .then(() => {return true})
		   .catch(this.refreshToken)
		   .catch(() => {return false});
    },

    isTokenExpired(token) {
        try {
            const decoded = decode(token);
            if (decoded.exp < Date.now() / 1000) { // Checking if token is expired. N
                return true;
            }
            else
                return false;
        }
        catch (err) {
            return false;
        }
    },

    fetch(url, options) {
        // performs api calls sending the required authentication headers
        const headers = {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }

        // Setting Authorization header
        // Authorization: Bearer xxxxxxx.xxxxxxxx.xxxxxx
        if (this.loggedIn()) {
            headers['Authorization'] = 'Bearer ' + this.getToken()
        }

        return fetch(url, {
            headers,
            ...options
        })
            .then(this._checkStatus)
            .then(response => response.json())
    },

    _checkStatus(response) {
        // raises an error in case response status is not a success
        if (response.status >= 200 && response.status < 300) { // Success status lies between 200 to 300
            return response
        } else {
            var error = new Error(response.statusText)
            error.response = response
            throw error
        }
    }
};