import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-fronteras',
  templateUrl: './fronteras.component.html',
  styleUrls: ['./fronteras.component.css']
})
export class FronterasComponent implements OnInit {

  paisEnRuta: string = "";
  datos: any;
  fronteras: Array<any> = [];

  constructor(private rutaActiva: ActivatedRoute, private service: PaisesService) {
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
  }

  ngOnInit(): void {
    console.log("entro en on init")

    this.service.dameDatos("https://restcountries.com/v3.1/name/" + this.paisEnRuta)
      .then((datos: any) => {
        console.log(datos)
        this.datos = datos[0];
        let promises = datos[0].borders.map((border: string) => {
          return this.service.dameDatos("https://restcountries.com/v3.1/alpha/" + border)
            .then((datos: any) => {
              return datos[0].name.common;
            })
        });
        Promise.all(promises).then((names) => {
          this.fronteras = names;
        });
      })
  }

}












