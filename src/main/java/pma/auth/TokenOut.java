package pma.auth;

import lombok.Builder;

@Builder
public record TokenOut(

    String jwt

) {

}
