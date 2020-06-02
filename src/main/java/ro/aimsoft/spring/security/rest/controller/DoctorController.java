package ro.aimsoft.spring.security.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.aimsoft.spring.security.rest.exception.DoctorNotFoundException;
import ro.aimsoft.spring.security.rest.model.dto.DoctorDTO;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void addDoctor(DoctorDTO doctorDTO) {

    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<DoctorDTO> getAll() {
        return doctorList();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public DoctorDTO getUser(@PathVariable @NotNull long id) {
        return doctorList().stream()
                .filter(doctorDTO -> doctorDTO.getId() == id)
                .findFirst()
                .orElseThrow(DoctorNotFoundException::new);
    }

    private List<DoctorDTO> doctorList() {
        return Arrays.asList(
                new DoctorDTO(1, "Andrei Mladin"),
                new DoctorDTO(2, "George Buhnici"));
    }
}
