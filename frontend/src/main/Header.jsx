import React from 'react';
import {Link}from 'react-router-dom';

import MainNav from './MainNav';

const Header = () => {
 return (
      <div id="topHead">
	   <div >
	   <Link to = "/"><h2>LMS</h2></Link>
        <MainNav/>
	   </div>
       </div>
    );
 }
 
 export default Header;