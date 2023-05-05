import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-banderas',
  templateUrl: './banderas.component.html',
  styleUrls: ['./banderas.component.css']
})
export class BanderasComponent {
  paisEnRuta:string=""
  

  constructor(private rutaActiva:ActivatedRoute, private service:PaisesService){
    
  }   
    ngOnInit(): void {
      this.paisEnRuta=this.rutaActiva.snapshot.params['pais'];
      this.service.dameDatos("https://restcountries.com/v3.1/name/" +this.paisEnRuta)
      
    }
  
}
