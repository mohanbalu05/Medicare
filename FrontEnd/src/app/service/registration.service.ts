import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Registration } from '../registration';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  private baseURL = "http://localhost:8181/users/users";

  constructor(private httpClient: HttpClient) { }
  
  getUsersList(): Observable<Registration[]>{
    return this.httpClient.get<Registration[]>(`${this.baseURL}`);
  }

  createUsers(users: Registration): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, users);
  }
}
