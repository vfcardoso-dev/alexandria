import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LogoutComponent } from './components/logout/logout.component';
import { MainComponent } from './components/main/main.component';
import { UsuarioListComponent } from './components/usuarios/usuarios.component';
import { UsuarioCreateComponent } from './components/usuario-create/usuario-create.component';
import { AuthorCreateComponent } from './components/author-create/author-create.component';
import { TitleListComponent } from './components/title-list/title-list.component';
import { TitleCreateComponent } from './components/title-create/title-create.component';
import { CopyListComponent } from './components/copy-list/copy-list.component';
import { CopyCreateComponent } from './components/copy-create/copy-create.component';
import { MemberListComponent } from './components/member-list/member-list.component';
import { MemberCreateComponent } from './components/member-create/member-create.component';
import { LoanListComponent } from './components/loan-list/loan-list.component';
import { LoanCreateComponent } from './components/loan-create/loan-create.component';
import { AuthorListComponent } from './components/author-list/author-list.component';

const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: '/app/main' },
    { path: 'main', component: MainComponent },
    { path: 'library/author/list', component: AuthorListComponent },
    { path: 'library/author/create', component: AuthorCreateComponent },
    { path: 'library/titles/list', component: TitleListComponent },
    { path: 'library/titles/create', component: TitleCreateComponent },
    { path: 'library/copies/list', component: CopyListComponent },
    { path: 'library/copy/create', component: CopyCreateComponent },
    { path: 'library/members/list', component: MemberListComponent },
    { path: 'library/loans/list', component: LoanListComponent },
    { path: 'library/loan/create', component: LoanCreateComponent },
    { path: 'library/loan/edit/:id', component: LoanCreateComponent },
    { path: 'library/member/create', component: MemberCreateComponent },
    { path: 'seguranca/usuarios', component: UsuarioListComponent },
    { path: 'seguranca/usuarios/criar', component: UsuarioCreateComponent },
    { path: 'logout', component: LogoutComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PrivateRoutingModule { }
