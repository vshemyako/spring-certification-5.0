package spring.certification.data.q032;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import spring.certification.ioc.q016.example.Holiday;

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
public class QueryAnnotation {

    public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

        @Query("select distinct h.name from Holiday h")
        List<Holiday> getUnique();
    }
}
