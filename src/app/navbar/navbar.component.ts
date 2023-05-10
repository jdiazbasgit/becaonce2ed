import { Component } from '@angular/core';
import { ElRevisorService } from '../el-revisor.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private elRevisor:ElRevisorService){}

  desElegirCuenta(){
    this.elRevisor.cuentaElegida=false
  }
}
