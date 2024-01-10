package com.andurasoftware.alexandria.business.domain.write.states;

import com.andurasoftware.alexandria.business.common.interfaces.State;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="[member]")
public class MemberState implements State{

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressState address;

    @Column(nullable = false)
    private Date birthDate;

    @Column
    private String email;

    @Column
    private String phone;

    @Column(nullable = false)
    private String registrationNumber;

    @Column
    private String occupation;

    @Column
    private Date version;


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
        return this.version;
    }

    @Override
    public void setVersion(Date version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressState getAddress() {
        return address;
    }

    public void setAddress(AddressState address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
