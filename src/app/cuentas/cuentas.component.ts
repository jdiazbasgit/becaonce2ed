import { Component } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import UserNameBean from '../beans/UserNameBean';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cuentas',
  templateUrl: './cuentas.component.html',
  styleUrls: ['./cuentas.component.css']
})
export class CuentasComponent {

  usuario: string = ""
  url: string = "http://localhost:8080/once/"
  cuentas: any
  saldo: number[] = []
  saldoTotal: number = 0


  constructor(private service:ProyectosService, private router:Router){

  }


  ngOnInit(){
    this.usuario = sessionStorage['user']
    console.log(this.usuario)
    this.service.patch(this.url+"currentsAccounts",new UserNameBean(this.usuario)).subscribe({
      next: (cuentas) => {
        console.log(cuentas)
        this.cuentas = cuentas
        cuentas.forEach((c:any, index:number) => {
          this.service.getDatos(this.url+"saldo/"+c.number).subscribe({
            next: (cuenta) => {
              this.saldo[index] = cuenta
              console.log(cuenta)
              this.saldoTotal = this.saldoTotal + cuenta
            }
          })
        })
      }
    })
    
    
  }

  elegirCuenta(cuenta:number, id:number){
    sessionStorage['cuenta'] = cuenta
    sessionStorage['idCuenta'] = id
    this.router.navigateByUrl("detalles")
  }

}
