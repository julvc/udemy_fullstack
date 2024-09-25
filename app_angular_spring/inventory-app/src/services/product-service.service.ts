import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  private urlBase = "http://localhost:8080/inventory-app/products"

  constructor(private clientHttp: HttpClient) { }

  obtainProductList(): Observable<Product[]>{
    return this.clientHttp.get<Product[]>(this.urlBase);
  }
}
