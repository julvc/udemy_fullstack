import { Component } from '@angular/core';
import { Product } from '../../models/product';
import { ProductService } from '../../services/product-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrl: './edit-product.component.css'
})
export class EditProductComponent {
  product: Product = new Product();
  id: number;

  constructor(private productService: ProductService, private route:ActivatedRoute,
    private router: Router) { }
  
  ngOnInit(){
    this.id = this.route.snapshot.params['id'];
    this.productService.obtainProductbyId(this.id).subscribe(
      {
        next: (data) => this.product = data
        ,
        error: (errors: any) => console.log(errors)
      }
    );
  }

  onSubmit(){
    this.modifyProduct();
  }
  
  modifyProduct(){
    this.productService.modifyProduct(this.id, this.product).subscribe(
      {
        next: (data) => this.goProductList()
        ,
        error: (errors: any) => console.log(errors)
      }
    );
  }

  goProductList(){
    this.router.navigate(['/products']);
  }
}
