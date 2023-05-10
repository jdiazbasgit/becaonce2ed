import { Component } from '@angular/core';
import { ElRevisorService } from '../el-revisor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cuentas',
  templateUrl: './cuentas.component.html',
  styleUrls: ['./cuentas.component.css']
})
export class CuentasComponent {
ccc:Array<number>=[7754,5565]
cccEnUso:number=0

constructor(private elRevisor:ElRevisorService, private router:Router){}

elegirCuenta(numero:number){
  this.cccEnUso=this.ccc[numero]
  this.elRevisor.cuentaElegida=true
  this.router.navigateByUrl("detallescuenta")
}

}
