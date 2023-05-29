package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.DTO.EmployeeProjectDTO;
import pt.ipp.isep.dei.esoft.project.domain.DTO.VisitRequestDTO;
import pt.ipp.isep.dei.esoft.project.domain.EmployeeProject;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;
import pt.ipp.isep.dei.esoft.project.repository.VisitRepository;

import java.util.List;

public class ListVisitRequestController {

    Repositories repositories = Repositories.getInstance();

    VisitRepository visitRepository = null;
    StoreRepository storeRepository = null;

    AuthenticationRepository authenticationRepository = null;

    public ListVisitRequestController() {
        getVisitRepository();
        getStoreRepository();
        getAuthenticationRepository();
    }

    public VisitRepository getVisitRepository(){
        if (visitRepository == null) {
            Repositories repositories = Repositories.getInstance();
            visitRepository = repositories.getVisitRepository();
        }
        return visitRepository;
    }

    public StoreRepository getStoreRepository(){
        if (storeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            storeRepository = repositories.getStoreRepository();
        }
        return storeRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    private EmployeeProjectDTO getEmployeeProject(String email) {
        return this.storeRepository.getEmployeeByEmail(email);
    }
    public List<VisitRequestDTO> getAllVisitRequests() {
        EmployeeProjectDTO employeeProjectDTO = getEmployeeProject(authenticationRepository.getCurrentUserSession().getUserId().getEmail());
        return this.visitRepository.getVisitRequests(employeeProjectDTO);
    }

}
