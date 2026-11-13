package pma.auth;

import lombok.Builder;

@Builder
public record CredentialIn(

    String email,
    String password

) {

}
