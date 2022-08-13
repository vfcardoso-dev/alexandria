import { Component } from "@angular/core";

@Component({
    selector: 'footer',
    templateUrl: './footer.component.html',
    styleUrls: ['./footer.component.scss']
})
export class FooterComponent {
    public currentYear: number = new Date().getFullYear();
    public versionNumber: string = '0.0.1';
}