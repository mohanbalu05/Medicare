import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseURL = "http://localhost:8181/logins/logins";
  
  constructor(private httpClient: HttpClient) { }

  getLoginsList(): Observable<Login[]>{
    return this.httpClient.get<Login[]>(`${this.baseURL}`);
  }

  createLogins(users: Login): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, users);
  }
}
