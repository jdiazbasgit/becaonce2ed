import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-banderas',
  templateUrl: './banderas.component.html',
  styleUrls: ['./banderas.component.css']
})
export class BanderasComponent {
  paisEnRuta: string = ""
  banderas: Array<any> = []
  datos: any;
  escudo: string = "";
  flag: boolean = true;


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
        this.escudo = this.datos.coatOfArms.png;
        this.banderas = this.datos.flags.png;
       
      })
  }

}
