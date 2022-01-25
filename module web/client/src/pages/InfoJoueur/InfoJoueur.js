import React from 'react';
import { useEffect, useState } from 'react';
import axios from "axios"; 

import { useParams } from 'react-router-dom';
import './InfoJoueur.scss';
import { useNavigate } from 'react-router-dom';

const DisplayBillets = ({billets}) => { //mettre une maj car c'est un component => sinon compile po
  const navigate = useNavigate();
  let court = { 1: "centrale", 2: "annexe 1", 3: "annexe 2", 4: "annexe 3"};
  return billets.map((billets, index) => { //.map = tableau. Sorte de foreach qui retourne du html. le index donne la position dans le tableau 
      const click=()=> {
          console.log(billets)
          navigate("/billet/" + billets.billetid)
      }
      return <div onClick={click} key={index} className="billets-item">
          <h1>Court {court[billets.courtid]}</h1>
          <div className='billet-info'>
          <div className='billet-match'>{billets.liste_match[0]?.joueursNoms[0]} vs {billets.liste_match[0]?.joueursNoms[1]}
          </div>
              <div className='heure'>10h</div>
              <div className='billet-prix'>{billets.prix}</div>
          </div>
          
          
      </div>
  })
}

const InfoJoueur = () => {
    let { id } = useParams();
    const[billets, setBillets] = useState([]);
    useEffect(() => {
        const getBillet = async () => {
          const {data} = await axios({ url: 'http://127.0.0.1:8000/billetterie/triParJoueur/' + id}); //à changer
        if (data) setBillets(data)
          console.log(data)
        }
    
        getBillet();
      }, [id]);
    return (
      <div> 
        <h1>Voici tous les billets disponibles avec ce joueur</h1> 
        <div className="wrapper"><DisplayBillets billets={billets}/></div>
      </div>
    );
};

export default InfoJoueur;