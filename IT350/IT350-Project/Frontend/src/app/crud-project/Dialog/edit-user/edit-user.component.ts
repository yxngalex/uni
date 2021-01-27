import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {UserServiceServices} from '../../../../crud-services/user-service-services';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  form = new FormGroup({
    ime: new FormControl(),
    prezime: new FormControl(),
    godine: new FormControl()
  });
  user: any;
  users: any[] = [];

  // tslint:disable-next-line:max-line-length
  constructor(private userService: UserServiceServices, private snackBar: MatSnackBar, private dialogRef: MatDialogRef<EditUserComponent>, @Inject(MAT_DIALOG_DATA) public data) {
    this.user = data;
  }

  ngOnInit(): void {
    this.form.get('ime').setValue(this.user.ime);
    this.form.get('prezime').setValue(this.user.prezime);
    this.form.get('godine').setValue(this.user.godine);
  }

  close(): any {
    this.dialogRef.close(true);
  }

  editUser(): void {
    const user = this.form.value;
    user.id = this.data.id;
    this.userService.editUser(user).subscribe(() => {
      this.getAllUsers();
      this.close();
      this.openSnackBar('Uspesno ste izmenili korisnika', 'Zatvori');
    });
  }

  getAllUsers(): void {
    this.userService.getAllUsers().subscribe(data => {
      this.users = data;
    });
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }
}
