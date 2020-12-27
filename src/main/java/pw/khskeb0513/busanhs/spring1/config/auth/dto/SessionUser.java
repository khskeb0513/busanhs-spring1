package pw.khskeb0513.busanhs.spring1.config.auth.dto;

import lombok.Getter;
import pw.khskeb0513.busanhs.spring1.domain.user.User;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private final String name;
    private final String email;
    private final String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
