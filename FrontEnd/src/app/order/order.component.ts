import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../service/cart.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  items = this.cartService.getItems();

  constructor(private cartService: CartService, private router: Router) { }

  ngOnInit(): void {
  }

  logout() {
    if (window.confirm('Are you sure to logout?')) {
      this.router.navigate(['/home']);
      localStorage.clear()
    }
  }

  back() {
    this.router.navigate(['/viewpro']);
  }

  print() {
    window.print();
    }

  getTotal() {
    let total = 0;
    for (var i = 0; i < this.items.length; i++) {
      if (this.items[i].price) {
        total += this.items[i].price;
      }
    }
    return total / 100 * 90;
  }

  reloadComponent() {
    let currentUrl = this.router.url;
        this.router.routeReuseStrategy.shouldReuseRoute = () => false;
        this.router.onSameUrlNavigation = 'reload';
        this.router.navigate(['/viewpro']);
    }
}
