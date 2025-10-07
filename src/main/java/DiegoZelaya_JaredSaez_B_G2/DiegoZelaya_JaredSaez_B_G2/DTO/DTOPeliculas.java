package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DTOPeliculas {

    private Long idPelicula;
    private String Titulo;
    private String director;
    private String genero;
    private Long anoEstreno;
    private Long duracionMinutos;
    private Date fechaCreacion;
}
