package sn.courwebservice.demo_ws.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sn.courwebservice.demo_ws.dto.LivresDTO;
import sn.courwebservice.demo_ws.models.Livres;


@Mapper
public interface LivresMapper {
    LivresMapper INSTANCE = Mappers.getMapper(LivresMapper.class);

    // Méthode pour mapper une entité vers un DTO
    // ignoré les propriete disponible et reservation
    @Mapping(target = "disponible", ignore = true)
    @Mapping(target = "reservation", ignore = true)
    LivresDTO toDto(Livres livres);

    // Méthode pour mapper un DTO vers une entité
    @Mapping(target = "disponible", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Livres toEntity(LivresDTO livresDTO);
}
