import {Component, Input} from "@angular/core";
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
export class AppComponent {

  apartments: Observable<Apartment[]>;

  @Input() apartment: Apartment;

  constructor(public dialog: MatDialog, private service: RoomService, private store: Store<AppState>) {
    this.apartments = store.select("apartment");
  }

  openSaveDialog(): void {
    const dialogConf = new MatDialogConfig();
    dialogConf.autoFocus = true;
    dialogConf.width = "50%";
    const dialogRef = this.dialog.open(AddApartmentComponent, dialogConf);
    dialogRef.afterClosed().subscribe(() => {
    });
  }

  // deleteApartmant(apart: Apartment): void {
  //   const dialogConf = new MatDialogConfig();
  //   dialogConf.autoFocus = true;
  //   dialogConf.width = "50%";
  //   const dialogRef = this.dialog.open(DeleteApartmentComponent, dialogConf);
  //   dialogRef.afterClosed().toPromise().then(result => {
  //     if (result !== undefined) {
  //       if (result === true) {
  //         const index = this.availableApartments.indexOf(apart);
  //         if (index > -1) {
  //           this.availableApartments.splice(index, 1);
  //         }
  //       } else if (result === false) {
  //         dialogRef.close();
  //       }
  //     }
  //   });
  // }

  private fullPrice(numOfNights, apartmentPrice): number {
    return this.service.getPrice(numOfNights, apartmentPrice);
  }

  openBuyDialog(apartment: Apartment): void {
    const dialogConf = new MatDialogConfig();
    dialogConf.autoFocus = true;
    dialogConf.width = "50%";
    dialogConf.data = apartment;
    const dialogRef = this.dialog.open(CheckoutApartmentComponent, dialogConf);
    dialogRef.afterClosed().subscribe(numOfNights => {
      console.log(
        this.fullPrice(numOfNights.numOfNights, apartment.price)
      );
    });

  }
}
