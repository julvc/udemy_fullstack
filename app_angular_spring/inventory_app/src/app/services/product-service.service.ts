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

  addProduct(product: Product): Observable<Object>{
    return this.http.post<Product[]>(this.urlBase, product);
  }

  obtainProductbyId(id: number){
    return this.http.get<Product>(`${this.urlBase}/${id}`);
  }

  modifyProduct(id: number, product: Product): Observable<Object>{
    return this.http.put(`${this.urlBase}/${id}`, product);
  }

  deleteProduct(id:number): Observable<Object>{
    return this.http.delete(`${this.urlBase}/${id}`);
  }
}
