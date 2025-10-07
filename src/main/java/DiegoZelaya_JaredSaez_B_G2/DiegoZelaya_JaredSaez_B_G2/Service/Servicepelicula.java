package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Service;

import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.DTO.DTOPeliculas;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Entity.EntityPeliculas;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Repository.RepositoryPelicula;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@CrossOrigin
public class Servicepelicula {

    @Autowired
    private RepositoryPelicula repo;

    public List<DTOPeliculas> Listar(){
        return repo.findAll()
                .stream()
                .map(this::ToDTO)
                .collect(Collectors.toList());
    }

    public DTOPeliculas ToDTO(EntityPeliculas entityPeliculas) {
        DTOPeliculas json = new DTOPeliculas();

        json.setIdPelicula(entityPeliculas.getIdPelicula());
        json.setTitulo(entityPeliculas.getTitulo());
        json.setDirector(entityPeliculas.getDirector());
        json.setGenero(entityPeliculas.getGenero());
        json.setAnoEstreno(entityPeliculas.getAnoEstreno());
        json.setDuracionMinutos(entityPeliculas.getDuracionMinutos());
        json.setFechaCreacion(entityPeliculas.getFechaCreacion());

        return json;
    }
}
