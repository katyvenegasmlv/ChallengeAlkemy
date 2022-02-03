import React, { Component } from 'react';
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import { Modal, ModalBody, ModalFooter, ModalHeader, Form } from 'reactstrap';




class PeliculaComponent extends Component {

  state = {
    data: [],
    modalInsertar: false,
    modalEliminar: false,
    form: {
      id_pelicula: '',
      title: '',
      id_genero: '',
      personajes: '',
      fecha: '',
      calificacion: '',
      picture: '',
      tipoModal: '',
      imagenB64: ''
    }
  }






  peticionGet = () => {
    axios.get("http://localhost:8080/movies/GetMovies").then(response => {
      console.log(response.data);
      this.setState({ data: response.data });
    }).catch(error => {
      console.log(error.message);
    })
  }

  peticionGetPersonaje=()=>{
    axios.get("http://localhost:8080/personaje/GetPersonajes").then(response=>{
      
      this.setState({personajes: response.data});
    }).catch(error=>{
      console.log(error.message);
    })
    }
    

  peticionPost = async () => {

    this.state.form.picture = this.state.form.imagenB64
    
    console.log(this.state.form);
    await axios.post("http://localhost:8080/movies/InsertMovies", this.state.form
    ).then(response => {

      this.modalInsertar();
      this.peticionGet();
    }).catch(error => {
      console.log(error.message);
    })
  }

  peticionPut = () => {

    this.state.form.picture = this.state.form.imagenB64
    
    axios.put("http://localhost:8080/movies/UpdateMovies/" + this.state.form.id_pelicula, this.state.form).then(response => {
      this.modalInsertar();
      this.peticionGet();
    })
  }

  peticionDelete = () => {
    axios.delete("http://localhost:8080/movies/DeleteMovies/" + this.state.form.id_pelicula).then(response => {
      this.setState({ modalEliminar: false });
      this.peticionGet();
    })
  }

  modalInsertar = () => {
    this.setState({ modalInsertar: !this.state.modalInsertar });
  }

  seleccionarPelicula = (Peliculas) => {
    this.setState({
      tipoModal: 'actualizar',
      form: {
        id_pelicula: Peliculas.id_pelicula,
        title: Peliculas.title,
        id_genero: Peliculas.id_genero.nombre,
        personaje: Peliculas.personajes[0].name,
        fecha: Peliculas.fecha,
        calificacion: Peliculas.calificacion,
        picture: Peliculas.picture,
        imagenB64: ''
      }
    })
  }


  handleChange = async e => {


    e.persist();
    await this.setState({
      form: {
        ...this.state.form,
        [e.target.name]: e.target.value
       

      }
    });
    console.log(this.state.form);
  }


  handleChangeFile(e){

    let files = e.target.files;

    let reader = new FileReader();
    reader.readAsDataURL(files[0]);

    reader.onload=(e) =>{
      this.state.form.imagenB64 = e.target.result
    }
  
  }

  componentDidMount() {
    this.peticionGet();
    this.peticionGetPersonaje();
  }




  render(){
    const {form}=this.state;
  
    return (
      <div className="App">
        <br /><br /><br />
        <button className="btn btn-success" onClick={() => { this.setState({ form: null, tipoModal: 'insertar' }); this.modalInsertar() }}>Crear Pelicula</button>
        <br /><br />
        <table class="table" id="table-Pelicula">
          <thead class="thead-light" >
            <tr>
              <th>Pelicula</th>
              <th>Category</th>
              <th>Personaje</th>
              <th>Fecha</th>
              <th>Calificacion</th>
              <th>Picture</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {this.state.data.map(Peliculas => {

              return (
                <tr>
                  <td>{Peliculas.title}</td>
                  <td>{Peliculas.id_genero.nombre}</td>
                  <td>{Peliculas.personajes[0].name}</td>
                  <td>{Peliculas.fecha}</td>
                  <td>{Peliculas.calificacion}</td>
                  <td><img src={Peliculas.picture}></img> </td>
                  <td>
                    <button className="btn btn-primary" onClick={() => { this.seleccionarPelicula(Peliculas); this.modalInsertar() }}><FontAwesomeIcon icon={faEdit} /></button>
                    {"   "}
                    <button className="btn btn-danger" onClick={() => { this.seleccionarPelicula(Peliculas); this.setState({ modalEliminar: true }) }}><FontAwesomeIcon icon={faTrashAlt} /></button>
                  </td>
                </tr>

              )
            })}
          </tbody>
        </table>
  




        <Modal isOpen={this.state.modalInsertar} encType="multipart/form-data">


          <ModalHeader style={{ display: 'block' }}>
            <span style={{ float: 'right' }} onClick={() => this.modalInsertar()}>x</span>
          </ModalHeader>
          <ModalBody>
            <div className="form-group mb-3">

              <label htmlFor="Pelicula">Pelicula</label>
              <input className="form-control mb-3" type="text" name="title" id="title" onChange={this.handleChange} />
             
             <label htmlFor="personaje">Picture </label>
             <input className="form-control mb-3" type="file" name="picture" id="picture" onChange={(e)=>this.handleChangeFile(e)} value={undefined} />
        
           
              <label htmlFor="category" >Category</label>

              <select  className="form-control ml-4 mb-3" name="id_genero" id="id_genero" onChange={this.handleChange} value={form ? form.id_genero : ''}>
                <option>Seleccionar</option>
                <option value="1">Accion</option>
                <option value="2">Aventura</option>
                <option value="3">Comedia</option>
                <option value="4">Terror</option>
              </select>
            
              <label htmlFor="personaje">Personaje</label>
              <select  className="form-control ml-4 mb-3" name="id_personake" id="id_personje" onChange={this.handleChange} value={form ? form.personajes : ''}>
                <option>Seleccionar</option>
            
              </select>
             

              <label htmlFor="fecha">Fecha</label>
              <input className="form-control mb-3" type="date" name="fecha" id="fecha" onChange={this.handleChange} value={form ? form.fecha : ''} />
            
              <label htmlFor="calificacion">Calificacion</label>
              <p className="clasificacion" onChange={this.handleChange} value={form ? form.calificacion : ''}>
                <input className="form-control" onChange={this.handleChange} value={form ? form.calificacion : ''} id="radio1" type="radio" name="calificacion" value="5" />
                <label for="radio1">★</label>
                <input className="form-control" onChange={this.handleChange} value={form ? form.calificacion : ''} id="radio2" type="radio" name="calificacion" value="4" />
                <label for="radio2">★</label>
                <input className="form-control" onChange={this.handleChange} value={form ? form.calificacion : ''} id="radio3" type="radio" name="calificacion" value="3" />
                <label for="radio3">★</label>
                <input className="form-control" onChange={this.handleChange} value={form ? form.calificacion : ''} id="radio4" type="radio" name="calificacion" value="2" />
                <label for="radio4">★</label>
                <input className="form-control" onChange={this.handleChange} value={form ? form.calificacion : ''} id="radio5" type="radio" name="calificacion" value="1" />
                <label for="radio5">★</label>
              </p>
           




            </div>
          </ModalBody>

          <ModalFooter>
            {this.state.tipoModal == 'insertar' ?
              <button className="btn btn-success" onClick={() => this.peticionPost()}>
                Crear Pelicula
              </button> : <button className="btn btn-primary" onClick={() => this.peticionPut()}>
                Actualizar
              </button>
            }
            <button className="btn btn-danger" onClick={() => this.modalInsertar()}>Cancelar</button>
          </ModalFooter>

        </Modal>


        <Modal isOpen={this.state.modalEliminar}>
          <ModalBody>
            Estás seguro que deseas eliminar esta Pelicula? {form && form.title}
          </ModalBody>
          <ModalFooter>
            <button className="btn btn-danger" onClick={() => this.peticionDelete()}>Sí</button>
            <button className="btn btn-secundary" onClick={() => this.setState({ modalEliminar: false })}>No</button>
          </ModalFooter>
        </Modal>
      </div>



    );
  }
}

export default PeliculaComponent;