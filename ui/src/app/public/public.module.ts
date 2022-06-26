import { NgModule } from "@angular/core";
import { SigninComponent } from "./signin/signin.component";
import { PublicRoutingModule } from "./public-routing.module";
import { PublicRootComponent } from "./public.component";
import { MaterialModule } from "../shared/material.module";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";

@NgModule({
    declarations: [
        PublicRootComponent,
        SigninComponent
    ],
    imports: [
        CommonModule,
        MaterialModule,
        ReactiveFormsModule,
        PublicRoutingModule,
    ],
    providers: []
})
export class PublicModule { }