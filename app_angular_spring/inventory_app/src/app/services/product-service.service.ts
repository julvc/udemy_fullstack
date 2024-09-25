import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private urlBase = "http://localhost:8080/inventory-app/products";

  constructor(private http: HttpClient) { }

  obtainProductList(): Observable<Product[]>{
    return this.http.get<Product[]>(this.urlBase);
  }
}
