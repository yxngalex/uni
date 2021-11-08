import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-available-apartments',
  templateUrl: './available-apartments.component.html',
  styleUrls: ['./available-apartments.component.scss']
})
export class AvailableApartmentsComponent implements OnInit {

  availableApartments: string[] = [
    'Apartmen 1',
    'Apartmen 2',
    'Apartmen 3',
    'Apartmen 4',
    'Apartmen 5'
  ];

  selectedApartment: string;

  constructor() { }

  ngOnInit(): void {
    this.availableApartments.push(localStorage.getItem('apt'));
  }

  selected(value: string): void {
    this.selectedApartment = value;
  }
}
