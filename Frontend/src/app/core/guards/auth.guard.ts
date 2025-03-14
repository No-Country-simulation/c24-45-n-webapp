import { CanActivateFn, Router } from '@angular/router';
import { computed, inject } from '@angular/core';
import { JwtService } from '../services/jwt.service';

export const authGuard: CanActivateFn = (route, state) => {

  const jwtSvc = inject(JwtService)
  const router = inject(Router)

  function canActivate(){
    const isUserLogged = computed(()=>jwtSvc.tokenExist())
    if(!isUserLogged()){
      router.navigate(['/login'],{replaceUrl:true})
      return false
    }
    return true
  }

  return canActivate()
};

