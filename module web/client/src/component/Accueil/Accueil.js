import Nav from 'component/Nav/Nav';
import React from 'react';
import { useParams } from 'react-router-dom';
import billets  from 'data/billets';
import './Accueil.scss';


const DisplayBillets = () => { //mettre une maj car c'est un component => sinon compile po
    return billets.map((billets, index) => { //.map = tableau. Sorte de foreach qui retourne du html. le index donne la position dans le tableau 
        return <div key={index} className="billets-item">
            <h1>Court {billets.court}</h1>
            <div>{billets.match.map((joueurs, i) => <p key={i}>{joueurs} {billets.heure}</p>)}</div>
            <div>{billets.prix.map((joueurs, i) => <p key={i}>{joueurs}</p>)}</div>
            
        </div>
    })
}

const Accueil = () => {
    let { id } = useParams();
    return (
        <div>
            <h1>Voici tous les billets disponibles le {id ? id : "coucou"}</h1> 
            <div className="wrapper"><DisplayBillets/></div>
        </div>
    );
};

export default Accueil;