import { HttpClient } from "@angular/common/http";
import { AfterViewInit, Component, OnInit, ViewChild } from "@angular/core";
import { MatPaginator } from "@angular/material/paginator";
import { MatSort } from "@angular/material/sort";
import { MatTableDataSource } from "@angular/material/table";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";

export interface LoanGridModel{
    id: string;
    memberName: string;
    titleName: string;
    copyId: string;
    copyCode: string;
    date: string;
    expiringDate: string;
    returnDate:string;    				
}

@Component({
    selector: 'loan-list',
    templateUrl: './loan-list.component.html',
    styleUrls: ['./loan-list.component.scss'],
})
export class LoanListComponent implements AfterViewInit {


    public dataSource: MatTableDataSource<LoanGridModel>;

    @ViewChild(MatPaginator) paginator: MatPaginator;
    @ViewChild(MatSort) sort: MatSort;

    displayedColumns: string[] = ['id', 'memberName', 'titleName', 'copyCode', 'date', 'expiringDate', 'returnDate'];
    
    constructor(private http: HttpClient, private router: Router){
        this.dataSource = new MatTableDataSource<LoanGridModel>();        
    }
                
    public loadDisplayData = () => {        
        this.http.post<LoanGridModel[]>(`${environment.apiUrl}/api/loan/grid/list.json`, {  }).subscribe(data => {                                                          
            this.dataSource = new MatTableDataSource(data);
        });     
    }     
        
    ngAfterViewInit() {
        this.loadDisplayData();   
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;        
      }


    applyFilter(event: Event) {
        const filterValue = (event.target as HTMLInputElement).value;
        this.dataSource.filter = filterValue.trim().toLowerCase();
           
        if (this.dataSource.paginator) {
          this.dataSource.paginator.firstPage();
        }
      }



}    