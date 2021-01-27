import {BrowserModule} from '@angular/platform-browser';
import {NgModule, Component} from '@angular/core';

import {AppComponent} from './app.component';
import {CrudProjectComponent} from './crud-project/crud-project.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatTableModule} from '@angular/material/table';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatPaginatorModule} from '@angular/material/paginator';
import { AddUserComponent } from './crud-project/Dialog/add-user/add-user.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import { MatRadioModule} from '@angular/material/radio';
import { MatInputModule} from '@angular/material/input';
import { EditUserComponent } from './crud-project/Dialog/edit-user/edit-user.component';
import { DeleteUserComponent } from './crud-project/Dialog/delete-user/delete-user.component';
import { ViewUserComponent } from './crud-project/Dialog/view-user/view-user.component';

@NgModule({
  declarations: [
    AppComponent,
    CrudProjectComponent,
    AddUserComponent,
    EditUserComponent,
    DeleteUserComponent,
    ViewUserComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatFormFieldModule,
    MatTableModule,
    MatSnackBarModule,
    MatDialogModule,
    MatTooltipModule,
    MatPaginatorModule,
    FormsModule,
    MatSelectModule,
    MatRadioModule,
    ReactiveFormsModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
