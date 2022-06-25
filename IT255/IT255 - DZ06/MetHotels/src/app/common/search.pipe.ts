import { Pipe, PipeTransform } from "@angular/core";
import {Apartment} from "./@Types/apartment";

@Pipe({
  name: "search"
})
export class SearchPipe implements PipeTransform {

  transform(apartments: Apartment[], searchNum: number): Apartment[] {
    if (!apartments) {
      return [];
    }
    if (!searchNum) {
      return apartments;
    }
    return apartments.filter(p => {
      return p.price <= searchNum;
    });
  }

}
