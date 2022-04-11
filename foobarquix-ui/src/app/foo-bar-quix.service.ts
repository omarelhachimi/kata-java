import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})


export class FooBarQuixService {

  private REST_API_SERVER = "http://localhost:8080/foo-bar-quix/";

  constructor(private http: HttpClient) { }

  convertNumber(inputNumber: number) {
    return this.http.get(this.REST_API_SERVER + inputNumber)
  }

}
