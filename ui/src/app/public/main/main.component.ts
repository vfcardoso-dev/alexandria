import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthService } from "src/app/shared/services/app.auth";
import { environment } from "src/environments/environment";


@Component({
    selector: 'main',
    template: '<p>Logado!</p>'
})
export class MainComponent {

    
}