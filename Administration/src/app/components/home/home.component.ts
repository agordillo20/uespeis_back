import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  isloggin:boolean=false;

  checkedResult(result:string){
    if(result!="OK"){
      alert(result)
    }else{
      this.loadProfile()
    }
  }


  private loadProfile(){
    this.isloggin=true;
  }

}
