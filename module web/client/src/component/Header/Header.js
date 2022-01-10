import React from 'react';
import './Header.scss';
import logo from "assets/logo.png";

const header = () => {
    return (
        <div className='header'>
            <img src={logo}/>
        </div>
    );
};

export default header;