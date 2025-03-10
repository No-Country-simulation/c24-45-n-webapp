import { CanActivateFn, Router } from '@angular/router';
import { inject } from '@angular/core';
import { JwtService } from '../services/jwt.service';

export const authGuard: CanActivateFn = (route, state) => {

  const jwtSvc = inject(JwtService)
  const router = inject(Router)

  function canActivate(){
    const isLogged = jwtSvc.isLogged
    if(!isLogged()){
      router.navigate(['/login'],{replaceUrl:true})
      return false
    }
    return true
  }

  return canActivate()
};

