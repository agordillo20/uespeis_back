import { inject, NgModule } from '@angular/core';
import { CanActivateFn, Router, RouterModule, Routes } from '@angular/router';
import { map, take } from 'rxjs';
import { FilterComponent } from '../components/filter/filter.component';
import { FormulariosComponent } from '../components/formularios/formularios.component';
import { HomeComponent } from '../components/home/home.component';
import { LoginComponent } from '../components/login/login.component';
import { RelationsComponent } from '../components/relations/relations.component';
import { AuthPersistenceService } from './auth-persistence.service';
import { FicherosComponent } from '../components/ficheros/ficheros.component';

const canActivate:CanActivateFn = () => {
  let router = inject(Router)
  let AuthPersistence = inject(AuthPersistenceService)
  return AuthPersistence.isAuthenticated().pipe(
    take(1),
    map((res) => {
      if (res) {
        return true;
      }
      return router.createUrlTree(['/login']);
    })
  );
}

const routes: Routes = [
  {path: '',component:HomeComponent},
  {path: 'formularios', component: FormulariosComponent,canActivate: [canActivate]},
  {path:'filtros',component:FilterComponent,canActivate:[canActivate]},
  {path:'relaciones',component:RelationsComponent,canActivate:[canActivate]},
  {path:'archivos',component:FicherosComponent,canActivate:[canActivate]},
  {path: 'login', component: LoginComponent},
  {path: '**', redirectTo: ''}
];




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
