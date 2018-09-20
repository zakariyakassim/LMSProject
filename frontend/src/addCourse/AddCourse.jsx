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
    constructor(props) {
        super(props);

        this.state = {
            title:"",
            description: "",
            data: null,
            listDataFromChild: null
        };


        this.handleChangeTitle = this.handleChangeTitle.bind(this);
        this.handleChangeDescription = this.handleChangeDescription.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    myCallback = (dataFromChild) => {

        this.setState({ listDataFromChild: dataFromChild });
    }

    handleSubmit(e){
        for (var i =0; i < this.state.listDataFromChild.length; i++){
            this.state.listDataFromChild[i] = {name:  this.state.listDataFromChild[i] , description: "please add a description" };
        }
        
        fetch('http://localhost:8080/api/addCourseAndModule', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                name: this.state.title,
                description: this.state.description,
                modules: this.state.listDataFromChild
            })
        });
        
        console.log(this.state.listDataFromChild);
        
        window.location.reload();
        
        
       
    }


handleChangeTitle(e) {
    this.setState({ title: e.target.value });

}
handleChangeDescription(e) {

    this.setState({ description: e.target.value });
}

handleItemClick = (e) => {console.log(e.target.innerHTML)}



render() {
    return (
        <div className="AddCourse-body">
            <form id="addCourse-form-container">

                <FormGroup controlId="formCourse" >
                    <ControlLabel>Course Title</ControlLabel>
                    <FormControl type="text" 
                        defaultValue={this.state.title}
                        placeholder="Course Title"
                        onChange={this.handleChangeTitle}/>

                </FormGroup>


                <FormGroup controlId="formAbout">
                    <ControlLabel>About your course</ControlLabel>
                    <FormControl type = "text" defaultValue={this.state.description} componentClass="textarea" placeholder="Tell us about your course" style={{height: '300px'}} onChange={this.handleChangeDescription}/>
                </FormGroup>


                <FormGroup controlId="formModule">
                    <AddModule callbackFromParent={this.myCallback}/>
                </FormGroup>


                <FormGroup controlId="formSubmit">
                    <Button  onClick={this.handleSubmit}>Submit Course</Button>
                </FormGroup>
            </form>
        </div>
    );
}
}
export default AddCourse;