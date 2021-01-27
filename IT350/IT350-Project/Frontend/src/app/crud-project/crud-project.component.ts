import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {UserServiceServices} from '../../crud-services/user-service-services';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {filterUsers} from '../../utils/filterUtils';
import {MatPaginator} from '@angular/material/paginator';
import {AddUserComponent} from './Dialog/add-user/add-user.component';
import {EditUserComponent} from './Dialog/edit-user/edit-user.component';
import {DeleteUserComponent} from './Dialog/delete-user/delete-user.component';
import {ViewUserComponent} from './Dialog/view-user/view-user.component';

@Component({
  selector: 'app-crud-project',
  templateUrl: './crud-project.component.html',
  styleUrls: ['./crud-project.component.css']
})

export class CrudProjectComponent implements OnInit, AfterViewInit {
  users: any[] = [];
  dataSource = new MatTableDataSource<any>([]);
  displayedColumns: string[] = ['ime', 'prezime', 'godine', 'opcije'];
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private userServices: UserServiceServices, private snackBar: MatSnackBar, public dialog: MatDialog) {
  }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void {
    this.getAllUsers();
  }

  openSnackBar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  getAllUsers(): void {
    this.userServices.getAllUsers().subscribe(data => {
      this.users = data;
      this.dataSource.data = this.users;
      this.dataSource.paginator = this.paginator;
    });
  }

  openEditDialog(user: any): void {
    const dialogRef = this.dialog.open(EditUserComponent, {
      width: '300px',
      backdropClass: 'background',
      data: user
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.getAllUsers();
      }
    });
  }

  openDeleteDialog(id: number): void {
    const dialogRef = this.dialog.open(DeleteUserComponent, {
      width: '600px',
      backdropClass: 'background'
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        if (result === 'da') {
          this.userServices.deleteUser(id).subscribe(() => {
            this.openSnackBar('Uspesno ste obrisali korisnika iz baze!', 'Zatvori');
            this.getAllUsers();
          }, error => {
            this.openSnackBar(error.error.message, 'Close');
          });
        } else if (result === 'ne') {
          this.dialog.closeAll();
        }
      }
    });
  }

  openViewDialog(user: any): void {
    const dialogRef = this.dialog.open(ViewUserComponent, {
      width: '300px',
      backdropClass: 'background',
      data: user
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.getAllUsers();
      }
    });
  }

  openAddDialog(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = '600px';
    this.dialog.open(AddUserComponent, dialogConfig).afterClosed().subscribe(() => {
      this.getAllUsers();
    });
  }

  searchKorisnik(inputPar: string): void {
    if (inputPar) {
      this.dataSource.data = this.users.filter(item => filterUsers(item, inputPar));
    } else {
      this.dataSource.data = this.users;
    }
  }
}
