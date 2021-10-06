package com.i0dev.ChatColorGUI.commands;

import com.i0dev.ChatColorGUI.Heart;
import com.i0dev.ChatColorGUI.config.MessageConfig;
import com.i0dev.ChatColorGUI.handlers.ChatHandler;
import com.i0dev.ChatColorGUI.managers.MessageManager;
import com.i0dev.ChatColorGUI.templates.AbstractCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Colors extends AbstractCommand {

    MessageConfig msg;
    MessageManager msgManager;

    public Colors(Heart heart, String command) {
        super(heart, command);
    }

    @Override
    public void initialize() {
        msgManager = getHeart().getManager(MessageManager.class);
        msg = getHeart().getConfig(MessageConfig.class);
    }

    @Override
    public void deinitialize() {
        msgManager = null;
        msg = null;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            msgManager.msg(sender, msg.getNoConsole());
            return;
        }

        if (!sender.hasPermission("ChatColorGUI.colors.cmd")) {
            msgManager.msg(sender, msg.getNoPermission());
            return;
        }

        heart.getManager(ChatHandler.class).openMainGUI(((Player) sender));
    }

    List<String> blank = new ArrayList<>();

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return blank;
    }
}
