import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "src/app/shared/services/app.auth";

@Component({
    selector: 'logout',
    templateUrl: './logout.component.html',
    styleUrls: ['./logout.component.scss']
})
export class LogoutComponent implements OnInit{

    constructor(private auth: AuthService, private router:Router){}
    
    ngOnInit(): void {         
        if(this.auth.isAuthenticated()){           
            this.auth.logout().subscribe(()=>{                 
                this.router.navigateByUrl('/signin');                
            });                    
        }
    }

}