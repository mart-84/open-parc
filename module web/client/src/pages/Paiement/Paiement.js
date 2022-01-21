import React from 'react';

const Paiement = () => {
    return (
        <div>
        <div>Prix à payer : 30€</div>
        <div className="input-co"><input type="text" placeholder="Nom"/></div>
        <div className="input-co"><input type="text" placeholder="Prénom"/></div>
        <div className="input-co"><input type="text" placeholder="Adresse Mail"/></div>
        <div className="input-co"><input type="text" placeholder="Numéro de téléphone"/></div>
        <div className="input-co"><input type="text" placeholder="Adresse de facturation"/></div>
        <div className="input-co"><input type="submit" placeholder="Payer la commande"/></div>
        </div>
    );
};

export default Paiement;