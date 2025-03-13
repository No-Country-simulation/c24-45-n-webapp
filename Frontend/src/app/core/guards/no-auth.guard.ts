import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { JwtService } from '../services/jwt.service';

export const noAuthGuard: CanActivateFn = (route, state) => {

  const jwtSvc = inject(JwtService)
  const router = inject(Router)

  function canActivate() {
      const isLogged = jwtSvc.isLogged
      console.log(isLogged)
      if(isLogged()){
        router.navigate(['/main/feed'], {replaceUrl:true})
        return false
      }
      return true
  }
  return canActivate();
};
