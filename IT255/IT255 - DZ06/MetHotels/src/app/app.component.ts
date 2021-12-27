import {Component, Input, OnInit} from "@angular/core";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {AddApartmentComponent} from "./apartment-crud/add-apartment/add-apartment.component";
import {Apartment} from "./common/@Types/apartment";
import {EditApartmentComponent} from "./apartment-crud/edit-apartment/edit-apartment.component";
import {RoomService} from "./common/services/room.service";
import {DeleteApartmentComponent} from "./apartment-crud/delete-apartment/delete-apartment.component";
import {CheckoutApartmentComponent} from "./apartment-crud/checkout-apartment/checkout-apartment.component";
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {AppState} from "./common/redux/app.state";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"]
})
export class AppComponent implements OnInit {

  apartment$: Observable<Apartment[]>;

  @Input() apartment: Apartment;

  constructor(public dialog: MatDialog, private service: RoomService, private store: Store<AppState>) {
    this.apartment$ = this.store.select("apartment");
  }

  ngOnInit(): void {
  }

  add(): void {
    const dialogConf = new MatDialogConfig();
    dialogConf.autoFocus = true;
    dialogConf.width = "50%";
    const dialogRef = this.dialog.open(AddApartmentComponent, dialogConf);
    dialogRef.afterClosed().subscribe(() => {
    });
  }

}
