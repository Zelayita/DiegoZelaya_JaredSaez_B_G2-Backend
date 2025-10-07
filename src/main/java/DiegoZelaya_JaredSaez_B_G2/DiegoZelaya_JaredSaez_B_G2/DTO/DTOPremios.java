package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DTOPremios {

    private Long idPremio;
    private Long idPelicula;
    private String nombrePremio;
    private String categoria;
    private Long anoPremio;
    private String resultado;
    private Date fechaRegistro;
}
