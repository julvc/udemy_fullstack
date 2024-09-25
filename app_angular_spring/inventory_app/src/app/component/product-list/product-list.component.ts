import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { ProductService } from '../../services/product-service.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
})
export class ProductListComponent implements OnInit{
  products: Product[];

  constructor(private productService: ProductService){}

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
}
