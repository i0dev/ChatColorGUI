package com.i0dev.ChatColorGUI.handlers;

import com.i0dev.ChatColorGUI.Heart;
import com.i0dev.ChatColorGUI.config.GeneralConfig;
import com.i0dev.ChatColorGUI.config.MessageConfig;
import com.i0dev.ChatColorGUI.config.StorageConfig;
import com.i0dev.ChatColorGUI.managers.MessageManager;
import com.i0dev.ChatColorGUI.objects.ChatColorOption;
import com.i0dev.ChatColorGUI.objects.NicknameOption;
import com.i0dev.ChatColorGUI.templates.AbstractListener;
import com.i0dev.ChatColorGUI.utility.ConfigUtil;
import com.i0dev.ChatColorGUI.utility.Utility;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChatHandler extends AbstractListener {
    public ChatHandler(Heart heart) {
        super(heart);
    }

    public void openMainGUI(Player player) {
        Inventory gui = Bukkit.createInventory(new ChatColorGUIHolder(), heart.cnf().getMainMenuGUISize(), Utility.color(heart.cnf().getMainGUITitle()));
        GeneralConfig cnf = heart.cnf();

        ItemStack nickname = Utility.makeItem(cnf.getMainMenuNicknameItem());
        nickname = Utility.addNBTValue(nickname, "chatcolorgui_main_menu_item", "nickname");
        ItemStack info = Utility.makeItem(cnf.getMainMenuInfoItem());
        ItemStack chatColor = Utility.makeItem(cnf.getMainMenuChatColorItem());
        chatColor = Utility.addNBTValue(chatColor, "chatcolorgui_main_menu_item", "chatColor");
        ItemStack remove = Utility.makeItem(cnf.getMainMenuRemoveColorItem());
        remove = Utility.addNBTValue(remove, "chatcolorgui_main_menu_item", "remove");

        gui.setItem(cnf.getMainMenuNicknameItem().index, nickname);
        gui.setItem(cnf.getMainMenuInfoItem().index, info);
        gui.setItem(cnf.getMainMenuChatColorItem().index, chatColor);
        gui.setItem(cnf.getMainMenuRemoveColorItem().index, remove);

        gui = fillAir(gui, Utility.makeItem(heart.cnf().getMainMenuBorderItem()));
        player.openInventory(gui);
    }

    public void openNicknameGUI(Player player) {
        Inventory gui = Bukkit.createInventory(new ChatColorGUINicknameHolder(), getInventorySize(heart.cnf().getNickNameOptions().size()), Utility.color(heart.cnf().getNicknameGUITitle()));
        GeneralConfig cnf = heart.cnf();

        for (int i = 0; i < cnf.getNickNameOptions().size(); i++) {
            NicknameOption opt = cnf.getNickNameOptions().get(i);
            List<String> lore = new ArrayList<>();
            cnf.getNicknameLoreFormat().forEach(s -> {
                lore.add(s
                        .replace("{availability}", player.hasPermission(opt.getPermission()) ? cnf.getAvailabilityUnlocked() : cnf.getAvailabilityLocked())
                        .replace("{colorName}", opt.getColorName())
                        .replace("{obtained}", opt.getObtainedBy())
                        .replace("{footerAvailability}", player.hasPermission(opt.getPermission()) ? cnf.getFooterAvailabilityUnlocked() : cnf.getNicknameFooterAvailabilityLocked())
                );
            });

            String name = opt.getDisplayName().replace("{preview}", formatColors(player.getName(), opt.getColorCodes()));

            ItemStack item = Utility.makeItem(
                    Material.getMaterial(opt.getItemMaterial()),
                    opt.getItemAmount(),
                    opt.getItemData(),
                    name,
                    lore,
                    true
            );

            item = Utility.addNBTValue(item, "chatcolorgui_nickname_item_index", i + "");

            gui.setItem(i, item);

        }


        gui = fillAir(gui, Utility.makeItem(heart.cnf().getNicknameMenuBorderItem()));
        player.openInventory(gui);
    }


    public void openChatColorGUI(Player player) {
        Inventory gui = Bukkit.createInventory(new ChatColorGUIChatColorHolder(), getInventorySize(heart.cnf().getChatColorOptions().size()), Utility.color(heart.cnf().getChatColorGUITitle()));
        GeneralConfig cnf = heart.cnf();
        for (int i = 0; i < cnf.getChatColorOptions().size(); i++) {
            ChatColorOption opt = cnf.getChatColorOptions().get(i);
            List<String> lore = new ArrayList<>();
            cnf.getChatColorLoreFormat().forEach(s -> {
                lore.add(s
                        .replace("{availability}", player.hasPermission(opt.getPermission()) ? cnf.getAvailabilityUnlocked() : cnf.getAvailabilityLocked())
                        .replace("{colorName}", opt.getColorName())
                        .replace("{preview}", player.getDisplayName() + "&7: " + formatColors("Hello, How is your day?", opt.getColorCodes()))
                        .replace("{obtained}", opt.getObtainedBy())
                        .replace("{footerAvailability}", player.hasPermission(opt.getPermission()) ? cnf.getFooterAvailabilityUnlocked() : cnf.getChatColorFooterAvailabilityLocked())
                );
            });

            String name = opt.getDisplayName().replace("{color}", formatColors(opt.getColorName(), opt.getColorCodes()));

            ItemStack item = Utility.makeItem(
                    Material.getMaterial(opt.getItemMaterial()),
                    opt.getItemAmount(),
                    opt.getItemData(),
                    name,
                    lore,
                    true
            );

            item = Utility.addNBTValue(item, "chatcolorgui_chatcolor_item_index", i + "");

            gui.setItem(i, item);
        }

        gui = fillAir(gui, Utility.makeItem(heart.cnf().getChatColorMenuBorderItem()));
        player.openInventory(gui);
    }


    public Inventory fillAir(Inventory inv, ItemStack borderItem) {
        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null || Material.AIR.equals(inv.getItem(i).getType()))
                inv.setItem(i, borderItem);
        }
        return inv;
    }

    public int getInventorySize(int number) {
        if (number >= 0 && number <= 9) {
            return 9;
        } else if (number >= 10 && number <= 18) {
            return 18;
        } else if (number >= 19 && number <= 27) {
            return 27;
        } else if (number >= 28 && number <= 36) {
            return 36;
        } else if (number >= 37 && number <= 45) {
            return 45;
        } else {
            return 54;
        }
    }

    public static class ChatColorGUIHolder implements InventoryHolder {
        @Override
        public Inventory getInventory() {
            return null;
        }
    }

    public static class ChatColorGUINicknameHolder extends ChatColorGUIHolder {
    }


    public static class ChatColorGUIChatColorHolder extends ChatColorGUIHolder {
    }


    /*
    This method will handle switching between the main menu, and the two sub menus.
     */

    @EventHandler
    public void inventoryClickEventMoveMenu(InventoryClickEvent e) {
        if (!(e.getInventory().getHolder() instanceof ChatColorGUIHolder)) return;
        if (e.getCurrentItem() == null || Material.AIR.equals(e.getCurrentItem().getType())) return;
        NBTItem nbtItem = new NBTItem(e.getCurrentItem());
        if (nbtItem.getString("chatcolorgui_main_menu_item").equalsIgnoreCase("nickname"))
            openNicknameGUI(((Player) e.getWhoClicked()));
        else if (nbtItem.getString("chatcolorgui_main_menu_item").equalsIgnoreCase("chatColor")) {
            openChatColorGUI(((Player) e.getWhoClicked()));
        } else if (nbtItem.getString("chatcolorgui_main_menu_item").equalsIgnoreCase("remove")) {
            if (ClickType.RIGHT.equals(e.getClick())) {
                setNickname(((Player) e.getWhoClicked()), e.getWhoClicked().getName());
                heart.getManager(MessageManager.class).msg(e.getWhoClicked(), heart.getConfig(MessageConfig.class).getYouRemovedNickname());
            } else if (ClickType.LEFT.equals(e.getClick())) {
                setChatColor(e.getWhoClicked().getUniqueId(), null);
                heart.getManager(MessageManager.class).msg(e.getWhoClicked(), heart.getConfig(MessageConfig.class).getYouRemovedChatColor());
            }

        }
        e.setCancelled(true);
    }


    @EventHandler
    public void inventoryClickEventNicknameSelect(InventoryClickEvent e) {
        if (!(e.getInventory().getHolder() instanceof ChatColorGUINicknameHolder)) return;
        if (e.getCurrentItem() == null || Material.AIR.equals(e.getCurrentItem().getType())) return;
        NBTItem nbtItem = new NBTItem(e.getCurrentItem());
        String nbtIndex = nbtItem.getString("chatcolorgui_nickname_item_index");
        if (nbtIndex.equalsIgnoreCase("")) return;
        NicknameOption option = heart.cnf().getNickNameOptions().get(Integer.parseInt(nbtIndex));
        e.setCancelled(true);
        if (!e.getWhoClicked().hasPermission(option.getPermission())) {
            heart.getManager(MessageManager.class).msg(e.getWhoClicked(), heart.getConfig(MessageConfig.class).getNoPermissionForNickname());
            if (heart.cnf().isCloseInventoryOnNoPermissionSelect())
                e.getWhoClicked().closeInventory();
            return;
        }
        String nickname = formatColors(e.getWhoClicked().getName(), option.getColorCodes());
        setNickname(((Player) e.getWhoClicked()), nickname);
        heart.getManager(MessageManager.class).msg(e.getWhoClicked(), heart.getConfig(MessageConfig.class).getChangedNickname(), new MessageManager.Pair<>("{nickname}", nickname));
        e.getWhoClicked().closeInventory();
    }

    @EventHandler
    public void inventoryClickEventChatColorSelect(InventoryClickEvent e) {
        if (!(e.getInventory().getHolder() instanceof ChatColorGUIChatColorHolder)) return;
        if (e.getCurrentItem() == null || Material.AIR.equals(e.getCurrentItem().getType())) return;
        NBTItem nbtItem = new NBTItem(e.getCurrentItem());
        String nbtIndex = nbtItem.getString("chatcolorgui_chatcolor_item_index");
        if (nbtIndex.equalsIgnoreCase("")) return;
        ChatColorOption option = heart.cnf().getChatColorOptions().get(Integer.parseInt(nbtIndex));
        e.setCancelled(true);
        if (!e.getWhoClicked().hasPermission(option.getPermission())) {
            heart.getManager(MessageManager.class).msg(e.getWhoClicked(), heart.getConfig(MessageConfig.class).getNoPermissionForChatColor());
            if (heart.cnf().isCloseInventoryOnNoPermissionSelect())
                e.getWhoClicked().closeInventory();
            return;
        }

        setChatColor(e.getWhoClicked().getUniqueId(), option.getColorCodes());

        heart.getManager(MessageManager.class).msg(e.getWhoClicked(), heart.getConfig(MessageConfig.class).getChangedChatColor(), new MessageManager.Pair<>("{color}", formatColors(option.getColorName(), option.getColorCodes())));
        e.getWhoClicked().closeInventory();
    }


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        List<String> colors = getChatColor(e.getPlayer().getUniqueId());
        if (colors.isEmpty()) return;
        e.setMessage(formatColors(e.getMessage(), colors));
    }

    public void setChatColor(UUID uuid, List<String> colors) {
        StorageConfig storage = heart.getConfig(StorageConfig.class);
        if (colors == null) storage.getChatColorMap().remove(uuid);
        else storage.getChatColorMap().put(uuid, colors);
        ConfigUtil.save(storage, storage.path);
    }

    public List<String> getChatColor(UUID uuid) {
        return Utility.color(heart.getConfig(StorageConfig.class).getChatColorMap().getOrDefault(uuid, new ArrayList<>()));
    }

    public static String formatColors(String name, List<String> colors) {
        char[] nameArray = name.toCharArray();
        StringBuilder newNick = new StringBuilder();
        int t = 0;
        for (int i = 0; i < name.length(); i++) {
            if (t >= colors.size()) t = 0;
            newNick.append(colors.get(t)).append(nameArray[i]);
            t++;
        }
        return newNick.toString();
    }

    public void setNickname(Player player, String nickname) {
        if (heart.isUsingEssentials()) {
            com.earth2me.essentials.User user = ((com.earth2me.essentials.Essentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials")).getUser(player);
            user.setNickname(Utility.color(nickname));
        }
    }
}
