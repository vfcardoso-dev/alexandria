package com.andurasoftware.alexandria.business.domain.write.states;

import com.andurasoftware.alexandria.business.common.interfaces.State;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="[loan]")
public class LoanState implements State {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private Date date;
    @Column
    private Date expiringDate;

    @Column
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name="copy_id", columnDefinition = "uniqueidentifier")
    private CopyState copy;

    @ManyToOne
    @JoinColumn(name="member_id", columnDefinition = "uniqueidentifier")
    private MemberState member;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getExpiringDate() {
        return expiringDate;
    }

    public void setExpiringDate(Date expiringDate) {
        this.expiringDate = expiringDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public CopyState getCopy() {
        return copy;
    }

    public void setCopy(CopyState copy) {
        this.copy = copy;
    }

    public MemberState getMember() {
        return member;
    }

    public void setMember(MemberState member) {
        this.member = member;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public Date getVersion() {
        return null;
    }

    @Override
    public void setVersion(Date version) {
    }
}
