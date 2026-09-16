import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { HeaderApi } from "./header.api";
import { ThemeService } from "src/app/shared/services/theme.service";

@Component({
    selector: 'header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss'],
    providers: [HeaderApi],
    standalone: false
})
export class HeaderComponent implements OnInit {
    @Input() isMobile = false;
    @Output() menuToggle = new EventEmitter<void>();

    public user: any;

    constructor(private headerApi: HeaderApi, public themeService: ThemeService){}

    ngOnInit(): void {
        this.headerApi.getUserInfo().subscribe(user => this.user = user);
    }
}
