package pw.khskeb0513.busanhs.spring1.config.auth.dto;

import lombok.Builder;
import lombok.Getter;
import pw.khskeb0513.busanhs.spring1.domain.user.Role;
import pw.khskeb0513.busanhs.spring1.domain.user.User;

import java.util.Locale;
import java.util.Map;

@Getter
public class OAuthAttributes {

    private final Map<String, Object> attributes;
    private final String nameAttributeKey;
    private final String name;
    private final String email;
    private final String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(
            String registrationId, String userNameAttributeName, Map<String, Object> attributes
    ) {
        System.out.println("userNameAttributeName " + userNameAttributeName);
        System.out.println("registrationId " + registrationId);
        if ("kakao".equalsIgnoreCase(registrationId.toLowerCase(Locale.ROOT))) {
            return ofKakao("id", attributes);
        }
        if ("naver".equals(registrationId.toLowerCase(Locale.ROOT))) {
            return ofNaver("id", attributes);
        }
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .picture((String) response.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, String> profile = (Map<String, String>) kakao_account.get("profile");
        return OAuthAttributes.builder()
                .name((String) kakao_account.get("nickname"))
                .email((String) kakao_account.get("email"))
                .picture(profile.get("profile_image_url"))
                .attributes(kakao_account)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
