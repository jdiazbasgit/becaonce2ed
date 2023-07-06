import { Component } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import { CurrentAccountService } from '../servicios/current-account.service';

@Component({
  selector: 'app-detalles-cuenta',
  templateUrl: './detalles-cuenta.component.html',
  styleUrls: ['./detalles-cuenta.component.css']
})
export class DetallesCuentaComponent {
  
  cuentaElegida:string
  url: string = "http://localhost:8080/once/"
  urlCurrentsAccounts:string ="http://localhost:8080/once/currentsAccounts"

  constructor(private service:ProyectosService, currentAccountService:CurrentAccountService){
    this.cuentaElegida=""
  }

  ngOnInit(){
    this.cuentaElegida= sessionStorage['cuenta']
    console.log(this.cuentaElegida)
    this.service.getDatos(this.url+"balance/"+this.cuentaElegida).subscribe((datos:any)=>{
      console.log(datos)

      this.service.getDatos(this.urlCurrentsAccounts).subscribe((datos:any)=>{
        console.log(datos + "datos de cuenta")
      })

    })
  }

    
      
       
}

