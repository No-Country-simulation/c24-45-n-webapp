import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { LoginData } from '../../shared/models/login.interface';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { TokenData } from '../../shared/models/jwt.interface';
import { UserRegistrationData } from '../../shared/models/user.interface';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl: string = environment.baseUrl

  _http = inject(HttpClient)

  login({ email, password }: LoginData): Observable<TokenData> {
    return this._http.post<TokenData>(`${this.baseUrl}/login`, { email, password })
  }

  register({ userName, email, password, password2 }: UserRegistrationData): Observable<any> {
    return this._http.post<any>(`${this.baseUrl}/volunteer/register`, {userName, email,password, password2})
  }
}
