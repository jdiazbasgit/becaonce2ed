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
  datos:any;
  rutaBandera: string = "";
  rutaEscudo: string ="";

  constructor(private rutaActiva:ActivatedRoute, private service: PaisesService){
    this.paisEnRuta = this.rutaActiva.snapshot.params['pais'];
  }
    
    
    ngOnInit(): void {
      
      this.paisEnRuta=this.rutaActiva.snapshot.params['pais'];
      console.log("pais:"+ this.paisEnRuta)
      this.service.dameDatos("https://restcountries.com/v3.1/name/" + 
      this.paisEnRuta).then((datos: any)=>{
        console.log(datos)
        this.datos = datos[0];
        this.rutaBandera = this.datos.flags.png;
        this.rutaEscudo = this.datos.coatOfArms.png;
      });
    }
  
}
