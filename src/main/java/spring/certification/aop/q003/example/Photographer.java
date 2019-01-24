package spring.certification.aop.q003.example;

import org.springframework.stereotype.Component;

/**
 * A person who takes photos.
 */
@Component
public class Photographer {

    public void takePhotoOf(Celebrity celebrity) {
        celebrity.poseForPhoto();
    }
}
