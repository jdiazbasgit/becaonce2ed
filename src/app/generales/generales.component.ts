import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';


@Component({
  selector: 'app-generales',
  templateUrl: './generales.component.html',
  styleUrls: ['./generales.component.css']
})

export class GeneralesComponent implements OnInit {

  paisEnRuta: string = "";
  datos: any;
  monedas: Array<any> = [];
  /*dirNombre: string = "";
  dirPoblacion: string = "";
  dirLongitud: string = "";
  dirCapital: string = "";*/


  constructor(private rutaActiva: ActivatedRoute, private service: PaisesService) {

    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];

  }

  ngOnInit(): void {
    
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
    

    this.service.dameDatos("https://restcountries.com/v3.1/name/" +
      this.paisEnRuta).subscribe((datos: any) => {
        
        this.datos = [0];

        //this.dirNombre = this.datos.name.common;
        //this.dirPoblacion = this.datos.population;
        //this.dirLongitud = this.datos.latlng;
        //this.dirCapital = this.datos.capital;

        Object.keys(this.datos.curencies)
          .forEach(moneda => this.monedas.push(this.datos.currencies[moneda]))

      });

  }
}
