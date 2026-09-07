package com.andurasoftware.alexandria.business.domain.write.states;

import com.andurasoftware.alexandria.business.common.base.BaseAuditableState;

import jakarta.persistence.*;

@Entity
@Table(name="[address]")
public class AddressState extends BaseAuditableState {

    @Column(nullable = false)
    private String address;

    @Column
    private String number;

    @Column
    private String details;

    @Column(nullable = false)
    private String stateProvince;

    @Column(nullable = false)
    private String city;

    @Column
    private String postalCode;

    //region Getters and Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    //endregion

}
