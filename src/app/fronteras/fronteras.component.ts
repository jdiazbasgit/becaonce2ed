
import { DoCheck, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Component } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-fronteras',
  templateUrl: './fronteras.component.html',
  styleUrls: ['./fronteras.component.css']
})
export class FronterasComponent implements OnInit {

  //@Input() pais:string | undefined="";
  paisEnRuta: string = ""
  datos: any;
  fronteras: Array<string> = []
  fronterasAcronimos: Array<string> = []
  resuelto:boolean = false
  
  constructor(private rutaActiva: ActivatedRoute, private service: PaisesService) {
    //this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
  }
  ngOnInit(): void {
    console.log("entro en on init")

    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
    console.log("pais:" + this.paisEnRuta)
    this.service.dameDatos("https://restcountries.com/v3.1/name/" + this.paisEnRuta)
      .then((datos: any) => {
        console.log(datos)
        this.datos = datos[0];
        console.log(datos[0].borders)
        if (datos[0].borders != undefined){
          this.fronteras = datos[0].borders

          //***Lo sacamos al Pipe Acronimos */
          //this.fronterasAcronimos = datos[0].borders
          // this.fronterasAcronimos.forEach(acronimo => {
          //   this.service.dameDatos("https://restcountries.com/v3.1/alpha/"+acronimo)
          //     .then((datosPaisAcronimo: any) =>{
          //       this.fronteras.push(datosPaisAcronimo[0].name.common)
          //     }
          //   )
          //   }
          // );
        }
        else{
          this.fronteras = ["Este país no tiene fronteras declaradas"]
        }
      })   
  }

}










