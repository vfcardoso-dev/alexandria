import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";


export interface AuthorGridModel{

    id:string;
    nome:string;
    sobrenome:string;
    pseudonimo:string;    

}

@Component({
    selector: 'autores',
    templateUrl: './autores.component.html',
    styleUrls: ['./autores.component.scss'],
})

export class AutorListComponent{

    constructor(private http: HttpClient, private router:Router){}

    authorData: AuthorGridModel[] = [];  
    displayedColumns: string[] = ['id', 'nome', 'pseudonimo'];
    dataSource = this.authorData;

    public loadDisplayData = () => {

        this.http.post<AuthorGridModel[]>(`${environment.apiUrl}/api/author/grid/list.json`, {  }).subscribe(data => {                                              
          this.authorData = data;
        });
        
      }
  
      ngOnInit() {        
        this.loadDisplayData();                  
      }
    
}