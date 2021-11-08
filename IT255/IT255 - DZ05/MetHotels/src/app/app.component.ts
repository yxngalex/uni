import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'MetHotels';
  newApartment: any;

  apartmentObjectHandler(apartment: any): void {
    this.newApartment = apartment;
  }
}
