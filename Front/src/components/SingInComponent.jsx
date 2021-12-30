import React, { Component } from 'react';
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import { Modal, ModalBody, ModalFooter, ModalHeader } from 'reactstrap';
import Cookies from 'universal-cookie'

var cookies = new Cookies() ;

class SingInComponent extends Component {
  state = {
    data: [],
    modalInsertar: false,
    form: {
      id_users: '',
      email: '',
      password: '',
      role: ''
    }
  }

  peticionGet = () => {
    axios.get("http://localhost:8080/user/GetUsers").then(response => {
      this.setState({ data: response.data });
    }).catch(error => {
      console.log(error.message);
    })
  }

  peticionPost = async () => {
    delete this.state.form.id_users;

    this.state.form.password = btoa(this.state.form.password) 

    await axios.post("http://localhost:8080/user/FindUserByEmailAndPass", this.state.form).then(response => {
      console.log(response.data)
      if( response.data.id_users != 0){

        cookies.set("id" , response.data.id_users, {path: "/"});
        cookies.set("email" , response.data.email, {path: "/"});
        cookies.set("apellido" , response.data.last_name, {path: "/"});
        cookies.set("rol" , response.data.role, {path: "/"});
        cookies.set("usuario" , response.data.user_name, {path: "/"});
        alert( "Bienvenido " + response.data.last_name + " " + response.data.user_name);
        window.location.href = "http://localhost:3000/"
      }
      else{
        alert("El Usuario o la contraseña no son correctos")
      }
    })
  }

  
  peticionPost = async () => {
    delete this.state.form.id_users;
    this.state.form.password = btoa(this.state.form.password)
    await axios.post("http://localhost:8080/user/InsertUser", this.state.form).then(response => {
      this.modalInsertar();
      this.peticionGet();
    }).catch(error => {
      console.log(error.message);
    })
  }

  peticionPut = () => {
    axios.put("http://localhost:8080/user/UpdateUser/" + this.state.form.id_users, this.state.form).then(response => {
      this.modalInsertar();
      this.peticionGet();
    })
  }


  modalInsertar = () => {
    this.setState({ modalInsertar: !this.state.modalInsertar });
  }

  seleccionarUser = (users) => {
    this.setState({
      tipoModal: 'actualizar',
      form: {
        id_users: users.id_users,
        email: users.email,
        password: users.password
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

  componentDidMount() {
    this.peticionGet();
  }


  render() {
    const { form } = this.state;
    return (
      <div className="App">

<button className="btn btn-success" onClick={() => { this.setState({ form: null, tipoModal: 'insertar' }); this.modalInsertar() }}>Crear Usuario</button>
      

        <Modal isOpen={this.state.modalInsertar}>
          <ModalHeader style={{ display: 'block' }}>
            <span style={{ float: 'right' }} onClick={() => this.modalInsertar()}>x</span>
          </ModalHeader>
          <ModalBody>
            <div className="form-group">

              <label htmlFor="product">User</label>
              <input className="form-control" type="text" name="user_name" id="user_name" onChange={this.handleChange} value={form ? form.user_name : ''} />
              <br />              
              <label htmlFor="description">Email</label>
              <input className="form-control" type="email" name="email" id="email" onChange={this.handleChange} value={form ? form.email : ''} />
              <br />
              <label htmlFor="description">Last Name</label>
              <input className="form-control" type="text" name="last_name" id="last_name" onChange={this.handleChange} value={form ? form.last_name : ''} />
              <br />
              <label htmlFor="description">Password</label>
              <input className="form-control" type="password" name="password" id="password" onChange={this.handleChange} value={form ? form.password : ''} />
              <br />
         
              </div>
          </ModalBody>

          <ModalFooter>
            {this.state.tipoModal == 'insertar' ?
              <button className="btn btn-success" onClick={() => this.peticionPost()}>
                Insertar
              </button> : <button className="btn btn-primary" onClick={() => this.peticionPut()}>
                Actualizar
              </button>
            }
            <button className="btn btn-danger" onClick={() => this.modalInsertar()}>Cancelar</button>
          </ModalFooter>
          </Modal>

      </div>



    );
  }
}

export default SingInComponent;