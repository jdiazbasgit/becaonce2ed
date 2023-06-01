import { Component } from '@angular/core';
import { LoginService } from '../servicios/login.service';
import { FeeService } from '../servicios/fee.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
user:string=""
pwd:string=""

constructor(private service:LoginService,private feeService:FeeService){}

enviar(){
this.service.identificar("http://localhost:8080/login",this.user,this.pwd)
.subscribe((datos:any)=>{
  console.log(datos.token)
  sessionStorage['token']=datos.token+"a";
  this.feeService.getDatos("http://localhost:8080/once/fees")
  .subscribe((datos:any)=>{
    console.log(datos)
    datos._embedded.fees.forEach((element:any) => {
      console.log(element.current)
    });
  })
})
}

}
