package cli;

import picocli.CommandLine;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.UnmatchedArgumentException;

import java.io.PrintWriter;

class ShortErrorMessageHandler implements CommandLine.IParameterExceptionHandler {

    public int handleParseException(ParameterException ex, String[] args) {
        CommandLine cmd = ex.getCommandLine();
        PrintWriter writer = cmd.getErr();

        writer.println(ex.getMessage());
        UnmatchedArgumentException.printSuggestions(ex, writer);
        writer.print(cmd.getHelp().fullSynopsis());

        CommandSpec spec = cmd.getCommandSpec();
        writer.printf("Try '%s --help' for more information.%n", spec.qualifiedName());

        return cmd.getExitCodeExceptionMapper() != null
                ? cmd.getExitCodeExceptionMapper().getExitCode(ex)
                : spec.exitCodeOnInvalidInput();
    }
}