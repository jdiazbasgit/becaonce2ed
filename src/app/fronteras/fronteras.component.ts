
import { DoCheck, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-fronteras',
  templateUrl: './fronteras.component.html',
  styleUrls: ['./fronteras.component.css']
})
export class FronterasComponent implements DoCheck {

  //@Input() pais:string | undefined="";
  paisEnRuta:string=""
  datos:any;
  

constructor(private rutaActiva:ActivatedRoute,  service:PaisesService){
  
}
  ngDoCheck(): void {
    this.paisEnRuta=this.rutaActiva.snapshot.params['pais'];
    this.service.dameDatos("https://restcountries"+this.paisEnRuta)
    .suscribe((this.datos:any)=>{
      this.datos=datos[0];
    })

  }

}
