package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Service;

import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.DTO.DTOPremios;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Entity.EntityPremios;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Repository.RepositoryPremios;
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

    public List<DTOPremios> GetAllPremios() {
        List<EntityPremios> dto = repo.findAll();
        return dto.stream()
                .map(this::ConvertirADTOPremios)
                .collect(Collectors.toList());
    }

    public DTOPremios ConvertirADTOPremios(EntityPremios entity){
        DTOPremios json = new DTOPremios();
        json.setIdPremio(entity.getIdPremio());
        json.setIdPelicula(entity.getIdPelicula());
        json.setNombrePremio(entity.getNombrePremio());
        json.setCategoria(entity.getCategoria());
        json.setAnoPremio(entity.getAnoPremio());
        json.setResultado(entity.getResultado());
        json.setFechaRegistro(entity.getFechaRegistro());

        return json;
    }
}
