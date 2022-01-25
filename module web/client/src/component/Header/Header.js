import React from 'react';
import './Header.scss';
import logo from "assets/logo.png";
import PopUp from 'component/PopUp/PopUp';


const header = () => {
    return (
        <div className='header'>
            <img src={logo}/>
            
            <PopUp/>
        </div>
    );
};

export default header;