import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AuthGuard } from './auth.guard';
import { CartComponent } from './cart/cart.component';
import { CartitemComponent } from './cartitem/cartitem.component';
import { ContactComponent } from './contact/contact.component';
import { CreateproductComponent } from './createproduct/createproduct.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OrderComponent } from './order/order.component';
import { ProductviewComponent } from './productview/productview.component';
import { ProlistComponent } from './prolist/prolist.component';
import { RegComponent } from './reg/reg.component';
import { UpdateproductComponent } from './updateproduct/updateproduct.component';
import { ViewusersComponent } from './viewusers/viewusers.component';

const routes: Routes = [
  { path: "", redirectTo: 'home', pathMatch: 'full' },
  { path: "home", component: HomeComponent, canActivate: [AuthGuard] },
  { path: "reg", component: RegComponent, canActivate: [AuthGuard] },
  { path: "login", component: LoginComponent, canActivate: [AuthGuard] },
  { path: "contact", component: ContactComponent, canActivate: [AuthGuard] },
  { path: "about", component: AboutComponent, canActivate: [AuthGuard] },
  { path: "alogin", component: AdminloginComponent, canActivate: [AuthGuard] },
  { path: "prolist", component: ProlistComponent },
  { path: "createpro", component: CreateproductComponent },
  { path: "updatepro/:id", component: UpdateproductComponent },
  { path: "viewpro", component: ProductviewComponent },
  { path: 'cart', component: CartComponent },
  { path: 'order', component: OrderComponent },
  { path: 'cartitem/:id', component: CartitemComponent },
  { path: 'viewusr', component: ViewusersComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
