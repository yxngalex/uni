import {Directive, HostBinding, Input, OnChanges} from '@angular/core';
import {ApartmentTypes} from './d-logo.types';

@Directive({
  selector: "[appDLogo]"
})
export class DLogoDirective implements OnChanges {

  @HostBinding("src")
  imageSource;

  @Input()
  roomNumber: number;

  constructor() {
  }

  ngOnChanges(): any {
    this.imageSource = "assets/" + this.getApartmentFromRoomNumber() + ".jpg";
    console.log(this.getApartmentFromRoomNumber());
  }

  getApartmentFromRoomNumber(): ApartmentTypes {
    if (this.roomNumber) {
      if (this.roomNumber > 0 && this.roomNumber <= 4) {
        return ApartmentTypes.APARTMENT1;
      } else if (this.roomNumber > 4 && this.roomNumber <= 8) {
        return ApartmentTypes.APARTMENT2;
      } else if (this.roomNumber > 8 && this.roomNumber <= 12) {
        return ApartmentTypes.APARTMENT3;
      } else if (this.roomNumber === 0) {
        return ApartmentTypes.UNKNOWN;
      } else {
        return ApartmentTypes.APARTMENT4;
      }
    }
  }
}
