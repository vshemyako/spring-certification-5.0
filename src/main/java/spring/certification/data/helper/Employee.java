package spring.certification.data.helper;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * An employed person.
 */
@Getter @Setter
public class Employee {
    private int number;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate hireDate;
}
