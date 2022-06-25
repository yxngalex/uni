import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AddApartmentComponent} from './add-apartment/add-apartment.component';
import {AvailableApartmentsComponent} from './available-apartments/available-apartments.component';

const routes: Routes = [
  {
    path: '',
    component: AvailableApartmentsComponent
  },
  {
    path: 'add',
    component: AddApartmentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
