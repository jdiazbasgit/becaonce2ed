import { Component, OnInit } from '@angular/core';
import { PaisesService } from '../paises.service';

@Component({
  selector: 'app-odin',
  templateUrl: './odin.component.html',
  styleUrls: ['./odin.component.css']
})
export class OdinComponent implements OnInit{

saludo:string=""
nombrePais:string=""
pais:string="cuba"
constructor(private service:PaisesService){}

ngOnInit(): void {
  this.service.getDatos("https://restcountries.com/v3.1/name/"+this.pais)
  .subscribe((dato:any)=>{
    //this.nombrePais=dato[0].name.official
    this.nombrePais=dato[0].translations.hun.official
  })
}

}
