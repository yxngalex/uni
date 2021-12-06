import {Component, Inject, OnInit} from "@angular/core";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {RoomService} from "../../common/services/room.service";
import {Apartment} from "../../common/@Types/apartment";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: "app-checkout-apartment",
  templateUrl: "./checkout-apartment.component.html",
  styleUrls: ["./checkout-apartment.component.scss"]
})
export class CheckoutApartmentComponent implements OnInit {

  apartment: Apartment;
  fullPrice: number;

  form = new FormGroup({
    numOfNights: new FormControl(null, [Validators.required]),
  });

  constructor(@Inject(MAT_DIALOG_DATA) public data,
              private dialogRef: MatDialogRef<CheckoutApartmentComponent>
  ) {
  }

  save(): void {
    if (this.form.valid) {
      this.dialogRef.close({
        numOfNights: this.form.value.numOfNights
      });
    }
  }

  ngOnInit(): void {
  }
}
