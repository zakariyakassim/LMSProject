import React from 'react';
import FormGroup from "react-bootstrap/es/FormGroup";
import FormControl from "react-bootstrap/es/FormControl";
import ControlLabel from "react-bootstrap/es/ControlLabel";
import HelpBlock from "react-bootstrap/es/HelpBlock";
import Button from "react-bootstrap/es/Button";
import Col from "react-bootstrap/es/Col";

class AddCourse extends React.Component {
    constructor(props, context) {
        super(props, context);

        this.handleChange = this.handleChange.bind(this);

        this.state = {
            value: ''
        };
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
            <form>

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
                    <ControlLabel>Add Module</ControlLabel>
                    <FormControl type="text" placeholder="Module Title"/>
                    <Button type="button">Add Module</Button>
                </FormGroup>


                <FormGroup controlId="formSubmit">
                    <Button type="submit">Submit Course</Button>
                </FormGroup>
            </form>
        );
    }
}
export default AddCourse;