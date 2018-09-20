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

import './Login.css';


class Login extends React.Component {
    constructor(props) {
        super(props);
        this.handleHide = this.handleHide.bind(this);
        this.state = {
            show: false
        };
        this.state = {
            userName: '',
            password: '',
			submitted:false
        };
		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleHide() {
        this.setState({show: false});
    }

    handleShow() {
        this.setState({show: true});
    }
	handleChange(e) {
		const {name, value } = e.target ;
		this.setState({[name]: value });
	}
	handleSubmit(e){
		e.preventDefault();
		
	}

    render() {
		const { loggingIn } = this.props;
		const {username, password, submitted} = this.state;
		
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
          <Form onSubmit={this.handleSubmit} className="form" horizontal>
         <FormGroup  controlId="formHorizontalEmail">
             <Col className ={'form-group' + (submitted && !username ? ' has-error' : '')} componentClass={ControlLabel} sm={2}>
              Username
              </Col>
             <Col sm={10}>
			 {submitted && !username && <div className="help-block">Username is required</div>
				 }
             <FormControl className="loginBar" name="username" value={username} onChange={this.handleChange} type="input" placeholder="Username"/>
				 
             </Col>
             </FormGroup>

             <FormGroup controlId="formHorizontalPassword">
                 <Col className ={'form-group' + (submitted && !password ? ' has-error' : '')} componentClass={ControlLabel} sm={2}>
                   Password
                    </Col>
                <Col sm={10}>
				{submitted && !password && <div className="help-block">Password is required</div>}
				
                <FormControl className="loginBar" name="password" value={password} onChange={this.handleChange} type="password" placeholder="Password"/>
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