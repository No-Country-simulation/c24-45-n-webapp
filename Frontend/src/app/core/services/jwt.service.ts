import { inject, Injectable, signal } from '@angular/core';
import { jwtDecode } from 'jwt-decode'
import { Volunteer } from '../../shared/models/volunteer.interface';

@Injectable({
  providedIn: 'root'
})
export class JwtService {

  private _decodedToken = signal<any | null>(this.loadToken())
  private _isLogged = signal<boolean>(!!localStorage.getItem('token'));
  private user = signal<Partial<Volunteer>>({})

  private loadToken(){
    const token = localStorage.getItem('token')
    return token ? this.decodeToken(token) : null
  }

  get isLogged(){
    return this._isLogged
  }

  get userLogged(){
    const userid = this.currentUser.sub
    return userid
  }

  decodeToken(token:string){
    try {
      return  jwtDecode(token)
    } catch (error) {
      return null
    }
  }

  get currentUser(){
    return this._decodedToken()
  }

  get decodedToken(){
    return this._decodedToken;
  }

}
