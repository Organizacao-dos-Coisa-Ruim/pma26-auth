package pma.auth;

import lombok.Builder;

@Builder
public record RegisterIn(

    String name,
    String email,
    String password

) {

}
