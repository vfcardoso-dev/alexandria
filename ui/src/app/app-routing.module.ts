import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PublicRootComponent } from './public/public.component';

const routes: Routes = [
    { path: '', component: PublicRootComponent, loadChildren: () => import('./public/public.module').then(m => m.PublicModule) },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
