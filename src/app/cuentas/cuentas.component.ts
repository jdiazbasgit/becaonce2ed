import { Component, ElementRef } from '@angular/core';
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
  cuentas: any[] = []
  saldo: number[] = []
  saldoTotal: number = 0
  fees: any[] = []
  typesAccounts: any[] = []


  constructor(private service:ProyectosService, private router:Router){

  }


  ngOnInit(){
    this.getFees()
    this.getTypesAccounts()
    
    this.usuario = sessionStorage['user']
    console.log(this.usuario)
    console.log(this.cuentas)
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

  yaTieneCuentas(){
    if(this.cuentas.length !== 0)
    return true
    return false
  }

  elegirCuenta(cuenta:number, id:number){
    sessionStorage['cuenta'] = cuenta
    sessionStorage['idCuenta'] = id
    window.scrollTo(0,0)
  }

  getFees() {
    this.service.getDatos(this.url+"fees")
      .subscribe({
        next: (fees) => {
          console.log(fees)
          this.fees = fees._embedded.fees
          fees._embedded.fees.forEach((element: any) => {
            console.log(element.current)

          });
        }
      })
  }
  getTypesAccounts() {
    this.service.getDatos(this.url+"typesAccounts")
      .subscribe({
        next: (typesAccounts) => {
          console.log(typesAccounts)
          this.typesAccounts = typesAccounts._embedded.typeAccounts
          typesAccounts._embedded.typeAccounts.forEach((element: any) => {
            console.log(element.description)
          });
        }
      })
  }

  crearCuenta(idTypoCuenta:number){
    let jsonParaEnviar = {      
      "user": sessionStorage['user'],
      "typeAccount": idTypoCuenta
    }
    this.service.saveOrUpdate(this.url+"currentsAccountsCreate",jsonParaEnviar)
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
      next: (response) => {
        console.log(response)
        this.ngOnInit()
        // this.cuentas = cuentas
        // cuentas.forEach((c:any, index:number) => {
        //   this.service.getDatos(this.url+"balance/"+c.number).subscribe({
        //     next: (saldo) => {
        //       this.saldo[index] = saldo
        //       console.log(saldo)
        //       this.saldoTotal = this.saldoTotal + saldo
        //     }
        //   })
        // })
      }
    })
  }
}
