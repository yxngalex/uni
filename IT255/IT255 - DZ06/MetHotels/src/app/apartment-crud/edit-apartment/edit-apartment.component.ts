import {Component, Inject, OnInit} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Apartment} from "../../common/@Types/apartment";

@Component({
  selector: "app-edit-apartment",
  templateUrl: "./edit-apartment.component.html",
  styleUrls: ["./edit-apartment.component.scss"]
})
export class EditApartmentComponent implements OnInit {
  form = new FormGroup({
    room: new FormControl(null, [Validators.required]),
    floor: new FormControl(null, [Validators.required]),
    price: new FormControl(null, [Validators.required]),
    desc: new FormControl(null, [Validators.required])
  });

  constructor(public dialogRef: MatDialogRef<EditApartmentComponent>, @Inject(MAT_DIALOG_DATA) public data: Apartment) {
  }

  ngOnInit(): void {
    this.form.get("room")?.setValue(this.data.room);
    this.form.get("floor")?.setValue(this.data.floor);
    this.form.get("price")?.setValue(this.data.price);
    this.form.get("desc")?.setValue(this.data.desc);
  }

  edit(): void {
    if (this.form.valid) {
      this.dialogRef.close({
        room: this.form.controls.room.value,
        price: this.form.controls.price.value,
        desc: this.form.controls.desc.value
      });
    }
  }

}
