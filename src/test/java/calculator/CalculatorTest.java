package calculator;

import model.DistanceUnit;
import model.TransportationMethod;
import model.WeightUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    private void testCalculateEquivalentForLargeDieselCar100KmsWithDistanceUnitInKm() {
        BigDecimal actual = calculator.calculateCO2Equivalent(TransportationMethod.LARGE_DIESEL_CAR, new BigDecimal(100), DistanceUnit.KM);
        Assert.assertEquals(actual.doubleValue(), 20900);
    }

    @Test
    private void testCalculateEquivalentForBus1KmWithDistanceUnitInKm() {
        BigDecimal actual = calculator.calculateCO2Equivalent(TransportationMethod.bus, new BigDecimal(1), DistanceUnit.KM);
        Assert.assertEquals(actual.doubleValue(), 27);
    }

    @Test
    private void testCalculateEquivalentForLargeElectricCar1MWithDistanceUnitInM() {
        BigDecimal actual = calculator.calculateCO2Equivalent(TransportationMethod.LARGE_ELECTRIC_CAR, new BigDecimal(1), DistanceUnit.M);
        Assert.assertEquals(actual.doubleValue(), 0.073);
    }

    @Test
    private void testCalculateEquivalentForLargePluginHybridCar1000MWithDistanceUnitInM() {
        BigDecimal actual = calculator.calculateCO2Equivalent(TransportationMethod.LARGE_PLUGIN_HYBRID_CAR, new BigDecimal(1000), DistanceUnit.M);
        Assert.assertEquals(actual.doubleValue(), 126);
    }

    @Test
    private void testCreateOutputFor100GWithUnitG() {
        String actual = calculator.createOutput(new BigDecimal(100), WeightUnit.G);
        Assert.assertEquals(actual, "Your trip caused 100g of CO2-equivalent.");
    }

    @Test
    private void testCreateOutputFor100GWithUnitKg() {
        String actual = calculator.createOutput(new BigDecimal(100), WeightUnit.KG);
        Assert.assertEquals(actual, "Your trip caused 0.1kg of CO2-equivalent.");
    }

    @Test
    private void testCreateOutputFor1000GWithUnitKg() {
        String actual = calculator.createOutput(new BigDecimal(1000), WeightUnit.KG);
        Assert.assertEquals(actual, "Your trip caused 1kg of CO2-equivalent.");
    }

    @Test
    private void testCreateOutputFor1000GWithUnitG() {
        String actual = calculator.createOutput(new BigDecimal(1000), WeightUnit.G);
        Assert.assertEquals(actual, "Your trip caused 1000g of CO2-equivalent.");
    }

    @Test
    private void testCreateOutputFor1000GWithoutUnit() {
        String actual = calculator.createOutput(new BigDecimal(1000), null);
        Assert.assertEquals(actual, "Your trip caused 1kg of CO2-equivalent.");
    }

    @Test
    private void testCreateOutputFor100GWithoutUnit() {
        String actual = calculator.createOutput(new BigDecimal(100), null);
        Assert.assertEquals(actual, "Your trip caused 100g of CO2-equivalent.");
    }

    @AfterClass
    private void finish() {
        calculator = null;
    }

}
