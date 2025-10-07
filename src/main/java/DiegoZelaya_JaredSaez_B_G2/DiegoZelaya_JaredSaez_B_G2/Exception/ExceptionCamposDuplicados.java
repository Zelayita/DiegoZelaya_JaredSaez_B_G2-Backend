package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Exception;

import lombok.Getter;

public class ExceptionCamposDuplicados extends RuntimeException {

  public ExceptionCamposDuplicados(String message,ExceptionCamposDuplicados campos) {
    super(message);
    this.campos = campos;
  }

  @Getter
  private ExceptionCamposDuplicados campos;


    public ExceptionCamposDuplicados(String message) {
        super(message);
    }
}
