import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-add-apartment',
  templateUrl: './add-apartment.component.html',
  styleUrls: ['./add-apartment.component.scss']
})
export class AddApartmentComponent implements OnInit {
  form = new FormGroup({
    room: new FormControl(null, [Validators.required]),
    price: new FormControl(null, [Validators.required]),
    desc:  new FormControl(null, [Validators.required])
  });

  @Output() apartmentObject: EventEmitter<any> = new EventEmitter<any>();
  apartment: any;

  constructor() { }

  ngOnInit(): void {
  }

  save(): void {
    if (this.form.valid) {
      this.apartment = this.form.value;
      this.apartmentObject.emit(this.apartment);
    }
  }
}
