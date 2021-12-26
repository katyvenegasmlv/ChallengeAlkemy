
import NavComponent from "../components/NavComponent";
import ProductComponent from "../components/ProductComponent";
import ReactHTMLTableToExcel from 'react-html-table-to-excel';

const ProductsContainer = () => {
  


  return (
    <div className="container">
      <NavComponent />
      <div className="btnexport">
        <ReactHTMLTableToExcel
          id="test-table-xls-button"
          className="btn btn-outline-success"
          table="table-product"
          filename="Product-List"
          sheet="tableproducts"
          buttonText="Download List" />
      </div>
      <div clasName="row">

  
            <ProductComponent   />

 
          

      </div>
    </div>
  )
}
export default ProductsContainer;