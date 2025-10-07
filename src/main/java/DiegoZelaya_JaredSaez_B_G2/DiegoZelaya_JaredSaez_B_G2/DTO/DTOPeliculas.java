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
    @NotBlank
    private String Titulo;
    @NotBlank
    private String director;
    @NotBlank
    private String genero;
    @NotBlank
    private Long anoEstreno;
    @NotBlank
    private Long duracionMinutos;
    @NotBlank
    private Date fechaCreacion;
}
