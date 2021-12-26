import {useState} from "react";


const NewProductComponent = (products, Agregar) => {
const [productData, setProductData] = useState ({name:'', category:'', description:'', quantity:'', price:'', picture:'',})
console.log(productData);
  return (
    <form class="row g-3 needs-validation">
      <div class="col-md-5">
        <label for="validationServer01" class="form-label">Product</label>
        <input type="text" class="form-control" id="validationServer01" placeholder="Pineaple" onChange={(event)=>{setProductData({...productData, name:event.target.value})}} required />

      </div>
      <div class="col-md-5">
        <label for="validationServer02" class="form-label">Category</label>
        <input type="text" class="form-control" id="validationServer02" placeholder="Fruit" onChange={(event)=>{setProductData({...productData, category:event.target.value})}} required />
      </div>
      <div class="col-md-10">
        <label for="validationServer03" class="form-label">Description</label>
        <input type="text" class="form-control" id="validationServer03" placeholder="Citric" aria-describedby="validationServer03Feedback" onChange={(event)=>{setProductData({...productData, description:event.target.value})}} required />

      </div>
      <div class="col-md-3">
        <label for="validationServer04" class="form-label">Quantity</label>
        <input type="number" class="form-select" id="validationServer04" placeholder="38" aria-describedby="validationServer04Feedback" onChange={(event)=>{setProductData({...productData, quantity:event.target.value})}} required>
        </input>
      </div>

      <div class="col-md-2">
        <label class="form-label">Unit Price</label>
        <input type="number" class="form-select" id="validationServer04" placeholder="87" aria-describedby="validationServer04Feedback" onChange={(event)=>{setProductData({...productData, price:event.target.value})}} required>
        </input>
      </div>
      <div class="col-md-5">
        <label for="validationServer05" class="form-label">Picture</label>
        <input type="file" class="form-control" id="validationServer05" aria-describedby="validationServer05Feedback" onChange={(event)=>{setProductData({...productData, picture:event.target.value})}} required />
      </div>

      <div class="col-12">
        <button class="btn btn-outline-success"  onClick={()=>{this.setState({form: null, tipoModal: 'insertar'}); this.modalInsertar()}}>Create</button>
      </div>
    </form>
  )
}
export default NewProductComponent;