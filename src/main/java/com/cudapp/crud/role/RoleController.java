package com.cudapp.crud.role;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public List<Role> getRoles(){
        List<Role> roles=roleService.getRoles();
        return roles;
    }
    @PostMapping()
    public Role addRole( @RequestBody Role role){
        roleService.addRole(role);
        return role;
    }
}
