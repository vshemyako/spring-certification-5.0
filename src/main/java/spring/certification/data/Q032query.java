package spring.certification.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.certification.ioc.Q016.Holiday;

import java.util.List;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 032:<br>
 * What is @Query used for?<br>
 * <p>
 * Answer:<br>
 * {@link Query} is an annotation which should be applied at repository method level to define custom queries. There
 * are several reasons to do so:
 * - method name parsing mechanism has its limitations - not all desired keywords are supported<br>
 * - method name is very cumbersome and hard to understand<br>
 *
 * @author Valentine Shemyako
 * @since January 10, 2019
 */
public class Q032query {

    public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

        @Query("select distinct h.name from Holiday h")
        List<Holiday> getUnique();
    }
}
