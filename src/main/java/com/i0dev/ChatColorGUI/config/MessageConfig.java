package com.i0dev.ChatColorGUI.config;

import com.i0dev.ChatColorGUI.Heart;
import com.i0dev.ChatColorGUI.templates.AbstractConfiguration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MessageConfig extends AbstractConfiguration {

    String reloadUsage = "&cUsage: &7/ChatColorGUI reload";
    String HelpUsage = "&cUsage: &7/ChatColorGUI help";
    String colorsUsage = "&cUsage: &7/colors";
    String helpTitle = "&7&m----&r&7[ &cChatColorGUI Help &7]&m----";
    String changedNickname = "&7You have &asuccessfully &7changed your nickname to: {nickname}";
    String changedChatColor = "&7You have &asuccessfully &7changed your chat color to: {color}";
    String noPermissionForNickname = "&cYou do not have permission to select this nickname!";
    String noPermissionForChatColor = "&cYou do not have permission to select this chat color!";
    String youRemovedNickname = "&7You have removed your nickname color.";
    String youRemovedChatColor = "&7You have removed your chat color.";
    String reloadedConfig = "&7You have&a reloaded&7 the configuration.";
    String noPermission = "&cYou don not have permission to run that command.";
    String cantFindPlayer = "&cThe player: &f{player}&c cannot be found!";
    String invalidNumber = "&cThe number &f{num} &cis invalid! Try again.";
    String noConsole = "&cYou cannot run that command as console";

    public MessageConfig(Heart heart, String path) {
        this.path = path;
        this.heart = heart;
    }
}
