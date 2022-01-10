import Accueil from './component/Accueil/Accueil';
import Header from './component/Header/Header';

import { BrowserRouter, Routes, Route } from "react-router-dom"; 
import Nav from 'component/Nav/Nav';

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
