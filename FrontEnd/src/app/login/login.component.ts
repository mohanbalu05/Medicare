import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from '../login';
import { AuthService } from '../service/auth.service';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private service: AuthService, private logService: LoginService,
     private http: HttpClient, private formBuilder: FormBuilder,) { }
  regForm!: FormGroup;
  users: Login = new Login();

  ngOnInit(): void {
    this.regForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
    },)
  }

  saveLogins(){
    this.logService.createLogins(this.regForm.getRawValue()).subscribe( data =>{
      console.log(data);
      // this.goToLogin();
    },
    error => console.log(error));
  }

  login(){
    this.http.get<any>("http://localhost:3000/signupUsers")
    .subscribe(res=>{
      const user = res.find((a:any)=>{
        return a.email === this.regForm.value.email && a.password === this.regForm.value.password
      });
      if(user){
        localStorage.setItem('user', JSON.stringify(this.regForm.value));
        console.log('Login Successfully');
        alert("Welcome back :)\nClick ok to proceed!");
        this.router.navigate(['viewpro'])
      }
      else{
        console.log('Login not Successfully');
        alert("User not found :(\nTry again!");
        this.regForm.reset();
      }
    },err=>{
      alert("Something went wrong");
    })
  }
  // onLogin(loginForm: NgForm) {
  //   console.log(loginForm.value);
  //   const user = this.service.authUser1(loginForm.value);
  //   console.log(user);

  //   if (user) {
      // localStorage.setItem('user', JSON.stringify(user));
      // console.log('Login Successfully');
      // alert("Welcome back :)\nClick ok to proceed!");
      // this.router.navigate(['viewpro'])

  //   }
  //   else {
      // console.log('Login not Successfully');
      // alert("User not found :(\nTry again!");
      // loginForm.reset();
  //   }
  // }

}
