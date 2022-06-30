package com.andurasoftware.alexandria.model.valueobjects;

import java.io.Serial;
import java.io.Serializable;

public record JwtResponse(String token) implements Serializable {

    @Serial
    private static final long serialVersionUID = -8091879091924046844L;
}
