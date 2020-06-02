package ro.aimsoft.spring.security.rest.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PatientDTO {

    @NotNull
    private String cnp;

    @Email
    private String email;

    @Size(min = 4, max=8)
    private String firstName;

    @Size(min = 4, max=8)
    private String lastName;

    public PatientDTO() {
    }

    public PatientDTO(@NotNull String cnp, @Email String email, @Size(min = 4, max = 8) String firstName, @Size(min = 4, max = 8) String lastName) {
        this.cnp = cnp;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
