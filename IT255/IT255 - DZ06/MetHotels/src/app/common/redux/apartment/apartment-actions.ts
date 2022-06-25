import {ApartmentActionTypes} from "./apartment-types";
import {Action} from "@ngrx/store";
import {Apartment} from "../../@Types/apartment";

export class AddApartment implements Action {
  readonly type = ApartmentActionTypes.ADD_APARTMENT;

  constructor(public payload: Apartment) {
  }
}

export type Actions = AddApartment;
