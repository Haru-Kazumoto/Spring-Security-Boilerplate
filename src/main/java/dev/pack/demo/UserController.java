package dev.pack.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/user")
@PreAuthorize("hasRole('USER')")
public class UserController {

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public String get(){
        return "GET:: user controller";
    }

}
