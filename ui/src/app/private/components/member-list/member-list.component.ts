import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";


export interface MemberGridListModel{

    id: string;
    name: string;    
}

@Component({
    selector: 'member-list',
    templateUrl: './member-list.component.html',
    styleUrls: ['./member-list.component.scss'],
})
export class MemberListComponent implements OnInit{


    constructor(private http: HttpClient, private router:Router){}

    memberData: MemberGridListModel[] = [];  
    displayedColumns: string[] = ['id', 'name'];
    dataSource = this.memberData;

    public loadDisplayData = () => {

        this.http.post<MemberGridListModel[]>(`${environment.apiUrl}/api/member/grid/list.json`, {  }).subscribe(data => {                                              
          this.memberData = data;          
        });        
    }

    ngOnInit() {        
      this.loadDisplayData();                  
    }

}    