import React from 'react';
import './Footer.css';

class Footer extends React.Component {
	constructor(props){
		super(props);
		this.state = {value:' '};
		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}
	handleChange(event){
		this.setState({value:event.target.value});
	}
	handleSubmit(event){
		alert('Our services are currently unavailable right now, please try again later ' + this.state.value);
		event.preventDefault();
	}
		
	render(){
		return(
			<div className="footer" id="footer-row">
				<div id="footer-row-info">
                    <form id="footer-contact" onSubmit={this.handleSubmit}>
						<h5>Contact Us</h5>
						<label id="contact-email">E-Mail</label> <p />
						<input type="text" id="contact-email" name="contact-email" placeholder="Your E-Mail..." />
                        <p />
						<label id="contact-subject">Subject</label> <p />
                        <textarea id="contact-subject" name="contact-subject" placeholder="Say something to us..."/>
						<p />
						<input type="submit" value="Submit" />
					</form>
				</div>
				<div className="vl">
                </div>
				<div id="footer-row-info">
					<h5>About Us</h5>
					<p>QC Tutorials was created with several goals in mind, however at the
						forefront was the idea that everyone should be able to learn to our
						high standards, those who use us know that the system is intuitive,
						the trainers are impecable and the learning experience thrives under
						the quality we provide.</p>
				</div>
			</div>
		);
	}
}

export default Footer;