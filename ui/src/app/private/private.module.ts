import { NgModule } from "@angular/core";
import { MaterialModule } from "../shared/material.module";
import { ReactiveFormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";
import { PrivateRootComponent } from "./private.component";
import { PrivateRoutingModule } from "./private-routing.module";
import { MainComponent } from "./components/main/main.component";
import { LogoutComponent } from "./components/logout/logout.component";
import { FooterComponent } from "./components/footer/footer.component";
import { HeaderComponent } from "./components/header/header.component";
import { AutorListComponent } from "./components/autores/autores.component";
import { AuthorCreateComponent } from "./components/author-create/author-create.component";
import { UsuarioListComponent } from "./components/usuarios/usuarios.component";
import { UsuarioCreateComponent } from "./components/usuario-create/usuario-create.component";
import { TitleListComponent } from "./components/title-list/title-list.component";
import { TitleCreateComponent } from "./components/title-create/title-create.component";
import { CopyListComponent } from "./components/copy-list/copy-list.component";
import { CopyCreateComponent } from "./components/copy-create/copy-create.component";


@NgModule({
    declarations: [
        PrivateRootComponent,
        MainComponent,
        HeaderComponent,
        FooterComponent,
        LogoutComponent,
        AutorListComponent,
        AuthorCreateComponent,
        UsuarioListComponent,
        UsuarioCreateComponent,
        TitleListComponent,
        TitleCreateComponent,
        CopyListComponent,
        CopyCreateComponent             
    ],
    imports: [
        CommonModule,
        MaterialModule,
        ReactiveFormsModule,
        PrivateRoutingModule,
    ],
    providers: []
})
export class PrivateModule { }