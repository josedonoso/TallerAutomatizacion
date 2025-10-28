
Feature: Autenticación de Usuario

  Como usuario registrado,
  Quiero poder iniciar sesión,
  Para acceder a mis funcionalidades privadas.

  # Escenario 1: Inicio de sesión exitoso
  Scenario: Inicio de sesión exitoso con credenciales válidas
    Given el usuario "test@company.com" está registrado y activo
    When el usuario intenta iniciar sesión con correo "test@company.com" y contraseña "PassWordSeguro"
    Then el inicio de sesión debe ser exitoso
    And el usuario es redirigido al dashboard

  # Escenario 2: Scenario Outline
  Scenario Outline: Validar múltiples casos de credenciales inválidas
    Given el sistema de login está disponible
    When el usuario intenta iniciar sesión con correo "<correo>" y contraseña "<contraseña>"
    Then el inicio de sesión debe fallar
    And debe mostrar el mensaje de error "Credenciales inválidas. Por favor, intente de nuevo."

    Examples: Casos de Falla
      | correo | contraseña |
      | correo_no_existe@mail.com | PassWordSeguro |
      | test@company.com | 123 |
      | | PassWordSeguro | 