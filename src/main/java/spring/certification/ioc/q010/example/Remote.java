package spring.certification.ioc.q010.example;

/**
 * A TV control device.
 */
public class Remote {

    private Battery battery;

    public Remote(Battery battery) {
        this.battery = battery;
    }

    public Battery extractBattery() {
        return this.battery;
    }
}
