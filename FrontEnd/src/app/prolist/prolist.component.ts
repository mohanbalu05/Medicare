import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Products } from '../products';
import { ProductsService } from '../service/products.service';

@Component({
  selector: 'app-prolist',
  templateUrl: './prolist.component.html',
  styleUrls: ['./prolist.component.css']
})
export class ProlistComponent implements OnInit {
  
  product: Products[] = [];

  constructor(private service: ProductsService,
    private router: Router) { }

  ngOnInit(): void {
    this.getProducts();
  }

  private getProducts(){
    this.service.getProductsList().subscribe(data => {
      this.product = data;
    });
  }

  updateProducts(id: number){
    this.router.navigate(['updatepro', id]);
  } 

  deleteProducts(id: number){
    this.service.deleteProducts(id).subscribe( data => {
      console.log(data);
      this.getProducts();
    })
  }

  logout() {
    if (window.confirm('Are you sure to logout?')) {
      this.router.navigate(['/home']);
      localStorage.clear()
    }
  }
}
