package pt.ipp.isep.dei.esoft.project.domain.mapper;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;

public class AnnouncementMapper {

    public static Announcement toEntity(AnnouncementDTO dto) {
        return new Announcement(
                dto.getProperty(),
                dto.getValueOfProperty(),
                EmployeeProjectMapper.toEntity(dto.getEmployeeProject())
        );
    }

    public static AnnouncementDTO toDTO(Announcement entity) {
        return new AnnouncementDTO(
                entity.getProperty(),
                entity.getValueOfProperty(),
                EmployeeProjectMapper.toDTO(entity.getEmployeeProject()),
                entity.getAnnouncementState()
        );
    }
}
