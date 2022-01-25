import BarreRecherche from 'component/BarreRecherche/BarreRecherche';
import React from 'react';
import { NavLink } from "react-router-dom";
import './Nav.scss';
import { useState} from 'react';

const Nav = () => {
    return (
        <div className="navigation">
            <nav>
                <NavLink exact to="/day/1" className={({ isActive }) => isActive ? "red" : "blue"}>Dimanche</NavLink>
                <NavLink exact to="/day/2" className={({ isActive }) => isActive ? "red" : "blue"}>Lundi</NavLink>
                <NavLink exact to="/day/3" className={({ isActive }) => isActive ? "red" : "blue"}>Mardi</NavLink>
                <NavLink exact to="/day/4" className={({ isActive }) => isActive ? "red" : "blue"}>Mercredi</NavLink>
                <NavLink exact to="/day/5" className={({ isActive }) => isActive ? "red" : "blue"}>Jeudi</NavLink>
                <NavLink exact to="/day/6" className={({ isActive }) => isActive ? "red" : "blue"}>Vendredi</NavLink>
                <NavLink exact to="/day/7" className={({ isActive }) => isActive ? "red" : "blue"}>Samedi</NavLink>
                <NavLink exact to="/day/8" className={({ isActive }) => isActive ? "red" : "blue"}>Dimanche</NavLink>
                <BarreRecherche/>
            </nav>


        </div>
    );
};

export default Nav;