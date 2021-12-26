import NewProductComponent from "../components/CreateNewProduct";
import NavComponent from "../components/NavComponent";
import { useContext, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { EcommerceContext } from "../context/EcommerceContext";


const NewProductContainer = () => {
    const [searchProduct] = useState();
    const [carrito, setCarrito] = useState([])
    const [products, setProducts] = useState([]);
    const data = useContext(EcommerceContext);
    console.log(data);
    const { busqueda } = useParams();
   
    //http://localhost:8080/product/GetProducts
    //https://api.mercadolibre.com/sites/MLA/search?q=celulares

    const Agregar = (event, products) => {
        carrito.push(products);
        setCarrito([...carrito]);
    }

    const handleKeyUp = (e) => {
        console.log(e.target.value);
        const productFilter = products.filter(element => {
            if (element.name.toUpperCase().match(e.target.value.toUpperCase())) {
                return true
            }
            return false;

        })
        setProducts(productFilter);
    }

    return (
        <div className="container">
            <NavComponent />

            <div>



                <div>
                    <NewProductComponent Agregar={Agregar} />

                </div>



            </div>
        </div>
    )
}
export default NewProductContainer;