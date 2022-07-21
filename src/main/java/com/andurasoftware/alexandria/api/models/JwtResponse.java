package com.andurasoftware.alexandria.api.models;

import java.io.Serial;
import java.io.Serializable;

public record JwtResponse(String token) implements Serializable {

    @Serial
    private static final long serialVersionUID = -8091879091924046844L;
}
