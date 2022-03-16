import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Payment } from '../payment';
import { CartService } from '../service/cart.service';
import { PaymentService } from '../service/payment.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  items = this.cartService.getItems();

  pay: Payment = new Payment();


  constructor(private cartService: CartService, private router: Router,
    private service: PaymentService) { }

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

  getTotal() {
    let total = 0;
    for (var i = 0; i < this.items.length; i++) {
      if (this.items[i].price) {
        total += this.items[i].price;
      }
    }
    return total / 100 * 90;
  }

  clearItem(){
    this.cartService.clearCart();
  }

  reloadComponent() {
    let currentUrl = this.router.url;
        this.router.routeReuseStrategy.shouldReuseRoute = () => false;
        this.router.onSameUrlNavigation = 'reload';
        this.router.navigate([currentUrl]);
    }

    order(){
      if (window.confirm('Click Ok to Pay!!')) {
        this.router.navigate(['/order']);
      }
    }

    savePay(){
      this.service.createPayment(this.pay).subscribe( data =>{
        console.log(data);
      },
      error => console.log(error));
    }
}
