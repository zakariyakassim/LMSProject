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
import AuthService from './AuthService';

import axios from 'axios';
import './Login.css';

class Login extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.handleHide = this.handleHide.bind(this);
        this.state = {
            show: false
        };
        this.user = {
            userName: '',
            password: ''
        };

        this.Auth = new AuthService();
    }

    handleHide() {
        this.setState({show: false});
    }

    handleShow() {
        this.setState({show: true});
    }

    onChange = (e) => {
        this.user({[e.target.name]: e.target.value});
    };

    handleSubmit = (e) => {
        e.preventDefault();

        console.log("Account has logged in ");

        this.Auth.login('jharry', 'test')
            .then(res => {
                this.props.history.replace('/');
                console.log(res.data)
            })
            .catch(err => {
                alert(err);
            });

        axios('http://192.168.1.111:8080/api/user', {
            method: 'POST',
            auth: {
                username: 'jharry',
                password: 'test'
            }
        })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            })
    };

    render() {
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
                        <Form className="form" horizontal>
                            <FormGroup  controlId="formHorizontalEmail">
                                <Col componentClass={ControlLabel} sm={2}>
                                    Username
                                </Col>
                                <Col sm={10}>
                                    <FormControl className="loginBar" type="input" placeholder="Username"/>
                                </Col>
                            </FormGroup>

                            <FormGroup controlId="formHorizontalPassword">
                                <Col componentClass={ControlLabel} sm={2}>
                                    Password
                                </Col>
                                <Col sm={10}>
                                    <FormControl className="loginBar" type="password" placeholder="Password"/>
                                </Col>
                            </FormGroup>

                            <FormGroup>
                                <Col smOffset={2} sm={10}>
                                    <Button type="submit" onClick={this.handleSubmit}>Sign in</Button>
                                </Col>
                            </FormGroup>
                        </Form>
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