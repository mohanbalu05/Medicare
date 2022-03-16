import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from '../login';
import { AuthService } from '../service/auth.service';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  constructor( private service:AuthService, private router: Router,
    private logService: LoginService) { }
  @Input()
  loginsForm: any = {
    email: '',
    password: '',
  };
  users: Login = new Login();

  ngOnInit(): void {

  }

  saveLogins(){
    this.logService.createLogins(this.loginsForm.value).subscribe( data =>{
      console.log(data);
      // this.goToLogin();
    },
    error => console.log(error));
  }

  onLogin(loginForm: NgForm) {
    console.log(loginForm.value);
    const user = this.service.authUser(loginForm.value);
    console.log(user);

    if (user) {
      localStorage.setItem('user', JSON.stringify(user));
      console.log('Login Successfully');
      alert("Welcome back :)\nClick ok to proceed!");
      this.router.navigate(['prolist'])

    }
    else {
      console.log('Login not Successfully');
      alert("User not found :(\nTry again!");
      loginForm.reset();
    }
  }
}
