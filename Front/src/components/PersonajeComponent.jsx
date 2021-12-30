import React, { Component, useState } from 'react';
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import { Modal, ModalBody, ModalFooter, ModalHeader } from 'reactstrap';



    class PersonajeComponent extends Component {  
      
state={
  data:[],
  modalInsertar: false,
  modalEliminar: false,
  form:{
    id_personaje: '',
    name: '',
    category: '',
    description: '',
    peso: '',
    edad: '',
    picture: '',
    tipoModal: ''
  }
}

peticionGet=()=>{
axios.get("http://localhost:8080/personaje/GetPersonajes").then(response=>{
  this.setState({data: response.data});
}).catch(error=>{
  console.log(error.message);
})
}

peticionPost=async()=>{
  delete this.state.form.id_personaje;
 await axios.post("http://localhost:8080/personaje/InsertPersonaje",this.state.form).then(response=>{
    this.modalInsertar();
    this.peticionGet();
  }).catch(error=>{
    console.log(error.message);
  })
}

peticionPut=()=>{
  axios.put("http://localhost:8080/personaje/UpdatePersonaje/"+this.state.form.id_personaje, this.state.form).then(response=>{
    this.modalInsertar();
    this.peticionGet();
  })
}

peticionDelete=()=>{
  axios.delete("http://localhost:8080/personaje/DeletePersonaje/"+this.state.form.id_personaje).then(response=>{
    this.setState({modalEliminar: false});
    this.peticionGet();
  })
}

modalInsertar=()=>{
  this.setState({modalInsertar: !this.state.modalInsertar});
}

seleccionarPersonaje=(Personajes)=>{
  this.setState({
    tipoModal: 'actualizar',
    form: {
      id_personaje: Personajes.id_personaje,
      name: Personajes.name,
      category: Personajes.category,
      description: Personajes.description,
      peso: Personajes.peso,
      edad: Personajes.edad,
      picture: Personajes.picture
    }
  })
}

handleChange=async e=>{
e.persist();
await this.setState({
  form:{
    ...this.state.form,
    [e.target.name]: e.target.value
  }
});
console.log(this.state.form);
}

  componentDidMount() {
    this.peticionGet();
  }
  

  render(){
    const {form}=this.state;
  return (
    <div className="App">
    <br /><br /><br />
  <button className="btn btn-success" onClick={()=>{this.setState({form: null, tipoModal: 'insertar'}); this.modalInsertar()}}>Crear Personaje</button>
  <br /><br />
    <table class="table" id="table-Personaje">
      <thead class="thead-light" >
        <tr>
          <th>ID</th>
          <th>Personaje</th>
          <th>Category</th>
          <th>Description</th>
          <th>Peso</th>
          <th>Edad</th>
          <th>Picture</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {this.state.data.map(Personajes=>{
          return (
            <tr>
          <td>{Personajes.id_personaje}</td>
          <td>{Personajes.name}</td>
          <td>{Personajes.category}</td>
          <td>{Personajes.description}</td>
          <td>{Personajes.peso}</td>
          <td>{Personajes.edad}</td>
          <td>{Personajes.picture}</td>
          <td>
                <button className="btn btn-primary" onClick={()=>{this.seleccionarPersonaje(Personajes); this.modalInsertar()}}><FontAwesomeIcon icon={faEdit}/></button>
                {"   "}
                <button className="btn btn-danger" onClick={()=>{this.seleccionarPersonaje(Personajes); this.setState({modalEliminar: true})}}><FontAwesomeIcon icon={faTrashAlt}/></button>
                </td>
          </tr>
          
          )
        })}
      </tbody>
    </table>



    <Modal isOpen={this.state.modalInsertar} enctype="multipart/form-data">
                <ModalHeader style={{display: 'block'}}>
                  <span style={{float: 'right'}} onClick={()=>this.modalInsertar()}>x</span>
                </ModalHeader>
                <ModalBody>
                  <div className="form-group">
                 
                    <label htmlFor="Personaje">Personaje</label>
                    <input className="form-control" type="text" name="name" id="name" onChange={this.handleChange} value={form?form.name: ''}/>
                    <br />
                    <label htmlFor="category">Category</label>
                    <input className="form-control" type="text" name="category" id="category" onChange={this.handleChange} value={form?form.category: ''}/>
                    <br />
                    <label htmlFor="description">Description</label>
                    <input className="form-control" type="text" name="description" id="description" onChange={this.handleChange} value={form?form.description:''}/>
                    <br />
                    <label htmlFor="description">Peso</label>
                    <input className="form-control" type="number" name="peso" id="peso" onChange={this.handleChange} value={form?form.peso:''}/>
                    <br />
                    <label htmlFor="description">Edad</label>
                    <input className="form-control" type="number" name="edad" id="edad" onChange={this.handleChange} value={form?form.edad:''}/>
                    <br />
                   
                

                  </div>
                </ModalBody>

                <ModalFooter>
                  {this.state.tipoModal=='insertar'?
                    <button className="btn btn-success" onClick={()=>this.peticionPost()}>
                    Insertar
                  </button>: <button className="btn btn-primary" onClick={()=>this.peticionPut()}>
                    Actualizar
                  </button>
  }
                    <button className="btn btn-danger" onClick={()=>this.modalInsertar()}>Cancelar</button>
                </ModalFooter>
          </Modal>


          <Modal isOpen={this.state.modalEliminar}>
            <ModalBody>
               Estás seguro que deseas eliminar este Personaje? {form && form.name}
            </ModalBody>
            <ModalFooter>
              <button className="btn btn-danger" onClick={()=>this.peticionDelete()}>Sí</button>
              <button className="btn btn-secundary" onClick={()=>this.setState({modalEliminar: false})}>No</button>
            </ModalFooter>
          </Modal>
  </div>



  );
}
}

export default PersonajeComponent;
