import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";


export interface UserGridModel {
    id: string;
    createdAt: string;
    email: string;
    name: string;
    role: string;
    enabled:boolean;
  }
  

@Component({
    selector: 'usuarios',
    templateUrl: './usuarios.component.html',
    styleUrls: ['./usuarios.component.scss'],
})



export class UsuarioListComponent{

    constructor(private http: HttpClient, private router:Router){}

    
    userData: UserGridModel[] = [
      //{id: '0xFD9E9F8AC7CD4827853BCC8F94A15A81[...]', createdAt: '2022-07-23 12:19:07.9090000', email: 'admin@vfcardoso.dev', name:'Alexandria Sysadmin', role: 'ADMIN'},
    ];

    displayedColumns: string[] = ['id', 'createdAt', 'email', 'name','role'];
    dataSource = this.userData;
          
     
    
    public loadDisplayData = () => {

      this.http.post<UserGridModel[]>(`${environment.apiUrl}/api/user/grid/list.json`, {  }).subscribe(data => {                                              
        this.userData = data;
      });
      
    }

     
    
    /*
    public loadData = () => {

      this.http.post<UserModel[]>(`${environment.apiUrl}/api/user/list-all`, {  }).subscribe(data => {                              
              

        var us:Usuario[] = [];

        data.forEach(function(user){
            us.push(
              { 
                id:user.id,
                createdAt:user.createdAt,
                email:user.email,
                name:user.name,
                role:user.role,
                enabled:false
              });
        });
        
        this.userData = us;
      });
      
    }
    */
    
    ngOnInit() {        
      this.loadDisplayData();                  
  }
    
}