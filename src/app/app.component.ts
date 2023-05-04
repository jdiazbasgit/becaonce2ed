import { Component } from '@angular/core';
import { PaisesService } from './paises.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title:string ;
  flag:boolean;
  continente:string="0";
  paises:Array<string>=[]
  paisSeleccionado:string="0"

  constructor(private service:PaisesService){
    this.title="estamos en un curso de angular empezando"
    this.flag=false
  }

  cambiarPais(){

  }

  cargarPaises():void{
    this.flag=!this.flag;
    this.service.dameDatos("https://restcountries.com/v3.1/region/"+
    this.continente).subscribe((datos:any)=>{
      this.paises=[];
      datos.forEach((pais:any) => {
        this.paises.push(pais.name.common)
      });
    });
  }


}
