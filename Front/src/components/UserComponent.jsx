import React, { Component } from 'react';
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import { Modal, ModalBody, ModalFooter, ModalHeader } from 'reactstrap';



class UserComponent extends Component {
  state = {
    data: [],
    modalInsertar: false,
    modalEliminar: false,
    form: {
      id_users: '',
      user_name: '',
      password: '',
      email: '',
      name: '',
      last_name: '',
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
    await axios.post("http://localhost:8080/user/InsertUser", this.state.form).then(response => {
      this.modalInsertar();
      this.peticionGet();
    }).catch(error => {
      console.log(error.message);
    })
  }

  peticionPut = () => {
    this.state.form.password = btoa(this.state.form.password)
    axios.put("http://localhost:8080/user/UpdateUser/" + this.state.form.id_users, this.state.form).then(response => {
      this.modalInsertar();
      this.peticionGet();
    })
  }

  peticionDelete = () => {
    axios.delete("http://localhost:8080/user/DeleteUser/" + this.state.form.id_users).then(response => {
      this.setState({ modalEliminar: false });
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
        user_name: users.user_name,
        password: users.password,
        email: users.email,
        name: users.name,
        last_name: users.last_name,
        role: users.role
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
      
        <table class="table"  id="table-user">
          <thead class="thead-light">
            <tr>
              <th>ID</th>
              <th>User</th>
              <th>Email</th>
              <th>Name</th>
              <th>Last Name</th>
              <th>Role</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {this.state.data.map(users => {
              return (
                <tr>
                  <td>{users.id_users}</td>
                  <td>{users.user_name}</td>
                  <td>{users.email}</td>
                  <td>{users.name}</td>
                  <td>{users.last_name}</td>
                  <td>{users.role}</td>
                  <td>
                    <button className="btn btn-primary" onClick={() => { this.seleccionarUser(users); this.modalInsertar() }}><FontAwesomeIcon icon={faEdit} /></button>
                    {"   "}
                    <button className="btn btn-danger" onClick={() => { this.seleccionarUser(users); this.setState({ modalEliminar: true }) }}><FontAwesomeIcon icon={faTrashAlt} /></button>
                  </td>
                </tr>
              )
            })}
          </tbody>
        </table>



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
              <label htmlFor="description">Name</label>
              <input className="form-control" type="text" name="name" id="name" onChange={this.handleChange} value={form ? form.name : ''} />
              <br />
              <label htmlFor="description">Last Name</label>
              <input className="form-control" type="text" name="last_name" id="last_name" onChange={this.handleChange} value={form ? form.last_name : ''} />
              <br />
              <label htmlFor="description">Role</label>
              <select name="role" id="role" onChange={this.handleChange} value={form ? form.role : ''}>
                <option>Seleccionar</option>
                <option value="Admin">Admin</option>
                <option value="User">User</option>
              </select>


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


        <Modal isOpen={this.state.modalEliminar}>
          <ModalBody>
            Estás seguro que deseas eliminar a este usuario? {form && form.name}
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

export default UserComponent;