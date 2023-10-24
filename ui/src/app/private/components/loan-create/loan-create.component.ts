import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Component, ElementRef, OnInit, ViewChild } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { catchError, filter, Observable, throwError } from "rxjs";
import { environment } from "src/environments/environment";
import { MemberGridListModel } from "../member-list/member-list.component";
import { TitleGridModel } from "../title-list/title-list.component";
import { CopyListModel } from "../copy-list/copy-list.component";


export interface LoanForm {
    name: FormControl<string | null> 
}


@Component({
    selector: 'loan-create',
    templateUrl: './loan-create.component.html',
    styleUrls: ['./loan-create.component.scss']
})

export class LoanCreateComponent implements OnInit{

    @ViewChild('input') input: ElementRef<HTMLInputElement>;
    myControl = new FormControl(''); 
    myControl2 = new FormControl('');      
    
    memberData: MemberGridListModel[] = [];
    filteredMemberData: MemberGridListModel[];

    copyData: CopyListModel[] = [];
    filteredCopyData: CopyListModel[];

    memberId: string;
    copyId: string;



    public form: FormGroup = new FormGroup<LoanForm>({ 
        name: new FormControl('',[Validators.required])
    })

    
    constructor(private http: HttpClient, private router:Router){ 
        this.filteredMemberData = this.memberData.slice();     
    }

    ngOnInit() {      
        this.loadMemberData();
        this.loadCopyData();                   
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
        
    public loadCopyData = () => {
        this.http.post<CopyListModel[]>(`${environment.apiUrl}/api/copy/grid/list.json`, {  }).subscribe(data => {                                              
            this.copyData = data;                        
        });        
    }
    
    public filterCopy(input:any): void {
        const filterValue = input.value.toLowerCase();        
        this.filteredCopyData = 
            this.copyData.filter(m => 
                m.number.toString().includes(filterValue) ||            
                m.titleModel.name.toLowerCase().includes(filterValue));         
    }

    public setSelectedCopy(copy: CopyListModel){
        this.copyId = copy.id;
    }

    public displayCopyName(copy: CopyListModel): string {
        let name = '('+copy.number+') ';
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

    private addTitle(titleForm: LoanForm): Observable<any> {
        const headers = { 'content-type': 'application/json'}  
        const body=JSON.stringify(titleForm);                
        return this.http.post<LoanForm>(`${environment.apiUrl}/api/loan/add`, body,{'headers':headers})
                        .pipe(catchError(this.handleError));                        
    }

    public submit = () => {
        const name = this.form.get('name')?.value;        
        const titleForm : LoanForm = {name:name};    
       
        this.addTitle(titleForm)
        .subscribe(            
                () => this.router.navigate(['/app/library/loans/list'])
        );
       
    }

}