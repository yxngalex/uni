import { Component, OnInit } from "@angular/core";
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: "app-delete-apartment",
  templateUrl: "./delete-apartment.component.html",
  styleUrls: ["./delete-apartment.component.scss"]
})
export class DeleteApartmentComponent implements OnInit {

  constructor(private dialogRef: MatDialogRef<DeleteApartmentComponent>) { }

  ngOnInit(): void {
  }

}
