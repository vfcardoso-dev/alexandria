package com.andurasoftware.alexandria.business.domain.read.models.grid;

import com.andurasoftware.alexandria.business.common.base.BaseModel;
import org.hibernate.annotations.Immutable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;


@Immutable
@Entity
@Table(name="[payment]")
public class PaymentGridModel extends BaseModel {

    @Column(name = "[date]")
    private LocalDateTime date;

    @Column
    private String status;

    public LocalDateTime getDate() { return date;  }

    public void setDate(LocalDateTime date) { this.date = date; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

}
