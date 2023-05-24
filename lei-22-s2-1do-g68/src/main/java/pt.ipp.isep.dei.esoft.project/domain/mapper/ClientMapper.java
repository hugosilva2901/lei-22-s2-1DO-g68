package pt.ipp.isep.dei.esoft.project.domain.mapper;


import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.DTO.ClientDTO;

public class ClientMapper {

    public static Client toEntity(ClientDTO dto) {
        Client client = new Client(
                dto.getName(),
                dto.getDescptions(),
                dto.getTaxNumber(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getRoles()
        );
        return client;
    }

    public static ClientDTO toDTO(Client entity) {
        return new ClientDTO(
                entity.getName(),
                entity.getDescptions(),
                entity.getTaxNumber(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getRoles(),
                null
        );
    }
}