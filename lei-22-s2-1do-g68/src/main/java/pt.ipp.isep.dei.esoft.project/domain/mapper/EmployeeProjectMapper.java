package pt.ipp.isep.dei.esoft.project.domain.mapper;

import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.domain.Roles;

public class EmployeeProjectMapper {


    public static EmployeeProject toEntity(EmployeeProjectDTO dto) {
        return new EmployeeProject(
                dto.getName(),
                dto.getDescptions(),
                dto.getTaxNumber(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getRoles(),
                dto.getSalary(),
                StoreMapper.toEntity(dto.getStore())
        );
    }

    public static EmployeeProjectDTO toDTO(EmployeeProject entity) {
        return new EmployeeProjectDTO(
                entity.getName(),
                entity.getDescptions(),
                entity.getTaxNumber(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getAddress(),
                entity.getPhone(),
                new Roles[]{entity.getRoles()},
                entity.getSalary(),
                StoreMapper.toDTO(entity.getStore())
        );
    }
}
