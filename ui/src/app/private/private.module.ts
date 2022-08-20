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
import { UsuarioListComponent } from "./components/usuarios/usuarios.component";

@NgModule({
    declarations: [
        PrivateRootComponent,
        MainComponent,
        HeaderComponent,
        FooterComponent,
        LogoutComponent,
        AutorListComponent,
        UsuarioListComponent
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