import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-geograficos',
  templateUrl: './geograficos.component.html',
  styleUrls: ['./geograficos.component.css']
})
export class GeograficosComponent {
  paisEnRuta:string=""
  datos:any
  datosGeo:Array<string> = []  

  constructor(private rutaActiva: ActivatedRoute, private service: PaisesService) {
  }
    
  ngOnInit(): void {
    console.log("entro en on init")

    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
    console.log("pais:" + this.paisEnRuta)


    // this.service.dameDatos("https://restcountries.com/v3.1/name/" + this.paisEnRuta)
    //   .then((datos: any) => {
    //     console.log(datos)
    //     this.datos = datos[0];
    //     this.datosGeo.push("Latitud - Longitud: " + this.datos.latlng[0] + " - " + this.datos.latlng[1])
    //     this.datosGeo.push("Población: " + this.datos.population)
    //   })

    this.service.dameDatosPorHTTPService("https://restcountries.com/v3.1/name/" + this.paisEnRuta)
      .subscribe((datosQueRecibo:any)=>{
        this.datos = datosQueRecibo[0];
        this.datosGeo.push("Latitud - Longitud: " + this.datos.latlng[0] + " - " + this.datos.latlng[1])
        this.datosGeo.push("Población: " + this.datos.population)
      })
  }
  
  
}
