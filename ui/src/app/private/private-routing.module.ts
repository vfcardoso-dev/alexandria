import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AutorListComponent } from './components/autores/autores.component';
import { LogoutComponent } from './components/logout/logout.component';
import { MainComponent } from './components/main/main.component';
import { UsuarioListComponent } from './components/usuarios/usuarios.component';
import { UsuarioCreateComponent } from './components/usuario-create/usuario-create.component';

const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: '/app/main' },
    { path: 'main', component: MainComponent },
    { path: 'biblioteca/autores', component: AutorListComponent },
    { path: 'seguranca/usuarios', component: UsuarioListComponent },
    { path: 'seguranca/usuarios/criar', component: UsuarioCreateComponent },
    { path: 'logout', component: LogoutComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PrivateRoutingModule { }
