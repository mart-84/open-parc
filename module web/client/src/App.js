import Accueil from './pages/Accueil/Accueil';
import Header from './component/Header/Header';

import { BrowserRouter, Routes, Route } from "react-router-dom"; 
import Nav from 'component/Nav/Nav';
import Commande from 'pages/Commande/Commande';
import Paiement from 'pages/Paiement/Paiement';
import InfoJoueur from 'pages/InfoJoueur/InfoJoueur';
import Administration from 'pages/Administration/Administration';

function App() {
  return (
    <div className="App">
    <BrowserRouter>
    <Header/>
      
    <Nav/>
    <Routes>
      <Route path="/day/:id" element={<Accueil />} />
      <Route path="/billet/:id" element={<Commande />} />
      <Route path="/joueur/:id" element={<InfoJoueur />} />
      <Route path="/admin" element={<Administration />} />
    </Routes>
    </BrowserRouter>
      
    </div>
  );
}

export default App;
