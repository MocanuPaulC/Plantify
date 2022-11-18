package be.kdg.integration.plantifybackend.presentation.viewModel;

import javax.validation.constraints.NotEmpty;

public class SignUpViewModel {
    @NotEmpty(message = "Cannot be empty!")
    public String email;
    public String newUsername;
    public String newPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "SignUpViewModel{" +
                "email='" + email + '\'' +
                ", newUsername='" + newUsername + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
