import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PaisesService {

  constructor(private serviceHttp:HttpClient) { }

  dameDatos(url:string):any{
    return new Promise((resolve,reject)=>{
      fetch(url).then(response=>{
        console.log(response)
        return response.json()
        
      })
      .then(datos=>resolve(datos)).catch(error=>reject(error));
    })
  }

  dameDatosPorHTTPService(url:string):any{
    return this.serviceHttp.get(url)
  }

}
