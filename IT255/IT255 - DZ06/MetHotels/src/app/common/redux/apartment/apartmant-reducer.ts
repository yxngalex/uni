import {ApartmentActionTypes} from "./apartment-types";
import {Apartment} from "../../@Types/apartment";
import * as ApartmentActions from "./apartment-actions";

const INITIAL_STATE = {
  room: 0,
  floor: 0,
  price: 0,
  desc: ""
};

export const apartmantReducer = (state: Apartment[] = [INITIAL_STATE], action: ApartmentActions.Actions) => {
  switch (action.type) {
    case ApartmentActionTypes.ADD_APARTMENT:
      return {
        ...state,
        aparment: action.payload
      };
    default:
      return state;
  }
};
