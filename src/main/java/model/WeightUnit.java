package model;

public enum WeightUnit {
    G,
    KG;

    public static WeightUnit getByName(String name) {
        return name != null ? WeightUnit.valueOf(name.toUpperCase()) : null;
    }
}
