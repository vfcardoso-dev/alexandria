import { Component } from "@angular/core";

@Component({
    selector: 'public-root-component',
    template: '<router-outlet></router-outlet>',
    standalone: false
})
export class PublicRootComponent {
    constructor(){}
}