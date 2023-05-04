import { DoCheck, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Component } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-generales',
  templateUrl: './generales.component.html',
  styleUrls: ['./generales.component.css']
})
export class GeneralesComponent implements OnInit {

  
  paisEnRuta: string = ""
  datos: any;
  flag: boolean = true;
  fronteras: Array<string> = []
  nombre:string='';
  capital:string='';
  poblacion: string='';
  moneda: string='';
  simbolo: string='';

  constructor(private rutaActiva: ActivatedRoute, private service: PaisesService) {
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
  }
  ngOnInit(): void {
    console.log("entro en on init")

    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
    console.log("pais:" + this.paisEnRuta)
    this.service.dameDatos("https://restcountries.com/v3.1/name/" + this.paisEnRuta)
      .then((datos: any) => {
        console.log(datos)
        this.datos = datos[0];
        this.fronteras =datos.borders;
        this.capital = datos.capital;
        this.poblacion = datos.population;
        this.moneda = datos.currencies[1].name;
        this.simbolo = datos.currencies[2].symbol;
 
      })
   

   
  }

}
