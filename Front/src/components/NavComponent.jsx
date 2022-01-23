import Cookies from 'universal-cookie';
import favicon from '../images/favicon.png';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPowerOff } from '@fortawesome/free-solid-svg-icons';

const cookies = new Cookies();

function cerrarSesion(){
        cookies.remove("id"  , {path: "/"})
        cookies.remove("email" , {path: "/"})
        cookies.remove("apellido" , {path: "/"})
        cookies.remove("nombre" , {path: "/"})
        cookies.remove("rol" , {path: "/"})
        cookies.remove("usuario" , {path: "/login"})
        cookies.remove("peliculas" , {path: "/pelicula"})
        window.opener.location= "http://localhost:3000/login";
      window.close.href=  "http://localhost:3000/pelicula";
        window.location.href = "http://localhost:3000/login"
}

const NavComponent= () => {
  
  

    if(cookies.get("rol") == "admin"){
    return(
        <div className="navColor">

            <h1>
     <a href={'/'} className="aTitulo">Mundo Disney </a><img scr={favicon} width="100px"/>
     </h1>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
              <div class="container-fluid">
                <a class="navbar-brand" href={'/'}>Home</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      
                    <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href={'/user'}>User</a>
                  </li>
                    <li class="nav-item">
                      <a class="nav-link active" aria-current="page" href={'/personaje'}>Personajes</a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href={'/pelicula'}>Peliculas</a>
                  </li>
                    </ul>
                  <form class="d-flex">
                      <label class="" aria-current="page"  >Bienvenid@ {cookies.get("usuario")}</label>
                      <button class="btn pt-1" onClick={() => { cerrarSesion() }}><FontAwesomeIcon icon={faPowerOff} /></button>
                  </form>
                </div>
              </div>
            </nav>
        </div>
        
    )
    }
    else{

    
    if(cookies.get("rol") == "view"){
      
    return(
      <div className="navColor">

          <h1>
   <a href={'/'} className="aTitulo">Mundo Disney  </a><img scr={favicon} width="100px"/>
   </h1>
          <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
              <a class="navbar-brand" href={'/'}>Home</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              
                 
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href={'/personaje'}>Personajes</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href={'/pelicula'}>Peliculas</a>
                  </li>
                  </ul>
                <form class="d-flex">
                
                  <label class="pt-1" aria-current="page"  >Bienvenid@ {cookies.get("usuario")}</label>
                  <button class="btn pt-1" onClick={() => { cerrarSesion() }}><FontAwesomeIcon icon={faPowerOff} /></button>
                </form>
              </div>
            </div>
          </nav>
      </div>
      
  )
  
  }
  else{
    return(
 
      <div className="navColor">

          <h1>
   <a href={'/'} className="aTitulo">Mundo Disney  </a><img scr={favicon} width="100px"/>
   </h1>
          <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href={'/login'}>Login</a>
                  </li>
                
                  </ul>
                <form class="d-flex">
                <label class="" aria-current="page"  >Usuario no logeado</label>
                </form>
              </div>
            </div>
          </nav>
      </div>
      
  )
  }
}
}
export default NavComponent;