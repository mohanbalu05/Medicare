import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../cart';
import { Products } from '../products';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  items: Products[] = [];
  private baseURL = "http://localhost:8181/carts/carts";
  constructor(private httpClient: HttpClient) { }

  addToCart(product: Products) {
    this.items.push(product);
  }

  getItems() {
    return this.items;
  }

  clearCart() {
    this.items = [];
    return this.items;
  }

  getCartList(): Observable<Cart[]>{
    return this.httpClient.get<Cart[]>(`${this.baseURL}`);
  }

  createCart(cart: Cart): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, cart);
  }
}
