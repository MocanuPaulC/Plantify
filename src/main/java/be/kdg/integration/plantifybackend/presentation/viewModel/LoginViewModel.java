package be.kdg.integration.plantifybackend.presentation.viewModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginViewModel {
    @NotEmpty(message = "Email can't be empty!")
    @Email(regexp = "^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$",
            message = "Not a valid Email!")
    private String email;
    @NotEmpty(message = "Password can't be empty!")
    @Size(min=5, message = "Password must at least be 5 characters long")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginViewModel{" +
                "username='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
