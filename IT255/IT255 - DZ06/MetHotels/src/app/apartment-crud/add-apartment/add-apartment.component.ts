import {Component, OnInit} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatDialogRef} from "@angular/material/dialog";


@Component({
  selector: "app-add-apartment",
  templateUrl: "./add-apartment.component.html",
  styleUrls: ["./add-apartment.component.scss"]
})
export class AddApartmentComponent implements OnInit {
  input = "";

  form = new FormGroup({
    id: new FormControl(null),
    room: new FormControl(null, [Validators.required]),
    floor: new FormControl(null, [Validators.required]),
    price: new FormControl(null, [Validators.required]),
    desc:  new FormControl(null, [Validators.required])
  });

  constructor(public dialogRef: MatDialogRef<AddApartmentComponent>) { }

  ngOnInit(): void {
  }

  save(): void {
    console.log(this.form.value);
    if (this.form.valid) {
      this.dialogRef.close(
        this.form.value
      );
    }
  }

  checkLength(text: string): void {
    if (text.length < 6) {}
    window.alert("Dužina ne sme biti manja od 6 karaktera!");
  }
}
