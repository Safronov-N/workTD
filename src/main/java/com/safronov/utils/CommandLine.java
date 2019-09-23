package com.safronov.utils;

public class CommandLine {
    private static CommandLine commandLine;

    private CommandLine() {

    }

    public static CommandLine getInstance() {
        if (commandLine == null)
            return commandLine = new CommandLine();
        else
            return commandLine;
    }

    public String getLogin() {
        return System.getProperty("login");
    }

    public String getPassword() {
        return System.getProperty("password");
    }
}
