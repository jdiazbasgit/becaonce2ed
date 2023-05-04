import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaisesService {

  constructor(private http: HttpClient) { }

  //dameDatos(url:string):any{
    //return this.service.get(url);
    /*return new Promise((resolve,reject)=>{
      fetch(url).then(response=>{
        console.log(response)
        return response.json()
        
      })
      .then(datos=>resolve(datos)).catch(error=>reject(error));
    });*/
  //}

  dameDatos(url:string): Observable<any>{
    return this.http.get(url).pipe(
      catchError(err=>{
        console.error(err);
        return of (null);
      })
    );
  }

}
