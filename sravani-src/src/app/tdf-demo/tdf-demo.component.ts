import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tdf-demo',
  templateUrl: './tdf-demo.component.html',
  styleUrls: ['./tdf-demo.component.css']
})
export class TdfDemoComponent {

 handleSubmit(formData:any):void{
   console.log(formData);
 }
 newhandleSubmit(formData:any):void{
  console.log(formData);
}
}
