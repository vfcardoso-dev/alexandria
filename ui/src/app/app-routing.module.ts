import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PrivateRootComponent } from './private/private.component';
import { PublicRootComponent } from './public/public.component';
import { PrivateGuard } from './shared/guards/private.guard';

const routes: Routes = [
    { path: '', component: PublicRootComponent, loadChildren: () => import('./public/public.module').then(m => m.PublicModule) },
    { path: 'app', canActivate: [PrivateGuard], component: PrivateRootComponent, loadChildren: () => import('./private/private.module').then(m => m.PrivateModule) },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
