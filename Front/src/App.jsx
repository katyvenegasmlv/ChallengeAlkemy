import {BrowserRouter, Switch, Route} from 'react-router-dom';
import './App.css';
import InfoLogin from './containers/Login';
import HomeContainer from './containers/HomeContainer';
import ProductsContainer from './containers/ProductsContainer';
import UserCont from './containers/UserContainer';







const App= () => {
  return (
    <div className="App">
      <BrowserRouter>
      <Switch>
        <Route exact path="/productos">
          <ProductsContainer/>
        </Route>
        <Route path="/productos/:busqueda">
          <ProductsContainer/>
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
