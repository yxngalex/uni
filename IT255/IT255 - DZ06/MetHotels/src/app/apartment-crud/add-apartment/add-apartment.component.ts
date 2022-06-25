import {Component, OnInit} from "@angular/core";
import {MatDialogRef} from "@angular/material/dialog";
import {AppState} from "../../common/redux/app.state";
import {Store} from "@ngrx/store";
import * as ApartmentActions from "../../common/redux/apartment/apartment-actions";

@Component({
  selector: "app-add-apartment",
  templateUrl: "./add-apartment.component.html",
  styleUrls: ["./add-apartment.component.scss"]
})
export class AddApartmentComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<AddApartmentComponent>, private store: Store<AppState>) {
  }

  addApartment(room, floor, price, desc): void {
    this.store.dispatch(new ApartmentActions.AddApartment({room, floor, price, desc}));
  }

  ngOnInit(): void {
  }
}
