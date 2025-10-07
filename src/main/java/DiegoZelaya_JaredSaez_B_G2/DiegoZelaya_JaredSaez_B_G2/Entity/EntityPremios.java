package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Date;



@Entity
@Table(name = "PREMIOS")
@Getter @Setter
@ToString @EqualsAndHashCode
public class EntityPremios {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " SEQ_PREMIOS")
    @SequenceGenerator(sequenceName = " SEQ_PREMIOS", name = " SEQ_PREMIOS", allocationSize = 1)
    @Column(name = "ID_PREMIO")
    private Long idPremio;

    @Column(name = "NOMBRE_PREMIO")
    private String nombrePremio;

    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "ANO_PREMIO")
    private Long anoPremio;

    @Column(name = "RESULTADO")
    private String resultado;

    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PELICULA", referencedColumnName = "ID_PELICULA")
    private EntityPeliculas idPelicula;

}
