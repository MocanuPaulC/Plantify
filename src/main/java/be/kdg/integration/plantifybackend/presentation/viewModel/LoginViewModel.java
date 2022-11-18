package be.kdg.integration.plantifybackend.presentation.viewModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginViewModel {
    @NotEmpty(message = "Cannot be empty!")
    @Size(min=5, max=10)
    private String username;
    @Size(min=6, message = "Password cannot be shorten then 6 characters!")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
