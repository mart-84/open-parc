import React from 'react';
import './Commande.scss';
import { useState } from 'react';




const Commande = () => {
    const [searchTerm, setSearchTerm] = useState("");
    const prix = 30;
    return (
        <div className='commande'>
            <h1>Récapitulatif de la commande</h1>
            <div className='billets-item'>
                            <h1>Court Annexe</h1>
            <div className='billet-info'>
                <div className='billet-match'><p className='test'><div className='joueurs'>Fabrice</div>  <div className='heure'>10h</div></p></div>
                <div className='billet-prix'><p >Smartin's</p></div>
            </div>
        </div>
        
        <div className="input-co"><input type="text" placeholder="Code promo"onChange={(event) => {
                    setSearchTerm(event.target.value);
                    if (event.target.value =="lovecpoa") {
                        prix = prix * 0.8;
                    }
                    }}/></div>
        <div className="input-co"><input type="password" placeholder="Numéro licence"/></div>
        <div>Prix à payer : {prix}€</div>
        <div className="input-co"><input type="submit" placeholder="Payer la commande"/></div>

        </div>
    );
};

export default Commande;