import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Products } from '../products';
import { CartService } from '../service/cart.service';
import { ProductsService } from '../service/products.service';

@Component({
  selector: 'app-productview',
  templateUrl: './productview.component.html',
  styleUrls: ['./productview.component.css']
})
export class ProductviewComponent implements OnInit {
  product: Products[] = [];
  constructor(private service: ProductsService,private router: Router,private cartService: CartService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  private getProducts(){
    this.service.getProductsList().subscribe(data => {
      this.product = data;
    });
  }

  logout() {
    if (window.confirm('Are you sure to logout?')) {
      this.router.navigate(['/home']);
      localStorage.clear()
    }
  }

  addToCart(product: Products) {
    this.cartService.addToCart(product);
    window.alert('Your product has been added to the cart!');
    this.router.navigate(['/cart'])
  }

  checkProducts(id: number){
    this.router.navigate(['cartitem', id]);
  }
}
