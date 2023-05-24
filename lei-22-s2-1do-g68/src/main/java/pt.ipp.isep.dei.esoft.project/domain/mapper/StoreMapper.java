package pt.ipp.isep.dei.esoft.project.domain.mapper;

import pt.ipp.isep.dei.esoft.project.domain.DTO.StoreDTO;
import pt.ipp.isep.dei.esoft.project.domain.Store;

import java.util.stream.Collectors;

public class StoreMapper {

    public static Store toEntity(StoreDTO dto) {
        Store store = new Store(
                dto.getName(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getVatNumber(),
                dto.getAddress(),
                dto.getBranchNumber()
        );
        if (dto.getEmployees() != null) {
            store.setEmployees(dto.getEmployees().stream()
                    .map(EmployeeProjectMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (dto.getLocalManager() != null) {
            store.setLocalManager(EmployeeProjectMapper.toEntity(dto.getLocalManager()));
        }
        return store;
    }

    public static StoreDTO toDTO(Store entity) {
        return new StoreDTO(
                entity.getName(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getVatNumber(),
                entity.getAddress(),
                entity.getBranchNumber(),
                entity.getEmployees().stream()
                        .map(EmployeeProjectMapper::toDTO)
                        .collect(Collectors.toList()),
                EmployeeProjectMapper.toDTO(entity.getLocalManager())
        );
    }
}