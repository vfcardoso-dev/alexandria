import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AutorListComponent } from './components/autores/autores.component';
import { LogoutComponent } from './components/logout/logout.component';
import { MainComponent } from './components/main/main.component';
import { UsuarioListComponent } from './components/usuarios/usuarios.component';
import { UsuarioCreateComponent } from './components/usuario-create/usuario-create.component';
import { AuthorCreateComponent } from './components/author-create/author-create.component';
import { TitleListComponent } from './components/title-list/title-list.component';
import { TitleCreateComponent } from './components/title-create/title-create.component';
import { CopyListComponent } from './components/copy-list/copy-list.component';
import { CopyCreateComponent } from './components/copy-create/copy-create.component';

const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: '/app/main' },
    { path: 'main', component: MainComponent },
    { path: 'biblioteca/autores', component: AutorListComponent },
    { path: 'biblioteca/autores/criar', component: AuthorCreateComponent },
    { path: 'library/titles/list', component: TitleListComponent },
    { path: 'library/titles/create', component: TitleCreateComponent },
    { path: 'library/copies/list', component: CopyListComponent },
    { path: 'library/copy/create', component: CopyCreateComponent },
    { path: 'seguranca/usuarios', component: UsuarioListComponent },
    { path: 'seguranca/usuarios/criar', component: UsuarioCreateComponent },
    { path: 'logout', component: LogoutComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PrivateRoutingModule { }
