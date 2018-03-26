package org.aitesting.microservices.drivercmd.domain.commands;

import java.util.UUID;
import org.axonframework.commandhandling.TargetAggregateIdentifier;



public class CreateDriverCommand {
    @TargetAggregateIdentifier
    private UUID id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String license;

    public CreateDriverCommand(String firstName, String lastName, String address, String email,
                               String phone, String license) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.license = license;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLicense() {
        return license;
    }
}
