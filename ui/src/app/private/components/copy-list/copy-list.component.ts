import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";
import { TitleGridModel } from "../title-list/title-list.component";
import { AuthorGridModel } from "../autores/autores.component";


export interface CopyListModel{

    id: string;
    number: string;    
    titleModel: TitleGridModel;
}

@Component({
    selector: 'copy-list',
    templateUrl: './copy-list.component.html',
    styleUrls: ['./copy-list.component.scss'],
})
export class CopyListComponent implements OnInit{


    constructor(private http: HttpClient, private router:Router){}

    copyData: CopyListModel[] = [];  
    displayedColumns: string[] = ['id', 'number', 'title', 'author'];
    dataSource = this.copyData;

    public loadDisplayData = () => {

        
        this.http.post<CopyListModel[]>(`${environment.apiUrl}/api/copy/grid/list.json`, {  }).subscribe(data => {                                              
          this.copyData = data;
        });
        
        //Fake Data 
        /*
        this.copyData = 
        [
            {
                id : '2cb5333d-9614-4377-9bfc-d5357037c8a3',
                number: '10',
                title: 'O Boto do Reno',
                author: 'Flavio Gomes'
            },
            {
                id : 'xj3xxyr5-9614-42xx-dbfc-d55550abc108',
                number: '32',
                title: 'engenharia de Software - Uma abordagem Profissional',
                author: 'Roger Pressman'
            }
        ];
        */
        
    }

    //TODO:Abstrair
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
  
    ngOnInit() {        
      this.loadDisplayData();                  
    }

}    