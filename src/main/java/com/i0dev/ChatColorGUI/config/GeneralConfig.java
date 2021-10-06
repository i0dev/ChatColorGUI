package com.i0dev.ChatColorGUI.config;

import com.i0dev.ChatColorGUI.Heart;
import com.i0dev.ChatColorGUI.objects.ChatColorOption;
import com.i0dev.ChatColorGUI.objects.NicknameOption;
import com.i0dev.ChatColorGUI.templates.AbstractConfiguration;
import com.i0dev.ChatColorGUI.utility.Utility;
import com.massivecraft.massivecore.store.Coll;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bukkit.Material;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GeneralConfig extends AbstractConfiguration {

    public GeneralConfig(Heart heart, String path) {
        this.path = path;
        this.heart = heart;
    }


    int mainMenuGUISize = 9;
    String mainGUITitle = "&c&lColors Manager";
    String nicknameGUITitle = "&c&lNickname Colors";
    String chatColorGUITitle = "&c&lChat Colors";
    List<String> nicknameLoreFormat = Arrays.asList(
            "{availability}",
            "",
            "&cColor Information:",
            " &c&l* &7Color: &c{colorName}",
            " &c&l* &7Obtained By: &c{obtained}",
            "",
            "{footerAvailability}"
    );

    List<String> chatColorLoreFormat = Arrays.asList(
            "{availability}",
            "",
            "&cColor Information:",
            " &c&l* &7Color: &c{colorName}",
            " &c&l* &7Preview: &c{preview}",
            " &c&l* &7Obtained By: &c{obtained}",
            "",
            "{footerAvailability}"
    );
    String availabilityUnlocked = "&a&lAvailable";
    String availabilityLocked = "&c&lLocked";
    String footerAvailabilityUnlocked = "&7[!] Right click to equip";
    String nicknameFooterAvailabilityLocked = "&c[!] You do not have this name color";
    String chatColorFooterAvailabilityLocked = "&c[!] You do not have this chat color";
    boolean closeInventoryOnNoPermissionSelect = false;


    Utility.ConfigItem mainMenuBorderItem = new Utility.ConfigItem(
            "&f",
            1,
            (short) 15,
            Material.STAINED_GLASS_PANE.toString(),
            new ArrayList<>(),
            true
    );

    Utility.ConfigItem NicknameMenuBorderItem = new Utility.ConfigItem(
            "&f",
            1,
            (short) 15,
            Material.STAINED_GLASS_PANE.toString(),
            new ArrayList<>(),
            true
    );

    Utility.ConfigItem chatColorMenuBorderItem = new Utility.ConfigItem(
            "&f",
            1,
            (short) 15,
            Material.STAINED_GLASS_PANE.toString(),
            new ArrayList<>(),
            true
    );

    Utility.IndexableConfigItem mainMenuNicknameItem = new Utility.IndexableConfigItem(
            "&c&lNickname Colors",
            1,
            (short) 0,
            Material.NAME_TAG.toString(),
            Arrays.asList(
                    "&7Bring some style with custom Name Colors!",
                    "",
                    "&7(!) Click to view all nickname colors"
            ),
            true,
            3
    );

    Utility.IndexableConfigItem mainMenuInfoItem = new Utility.IndexableConfigItem(
            "&a&lColor Information",
            1,
            (short) 0,
            Material.PAPER.toString(),
            Arrays.asList(
                    "&7Colors give you the ability to customize your nickname or chat color in game.",
                    "",
                    "&7Go to our shop&c shop.mcrivals.com&7 to buy colors!"
            ),
            true,
            4
    );

    Utility.IndexableConfigItem mainMenuChatColorItem = new Utility.IndexableConfigItem(
            "&c&lChat Colors",
            1,
            (short) 0,
            Material.BOOK_AND_QUILL.toString(),
            Arrays.asList(
                    "&7Show off your custom Chat Color!",
                    "",
                    "&7(!) Click to view all Chat Colors!"
            ),
            true,
            5
    );

    Utility.IndexableConfigItem mainMenuRemoveColorItem = new Utility.IndexableConfigItem(
            "&4&lRemove colors",
            1,
            (short) 0,
            Material.BARRIER.toString(),
            Arrays.asList(
                    "&7Sick of your name or chat color?",
                    "",
                    "&7(!) Right-Click to remove your Nickname Color",
                    "&7(!) Left-Click to remove your Chat Color"
            ),
            true,
            8
    );

    List<NicknameOption> nickNameOptions = Arrays.asList(
            new NicknameOption(
                    "Lime Green",
                    "&f&lName Color: {preview}",
                    Material.INK_SACK.toString(),
                    ((short) 10),
                    1,
                    "chatcolorgui.nickname.lightgreen",
                    "Webstore",
                    Collections.singletonList("&a&l")
            ),
            new NicknameOption("Light Blue", "&f&lName Color: {preview}", Material.INK_SACK.toString(), (short) 12, 1,
                    "chatcolorgui.nickname.lightblue", "Webstore", Collections.singletonList("&b")
            ),
            new NicknameOption("Light Red", "&f&lName Color: {preview}", Material.INK_SACK.toString(), (short) 1, 1,
                    "chatcolorgui.nickname.lightred", "Webstore", Collections.singletonList("&c")
            ),
            new NicknameOption("Pink", "&f&lName Color: {preview}", Material.INK_SACK.toString(), (short) 9, 1,
                    "chatcolorgui.nickname.pink", "Webstore", Collections.singletonList("&d")
            ),
            new NicknameOption("Yellow", "&f&lName Color: {preview}", Material.INK_SACK.toString(), (short) 11, 1,
                    "chatcolorgui.nickname.yellow", "Webstore", Collections.singletonList("&e")
            ),
            new NicknameOption("White", "&f&lName Color: {preview}", Material.INK_SACK.toString(), (short) 15, 1,
                    "chatcolorgui.nickname.white", "Webstore", Collections.singletonList("&f")
            ),
            new NicknameOption("Dark Green", "&f&lName Color: {preview}", Material.INK_SACK.toString(), (short) 2, 1,
                    "chatcolorgui.nickname.darkgreen",
                    "Webstore", Collections.singletonList("&2")
            ),
            new NicknameOption("Cyan", "&f&lName Color: {preview}", Material.INK_SACK.toString(), (short) 6, 1,
                    "chatcolorgui.nickname.cyan",
                    "Webstore", Collections.singletonList("&3")
            ),
            new NicknameOption("Dark Red", "&f&lName Color: {preview}", Material.REDSTONE.toString(), (short) 0, 1,
                    "chatcolorgui.nickname.darkred",
                    "Webstore", Collections.singletonList("&4")
            ),
            new NicknameOption("Purple", "&f&lName Color: {preview}", Material.INK_SACK.toString(), (short) 5, 1,
                    "chatcolorgui.nickname.purple",
                    "Webstore", Collections.singletonList("&5")
            ),
            new NicknameOption("Orange", "&f&lName Color: {preview}", Material.INK_SACK.toString(), (short) 14, 1,
                    "chatcolorgui.nickname.orange",
                    "Webstore", Collections.singletonList("&6")
            ),
            new NicknameOption("Light Gray", "&f&lName Color: {preview}", Material.INK_SACK.toString(), (short) 7, 1,
                    "chatcolorgui.nickname.lightgray",
                    "Webstore", Collections.singletonList("&7")
            ),
            new NicknameOption("Dark Gray", "&f&lName Color: {preview}", Material.INK_SACK.toString(), (short) 8, 1,
                    "chatcolorgui.nickname.darkgray",
                    "Webstore", Collections.singletonList("&8")
            ),
            new NicknameOption("Blue", "&f&lName Color: {preview}", Material.INK_SACK.toString(), (short) 4, 1,
                    "chatcolorgui.nickname.blue",
                    "Webstore", Collections.singletonList("&9")
            ),
            new NicknameOption("Psycho", "&f&lName Color: {preview}", Material.EYE_OF_ENDER.toString(), (short) 0, 1,
                    "chatcolorgui.nickname.psycho",
                    "Webstore", Arrays.asList("&a", "&d")
            ),
            new NicknameOption("Spring", "&f&lName Color: {preview}", Material.DOUBLE_PLANT.toString(), (short) 0, 1,
                    "chatcolorgui.nickname.spring",
                    "Webstore", Arrays.asList("&2", "&a")
            )
    );

    List<ChatColorOption> chatColorOptions = Arrays.asList(
            new ChatColorOption(
                    "Light Gray",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(), (short) 7, 1, "chatcolorgui.chatcolor.lightgray", "Citizen Rank", Collections.singletonList("&7")
            ),
            new ChatColorOption(
                    "Lime Green",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(),
                    ((short) 10),
                    1,
                    "chatcolorgui.chatcolor.lightgreen",
                    "Webstore",
                    Collections.singletonList("&a")
            ),
            new ChatColorOption(
                    "Light Blue",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(), (short) 12, 1, "chatcolorgui.chatcolor.lightblue", "Webstore", Collections.singletonList("&b")
            ),
            new ChatColorOption(
                    "Light Red",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(), (short) 1, 1, "chatcolorgui.chatcolor.lightred", "Webstore", Collections.singletonList("&c")
            ),
            new ChatColorOption(
                    "Pink",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(), (short) 9, 1, "chatcolorgui.chatcolor.pink", "Webstore", Collections.singletonList("&d")
            ),
            new ChatColorOption(
                    "Yellow",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(), (short) 11, 1, "chatcolorgui.chatcolor.yellow", "Webstore", Collections.singletonList("&e")
            ),
            new ChatColorOption(
                    "White",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(), (short) 15, 1, "chatcolorgui.chatcolor.white", "Webstore", Collections.singletonList("&f")
            ),
            new ChatColorOption(
                    "Dark Green",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(), (short) 2, 1, "chatcolorgui.chatcolor.darkgreen", "Webstore", Collections.singletonList("&2")
            ),
            new ChatColorOption(
                    "Cyan",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(), (short) 6, 1, "chatcolorgui.chatcolor.cyan", "Webstore", Collections.singletonList("&3")
            ),
            new ChatColorOption(
                    "Dark Red",
                    "&f&lChat Color: {color}",
                    Material.REDSTONE.toString(), (short) 0, 1, "chatcolorgui.chatcolor.darkred", "Webstore", Collections.singletonList("&4")
            ),
            new ChatColorOption(
                    "Purple",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(), (short) 5, 1, "chatcolorgui.chatcolor.purple", "Webstore", Collections.singletonList("&5")
            ),
            new ChatColorOption(
                    "Orange",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(), (short) 14, 1, "chatcolorgui.chatcolor.orange", "Webstore", Collections.singletonList("&6")
            ),
            new ChatColorOption(
                    "Dark Gray",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(), (short) 8, 1, "chatcolorgui.chatcolor.darkgray", "Webstore", Collections.singletonList("&8")
            ),
            new ChatColorOption(
                    "Blue",
                    "&f&lChat Color: {color}",
                    Material.INK_SACK.toString(), (short) 4, 1, "chatcolorgui.chatcolor.blue", "Webstore", Collections.singletonList("&9")
            )

    );

}
