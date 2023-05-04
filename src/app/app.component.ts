import { Component } from '@angular/core';
import { PaisesService } from './paises.service';
import { CountryService } from './countryService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title:string ;
  edad:number=234;
  fecha:Date= new Date()
  flag:boolean;
  continente:string="0";
  paises:Array<string>=[]
  paisSeleccionado:string="0"
  textoContinente:string="continente";
  textoPais:string="pais";

  countryName: string="";

  constructor(private service:PaisesService, private countryService: CountryService){
  
    this.title="estamos en un CURSO de angular empezando"
    this.flag=false

    const borderCode = 'USA';
    this.countryService.getCountryNameByCode(borderCode)
    .subscribe((response:any)=> {const country = response [0];
    this.countryName = country.name.common;
    
  });


  }

  cambiarPais(){

  }

  cargarPaises():void{
    this.flag=!this.flag;
    this.service.dameDatos("https://restcountries.com/v3.1/region/"+this.continente)
    .then((datos:any)=>{
      this.paises=[];
      datos.forEach((pais:any) => {
        this.paises.push(pais.name.common)
      });
    })
  }



}
