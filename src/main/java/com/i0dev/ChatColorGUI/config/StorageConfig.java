package com.i0dev.ChatColorGUI.config;

import com.i0dev.ChatColorGUI.Heart;
import com.i0dev.ChatColorGUI.templates.AbstractConfiguration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StorageConfig extends AbstractConfiguration {

    public StorageConfig(Heart heart, String path) {
        this.path = path;
        this.heart = heart;
    }


    Map<UUID, List<String>> chatColorMap = new HashMap<>();

}
