import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductListComponent } from './component/product-list/product-list.component';
import { AddProductComponent } from './component/add-product/add-product.component';

//http://localhost/4200/products
const routes: Routes = [
  {path:'products', component: ProductListComponent},
  {path: '', redirectTo: 'products', pathMatch:'full'},
  {path: 'add-product', component: AddProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
