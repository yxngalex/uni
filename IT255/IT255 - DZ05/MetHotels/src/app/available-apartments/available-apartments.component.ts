import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-available-apartments',
  templateUrl: './available-apartments.component.html',
  styleUrls: ['./available-apartments.component.scss']
})
export class AvailableApartmentsComponent implements OnInit {

  public availableApartments = [
    {
      room: 1,
      floor: 1,
      price: 1000,
      desc: 'Lorem Ipsum is simply dummy text' +
        ' of the printing and typesetting industry. ' +
        'Lorem Ipsum has been the industry\'s standard dummy' +
        ' text ever since the 1500s, when an unknown printer took a ' +
        'galley of type and scrambled it to make a type specimen book'
    },
    {
      room: 2,
      floor: 1,
      price: 1000,
      desc: 'Lorem Ipsum is simply dummy text' +
        ' of the printing and typesetting industry. ' +
        'Lorem Ipsum has been the industry\'s standard dummy' +
        ' text ever since the 1500s, when an unknown printer took a ' +
        'galley of type and scrambled it to make a type specimen book'
    },
  ];

  @Input() newApartment: any;

  constructor() {
  }

  ngOnInit(): void {
    if (this.newApartment) {
      this.availableApartments.push(this.newApartment);
    }
  }
}
