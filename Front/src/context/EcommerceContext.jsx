import  {createContext, useEffect, useState} from "react";

export const EcommerceContext = createContext();

export const EcommerceProvider = ({children}) =>{
    const [products, setProducts] = useState([])
    const [carrito, setCarrito] = useState([])

    
    return <EcommerceContext.Provider value={{products, carrito, setCarrito, setProducts}}>
{children}
    </EcommerceContext.Provider>
}
