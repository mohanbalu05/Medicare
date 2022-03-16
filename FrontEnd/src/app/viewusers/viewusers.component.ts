import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Registration } from '../registration';
import { RegistrationService } from '../service/registration.service';

@Component({
  selector: 'app-viewusers',
  templateUrl: './viewusers.component.html',
  styleUrls: ['./viewusers.component.css']
})
export class ViewusersComponent implements OnInit {

  user: Registration[] = [];

  constructor(private service: RegistrationService,
    private router: Router) { }

  ngOnInit(): void {
    this.getProducts();
  }

  private getProducts(){
    this.service.getUsersList().subscribe(data => {
      this.user = data;
    });
  }

  logout() {
    if (window.confirm('Are you sure to logout?')) {
      this.router.navigate(['/home']);
      localStorage.clear()
    }
  }
  
  back() {
    this.router.navigate(['/prolist']);
  }
}
