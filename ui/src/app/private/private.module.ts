import { NgModule } from "@angular/core";
import { MaterialModule } from "../shared/material.module";
import { ReactiveFormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";
import { PrivateRootComponent } from "./private.component";
import { MainComponent } from "./main/main.component";
import { PrivateRoutingModule } from "./private-routing.module";
import { LogoutComponent } from "./logout/logout.component";

@NgModule({
    declarations: [
        PrivateRootComponent,
        MainComponent,
        LogoutComponent
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