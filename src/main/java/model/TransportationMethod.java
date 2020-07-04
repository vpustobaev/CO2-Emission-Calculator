package model;

public enum TransportationMethod {

    SMALL_DIESEL_CAR("small-diesel-car", 142),
    SMALL_PETROL_CAR("small-petrol-car", 154),
    SMALL_PLUGIN_HYBRID_CAR("small-plugin-hybrid-car", 73),
    SMALL_ELECTRIC_CAR("small-electric-car", 50),

    MEDIUM_DIESEL_CAR("medium-diesel-car", 171),
    MEDIUM_PETROL_CAR("medium-petrol-car", 192),
    MEDIUM_PLUGIN_HYBRID_CAR("medium-plugin-hybrid-car", 110),
    MEDIUM_ELECTRIC_CAR("medium-electric-car", 58),

    LARGE_DIESEL_CAR("large-diesel-car", 209),
    LARGE_PETROL_CAR("large-petrol-car", 282),
    LARGE_PLUGIN_HYBRID_CAR("large-plugin-hybrid-car", 126),
    LARGE_ELECTRIC_CAR("large-electric-car", 73),

    bus("bus", 27),

    train("train", 6);

    private final String name;
    private final double co2Equivalent;

    TransportationMethod(String name, double co2Equivalent) {
        this.name = name;
        this.co2Equivalent = co2Equivalent;
    }

    public static TransportationMethod getFromString(String text) {
        for (TransportationMethod t : TransportationMethod.values()) {
            if (t.name.equalsIgnoreCase(text)) {
                return t;
            }
        }
        return null;
    }

    public double getCo2Equivalent() {
        return co2Equivalent;
    }

}
