import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";


export interface AuthorGridModel{

    id:string;
    name:string;
    lastName:string;
    pseudonym:string;    

}

@Component({
    selector: 'author-list',
    templateUrl: './author-list.component.html',
    styleUrls: ['./author-list.component.scss'],
})

export class AuthorListComponent{

    constructor(private http: HttpClient, private router:Router){}

    authorData: AuthorGridModel[] = [];  
    displayedColumns: string[] = ['name', 'pseudonym'];
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