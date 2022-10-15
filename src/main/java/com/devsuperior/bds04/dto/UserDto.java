package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "Please, set a valid email")
    private String email;
    @Setter(AccessLevel.NONE)
    private Set<RoleDto> roles = new HashSet<>();

    public UserDto() {
    }

    public UserDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public UserDto(User user) {
        id = user.getId();
        email = user.getEmail();
        user.getRoles().forEach(role -> this.roles.add(new RoleDto(role)));
    }
}
