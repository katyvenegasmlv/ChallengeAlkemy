

const Init_State = {
    newproduct:[]
}

export const newproductReduce = (state = Init_State, action)=> {
    switch (action.type) {
        case "Insert new product":
            if (action.payload){
                console.log("existe");
            }
            return{ ...state,
            newproduct:[...state.newproduct, action.payload]
    };
    default:
         return state;
}
};