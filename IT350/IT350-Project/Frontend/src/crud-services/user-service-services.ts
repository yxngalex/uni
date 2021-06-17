import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class UserServiceServices {

  constructor(private http: HttpClient) {
  }

  getAllUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${environment.apiUrl}/korisniks`, {responseType: 'json'});
  }

  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/korisniks/${id}`, {responseType: 'json'});
  }

  addUser(user: any): Observable<any> {
    return this.http.post<any>(`${environment.apiUrl}/korisniks`, user, {responseType: 'json'});
  }

  editUser(id: number): Observable<any> {
    return this.http.put<any>(`${environment.apiUrl}/korisniks`, id, {responseType: 'json'});
  }

}
