import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";
import { AuthorGridModel } from "../autores/autores.component";



export interface TitleGridModel{

    id: string;
    name: string;   
    authorSet: AuthorGridModel[];
}

@Component({
    selector: 'title-list',
    templateUrl: './title-list.component.html',
    styleUrls: ['./title-list.component.scss'],
})

export class TitleListComponent implements OnInit{

    constructor(private http: HttpClient, private router:Router){}

    titleData: TitleGridModel[] = [];  
    displayedColumns: string[] = ['id', 'nome', 'autores'];
    dataSource = this.titleData;

    public loadDisplayData = () => {

        this.http.post<TitleGridModel[]>(`${environment.apiUrl}/api/title/grid/list.json`, {  }).subscribe(data => {                                              
          this.titleData = data;
        });
        
    }
  
    ngOnInit() {        
      this.loadDisplayData();                  
    }

    public displayAuthors(authorSet: AuthorGridModel[]): string{
        let authors: string = "";
        authorSet.forEach((author, index) => {            
            
            authors = authors + author.nome + ' ' + author.sobrenome;
            if(author.pseudonimo !== null)
              authors = authors + ' (' + author.pseudonimo + ')'; 
            
            if(index < authorSet.length-1){
              authors = authors + ',  ';                
            }
        });
        
        return authors;
    }
    
}