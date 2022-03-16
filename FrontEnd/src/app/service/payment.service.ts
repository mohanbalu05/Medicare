import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Payment } from '../payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private baseURL = "http://localhost:8181/payments/payments";
  constructor(private httpClient: HttpClient) { }

  getPaymentList(): Observable<Payment[]>{
    return this.httpClient.get<Payment[]>(`${this.baseURL}`);
  }

  createPayment(cart: Payment): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, cart);
  }
}
