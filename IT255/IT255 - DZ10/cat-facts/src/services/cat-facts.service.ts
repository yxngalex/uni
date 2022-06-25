import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../environments/environment";
import {CatFacts} from "../models/catFacts";

@Injectable({
  providedIn: 'root'
})
export class CatFactsService {

  constructor(private http: HttpClient) { }

  get(animalType: string, amount: number): Observable<CatFacts[]> {
    return this.http.get<CatFacts[]>(`${environment.api}/facts/random?animal_type=${animalType}&amount=${amount}`, {responseType: "json"});
  }
}
