import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-generales',
  templateUrl: './generales.component.html',
  styleUrls: ['./generales.component.css']
})
export class GeneralesComponent implements OnInit {
  paisEnRuta: string = ""

  monedas: Array<any> = []
  datos: any


  constructor(private rutaActiva: ActivatedRoute, private service: PaisesService) {
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais']
  }

  ngOnInit(): void {
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];

    
    console.log("pais:" + this.paisEnRuta)
    this.service.dameDatos("https://restcountries.com/v3.1/name/" + this.paisEnRuta)

      .then((datos: any) => {
        console.log(datos)
        this.datos = datos[0];

        Object.keys(this.datos.currencies).forEach(moneda => this.monedas.push(this.datos.currencies[moneda]))

      });
  }
}


