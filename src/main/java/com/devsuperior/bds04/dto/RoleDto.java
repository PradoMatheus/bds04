package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.Role;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RoleDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String authority;

    public RoleDto() {
    }

    public RoleDto(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public RoleDto(Role role) {
        id = role.getId();
        authority = role.getAuthority();
    }
}
