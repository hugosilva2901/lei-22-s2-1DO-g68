package pt.ipp.isep.dei.esoft.project.domain.mapper;
import pt.ipp.isep.dei.esoft.project.domain.order;
import pt.ipp.isep.dei.esoft.project.domain.DTO.OrderDTO;

public class OrderMapper {


    public static order toEntity(OrderDTO dto) {
        return new order(
                AnnouncementMapper.toEntity(dto.getAnnouncement()),
                dto.getValue(),
                ClientMapper.toEntity(dto.getClient())
        );
    }

    public static OrderDTO toDTO(order entity) {
        return new OrderDTO(
                AnnouncementMapper.toDTO(entity.getAnnouncement()),
                entity.getValue(),
                ClientMapper.toDTO(entity.getClient()),
                entity.getStatusOfOrder()
        );
    }
}