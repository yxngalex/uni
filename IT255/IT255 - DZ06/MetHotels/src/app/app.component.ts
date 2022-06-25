import {Component, Input, OnInit} from "@angular/core";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {AddApartmentComponent} from "./apartment-crud/add-apartment/add-apartment.component";
import {Apartment} from "./common/@Types/apartment";
import {RoomService} from "./common/services/room.service";
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
