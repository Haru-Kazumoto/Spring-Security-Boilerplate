package dev.pack.modules.auth;

import dev.pack.modules.authorization.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  @UniqueElements
  @NotEmpty(message = "Username cannot be empty!")
  private String username;

  @Email(message = "Email pattern doesn't valid!")
  @NotEmpty(message = "Email cannot be empty!")
  private String email;

  @NotEmpty(message = "Password cannot be empty!")
  private String password;

  @NotNull(message = "Role is required")
  private Role role;

}
