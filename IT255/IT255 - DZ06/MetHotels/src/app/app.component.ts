import {Component, Input} from "@angular/core";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {AddApartmentComponent} from "./apartment-crud/add-apartment/add-apartment.component";
import {Apartment} from "./common/@Types/apartment";
import {EditApartmentComponent} from "./apartment-crud/edit-apartment/edit-apartment.component";
import {RoomService} from "./common/services/room.service";
import {DeleteApartmentComponent} from "./apartment-crud/delete-apartment/delete-apartment.component";
import {CheckoutApartmentComponent} from "./apartment-crud/checkout-apartment/checkout-apartment.component";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"]
})
export class AppComponent {

  public availableApartments = [
    {
      id: 1,
      room: 1,
      floor: 1,
      price: 1000,
      desc: "Lorem Ipsum is simply dummy text" +
        " of the printing and typesetting industry. " +
        "Lorem Ipsum has been the industry's standard dummy" +
        " text ever since the 1500s, when an unknown printer took a " +
        "galley of type and scrambled it to make a type specimen book"
    },
    {
      id: 3,
      room: 3,
      floor: 1,
      price: 1000,
      desc: "Lorem Ipsum is simply dummy text" +
        " of the printing and typesetting industry. " +
        "Lorem Ipsum has been the industry's standard dummy" +
        " text ever since the 1500s, when an unknown printer took a " +
        "galley of type and scrambled it to make a type specimen book"
    },
    {
      id: 4,
      room: 4,
      floor: 1,
      price: 1000,
      desc: "Lorem Ipsum is simply dummy text" +
        " of the printing and typesetting industry. " +
        "Lorem Ipsum has been the industry's standard dummy" +
        " text ever since the 1500s, when an unknown printer took a " +
        "galley of type and scrambled it to make a type specimen book"
    },
    {
      id: 5,
      room: 5,
      floor: 1,
      price: 1000,
      desc: "Lorem Ipsum is simply dummy text" +
        " of the printing and typesetting industry. " +
        "Lorem Ipsum has been the industry's standard dummy" +
        " text ever since the 1500s, when an unknown printer took a " +
        "galley of type and scrambled it to make a type specimen book"
    },
    {
      id: 6,
      room: 6,
      floor: 1,
      price: 1000,
      desc: "Lorem Ipsum is simply dummy text" +
        " of the printing and typesetting industry. " +
        "Lorem Ipsum has been the industry's standard dummy" +
        " text ever since the 1500s, when an unknown printer took a " +
        "galley of type and scrambled it to make a type specimen book"
    },
    {
      id: 7,
      room: 7,
      floor: 1,
      price: 1000,
      desc: "Lorem Ipsum is simply dummy text" +
        " of the printing and typesetting industry. " +
        "Lorem Ipsum has been the industry's standard dummy" +
        " text ever since the 1500s, when an unknown printer took a " +
        "galley of type and scrambled it to make a type specimen book"
    },
  ];

  @Input() apartment: Apartment;

  constructor(public dialog: MatDialog, private service: RoomService) {
  }

  openSaveDialog(): void {
    const dialogConf = new MatDialogConfig();
    dialogConf.autoFocus = true;
    dialogConf.width = "50%";
    const dialogRef = this.dialog.open(AddApartmentComponent, dialogConf);
    dialogRef.afterClosed().subscribe(apart => {
      const apartId: number = this.availableApartments.length + 1;
      const apartment: Apartment = {
        id: apartId,
        room: apart.room,
        floor: apart.floor,
        price: apart.price,
        desc: apart.desc,
        numOfNights: apart.numOfNights
      };
      this.availableApartments.push(apartment);
    });
  }

  deleteApartmant(apartId: number): void {
    const dialogConf = new MatDialogConfig();
    dialogConf.autoFocus = true;
    dialogConf.width = "50%";
    const dialogRef = this.dialog.open(DeleteApartmentComponent, dialogConf);
    dialogRef.afterClosed().toPromise().then(result => {
      if (result !== undefined) {
        if (result === true) {
          this.availableApartments.slice(apartId);
        } else if (result === false) {
          dialogRef.close();
        }
      }
    });
  }

  private fullPrice(numOfNights, apartmentPrice): number {
    return this.service.getPrice(numOfNights, apartmentPrice);
  }

  openEditDialog(apartment: Apartment): void {
    const dialogConf = new MatDialogConfig();
    dialogConf.autoFocus = true;
    dialogConf.width = "50%";
    dialogConf.data = apartment;
    const dialogRef = this.dialog.open(EditApartmentComponent, dialogConf);
    dialogRef.afterClosed().subscribe(apart => {
        const index = this.availableApartments.findIndex((obj => obj.id === apart.id));
        this.availableApartments[index] = apart;
      }
    );
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
