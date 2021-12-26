const CardComponent = ({products, Agregar}) => {

  
    return(
      <div class="card-group">
  <div class="card">
    <img src={products.thumbnail} class="card-img-top" alt="..."/>
    <div class="card-body">
      <h5 class="card-title">{products.title}  <b> ${products.price}</b></h5>
      <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
      <button className="btn btn-primary" onClick={(event) => {Agregar(event, products)}}> Agregar al carrito</button>
    </div>
  </div>
 
  
</div>
    )
}
export default CardComponent;