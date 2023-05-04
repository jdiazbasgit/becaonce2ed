import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PaisesService {

  constructor(private service: HttpClient) { }

  dameDatos(url:string):any{
    return this.service.get(url);
    /*return new Promise((resolve,reject)=>{
      fetch(url).then(response=>{
        console.log(response)
        return response.json()
        
      })
      .then(datos=>resolve(datos)).catch(error=>reject(error));
    });*/
  }

}
