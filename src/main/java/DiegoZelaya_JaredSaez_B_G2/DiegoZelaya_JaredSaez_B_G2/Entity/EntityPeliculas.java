package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ADMIN.PELICULAS")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EntityPeliculas {

    @Id
    @Column(name = "ID_PELICULA")
    private Long idPelicula;
    @Column(name = "TITULO")
    private String Titulo;
    @Column(name = "DIRECTOR")
    private String director;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "ANO_ESTRENO")
    private Long anoEstreno;
    @Column(name = "DURACION_MIN")
    private Long duracionMinutos;
    @Column(name = "FECHA_CREACION")
    private Date fechaCreacion;





    @OneToMany(mappedBy = "idPelicula", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EntityPremios> idpeliculas = new ArrayList<>();

}
