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

class Login extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.handleHide = this.handleHide.bind(this);
        this.state = {
            show: false
        };
    }
    handleHide() {
        this.setState({ show: false });
    }
    render() {
        return (
          <div className="modal-container">
             
			 <NavItem onClick={() => this.setState({ show: true })}>LOGIN</NavItem>
            
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
                        <Form horizontal>
                            <FormGroup controlId="formHorizontalEmail">
                                <Col componentClass={ControlLabel} sm={2}>
                                    Username
                                </Col>
                                <Col sm={10}>
                                    <FormControl type="input" placeholder="Username" />
                                </Col>
                            </FormGroup>

                            <FormGroup controlId="formHorizontalPassword">
                                <Col componentClass={ControlLabel} sm={2}>
                                    Password
                                </Col>
                                <Col sm={10}>
                                    <FormControl type="password" placeholder="Password" />
                                </Col>
                            </FormGroup>

                            <FormGroup>
                                <Col smOffset={2} sm={10}>
                                    <Checkbox>Remember me</Checkbox>
                                </Col>
                            </FormGroup>

                            <FormGroup>
                                <Col smOffset={2} sm={10}>
                                    <Button type="submit">Sign in</Button>
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