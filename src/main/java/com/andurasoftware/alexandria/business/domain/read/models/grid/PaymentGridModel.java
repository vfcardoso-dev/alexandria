package com.andurasoftware.alexandria.business.domain.read.models.grid;

import com.andurasoftware.alexandria.business.common.interfaces.Model;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Immutable
@Entity
@Table(name="[payment]")
public class PaymentGridModel implements Model {

    @Id
    @Column(columnDefinition = "uniqueidentifier")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "[date]")
    private Date date;

    @Column
    private String status;

    @Column
    private Date version;

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public void setId(UUID id) {  this.id = id; }

    public Date getDate() { return date;  }

    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Date getVersion() { return version; }

    public void setVersion(Date version) { this.version = version; }
}
