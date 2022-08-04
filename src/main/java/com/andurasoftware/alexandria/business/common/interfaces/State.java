package com.andurasoftware.alexandria.business.common.interfaces;

import java.util.Date;
import java.util.UUID;

public interface State {
    UUID getId();
    void setId(UUID id);
    Date getVersion();
    void setVersion(Date version);
}
