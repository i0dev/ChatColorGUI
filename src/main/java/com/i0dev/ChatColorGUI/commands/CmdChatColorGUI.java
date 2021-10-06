package com.i0dev.ChatColorGUI.commands;

import com.i0dev.ChatColorGUI.Heart;
import com.i0dev.ChatColorGUI.config.MessageConfig;
import com.i0dev.ChatColorGUI.managers.MessageManager;
import com.i0dev.ChatColorGUI.templates.AbstractCommand;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CmdChatColorGUI extends AbstractCommand {

    MessageConfig msg;
    MessageManager msgManager;

    public CmdChatColorGUI(Heart heart, String command) {
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
        if (args.length == 0) {
            msgManager.msg(sender, msg.getReloadUsage());
            msgManager.msg(sender, msg.getHelpUsage());
            return;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("chatcolorgui.reload.cmd")) {
                msgManager.msg(sender, msg.getNoPermission());
                return;
            }
            getHeart().reload();
            msgManager.msg(sender, msg.getReloadedConfig());
            return;
        }

        if (args[0].equalsIgnoreCase("help")) {
            if (!sender.hasPermission("chatcolorgui.help.cmd")) {
                msgManager.msg(sender, msg.getNoPermission());
                return;
            }
            msgManager.msg(sender, msg.getHelpTitle());
            msgManager.msg(sender, msg.getColorsUsage());
            msgManager.msg(sender, msg.getReloadUsage());
            msgManager.msg(sender, msg.getHelpUsage());

        }
    }

    List<String> blank = new ArrayList<>();

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        if (args.length == 1) return Arrays.asList("reload", "help");
        return blank;
    }
}
