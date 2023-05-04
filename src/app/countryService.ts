import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({

    providedIn: 'root'
})
export class CountryService {
    private apiUrl='https://restcountries.com/v3.1/name/';

    constructor(private http: HttpClient) {}

    getCountryNameByCode(code: string){
        return this.http.get('${this.apiUrl}${code}');
    }
}