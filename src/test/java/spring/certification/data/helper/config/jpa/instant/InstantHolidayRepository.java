package spring.certification.data.helper.config.jpa.instant;

import spring.certification.data.helper.config.jpa.entity.Holiday;

/**
 * The most basic example of a spring-data instant repository.
 */
public interface InstantHolidayRepository extends IntermediateHolidayRepository<Holiday, Integer> {
}
