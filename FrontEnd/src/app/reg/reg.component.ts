import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ConfirmedValidator } from '../ConfirmedValidator';
import { Registration } from '../registration';
import { RegistrationService } from '../service/registration.service';

@Component({
  selector: 'app-reg',
  templateUrl: './reg.component.html',
  styleUrls: ['./reg.component.css']
})
export class RegComponent implements OnInit {
  regForm!: FormGroup;
  users: Registration = new Registration();
  constructor(private formBuilder: FormBuilder, private router: Router, 
    private service: RegistrationService, private http: HttpClient) { }
 
  ngOnInit(): void {
    this.regForm = this.formBuilder.group({
      cname: ['', Validators.required],
      mobile: ['', Validators.required],
      email: ['', Validators.required],
      gender: ['', Validators.required],
      address: ['', Validators.required],
      password: ['', Validators.required],
      repassword: ['', Validators.required],
    }, { 
      validator: ConfirmedValidator('password', 'repassword')
    })
  }

  saveProduct(){
    this.service.createUsers(this.regForm.getRawValue()).subscribe( data =>{
      console.log(data);
      // this.goToLogin();
    },
    error => console.log(error));
  }

  // goToLogin(){
  //   this.router.navigate(['/login']);
  // }
  
  onSubmit(){
    console.log(this.users);
    this.saveProduct();
    console.log(this.regForm.value);
  }

  signUp(){
    this.http.post<any>("http://localhost:3000/signupUsers",this.regForm.value)
    .subscribe(res=>{
      alert("Registered Successfull");
      this.router.navigate(['/login']);
    },
    err=>{
      alert("Something went wrong");
    })
  }
}
