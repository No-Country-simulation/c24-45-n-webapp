import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { LoginData } from '../../shared/models/login.interface';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { TokenData } from '../../shared/models/jwt.interface';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl:string = environment.baseUrl

  _http = inject(HttpClient)

  login({email, password}:LoginData):Observable<TokenData>{
    return this._http.post<TokenData>(`${this.baseUrl}/login`, {email, password})
  }
}
