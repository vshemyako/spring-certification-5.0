package spring.certification.data.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * An employed person.
 */
@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private int number;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate hireDate;

    public Employee(LocalDate birthDate, String firstName, String lastName, Gender gender, LocalDate hireDate) {
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hireDate = hireDate;
    }
}
