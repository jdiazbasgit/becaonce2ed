import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private serviceHttp:HttpClient) { }

  dameDatosPorHTTPService(url:string):any{
    return this.serviceHttp.get(url)
  }
}
