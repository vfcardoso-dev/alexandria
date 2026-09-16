import { Injectable, effect, signal } from "@angular/core";

export type ThemeMode = 'light' | 'dark';

const STORAGE_KEY = 'theme-mode';

@Injectable({ providedIn: 'root' })
export class ThemeService {
    public readonly mode = signal<ThemeMode>(this.readInitialMode());

    constructor() {
        effect(() => {
            const mode = this.mode();
            document.documentElement.setAttribute('data-theme', mode);
            localStorage.setItem(STORAGE_KEY, mode);
        });
    }

    public toggle(): void {
        this.mode.set(this.mode() === 'dark' ? 'light' : 'dark');
    }

    private readInitialMode(): ThemeMode {
        const stored = localStorage.getItem(STORAGE_KEY);
        if (stored === 'light' || stored === 'dark') return stored;
        return window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light';
    }
}
