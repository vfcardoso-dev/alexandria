import { HttpClient } from "@angular/common/http";
import { AfterViewInit, Component, OnInit, ViewChild } from "@angular/core";
import { DateAdapter } from "@angular/material/core";
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
    date: Date;
    expiringDate: Date;
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

    displayedColumns: string[] = ['memberName', 'titleName', 'copyCode', 'date', 'expiringDate', 'returnDate'];
    
    constructor(private http: HttpClient, private router: Router, private dateAdapter: DateAdapter<Date>){
        this.dateAdapter.setLocale('pt-BR'); //dd/MM/yyyy
        this.dataSource = new MatTableDataSource<LoanGridModel>();        
    }
                
    public loadDisplayData = () => {        
        this.http.post<LoanGridModel[]>(`${environment.apiUrl}/api/loan/grid/list.json`, {  }).subscribe(data => {                                                          
            console.log(data);
            this.dataSource = new MatTableDataSource(data);
        });     
    }  
    
    /*
    public editLoan(row: any){
        console.log(row);
    }
    */
        
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