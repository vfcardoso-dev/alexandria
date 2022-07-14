import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { environment } from "src/environments/environment";

export interface LoginForm { username: FormControl<string | null>, password: FormControl<string | null> }

@Component({
    selector: 'signin',
    templateUrl: './signin.component.html',
    styleUrls: ['./signin.component.scss']
})
export class SigninComponent {

    public form: FormGroup = new FormGroup<LoginForm>({        
        username: new FormControl('', [Validators.required,Validators.minLength(4)]),
        password: new FormControl('')
    })

    constructor(private http: HttpClient){}

    public signin = () => {
        const username = this.form.get('username')?.value;
        const password = this.form.get('password')?.value;        

        this.http.post(`${environment.apiUrl}/authenticate`, { username: username, password: password }).
            subscribe((token)=>console.log(token));
    }
}