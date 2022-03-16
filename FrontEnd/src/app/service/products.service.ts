import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Products } from '../products';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  private baseURL = "http://localhost:8181/products/products";

  constructor(private httpClient: HttpClient) { }
  
  getProductsList(): Observable<Products[]>{
    return this.httpClient.get<Products[]>(`${this.baseURL}`);
  }

  createProducts(products: Products): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, products);
  }

  getProductsById(id: number): Observable<Products>{
    return this.httpClient.get<Products>(`${this.baseURL}/${id}`);
  }

  updateProducts(id: number, products: Products): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, products);
  }

  deleteProducts(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
