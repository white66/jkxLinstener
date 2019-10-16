package com.rtstjkx.jkx.entity.systemInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author leigq
 * @since 2019-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer permissionId;


    private Boolean available;


    private Long parentId;


    private String parentIds;


    private String permission;


    private String permissionName;


    private String resourceType;

    private String url;


}
