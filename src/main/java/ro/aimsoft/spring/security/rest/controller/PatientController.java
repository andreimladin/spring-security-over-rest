package ro.aimsoft.spring.security.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.aimsoft.spring.security.rest.exception.PatientNotFoundException;
import ro.aimsoft.spring.security.rest.model.dto.PatientDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('DOCTOR')")
    public void create(@RequestBody @Valid PatientDTO patientDTO) {

    }

    @GetMapping
    @PreAuthorize("hasRole('DOCTOR')")
    public List<PatientDTO> getAll() {
        return patientList();
    }

    @GetMapping("/{cnp}")
    @PreAuthorize("hasRole('DOCTOR')")
    public PatientDTO getUser(@PathVariable @NotNull long cnp) {
        return patientList().stream()
                .filter(patientDTO -> patientDTO.getCnp().equals(cnp))
                .findFirst()
                .orElseThrow(PatientNotFoundException::new);
    }

    private List<PatientDTO> patientList() {
        return Arrays.asList(
                new PatientDTO("1870326244514", "andrei.mladin@gmail.com", "Andrei", "Mladin"),
                new PatientDTO("1870326244515", "george@gmail.com", "George", "Buhnici"));
    }
}
