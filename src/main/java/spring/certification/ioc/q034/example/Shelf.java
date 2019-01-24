package spring.certification.ioc.q034.example;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Piece of furniture.
 */
@Getter
@Component
public class Shelf {

    /**
     * Property injection, using literal value.
     */
    @Value("50")
    private int length;
    private int width;
    private String material;

    /**
     * Constructor parameter injection, using custom property source.
     */
    public Shelf(@Value("${shelf.width}") int width) {
        this.width = width;
    }

    /**
     * Setter parameter injection, using SpEL and referencing another bean property.
     * Note: {@link Autowired} is used here, because otherwise IoC container ignores autowiring config methods
     * (by default applies to a constructor)
     */
    @Autowired
    public void setMaterial(@Value("#{@plastic.materialName}") String material) {
        this.material = material;
    }
}
