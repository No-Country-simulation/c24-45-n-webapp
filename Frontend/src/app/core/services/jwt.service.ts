import { Injectable, signal } from '@angular/core';
import { jwtDecode } from 'jwt-decode'

@Injectable({
  providedIn: 'root'
})
export class JwtService {

  private _decodedToken = signal<any | null>(this.loadToken())

  private loadToken(){
    const token = localStorage.getItem('token')
    return token ? this.decodeToken(token) : null
  }

  get isLogged(){
    return localStorage.getItem('token') ? true : false
  }

  decodeToken(token:string){
    try {
      return  jwtDecode(token)
    } catch (error) {
      return null
    }
  }

  get decodedToken(){
    return this._decodedToken;
  }

}
