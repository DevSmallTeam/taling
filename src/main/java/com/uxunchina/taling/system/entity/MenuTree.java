package com.uxunchina.taling.system.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuTree implements Serializable {

    private String name;
    private boolean checked;
    private Long parentId;
    private Long permissionId;
    private boolean open;
}
