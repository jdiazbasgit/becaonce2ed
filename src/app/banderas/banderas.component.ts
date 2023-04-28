import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-banderas',
  templateUrl: './banderas.component.html',
  styleUrls: ['./banderas.component.css']
})
export class BanderasComponent implements OnInit {
  paisEnRuta:string=""
  service: any;

  constructor(private rutaActiva:ActivatedRoute){
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
  }


    ngOnInit(): void {
      console.log("entro en on init")
      this.paisEnRuta=this.rutaActiva.snapshot.params['pais'];

      console.log("pais:" + this.paisEnRuta)
    this.service.dameDatos("https://restcountries.com/v3.1/name/" + this.paisEnRuta)
      .then((datos: any) => {
        console.log(datos)
        /*this.datos = datos[0];
        this.fronteras = datos.borders;*/
      })

    }

}
