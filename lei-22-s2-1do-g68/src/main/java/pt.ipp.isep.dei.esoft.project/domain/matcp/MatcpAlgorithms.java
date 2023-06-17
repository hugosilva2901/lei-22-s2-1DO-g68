package pt.ipp.isep.dei.esoft.project.domain.matcp;

import org.apache.commons.math4.legacy.stat.regression.MultipleLinearRegression;
import org.apache.commons.math4.legacy.stat.regression.OLSMultipleLinearRegression;
import org.apache.commons.math4.legacy.stat.regression.SimpleRegression;
import pt.ipp.isep.dei.esoft.project.domain.Apartment;
import pt.ipp.isep.dei.esoft.project.domain.House;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class MatcpAlgorithms {

    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();

    PropertyRepository propertyRepository = Repositories.getInstance().getPropertyRepository();

    public void PropertyArea() {
        PropertyArea2();
    }

    private void PropertyArea2() {
        SimpleRegression regression = new SimpleRegression();

        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            double propretyArea = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getProperty_area();
            regression.addData(propretyArea, orderRepository.getOrders().get(i).getValue());
        }
        System.out.println("Slope: " + regression.getSlope());
        System.out.println("Intercept: " + regression.getIntercept());
        System.out.println("R-Square: " + regression.getRSquare());
        System.out.println("Slope Std Error: " + regression.getSlopeStdErr());
        System.out.println("Intercept Std Error: " + regression.getInterceptStdErr());
        System.out.println("Significance: " + regression.getSignificance());
        System.out.println("Slope Confidence Interval: " + regression.getSlopeConfidenceInterval());
        System.out.println("Predict(100): " + regression.predict(100));
    }

    public void DistanceFromCenter() {
        DistanceFromCenter2();
    }

    private void DistanceFromCenter2() {
        SimpleRegression regression = new SimpleRegression();

        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            int DistanceFromCenter = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getDistanceFromCenter();
            regression.addData(DistanceFromCenter, orderRepository.getOrders().get(i).getValue());
        }
        System.out.println("Slope: " + regression.getSlope());
        System.out.println("Intercept: " + regression.getIntercept());
        System.out.println("R-Square: " + regression.getRSquare());
        System.out.println("Slope Std Error: " + regression.getSlopeStdErr());
        System.out.println("Intercept Std Error: " + regression.getInterceptStdErr());
        System.out.println("Significance: " + regression.getSignificance());
        System.out.println("Slope Confidence Interval: " + regression.getSlopeConfidenceInterval());
        System.out.println("Predict(100): " + regression.predict(100));
    }

    public void numberOfBedroomsP() {
        numberOfBedrooms();
    }

    private void numberOfBedrooms() {
        SimpleRegression regression = new SimpleRegression();
        int numberOfBedrooms=-1;
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                numberOfBedrooms = house.getNumberOfRooms();
            }else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    numberOfBedrooms = apartment.getNumberOfRooms();
                }
            }
            if (numberOfBedrooms == -1) {
                System.out.println("Number of bathrooms not found");

            }else {
                regression.addData(numberOfBedrooms, orderRepository.getOrders().get(i).getValue());
            }
        }
        System.out.println("Slope: " + regression.getSlope());
        System.out.println("Intercept: " + regression.getIntercept());
        System.out.println("R-Square: " + regression.getRSquare());
        System.out.println("Slope Std Error: " + regression.getSlopeStdErr());
        System.out.println("Intercept Std Error: " + regression.getInterceptStdErr());
        System.out.println("Significance: " + regression.getSignificance());
        System.out.println("Slope Confidence Interval: " + regression.getSlopeConfidenceInterval());
        System.out.println("Predict(100): " + regression.predict(100));
    }

    public void numberOfBathroomsP() {
        numberOfBathrooms();
    }

    private void numberOfBathrooms() {
        SimpleRegression regression = new SimpleRegression();
        int numberOfBathrooms = -1;
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                numberOfBathrooms = house.getNumberOfBathrooms();
            }else {
            Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (apartment != null) {
                numberOfBathrooms = apartment.getNumberOfBathrooms();
            }
            }
            if (numberOfBathrooms == -1) {
                System.out.println("Number of bathrooms not found");

            }else {
                regression.addData(numberOfBathrooms, orderRepository.getOrders().get(i).getValue());
            }
        }
        System.out.println("Slope: " + regression.getSlope());
        System.out.println("Intercept: " + regression.getIntercept());
        System.out.println("R-Square: " + regression.getRSquare());
        System.out.println("Slope Std Error: " + regression.getSlopeStdErr());
        System.out.println("Intercept Std Error: " + regression.getInterceptStdErr());
        System.out.println("Significance: " + regression.getSignificance());
        System.out.println("Slope Confidence Interval: " + regression.getSlopeConfidenceInterval());
        System.out.println("Predict(100): " + regression.predict(100));
    }

    public void numberOfGaragesP() {
        numberOfGarages();
    }

    private void numberOfGarages() {
        SimpleRegression regression = new SimpleRegression();
        int numberOfGarages=-1;
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                numberOfGarages = house.getNumberOfGarages();
            }else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    numberOfGarages = apartment.getNumberOfGarages();
                }
            }
            if (numberOfGarages == -1) {
                System.out.println("Number of bathrooms not found");

            }else {
                regression.addData(numberOfGarages, orderRepository.getOrders().get(i).getValue());
            }
        }
        System.out.println("Slope: " + regression.getSlope());
        System.out.println("Intercept: " + regression.getIntercept());
        System.out.println("R-Square: " + regression.getRSquare());
        System.out.println("Slope Std Error: " + regression.getSlopeStdErr());
        System.out.println("Intercept Std Error: " + regression.getInterceptStdErr());
        System.out.println("Significance: " + regression.getSignificance());
        System.out.println("Slope Confidence Interval: " + regression.getSlopeConfidenceInterval());
        System.out.println("Predict(100): " + regression.predict(100));
    }

    private void MultipleRegression() {
        //MultipleLinearRegression regression = new MultipleLinearRegression();
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
                x[i][0] = 0;
                x[i][1] = 0;


        }
        regression.newSampleData();
    }

    ;

}

