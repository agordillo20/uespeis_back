import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthPersistenceService } from 'src/app/utils/auth-persistence.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  //TODO:Fixear tema del login/logout que cambie la variable de isLoggin bien

  isLoggin:boolean=false;
  constructor(private authService:AuthPersistenceService,private router:Router){
    authService.isAuthenticated().subscribe(res=>this.isLoggin=res)
  }

  logout(){
    this.isLoggin =false;
    this.authService.logOut()
    this.router.navigateByUrl("/home")
  }

}
