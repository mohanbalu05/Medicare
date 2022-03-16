import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegComponent } from './reg/reg.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { ProlistComponent } from './prolist/prolist.component';
import { CreateproductComponent } from './createproduct/createproduct.component';
import { UpdateproductComponent } from './updateproduct/updateproduct.component';
import { ProductviewComponent } from './productview/productview.component';
import { CartComponent } from './cart/cart.component';
import { OrderComponent } from './order/order.component';
import { AuthGuard } from './auth.guard';
import { CartitemComponent } from './cartitem/cartitem.component';
import { ViewusersComponent } from './viewusers/viewusers.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegComponent,
    ContactComponent,
    AboutComponent,
    HomeComponent,
    AdminloginComponent,
    ProlistComponent,
    CreateproductComponent,
    UpdateproductComponent,
    ProductviewComponent,
    CartComponent,
    OrderComponent,
    CartitemComponent,
    ViewusersComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
