import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Products } from '../products';
import { CartService } from '../service/cart.service';
import { ProductsService } from '../service/products.service';

@Component({
  selector: 'app-cartitem',
  templateUrl: './cartitem.component.html',
  styleUrls: ['./cartitem.component.css']
})
export class CartitemComponent implements OnInit {
  product: Products = new Products();
  id!: number; 
  constructor(private service: ProductsService, private cartService: CartService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.service.getProductsById(this.id).subscribe(data => {
      this.product = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.cartService.createCart(this.product).subscribe( data =>{
      console.log(data);
    }
    , error => console.log(error));
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
    this.router.navigate(['/cart']);
  }
}
