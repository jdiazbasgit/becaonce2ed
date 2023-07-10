import { Component } from '@angular/core';
import { ProyectosService } from '../servicios/proyectos.service';
import UserNameBean from '../beans/UserNameBean';
import { Router } from '@angular/router';
import { catchError } from 'rxjs';

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
    this.service.patch(this.url+"currentsAccounts",new UserNameBean(this.usuario))
    .pipe(
      catchError(error => {
        console.log(error)
        console.log(sessionStorage['token'])
        if (error.status === 401 || error.status === 403) {

          sessionStorage.clear()
          console.log("no autorizado")
          this.router.navigateByUrl('/landing')
        }
        return ""
      })
    )
    .subscribe({
      next: (cuentas) => {
        console.log(cuentas)
        this.cuentas = cuentas
        cuentas.forEach((c:any, index:number) => {
          this.service.getDatos(this.url+"balance/"+c.number).subscribe({
            next: (saldo) => {
              this.saldo[index] = saldo
              console.log(saldo)
              this.saldoTotal = this.saldoTotal + saldo
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
