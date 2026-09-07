package com.andurasoftware.alexandria.business.domain.write.states;


import com.andurasoftware.alexandria.business.common.base.BaseState;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="[loan]")
public class LoanState extends BaseState {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column
    private Date date;
    @Column
    private Date expiringDate;

    @Column
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "copy_id", columnDefinition = "uniqueidentifier")
    private CopyState copy;

    @ManyToOne
    @JoinColumn(name = "member_id", columnDefinition = "uniqueidentifier")
    private MemberState member;

    //region Getters and Setters
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

    //endregion

}