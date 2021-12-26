import {useAuth0} from  "@auth0/auth0-react";
import LogComponent from "../components/LogComp";
import NavComponent from "../components/NavComponent";
import ProductsContainer from "./ProductsContainer";

const InfoLogin= () => {
 const {isAuthenticated} = useAuth0();
  
    
    return(
<div>
<NavComponent></NavComponent>
{isAuthenticated?(
    <>
    <ProductsContainer/>
    </>
) : (
<LogComponent/>
)}


        </div>
    )
}
export default InfoLogin;
