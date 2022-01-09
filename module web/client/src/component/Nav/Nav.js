import React from 'react';
import { NavLink } from "react-router-dom";
import './Nav.scss';

const Nav = () => {
    return (
        <div className="navigation">
            <nav>
                <NavLink exact to="/day/dimanche1" className={({ isActive }) => isActive ? "red" : "blue"}>Dimanche</NavLink>
                <NavLink exact to="/day/lundi" className={({ isActive }) => isActive ? "red" : "blue"}>Lundi</NavLink>
                <NavLink exact to="/day/mardi" className={({ isActive }) => isActive ? "red" : "blue"}>Mardi</NavLink>
                <NavLink exact to="/day/mercredi" className={({ isActive }) => isActive ? "red" : "blue"}>Mercredi</NavLink>
                <NavLink exact to="/day/jeudi" className={({ isActive }) => isActive ? "red" : "blue"}>Jeudi</NavLink>
                <NavLink exact to="/day/vendredi" className={({ isActive }) => isActive ? "red" : "blue"}>Vendredi</NavLink>
                <NavLink exact to="/day/samedi" className={({ isActive }) => isActive ? "red" : "blue"}>Samedi</NavLink>
                <NavLink exact to="/day/dimanche2" className={({ isActive }) => isActive ? "red" : "blue"}>Dimanche</NavLink>
            </nav>
        </div>
    );
};

export default Nav;