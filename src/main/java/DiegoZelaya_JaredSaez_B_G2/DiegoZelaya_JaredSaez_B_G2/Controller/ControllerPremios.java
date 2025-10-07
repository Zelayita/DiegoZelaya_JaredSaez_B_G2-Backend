package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Controller;

import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.DTO.DTOPeliculas;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.DTO.DTOPremios;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Exception.ExceptionCamposDuplicados;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Exception.ExceptionDatosNoEncontrados;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Service.ServicePremios;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ControllerPremios {
    @Autowired
    private ServicePremios service;

    @GetMapping("/getall")
    public List<DTOPremios> getPremios(){return service.GetAllPremios();}


    @PostMapping("/registrar")
    public ResponseEntity<?> nuevoPremio(
            @Valid @RequestBody DTOPremios json, HttpServletRequest httpServletRequest
    ){
        try{
            DTOPremios respuesta = service.InsertarDatos(json);
            if(respuesta == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "Status", "Insercion Fallida",
                        "Error", "VALIDATION_ERROR",
                        "message", "Los datos no pueden ser Registrados"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "Status", "Succes",
                    "data", respuesta
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "Status", "Error",
                    "message", "Error encontrado al registrar Usuario",
                    "detail", e.getMessage()
            ));
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> Update(
            @PathVariable Long id,
            @Valid @RequestBody DTOPremios json, BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            Map<String, String> errores = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage()
            ));
            return ResponseEntity.badRequest().body(errores);
        }
        try{
            DTOPremios dto = service.Update(id,json);
            return ResponseEntity.ok(json);
        }catch (ExceptionDatosNoEncontrados e){
            return ResponseEntity.notFound().build();
        }catch (ExceptionCamposDuplicados e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                "Error", "Campos Duplicados",
                    "campo", e.getMessage()));
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Map<String, String>> Eliminar(@PathVariable Long id){
        try{
            if (!service.Delete(id)){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .header("x-Mensaje-error", "Premio no Enocntrado")
                        .body(Map.of(
                                "Error", "No Encontrado",
                                "Mensaje", "No se Encontro",
                                "TimeStamp", Instant.now().toString()));
            }
            return ResponseEntity.ok().body(Map.of(
                    "Status", "Proceso completado",
                    "Message", "Premio Eliminado"
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "Status", "Error",
                    "Message", "Error al Eliminar",
                    "detail", e.getMessage()));
        }
    }



}
