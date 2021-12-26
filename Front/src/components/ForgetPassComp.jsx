

const ForgetPassComponent= ({img}) => {
  
  

    
    return(
        <div>

<div class="container">
<form class="row g-3">
  <div class="col-md-4">
    <label for="validationServer01" class="form-label">User</label>
    <input type="email" class="form-control" id="validationServer01" placeholder="ejemplo@gmail.com" required/>
  </div>
  <div class="col-md-4">
    <label for="validationServer02" class="form-label">New Password</label>
    <input type="password" class="form-control" id="validationServer02" placeholder="Contraseña420." required/>

  </div>
  <div class="col-12">
    <div class="form-check">
  
      <div>
        <ul type="none">
          <li> <a  href={'/singin'}>Create a new user</a></li>
       
        
        </ul>
      </div>
    </div>
  </div>
  <div class="col-12">
    <button class="btn btn-outline-success" type="submit">Reset Password</button>
  </div>
</form>
</div>
        </div>
        
    )
}
export default ForgetPassComponent;