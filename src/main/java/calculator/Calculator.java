package calculator;

import model.DistanceUnit;
import model.TransportationMethod;
import model.WeightUnit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    public BigDecimal calculateCO2Equivalent(TransportationMethod method, BigDecimal distance, DistanceUnit distanceUnit) {
        BigDecimal adjustedDistance = DistanceUnit.M == distanceUnit ? distance.divide(new BigDecimal(1000)) : distance;
        return new BigDecimal(method.getCo2Equivalent()).multiply(adjustedDistance);
    }

    public String createOutput(BigDecimal calculatedValue, WeightUnit weightUnit) {
        if (weightUnit == null) {
            weightUnit = calculatedValue.doubleValue() < 1000 ? WeightUnit.G : WeightUnit.KG;
        }
        calculatedValue = weightUnit == WeightUnit.KG ? calculatedValue.divide(new BigDecimal(1000)) : calculatedValue;
        return ("Your trip caused " + calculatedValue.setScale(1, RoundingMode.HALF_EVEN).stripTrailingZeros().toPlainString() + weightUnit.name().toLowerCase() + " of CO2-equivalent.");
    }

}
