import React, { Component, useState } from 'react';
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import { Modal, ModalBody, ModalFooter, ModalHeader } from 'reactstrap';



    class ProductComponent extends Component {  
      
state={
  data:[],
  modalInsertar: false,
  modalEliminar: false,
  form:{
    id_product: '',
    name: '',
    category: '',
    description: '',
    quantity: '',
    price: '',
    picture: '',
    tipoModal: ''
  }
}

peticionGet=()=>{
axios.get("http://localhost:8080/product/GetProducts").then(response=>{
  this.setState({data: response.data});
}).catch(error=>{
  console.log(error.message);
})
}

peticionPost=async()=>{
  delete this.state.form.id_product;
 await axios.post("http://localhost:8080/product/InsertProduct",this.state.form).then(response=>{
    this.modalInsertar();
    this.peticionGet();
  }).catch(error=>{
    console.log(error.message);
  })
}

peticionPut=()=>{
  axios.put("http://localhost:8080/product/UpdateProduct/"+this.state.form.id_product, this.state.form).then(response=>{
    this.modalInsertar();
    this.peticionGet();
  })
}

peticionDelete=()=>{
  axios.delete("http://localhost:8080/product/DeleteProduct/"+this.state.form.id_product).then(response=>{
    this.setState({modalEliminar: false});
    this.peticionGet();
  })
}

modalInsertar=()=>{
  this.setState({modalInsertar: !this.state.modalInsertar});
}

seleccionarProducto=(products)=>{
  this.setState({
    tipoModal: 'actualizar',
    form: {
      id_product: products.id_product,
      name: products.name,
      category: products.category,
      description: products.description,
      quantity: products.quantity,
      price: products.price,
      picture: products.picture
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
  <button className="btn btn-success" onClick={()=>{this.setState({form: null, tipoModal: 'insertar'}); this.modalInsertar()}}>Crear Producto</button>
  <br /><br />
    <table class="table" id="table-product">
      <thead class="thead-light" >
        <tr>
          <th>ID</th>
          <th>Product</th>
          <th>Category</th>
          <th>Description</th>
          <th>Quantity</th>
          <th>Price</th>
          <th>Picture</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {this.state.data.map(products=>{
          return (
            <tr>
          <td>{products.id_product}</td>
          <td>{products.name}</td>
          <td>{products.category}</td>
          <td>{products.description}</td>
          <td>{products.quantity}</td>
          <td>{products.price}</td>
          <td>{products.pincture}</td>
          <td>
                <button className="btn btn-primary" onClick={()=>{this.seleccionarProducto(products); this.modalInsertar()}}><FontAwesomeIcon icon={faEdit}/></button>
                {"   "}
                <button className="btn btn-danger" onClick={()=>{this.seleccionarProducto(products); this.setState({modalEliminar: true})}}><FontAwesomeIcon icon={faTrashAlt}/></button>
                </td>
          </tr>
          
          )
        })}
      </tbody>
    </table>



    <Modal isOpen={this.state.modalInsertar}>
                <ModalHeader style={{display: 'block'}}>
                  <span style={{float: 'right'}} onClick={()=>this.modalInsertar()}>x</span>
                </ModalHeader>
                <ModalBody>
                  <div className="form-group">
                 
                    <label htmlFor="product">Product</label>
                    <input className="form-control" type="text" name="name" id="name" onChange={this.handleChange} value={form?form.name: ''}/>
                    <br />
                    <label htmlFor="category">Category</label>
                    <input className="form-control" type="text" name="category" id="category" onChange={this.handleChange} value={form?form.category: ''}/>
                    <br />
                    <label htmlFor="description">Description</label>
                    <input className="form-control" type="text" name="description" id="description" onChange={this.handleChange} value={form?form.description:''}/>
                    <br />
                    <label htmlFor="description">Quantity</label>
                    <input className="form-control" type="number" name="quantity" id="quantity" onChange={this.handleChange} value={form?form.quantity:''}/>
                    <br />
                    <label htmlFor="description">Price</label>
                    <input className="form-control" type="number" name="price" id="price" onChange={this.handleChange} value={form?form.price:''}/>
                   
                

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
               Estás seguro que deseas eliminar este producto? {form && form.name}
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

export default ProductComponent;
