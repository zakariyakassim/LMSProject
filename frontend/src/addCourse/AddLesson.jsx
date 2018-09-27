import React from 'react';
import FormGroup from "react-bootstrap/es/FormGroup";
import FormControl from "react-bootstrap/es/FormControl";
import ControlLabel from "react-bootstrap/es/ControlLabel";
import HelpBlock from "react-bootstrap/es/HelpBlock";
import Button from "react-bootstrap/es/Button";
import Col from "react-bootstrap/es/Col";


import './AddLesson.css';

class AddLesson extends React.Component {
	constructor(props) {
        super(props);

        this.state = {
            name:"",
			difficulty:"",
            content: "",
            data: null,
            listDataFromChild: null
        };


        this.handleChangeName = this.handleChangeName.bind(this);
		this.handleChangedifficulty = this.handleChangedifficulty.bind(this);
        this.handleChangeContent = this.handleChangeContent.bind(this);
        
    }

    myCallback = (dataFromChild) => {

        this.setState({ listDataFromChild: dataFromChild });
    }

    
  handleChangeName(e) {
    this.setState({ name: e.target.value });
  }
   handleChangedifficulty(e) {
    this.setState({ difficulty: e.target.value });
  }
   handleChangeContent(e) {

    this.setState({ content: e.target.value });
   }
    handleClose() {
    this.setState({ show: false });
  }
    handleShow() {
    this.setState({ show: true });
  }


render() {
    return (
        <div className="AddLesson-body">
		 <div className = "LessonHeading">
		   <div className = "lesson-left-heading">
            <FormGroup controlId="formLessonName" >
                    <ControlLabel>Name</ControlLabel>
                    <FormControl type="text" 
                        defaultValue={this.state.name}
						style={{width:'300px'}} 
                        placeholder="Name of Lesson"
                        onChange={this.handleChangeName}/>
            </FormGroup>
			
			<FormGroup controlId="formLessonDifficulty" >
                    <ControlLabel>Difficulty</ControlLabel>
                    <FormControl type="text" 
                        defaultValue={this.state.difficulty}
                        placeholder="Lesson difficulty"
						style={{width:'300px'}} 
                        onChange={this.handleChangedifficulty}/>
            </FormGroup>
			 </div>
			 <div className = "lesson-right-heading">
			 <Button className="module-button" bsStyle="success" bsSize="large" onClick={this.handleShow}>Upload Video</Button>			
			 </div>
			
			</div>
			<div className = "LessonContent">
            <FormGroup controlId="formContent">
                    <ControlLabel>Lesson Content</ControlLabel>
                    <FormControl type = "text" defaultValue={this.state.content} 
					componentClass="textarea" placeholder="Insert Your Content here" 
					style={{height: '500px', width:'800px'}} 
					onChange={this.handleChangeContent}/>
                </FormGroup>
				</div>
        </div>
    );
}
}

export default AddLesson;