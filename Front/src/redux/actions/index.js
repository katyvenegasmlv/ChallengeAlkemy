import { combineReducers } from "redux";
import { newproductReduce } from "./newproductReduce";


export default combineReducers({
    cartReducer: newproductReduce
})