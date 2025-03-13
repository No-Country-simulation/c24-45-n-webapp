import { computed, inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { JwtService } from '../services/jwt.service';

export const noProfileGuard: CanActivateFn = (route, state) => {

  const jwtSvc = inject(JwtService)
  const router = inject(Router)
  const user = computed(()=>jwtSvc.user())

  if(!user()?.name && !user()?.lastname && !user()?.address && !user()?.birthday && !user()?.phone){
    router.navigate(['/main/complete-register-volunteer'],{replaceUrl:true})
    return false
  }

  return true;
};
