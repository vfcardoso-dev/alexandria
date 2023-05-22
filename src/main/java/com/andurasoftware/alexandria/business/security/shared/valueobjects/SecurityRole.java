package com.andurasoftware.alexandria.business.security.shared.valueobjects;

public enum SecurityRole {
    USER,
    MANAGER,
    ADMIN;

    @Override
    public String toString() {
        return switch (this) {
            case USER -> "Usuário";
            case MANAGER -> "Gestor";
            case ADMIN -> "Administrador";
        };
    }
}
