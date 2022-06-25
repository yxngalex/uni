import {Injectable} from "@angular/core";

@Injectable()

export class RoomService {
  constructor() {}

  getPrice(numOfNights: number, nightPrice: number): number {
    return numOfNights * nightPrice;
  }
}
