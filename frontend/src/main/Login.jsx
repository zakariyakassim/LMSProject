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
            username: '',
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
		this.setState({[e.target.id]: e.target.value });
	}
	handleSubmit(e) {
		e.preventDefault();
		const { username, password } = this.state;
        const { dispatch } = this.props;

}
	

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
          <form onSubmit={this.handleSubmit} action="{/login}" method="post">
		  
        <fieldset>
		
            <legend>Please Login</legend>
			
            <label for="username">Username</label>
			
            <input type="text" id="username" name="username"/>
			<br/>
			<br/>
            <label for="password">Password</label>
			
            <input type="password" id="password" name="password"/>
			
            <div class="form-actions">
                <button type="submit" class="btn">Log in</button>
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