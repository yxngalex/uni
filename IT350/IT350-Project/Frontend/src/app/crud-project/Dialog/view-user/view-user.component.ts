import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {UserServiceServices} from '../../../../crud-services/user-service-services';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit {
  form = new FormGroup({
    ime: new FormControl(),
    prezime: new FormControl(),
    godine: new FormControl()
  });

  user: any;
  users: any[] = [];

  // tslint:disable-next-line:max-line-length
  constructor(private userService: UserServiceServices, private snackBar: MatSnackBar, private dialogRef: MatDialogRef<ViewUserComponent>, @Inject(MAT_DIALOG_DATA) public data) {
    this.user = data;
  }

  ngOnInit(): void {
    this.form.get('ime').disable();
    this.form.get('prezime').disable();
    this.form.get('godine').disable();
    this.form.get('ime').setValue(this.user.ime);
    this.form.get('prezime').setValue(this.user.prezime);
    this.form.get('godine').setValue(this.user.godine);
  }

  close(): void {
    this.dialogRef.close(true);
  }
}
