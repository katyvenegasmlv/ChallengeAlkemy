export const addElementTobbdd = (products) =>{
    return {
        type: 'Insert new product',
        payload: products
    }
}