package com.i0dev.ChatColorGUI.objects;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatColorOption {
    private String colorName;
    private String displayName;
    private String itemMaterial;
    private short itemData;
    private int itemAmount;
    private String permission;
    private String obtainedBy;
    private List<String> colorCodes;
}
