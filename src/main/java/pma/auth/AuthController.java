package pma.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Contrato do serviço Auth.
 *
 * - O auth-service implementa esta interface (AuthResource).
 * - Outros serviços podem usá-la como cliente Feign.
 */
@FeignClient(name = "auth", url = "${pma.auth.url:http://auth:8080}")
public interface AuthController {

  /** Cria a conta no Account. 201; 400 se faltar campo; 409 se o email já existe. */
  @PostMapping("/auth/register")
  public ResponseEntity<Void> register(
      @RequestBody RegisterIn in);

  /** Confere email e senha no Account. 200 com o JWT; 401 se as credenciais não conferem. */
  @PostMapping("/auth/login")
  public ResponseEntity<TokenOut> login(
      @RequestBody CredentialIn in);

  /**
   * Usado pelo gateway: valida assinatura e expiração do JWT.
   * 200 com idAccount e role; 401 se o token é inválido ou expirou.
   */
  @PostMapping("/auth/solve")
  public ResponseEntity<SolveOut> solve(
      @RequestBody SolveIn in);

  @GetMapping("/auth/health-check")
  public ResponseEntity<Void> healthCheck();

}
