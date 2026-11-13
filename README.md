# pma26-auth

Interface do serviço **Auth**: `@FeignClient` + DTOs. É uma lib, não roda sozinha.
A implementação fica em [`pma26-auth-service`](https://github.com/Organizacao-dos-Coisa-Ruim/pma26-auth-service).

## Instalar no repositório Maven local

```bash
./mvnw clean install
```

## Endpoints

| Método | Rota | Corpo | Resposta |
|--------|------|-------|----------|
| `POST` | `/auth/register` | `RegisterIn {name, email, password}` | `201` · `400` campo faltando · `409` email já existe |
| `POST` | `/auth/login` | `CredentialIn {email, password}` | `200` + `TokenOut {jwt}` · `401` |
| `POST` | `/auth/solve` | `SolveIn {jwt}` | `200` + `SolveOut {idAccount, role}` · `401` token inválido/expirado |
| `GET` | `/auth/health-check` | – | `200` |

`/auth/register` e `/auth/login` são rotas abertas no gateway. O `/auth/solve` é chamado pelo
próprio gateway, pela rede interna, para validar o token das rotas protegidas.
