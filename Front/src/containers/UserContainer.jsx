import NavComponent from "../components/NavComponent";
import UserComponent from "../components/UserComponent";
import ReactHTMLTableToExcel from 'react-html-table-to-excel';
import { EcommerceContext } from "../context/EcommerceContext";
import  { useParams } from "react-router-dom";
import { useContext, useEffect, useState } from "react";


const UserCont =  () => {
    const [searchProduct]= useState();
    const [carrito, setCarrito] = useState([])
    const [products, setProducts] = useState([]);
    const data = useContext(EcommerceContext);
    console.log(data);
    const {busqueda} = useParams();

    useEffect(async() => {
      let data = await fetch('http://localhost:8080/user/GetUsers');
      let response = await data.json();
      setProducts(response);
      console.log(response);
    return() => {
        console.log("Fin de componente");
    }
    },[]);
    //http//localhost:8080/product/GetProducts
    //https://api.mercadolibre.com/sites/MLA/search?q=celulares

    const Agregar= (event, products)=>{
      carrito.push(products);
      setCarrito([...carrito]);
    }
    const handleKeyUp= (e)=> {
      console.log(e.target.value);
      const productFilter= products.filter(element =>{ 
        if (element.title.toUpperCase().match(e.target.value.toUpperCase())){
          return true
        }
        return false;
        
      })
      setProducts(productFilter);
    }

    return(
        <div className="container">
          <NavComponent/>
          <div className="btnexport">
<ReactHTMLTableToExcel
                    id="test-table-xls-button"
                    className="btn btn-outline-success"
                    table="table-user"
                    filename="User-List"
                    sheet="tableUsers"
                    buttonText="Download List"/>
          </div> 
         
            <div clasName="row">
                
                       <br /><br /><br />
                        
                       <UserComponent  Agregar={Agregar}/>
                      
                      </div>
                    
        
      </div>
     
    )
}
    
export default UserCont;