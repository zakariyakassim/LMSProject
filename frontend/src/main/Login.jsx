import React from 'react';
import Button from "react-bootstrap/es/Button";
import Modal from "react-bootstrap/es/Modal";
import NavItem from "react-bootstrap/es/NavItem";
import Form from "react-bootstrap/es/Form";
import FormGroup from "react-bootstrap/es/FormGroup";
import Col from "react-bootstrap/es/Col";
import {Checkbox} from "react-bootstrap";
import FormControl from "react-bootstrap/es/FormControl";
import ControlLabel from "react-bootstrap/es/ControlLabel";
import {Nav} from 'react-bootstrap';

import Auth from './AuthService';
import {checkResponseStatus, loginResponseHandler} from './responseHandler';
import {defaultErrorHandler} from './errorHandler';


import './Login.css';


class Login extends React.Component {
    constructor(props) {
        super(props);
        this.handleHide = this.handleHide.bind(this);
        this.state = {
            show: false
        };
        this.state = {
			userDetails:{
            username: '',
            password: ''
			},
			submitted:false,
			currentUser: null,
			isAuthenticated: false,
			isLoading:false
        };
		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
    }
	reset = () => {
		this.setState({
             userDetails:{
				username: '',
				password: ''
			 },
			route: '/',
		error:null});
	};
	componentDidMount = async () => {
		console.log('app mounting....');
          if (await Auth.loggedIn()){
				this.setState({route:'login'});
	};
	}
	componentDidUpdate(){
		if(this.state.route!=='login' && !Auth.loggedIn()){
			this.setState({route:'login'})
		}
	}
	
    handleHide() {
        this.setState({show: false});
    }

    handleShow() {
        this.setState({show: true});
    }
	handleChange = (e) => {
		let {userDetails} = this.state;

		const target = e.target ;
		
		userDetails[target.name] = target.value,

		this.setState({userDetails});
	}
	
	handleSubmit = async e => {
		console.log('login');
		e.preventDefault();

		fetch('http://localhost:8080/api/login', {
			method:'POST',
			headers:{
				'Accept':'application/json',
				'content-Type':'application/json'
			},
			body:JSON.stringify(this.state.userDetails)
		}).then(checkResponseStatus)
		.then(response => loginResponseHandler(response, this.customLoginHandler))
		.catch(error => defaultErrorHandler(error, this.customLoginHandler));
	};
	
	customLoginHandler = () => {
		this.setState({route:'login'});
	};
	
	logoutHandler = () => {
		Auth.logOut();
		this.reset();
	};
		
	

    render() {
	const {userDetails} = this.state;
        return (
            <div className="modal-container">

                <p onClick={() => this.setState({show: true})} href="#">LOGIN</p>

                <Modal
                    show={this.state.show}
                    onHide={this.handleHide}
                    container={this}
                    aria-labelledby="contained-modal-title">

                    <Modal.Header closeButton>
                        <Modal.Title id="contained-modal-title">
                            Login
                        </Modal.Title>
              </Modal.Header>
            <Modal.Body>
          <form onSubmit={this.handleSubmit}>
		  
        <fieldset>
		
            <legend>Please Login</legend>
			
            <label htmlFor="username">Username</label>
			
            <input type="text" id="username" name="username" value={userDetails.username} onChange={this.handleChange}/>
			<br/>
			<br/>
            <label htmlFor="password">Password</label>
			
            <input type="password" id="password" name="password" value={userDetails.password} onChange={this.handleChange}/>
			
            <div className="form-actions">
                <button type="submit" className="btn">Log in</button>
            </div>
			
        </fieldset>
    </form>
      </Modal.Body>
    <Modal.Footer>
        <Button onClick={this.handleHide}>Close</Button>
 </Modal.Footer>
   </Modal>
 </div>
        );
    }
}

export default Login;