import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {UserServiceServices} from '../../../../crud-services/user-service-services';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MatDialogRef} from '@angular/material/dialog';


@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  form: FormGroup;

  // tslint:disable-next-line:max-line-length
  constructor(private userService: UserServiceServices, private dialogRef: MatDialogRef<AddUserComponent>, private snackBar: MatSnackBar) {
    this.form = new FormGroup({
      id: new FormControl(),
      ime: new FormControl(),
      prezime: new FormControl(),
      godine: new FormControl()
    });
  }

  ngOnInit(): void {
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  close(): void {
    this.dialogRef.close(true);
  }

  addANewUser(): void {
    this.userService.addUser(this.form.value).subscribe(() => {
      this.openSnackBar('Uspesno ste sacuvali novog korisnika', 'Zatvori');
      this.close();
    }, err => {
      this.openSnackBar(err.error.message, 'Zatvori');
    });
  }

}
