package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Service;

import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.DTO.DTOPremios;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Entity.EntityPeliculas;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Entity.EntityPremios;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Exception.ExceptionDatosNoEncontrados;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Repository.RepositoryPelicula;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Repository.RepositoryPremios;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@CrossOrigin
public class ServicePremios {

    @Autowired
    private RepositoryPremios repo;

    @Autowired
    private RepositoryPelicula repoID;

    public List<DTOPremios> GetAllPremios() {
        List<EntityPremios> dto = repo.findAll();
        return dto.stream()
                .map(this::ConvertirADTOPremios)
                .collect(Collectors.toList());
    }

    public DTOPremios ConvertirADTOPremios(EntityPremios entity){
        DTOPremios json = new DTOPremios();
        json.setIdPremio(entity.getIdPremio());
        json.setIdPelicula(entity.getIdPelicula().getIdPelicula());
        json.setNombrePremio(entity.getNombrePremio());
        json.setCategoria(entity.getCategoria());
        json.setAnoPremio(entity.getAnoPremio());
        json.setResultado(entity.getResultado());
        json.setFechaRegistro(entity.getFechaRegistro());

        return json;
    }

    public DTOPremios InsertarDatos(@Valid DTOPremios json){
        if(json == null){
            throw new IllegalArgumentException("Vereificar los Datos, ya que no pueden ser nulos");
        }
        try{
            EntityPremios entity = ConvertirAEntityPremios(json);
            EntityPremios respuesta = repo.save(entity);

            return ConvertirADTOPremios(respuesta);
        }catch (Exception e){
            log.error("Error al registrar el usuario" + e.getMessage());
            throw  new ExceptionDatosNoEncontrados("Error al registrar usuario");
        }
    }

    private EntityPremios ConvertirAEntityPremios(@Valid DTOPremios json) {
        EntityPremios entity = new EntityPremios();

        entity.setIdPremio(json.getIdPremio());

        if (json.getIdPelicula() != null){
            EntityPeliculas peliculaid = repoID.findById(json.getIdPelicula()).orElseThrow(() -> new IllegalArgumentException("Id no Enocntrado" + json.getIdPelicula()));
            entity.setIdPelicula(peliculaid);
        }
        entity.setNombrePremio(json.getNombrePremio());
        entity.setCategoria(json.getCategoria());
        entity.setAnoPremio(json.getAnoPremio());
        entity.setResultado(json.getResultado());
        entity.setFechaRegistro(json.getFechaRegistro());

        return entity;
    }

    public DTOPremios Update(Long id, @Valid DTOPremios json){
        EntityPremios existe = repo.findById(id).orElseThrow(() -> new ExceptionDatosNoEncontrados("No encontrado"));
        existe.setIdPremio(json.getIdPremio());

        if (json.getIdPelicula() != null){
            EntityPeliculas peliculaid = repoID.findById(json.getIdPelicula()).orElseThrow(() -> new IllegalArgumentException("Id no Enocntrado"));
            existe.setIdPelicula(peliculaid);
        }
        existe.setNombrePremio(json.getNombrePremio());
        existe.setCategoria(json.getCategoria());
        existe.setAnoPremio(json.getAnoPremio());
        existe.setResultado(json.getResultado());
        existe.setFechaRegistro(json.getFechaRegistro());

        EntityPremios Update = repo.save(existe);
        return ConvertirADTOPremios(Update);
    }

    public boolean Delete(Long id){
        EntityPremios existencia = repo.findById(id).orElse(null);
        if (existencia != null){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
