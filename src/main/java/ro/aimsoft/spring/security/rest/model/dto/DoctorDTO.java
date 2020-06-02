package ro.aimsoft.spring.security.rest.model.dto;

import javax.validation.constraints.Size;

public class DoctorDTO {

    private long id;

    @Size(min=6, max=10)
    private String name;

    public DoctorDTO() {
    }

    public DoctorDTO(long id, @Size(min = 6, max = 10) String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
