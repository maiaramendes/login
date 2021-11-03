package com.login.user.model;

import com.login.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class User extends BaseEntity {

    private String name;

    private String userName;

    private String email;
}
