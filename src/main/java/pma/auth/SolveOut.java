package pma.auth;

import lombok.Builder;

@Builder
public record SolveOut(

    String idAccount,
    String role

) {

}
