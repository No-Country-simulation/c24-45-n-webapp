import { effect, inject, Injectable, signal } from '@angular/core';
import { jwtDecode } from 'jwt-decode';
import { Router } from '@angular/router';
import { TokenData } from '../../shared/models/jwt.interface';

@Injectable({
  providedIn: 'root'
})
export class JwtService {

  private router = inject(Router);

  tokenExist = signal<boolean>(!!localStorage.getItem('token'));
  user = signal<Omit<TokenData,'token'> | null>(null)
  private _decodedToken = signal<any | null>(this.loadToken());

  constructor(){
    effect(()=>{
      const data = localStorage.getItem('user')
      if(data){
        this.user.set(JSON.parse(data))
        this.tokenExist.set(true)
        this._decodedToken.set(localStorage.getItem('token'))
      }
    })
  }

  login(response: TokenData): void {
    const {token, ...rest} = response
    localStorage.setItem('token', token);
    localStorage.setItem('user', JSON.stringify(rest))
    this.tokenExist.set(true);
    this.user.set(rest)
    this._decodedToken.set(this.decodeToken(token));
    this.router.navigate(['/main/feed'], { replaceUrl: true });
  }

  logout(): void {
    localStorage.removeItem('token');
    this.tokenExist.set(false);
    this._decodedToken.set(null);
    this.user.set(null)
    this.router.navigate(['/home'], { replaceUrl: true });
  }

  isLogged(): boolean {
    return this.tokenExist();
  }

  private loadToken() {
    const token = localStorage.getItem('token');
    return token ? this.decodeToken(token) : null;
  }

  private decodeToken(token: string) {
    try {
      return jwtDecode(token);
    } catch (error) {
      return null;
    }
  }

  get currentUser() {
    return this.user();
  }
}
