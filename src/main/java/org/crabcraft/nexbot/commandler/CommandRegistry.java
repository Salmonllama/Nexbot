package org.crabcraft.nexbot.commandler;

import java.util.TreeMap;

public class CommandRegistry {
    private static TreeMap<String, Command> commands;

    public CommandRegistry() {
        commands = new TreeMap<>();
    }

    public Command registerCommand(Command command) {
        commands.put(command.Aliases().get(0), command);
        return command;
    }

    public TreeMap<String, Command> getCommands() {
        return commands;
    }
}