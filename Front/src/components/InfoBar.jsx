import { useState } from "react";
import { Link } from "react-router-dom";


const InfoBarComponent= ({carrito, handleKeyUp,children}) => {
  
  

    
    return(
        <div className="bg-warning py-3">
      
        Articulos en el carrito: {carrito.length}
        {children}
        </div>
    )
}
export default InfoBarComponent;