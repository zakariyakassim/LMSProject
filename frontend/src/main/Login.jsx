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
		this.handleShow = this.handleShow.bind(this);
		
        this.state = {
            show: false
        };
		
        this.state = {
            username: '',
            password: '',
			submitted:false,
			currentUser: null,
			isAuthenticated: false,
			isLoading:false
        };
		
		this.handleChangeUsername = this.handleChangeUsername.bind(this);
		this.handleChangePassword = this.handleChangePassword.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.getCurrentUser = this.getCurrentUser.bind(this);
		this.logout = this.logout.bind(this);
    }
	
	getCurrentUser = () =>{
		fetch("/security/getUsername")
		.then(response => response.text())
		.then(json => {this.setState({
			username: json.username
			});
		})
		.catch();  
	}
	
	componentWillMount() {
		this.getCurrentUser();
	}
	
    handleHide() {
        this.setState({show: false});
    }

    handleShow() {
        this.setState({show: true});
    }
	onChange = (e)=> {
		this.user({[e.target.name]:e.target.value});
	}
	handleChangeUsername(e){
		 this.setState({username: e.target.value});
	}
	handleChangePassword(e){
		this.setState({password: e.target.value});	
	}

	handleSubmit(e){
	e.preventDefault();
	console.log(this.state.username);
	}
	
	logout(){
		fetch("/logout",{
			method:"post"
			})
		.then(() => window.location = "/").catch("/");
	}
	

    render() {

        return (
            <div  className="modal-container">

                <p onClick={() => this.setState({show: true})} href="#">LOGIN</p>

                <Modal
				    id="login-modal-content"
                    show={this.state.show}
                    onHide={this.handleHide}
                    container={this}
                    aria-labelledby="contained-modal-title">

                    <Modal.Header closeButton>
                        <Modal.Title id="contained-modal-title">
                            Login
                        </Modal.Title>
              </Modal.Header>
            <Modal.Body id="login-body">
	<form name="f"  action='/login' method="POST">
		  
        <fieldset>
		
            <legend>Please Login</legend>
			
            <label htmlFor="username">Username</label>
			
            <input type="text" id="username" name="username" value={this.username} />
			<br/>
			<br/>
            <label htmlFor="password">Password</label>
			
            <input type="password" id="password" name="password" value={this.password} />
			
            <div className="form-actions">
                <button type="submit" onClick={this.handleSubmit} className ="btn">Log in</button>
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