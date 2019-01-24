package spring.certification.ioc.q010.example;

/**
 * Multi-purpose mobile device.
 */
public class Smartphone {

    private Battery battery;

    /**
     * No reason to use a smartphone without a battery.
     */
    public Smartphone(Battery battery) {
        this.battery = battery;
    }

    /**
     * Extract battery from mobile device.
     */
    public Battery extractBattery() {
        return this.battery;
    }
}
