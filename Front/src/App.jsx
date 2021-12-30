import {BrowserRouter, Switch, Route} from 'react-router-dom';
import './App.css';
import InfoLogin from './containers/Login';
import HomeContainer from './containers/HomeContainer';
import PersonajeContainer from './containers/PersonajeContainer';
import PeliculaContainer from './containers/PeliculaContainer';
import UserCont from './containers/UserContainer';







const App= () => {
  return (
    <div className="App">
      <BrowserRouter>
      <Switch>
        <Route exact path="/personaje">
          <PersonajeContainer/>
        </Route>
        <Route path="/personaje/:busqueda">
          <PersonajeContainer/>
        </Route>
        <Route exact path="/pelicula">
          <PeliculaContainer/>
        </Route>
        <Route path="/pelicula/:busqueda">
          <PeliculaContainer/>
        </Route>
        <Route path="/login">
          <InfoLogin/>
        </Route> 
        <Route exact path="/">
          <HomeContainer/>
        </Route>
        <Route path="/home">
          <HomeContainer/>
        </Route>

        <Route path="/user">
          <UserCont/>
        </Route>
      </Switch>
      

      </BrowserRouter>
    </div>
  );
}

export default App;
