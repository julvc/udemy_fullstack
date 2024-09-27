import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { ProductService } from '../../services/product-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
})
export class ProductListComponent implements OnInit{
  products: Product[];

  constructor(private productService: ProductService, private router: Router){}

  ngOnInit(){
    //carga de productos
    this.obtainProducts();
  }

  private obtainProducts(){
    this.productService.obtainProductList().subscribe(
      (data => {
        this.products = data;
      })
    );
  }

  editProduct(id: number){
    this.router.navigate(['edit-product',id])
  }

  deleteProduct(id:number){
    this.productService.deleteProduct(id).subscribe({
      next: (data) => this.obtainProducts(),
      error: (error) => console.error(error)
    });
  }
}
