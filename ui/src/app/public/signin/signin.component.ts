import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthService } from "src/app/shared/services/app.auth";
import { environment } from "src/environments/environment";

export interface LoginForm { email: FormControl<string | null>, password: FormControl<string | null> }

@Component({
    selector: 'signin',
    templateUrl: './signin.component.html',
    styleUrls: ['./signin.component.scss']
})
export class SigninComponent {

    public form: FormGroup = new FormGroup<LoginForm>({        
        email: new FormControl('', [Validators.required,Validators.email]),
        password: new FormControl('')
    })

    constructor(private auth: AuthService, private router: Router){}

    public signin = () => {
        const email = this.form.get('email')?.value;
        const password = this.form.get('password')?.value;        

        this.auth.login(email, password).subscribe((token) => {
            console.log(token);
            this.router.navigateByUrl('/main')
        });
    }
}