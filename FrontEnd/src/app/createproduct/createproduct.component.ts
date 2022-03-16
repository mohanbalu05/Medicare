import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Products } from '../products';
import { ProductsService } from '../service/products.service';

@Component({
  selector: 'app-createproduct',
  templateUrl: './createproduct.component.html',
  styleUrls: ['./createproduct.component.css']
})
export class CreateproductComponent implements OnInit {
  product: Products = new Products();
  constructor(private service: ProductsService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveProduct(){
    this.service.createProducts(this.product).subscribe( data =>{
      console.log(data);
      this.goToEmployeeList();
    },
    error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/prolist']);
  }
  
  onSubmit(){
    console.log(this.product);
    this.saveProduct();
  }

  logout() {
    if (window.confirm('Are you sure to logout?')) {
      this.router.navigate(['/home']);
      localStorage.clear()
    }
  }

}
