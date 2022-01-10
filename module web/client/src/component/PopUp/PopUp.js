import React, {useState} from 'react';
import './PopUp.scss';
import joueur from "assets/joueur.png";

const PopUp = () => {

    const[popUp, setPopUp] = useState(false);

    const togglePupUp = () => {
        setPopUp(!popUp)
    }

    return (
        <>
            <input
            type="image"
            src={joueur}
                onClick={togglePupUp}
                className="btn-connexion"/>

            {popUp && (
                <div className="popUp">
                <div onClick={togglePupUp} className="overlay">
                </div>
                <div className="popUp-content">
                    <h2>Rechercher un joueur</h2>
                    <div className="input-co"><input type="text" placeholder="Prénom"/></div>
                    <div className="input-co"><input type="password" placeholder="Nom"/></div>
                    <div className="input-co"><input type="submit" placeholder="Rechercher"/></div>
                    <button className="close-popUp" onClick={togglePupUp}> X
                    </button>
                </div>
            </div>
            )}

            
        </>
    );
};

export default PopUp;