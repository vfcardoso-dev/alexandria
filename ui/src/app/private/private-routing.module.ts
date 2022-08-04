import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LogoutComponent } from './logout/logout.component';
import { MainComponent } from './main/main.component';

const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: '/app/main' },
    { path: 'main', component: MainComponent },
    { path: 'logout', component:LogoutComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PrivateRoutingModule { }
