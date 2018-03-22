package org.aitesting.microservices.drivercmd.domain.models;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class DriverDto {
    @NotNull
    @NotEmpty
    @NotBlank
    private String license;
    @NotNull
    @NotEmpty
    @NotBlank
    private boolean available;

    public DriverDto() {}

    public DriverDto(String license, boolean available) {
        this.license = license;
        this.available = available;
    }

    public String getLicense() { return license; }

    public boolean isAvailable() { return available; }
}
