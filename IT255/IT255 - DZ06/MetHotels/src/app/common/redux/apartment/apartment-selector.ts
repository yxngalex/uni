import {createSelector} from "@ngrx/store";

const selectApartment = state => state.apartment;

export const selector = createSelector(
  [selectApartment],
  apartment => apartment.apartment
);
