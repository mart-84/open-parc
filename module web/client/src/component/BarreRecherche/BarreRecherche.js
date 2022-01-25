import './BarreRecherche.scss';
import joueur from '../../data/joueur.json'
import { useEffect, useState } from 'react';
import axios from "axios"; 

import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';


const BarreRecherche = () => {
    const navigate = useNavigate();
    const [searchTerm, setSearchTerm] = useState("");
    const[joueurs, setJoueurs] = useState([]);
    useEffect(() => {
        const getJoueurs = async () => {
          const {data} = await axios({ url: 'http://127.0.0.1:8000/billetterie/liste_joueur'}); //à changer
        if (data) setJoueurs(data)
          console.log(data)
        }
    
        getJoueurs();
      }, []);
    return (
            <div className='App'>
                <input type="text" placeholder="Trier par joueur" onChange={(event) => {
                    setSearchTerm(event.target.value);
                    }}/>
                {joueurs.filter((val) => {
                    if (searchTerm == "") {
                        return 
                    } else if (val.Prenom.toLowerCase().includes(searchTerm.toLowerCase()) || val.Nom.toLowerCase().includes(searchTerm.toLowerCase())) {
                        return val
                    }
                }).map((val, index) => {
                    const click=()=> {
                        console.log(val)
                        navigate("/joueur/" + val.Nom+"_"+val.Prenom)
                    }  
                return (
                    <div onClick={click} className='utilisateur' key={index}> 
                        <div> {val.Nom}_{val.Prenom} </div>
                    </div>
                );
            })} 
            </div>
    );
};

export default BarreRecherche;