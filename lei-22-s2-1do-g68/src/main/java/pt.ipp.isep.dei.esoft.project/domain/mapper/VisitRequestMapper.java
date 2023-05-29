package pt.ipp.isep.dei.esoft.project.domain.mapper;

import pt.ipp.isep.dei.esoft.project.domain.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;

public class VisitRequestMapper {
    public static VisitRequestDTO toDTO(VisitRequest visitRequest) {
        return new VisitRequestDTO(
                (AnnouncementMapper.toDTO(visitRequest.getAnnouncement())),
       (visitRequest.getDate()),
        (visitRequest.getMessage()),
                (ClientMapper.toDTO(visitRequest.getClient()))
       );
    }

    public static VisitRequest toDomain(VisitRequestDTO visitRequestDTO) {
        return new VisitRequest(
                AnnouncementMapper.toEntity(visitRequestDTO.getAnnouncement()),
                visitRequestDTO.getDate(),
                visitRequestDTO.getMessage(),
                ClientMapper.toEntity(visitRequestDTO.getClient())
        );
    }
}
