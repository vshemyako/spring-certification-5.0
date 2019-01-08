package spring.certification.data.helper.config.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity-class to verify workings of JPA.
 *
 * @author Valentine Shemyako
 * @since January 08, 2019
 */
@Entity
@Table(name = "holidays")
@Getter @Setter
public class Holiday {
    @Id
    private int id;
    private String name;
}
