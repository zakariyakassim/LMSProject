import React, { Component } from "react";
import {HelpBlock,FormGroup,FormControl, ControlLabel} from "react-bootstrap";
import classNames from 'classnames';
import Button from "react-bootstrap/es/Button";

import "./Signup.css";

export default class Signup extends Component {
    constructor(props) {
        super(props);
		
        this.state = {
            isLoading: false,
            username:"",
            email: "",
            password: "",
            confirmPassword: "",
            confirmationCode: "",
            newUser: null
        };
    }
	
	formDefaults = {
	  username: { value: '', isValid: true, message: '' },
      email: { value: '', isValid: true, message: '' },
      password: { value:'', isValid: true, message: '' },
      confirmPassword: { value: '', isValid: true, message: '' }
    }

    state = {
      ...this.formDefaults
    };

    validateForm() {
        return (
		    console.log(this),
            this.state.username.length > 0 &&
            this.state.email.length > 0 &&
            this.state.password.length > 0 &&
            this.state.password === this.state.confirmPassword
        );
    }
	
      onChange = (e) => {
        this.setState({ [e.target.name]: e.target.value });
      }
	

    validateConfirmationForm() {
        return this.state.confirmationCode.length > 0;
    }

    handleChange = event => {
        this.setState({
            [event.target.id]: event.target.value
        });
    }

    handleSubmit = async event => {
        event.preventDefault();
        this.setState({ isLoading: true });
        this.setState({ newUser: "test" });
        this.setState({ isLoading: false });
    }

    
    resetForm = () => {
        this.setState({
            ...this.state,
            username: '',
            email: '',
            password: '',
            confirmPassword: ''
        })
        alert('User Added!');
    }

    handleSubmit(e){
        alert('You course,' + this.state.value + 'has been created');
        e.preventDefault();
    }

  
    renderForm() {
	  const {username, email, password, confirmPassword } = this.state;
      const emailGroupClass = classNames('form-group',
        { 'has-error': !email.isValid }
      );
      const passwordGroupClass = classNames('form-group',
        { 'has-error': !password.isValid }
      );
      const confirmGroupClass = classNames('form-group',
        { 'has-error': !confirmPassword.isValid }
      );
        return (
            <form id="add-new-user" onSubmit={this.handleSubmit}>
                <FormGroup class="formGroup" controlId="username" bsSize="large">
                    <ControlLabel>Username</ControlLabel>
                    <FormControl
                        autoFocus
                        type="text"
						placeholder="Username"
                        value={this.state.username}
                        onChange={this.handleChange}
						
                    />
					<span className="help-block"></span>
					<br></br>
					<br></br>
                <FormGroup class="formGroup" controlId="email" bsSize="large">
                    <ControlLabel>Email</ControlLabel>
                    <FormControl
                        autoFocus
                        type="email"
						placeholder="Email Address"
                        value={this.state.email}
                        onChange={this.handleChange}
                    />
					<span className="help-block"></span>
					
                </FormGroup>
				<br></br>
					<br></br>
                <FormGroup class="formGroup" controlId="password" bsSize="large">
                    <ControlLabel>Password</ControlLabel>
                    <FormControl
                        value={this.state.password}
                        onChange={this.handleChange}
						placeholder="Password"
                        type="password"
                    />
					
                </FormGroup>
				<br></br>
					<br></br>
                <FormGroup controlId="confirmPassword" bsSize="large">
                    <ControlLabel>Confirm Password</ControlLabel>
                    <FormControl
                        value={this.state.confirmPassword}
                        onChange={this.handleChange}
						placeholder="Confirm Password"
                        type="password"
                    />
					<br></br>
					<br></br>
                </FormGroup>
                    <FormGroup controlId="confirmUser" bsSize="large">
                        <Button type='reset' onClick={this.resetForm}>Add User</Button>
                    </FormGroup>

                </FormGroup>
            </form>
        );
    }

    render() {
        return (
            <div className="Signup">
                {this.state.newUser === null
                    ? this.renderForm()
                    : this.renderConfirmationForm()}
            </div>
        );
    }
}