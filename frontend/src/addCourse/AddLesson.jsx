import React from 'react';

import FormGroup from "react-bootstrap/es/FormGroup";
import FormControl from "react-bootstrap/es/FormControl";
import ControlLabel from "react-bootstrap/es/ControlLabel";

import Button from "react-bootstrap/es/Button";

import PropTypes from 'prop-types';


import './AddLesson.css';

const propTypes ={
	id: PropTypes.string.isRequired
};

class AddLesson extends React.Component {

	constructor(props) {
        super(props);

        this.state = {
            name:"",
			difficulty:"",
            content: "",
			duration: 60,
			qa:"lesson",
			trainer_name:"Trainer",
            data: null,
			listDataFromChild: null,
			value: []
        };
		
		
        this.handleChangeName = this.handleChangeName.bind(this);
		this.handleChangedifficulty = this.handleChangedifficulty.bind(this);
        this.handleChangeContent = this.handleChangeContent.bind(this);
		this.handleLessonSubmit = this.handleLessonSubmit.bind(this);
    }

	handleLessonSubmit(e){
		e.preventDefault()
		
        fetch('http://localhost:8080/api/addLesson', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                name: this.state.name,
				difficulty: this.state.difficulty,
                content: this.state.content
            })
        });
     console.log(this);		
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
 

   
render() {

    return (
	<div className="AddLesson-Modal">
        <div className="AddLesson-body">
		<FormGroup>
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
			 <Button className="module-button" bsStyle="info" bsSize="large" onClick='#'>Upload Video</Button>			
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
				
			<div className="lessonBtn">
			<Button onClick={this.handleLessonSubmit} bsStyle="success">Submit Lesson</Button>
	       </div>
		</FormGroup>
		</div>
	</div>
    );
}
}
AddLesson.propTypes = propTypes;

export default AddLesson;