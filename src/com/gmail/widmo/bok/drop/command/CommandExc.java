package com.gmail.widmo.bok.drop.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class CommandExc extends Command {

    protected CommandExc(String name, String description, String usageMessage, List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }

    public abstract boolean execute(CommandSender commandSender, String arg, String[] args);

}
