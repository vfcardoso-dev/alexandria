import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from "@angular/common/http";
import { Component, ElementRef, OnInit, ViewChild } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { catchError, filter, Observable, throwError } from "rxjs";
import { environment } from "src/environments/environment";
import { MemberGridListModel } from "../member-list/member-list.component";
import { CopyListModel } from "../copy-list/copy-list.component";
import { MatDatepickerInputEvent } from "@angular/material/datepicker";
import { LoanGridModel } from "../loan-list/loan-list.component";



export interface LoanForm {
    member: FormControl<string | null> 
    copy: FormControl<string | null>
    date: FormControl<Date | null>
}


@Component({
    selector: 'loan-create',
    templateUrl: './loan-create.component.html',
    styleUrls: ['./loan-create.component.scss']
})

export class LoanCreateComponent implements OnInit{

    @ViewChild('input') input: ElementRef<HTMLInputElement>;
      
    memberData: MemberGridListModel[] = [];
    filteredMemberData: MemberGridListModel[];

    copyData: CopyListModel[] = [];
    filteredCopyData: CopyListModel[];

    memberId: string;
    copyId: string;
    loanId: string | null;
    loanData: LoanGridModel | null;

    //today's date
    todayDate: Date = new Date();

    selectedDate: Date = this.todayDate;

    public form: FormGroup = new FormGroup<LoanForm>({ 
        member: new FormControl('',[Validators.required]),
        copy: new FormControl('',[Validators.required]),
        date: new FormControl(this.selectedDate,[Validators.required])
    })
    
    constructor(private http: HttpClient, private router:Router, private activatedRoute : ActivatedRoute){ 
        this.filteredMemberData = this.memberData.slice();     
    }

    ngOnInit() {      
        this.loadMemberData();
        this.loadCopyData();   
        
        this.loanId = this.activatedRoute.snapshot.paramMap.get("id");
        if(this.loanId){
            this.loadLoanData();
        }
    }

    public loadLoanData = () => {
        
        const headers = new HttpHeaders().append('Content-Type', 'application/json');
        const params = new HttpParams().append('id', this.loanId ? this.loanId : '');
        this.http.get<any>(`${environment.apiUrl}/api/loan/get-by-id.json`, {headers, params}).subscribe(data => {                                              
            console.log(data);
          });
    }

    public loadMemberData = () => {
        this.http.post<MemberGridListModel[]>(`${environment.apiUrl}/api/member/grid/list.json`, {  }).subscribe(data => {                                              
          this.memberData = data;
        });        
    }

    public filterMember(input:any): void {
        const filterValue = input.value.toLowerCase();
        this.filteredMemberData = this.memberData.filter(m => m.name.toLowerCase().includes(filterValue));
    }

    
    public setSelectedMember(member: MemberGridListModel){        
        this.memberId = member.id;
    }
        
    public setSelectedDate(event: MatDatepickerInputEvent<Date>){        
        this.selectedDate = new Date(event.value!.toDateString());
    }
    
        
    public loadCopyData = () => {
        this.http.post<CopyListModel[]>(`${environment.apiUrl}/api/copy/grid/list.json`, {  }).subscribe(data => {                                              
            this.copyData = data;                        
        });        
    }
    
    public filterCopy(input:any): void {
        const filterValue = input.value.toLowerCase();        
        this.filteredCopyData = 
            this.copyData.filter(m => 
                m.code.toString().includes(filterValue) ||     
                m.titleModel.name.toLowerCase().includes(filterValue));         
    }

    public setSelectedCopy(copy: CopyListModel){
        this.copyId = copy.id;
    }

    public displayCopyName(copy: CopyListModel): string {
        let name = '(' + copy.code + ') ';
        name+= copy.titleModel.name+' ';         
        return name;
    }

    private handleError(error: HttpErrorResponse) {
        if (error.status === 0) {
          // A client-side or network error occurred. Handle it accordingly.
          console.error('An error occurred:', error.error);
        } else {
          // The backend returned an unsuccessful response code.
          // The response body may contain clues as to what went wrong.
          console.error(
            `Backend returned code ${error.status}, body was: `, error.error);
        }
        // Return an observable with a user-facing error message.
        return throwError(() => new Error('Something bad happened; please try again later.'));
    }

    private addLoan(loanObject: any): Observable<any> {
        console.log('addLoan');
        const headers = { 'content-type': 'application/json'}  
        const body=JSON.stringify(loanObject);         
        return this.http.post<any>(`${environment.apiUrl}/api/loan/add`, body,{'headers':headers})
                        .pipe(catchError(this.handleError));                        
    }

    public submit = () => {
                        
        const loanObject: any =  {
            id: null,
            member: { id: this.memberId },
            copy: { id: this.copyId },
            date: this.form.get('date')?.value
        };

        this.addLoan(loanObject)
        .subscribe(            
                () => this.router.navigate(['/app/library/loans/list'])
        );        
       
    }

}