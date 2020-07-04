package cli;

import model.DistanceUnit;
import model.TransportationMethod;
import model.WeightUnit;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import calculator.Calculator;

import java.math.BigDecimal;

@Command(descriptionHeading = "CO2 Emission Calculator", description = ": Use this program to calculate your CO2 emission",
        mixinStandardHelpOptions = true, version = "1.0")
public class CommandLineInterface implements Runnable {

    @Option(names = "--transportation-method", required = true, description = "Please choose from available transportation methods:\n" +
            "small-diesel-car\n" + "medium-diesel-car\n" + "large-diesel-car\n" +
            "small-petrol-car\n" + "medium-petrol-car\n" + "large-petrol-car\n" +
            "small-plugin-hybrid-car\n" + "medium-plugin-hybrid-car\n" + "large-plugin-hybrid-car\n" +
            "small-electric-car\n" + "medium-electric-car\n" + "large-electric-car\n" +
            "bus\n" + "train\n")
    private String transportMethod;

    @Option(names = "--distance", required = true, description = "Enter a numeric value for distance")
    private BigDecimal distance;

    @Option(names = "--unit-of-distance", defaultValue = "km", description = "Optional. Put km for kilometer or m for meter. Default is kilometer.")
    private String distanceUnit;

    @Option(names = "--output", description = "Optional. Put kg for kilogram or g for gram")
    private String weightUnit;

    public static void main(String[] args) {

        int exitCode = new CommandLine(new CommandLineInterface()).setParameterExceptionHandler(new ShortErrorMessageHandler()).execute(args);
        System.exit(exitCode);

    }

    @Override
    public void run() {
        Calculator calculator = new Calculator();
        BigDecimal value = calculator.calculateCO2Equivalent(TransportationMethod.getFromString(transportMethod), distance, DistanceUnit.valueOf(distanceUnit.toUpperCase()));
        System.out.println(calculator.createOutput(value, WeightUnit.getByName(weightUnit)));
    }

}
