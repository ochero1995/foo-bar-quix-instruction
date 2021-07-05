import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FooBarQuixService {
  constructor(private http: HttpClient) {
    console.log(this.http.get("http://localhost:3000/33"));
  }

  convertNumber(inputNumber: number): Observable<any>{
    return this.http.get(`http://localhost:3000/foo-bar-quix/${inputNumber}`);
  }
}
