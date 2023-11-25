package com.andurasoftware.alexandria.business.domain.write.states;

import com.andurasoftware.alexandria.business.common.interfaces.State;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="[loan]")
public class LoanState implements State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private Date date;

    @Column
    private Date expiringDate;

    @Column
    private Date returnDate;

    @ManyToOne(targetEntity = TitleState.class)
    @JoinColumn(name="title_id")
    private UUID titleId;

    @ManyToOne(targetEntity = MemberState.class)
    @JoinColumn(name="member_id")
    private UUID memberId;


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

    public UUID getTitleId() {
        return titleId;
    }

    public void setTitleId(UUID titleId) {
        this.titleId = titleId;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public void setMemberId(UUID memberId) {
        this.memberId = memberId;
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
