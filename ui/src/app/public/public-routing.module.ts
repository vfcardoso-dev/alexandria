import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './main/main.component';
import { SigninComponent } from './signin/signin.component';

const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: 'signin' },
    { path: 'signin', component: SigninComponent },
    { path: 'main', component: MainComponent },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PublicRoutingModule { }
