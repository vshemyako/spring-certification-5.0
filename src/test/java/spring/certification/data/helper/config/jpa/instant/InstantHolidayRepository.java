package spring.certification.data.helper.config.jpa.instant;

import org.springframework.data.jpa.repository.Query;
import spring.certification.data.helper.config.jpa.entity.Holiday;

import java.util.List;

/**
 * The most basic example of a spring-data instant repository.
 */
public interface InstantHolidayRepository extends IntermediateHolidayRepository<Holiday, Integer> {

    List<Holiday> readTop2By();

    List<Holiday> readByNameOrName(String name, String otherName);

    @Query("select distinct h.name from Holiday h")
    List<Holiday> getUnique();
}
