import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  localStorage: any;

  constructor() { }

  authUser(user: any){
    let UserArray=[{email:'admin@gmail.com',password:'Admin@123'}];
    
    return UserArray.find((p: { email: any; password: any; }) => p.email ===user.email && p.password === user.password);
  }

  authUser1(user: any){
    let UserArray=[{email:'user@gmail.com',password:'Users@123'}];
    
    return UserArray.find((p: { email: any; password: any; }) => p.email ===user.email && p.password === user.password);
  }

  isUserLoggedIn(){
    return true;
  }
}
