import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";

export interface LoginForm { username: FormControl<string | null>, password: FormControl<string | null> }

@Component({
    selector: 'signin',
    templateUrl: './signin.component.html',
    styleUrls: ['./signin.component.scss']
})
export class SigninComponent {

    public form: FormGroup = new FormGroup<LoginForm>({
        username: new FormControl('', [Validators.email]),
        password: new FormControl('')
    })

    constructor(){}
}