import { OnInit, Pipe, PipeTransform } from '@angular/core';
import { PaisesService } from './paises.service';

@Pipe({
  name: 'pipeFronteras'
})
export class PipeFronterasPipe implements PipeTransform,OnInit {

  constructor(private service:PaisesService){}

  ngOnInit(): void {
    console.log("entroooo")
   this.service.dameDatos("https://restcountries.com/v3.1/all")
   .subscribe((datos:any)=>{
    console.log(datos.length)
    datos.forEach((element:any) => {
      console.log(element.name.common)
    });
   })
  }



  transform(value: string, ...args: any[]): string {
    console.log("entroooo")
    
    this.service.dameDatos("https://restcountries.com/v3.1/all")
    .subscribe((datos:any)=>{
     datos.forEach((element:any) => {
      if(value==element.name.common)
      return element.name.common
       console.log(element.name.common)
     });
    })
    
  }

}
