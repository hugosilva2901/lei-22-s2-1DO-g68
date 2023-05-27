package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.AnnouncementState;
import pt.ipp.isep.dei.esoft.project.domain.DTO.AnnouncementDTO;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;
import java.util.Scanner;

public class ListAnnouncementRequestUI implements Runnable {
    private CreateAnnouncementController createAnnouncementController = new CreateAnnouncementController();
    private AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();

    private List<AnnouncementDTO> pendingAnnouncements;

    @Override
    public void run() {
        String employeeProject = authenticationRepository.getCurrentUserSession().getUserId().getEmail();
        pendingAnnouncements = createAnnouncementController.getPendingAnnouncementsByDate(employeeProject);

        displayAnnouncements(pendingAnnouncements);

        int selectedAnnouncementIndex = getSelectedAnnouncementIndex(pendingAnnouncements);

        AnnouncementDTO selectedAnnouncement = pendingAnnouncements.get(selectedAnnouncementIndex);
        processSelectedAnnouncement(selectedAnnouncement);

        pendingAnnouncements.remove(selectedAnnouncement);

        displayAnnouncements(pendingAnnouncements);
    }

    private void displayAnnouncements(List<AnnouncementDTO> announcements) {
        System.out.println("Pending Announcements:");
        System.out.println();

        int announcementId = 1;
        for (AnnouncementDTO announcement : announcements) {
            System.out.println("Announcement ID: " + announcementId);
            System.out.println("Property: " + announcement.getProperty().getName());
            System.out.println("Value of Property: " + announcement.getValueOfProperty());
            System.out.println("Employee Project: " + announcement.getEmployeeProject().getName());
            System.out.println("Announcement State: " + announcement.getAnnouncementState());
            System.out.println("Creation Date: " + announcement.getCreationDate());
            System.out.println("-------------------------");
            announcementId++;
        }

    }

    private int getSelectedAnnouncementIndex(List<AnnouncementDTO> announcements) {
        int listSize = announcements.size();
        int selectedAnnouncementIndex = -1;

        Scanner scanner = new Scanner(System.in);

        while (selectedAnnouncementIndex < 1 || selectedAnnouncementIndex > listSize) {
            System.out.print("Selecione o ID do anúncio desejado: ");
            selectedAnnouncementIndex = scanner.nextInt();
        }

        return selectedAnnouncementIndex - 1;
    }

    private void processSelectedAnnouncement(AnnouncementDTO selectedAnnouncement) {
        System.out.println();
        System.out.println("=================================");
        System.out.println("Menu de Opções:");
        System.out.println("1 - Aceitar");
        System.out.println("2 - Rejeitar");
        System.out.println("=================================");

        System.out.print("Selecione o que pretende fazer com este anúncio: ");

        Scanner scanner = new Scanner(System.in);
        int selectedOption = scanner.nextInt();

        switch (selectedOption) {
            case 1:
                createAnnouncementController.changeAnnouncementState(selectedAnnouncement, AnnouncementState.ACCEPTED);
                System.out.println("Anúncio aceito com sucesso!");
                break;
            case 2:
                createAnnouncementController.changeAnnouncementState(selectedAnnouncement, AnnouncementState.REJECTED);
                System.out.println("Anúncio rejeitado com sucesso!");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}
