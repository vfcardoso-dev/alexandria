import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";


export interface CopyListModel{

    id: string;
    number: string;
    title: string;
    author: string;
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

        /*
        this.http.post<CopyListModel[]>(`${environment.apiUrl}/api/copy/grid/list.json`, {  }).subscribe(data => {                                              
          this.titleData = data;
        });
        */
        //Fake Data 
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
        
    }
  
    ngOnInit() {        
      this.loadDisplayData();                  
    }

}    