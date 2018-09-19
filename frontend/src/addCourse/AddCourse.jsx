import React from 'react';
import FormGroup from "react-bootstrap/es/FormGroup";
import FormControl from "react-bootstrap/es/FormControl";
import ControlLabel from "react-bootstrap/es/ControlLabel";
import HelpBlock from "react-bootstrap/es/HelpBlock";
import Button from "react-bootstrap/es/Button";
import Col from "react-bootstrap/es/Col";
import AddModule from "./AddModule";

import './AddCourse.css';

class AddCourse extends React.Component {
    constructor(props, context) {
        super(props, context);

        this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);

        this.state = {
            value: ''
        };
    }

	handleSubmit(e){
		alert('Your course,  ' + this.state.value + '   has been created');
	}
	
    getValidationState() {
        const length = this.state.value.length;
        if (length > 10) return 'success';
        else if (length > 5) return 'warning';
        else if (length > 0) return 'error';
        return null;
    }

    handleChange(e) {
        this.setState({ value: e.target.value });
    }

    handleItemClick = (e) => {console.log(e.target.innerHTML)}

    render() {
        return (
		<div className="AddCourse-body">
            <form id="addCourse-form-container">

                <FormGroup controlId="formCourse" validationState={this.getValidationState()}>
                    <ControlLabel>Course Title</ControlLabel>
                    <FormControl type="text" value={this.state.value} placeholder="Course Title" onChange={this.handleChange}/>
                    <FormControl.Feedback />
                </FormGroup>


                <FormGroup controlId="formAbout">
                    <ControlLabel>About your course</ControlLabel>
                    <FormControl componentClass="textarea" placeholder="Tell us about your course" style={{height: '300px'}}/>
                </FormGroup>


                <FormGroup controlId="formModule">
                    <AddModule/>
                </FormGroup>


                <FormGroup controlId="formSubmit">
                    <Button type="submit" onClick={this.handleSubmit}>Submit Course</Button>
                </FormGroup>
            </form>
			</div>
        );
    }
}
export default AddCourse;