import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from "@angular/material/form-field";


export interface UserForm { 
    name: FormControl<string | null>, 
    email: FormControl<string | null>,//role:SecurityRole??
    password: FormControl<string | null>,


}
  
@Component({
    selector: 'usuario-create',
    templateUrl: './usuario-create.component.html',
    styleUrls: ['./usuario-create.component.scss']

})




export class UsuarioCreateComponent{

    public form: FormGroup = new FormGroup<UserForm>({ 
        name: new FormControl('',[Validators.required]),       
        email: new FormControl('', [Validators.required,Validators.email]),
        password: new FormControl('',[Validators.required])
    })
    
    
    constructor(private http: HttpClient, private router:Router){}

    public submit = () => {
        const email = this.form.get('email')?.value;
                 
    }
    
}