import Accueil from './pages/Accueil/Accueil';
import Header from './component/Header/Header';

import { BrowserRouter, Routes, Route } from "react-router-dom"; 
import Nav from 'component/Nav/Nav';
import Commande from 'pages/Commande/Commande';
import Paiement from 'pages/Paiement/Paiement';

function App() {
  return (
    <div className="App">
    <BrowserRouter>
    <Header/>
      
    <Nav/>
    <Routes>
      <Route path="/day/:id" element={<Accueil />} />
    </Routes>
    </BrowserRouter>
      
    </div>
  );
}

export default App;
