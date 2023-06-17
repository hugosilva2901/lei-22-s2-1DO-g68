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
    public void AreaAndDistance() {
        MultipleRegression();
    }


    private void MultipleRegression() {
        //MultipleLinearRegression regression = new MultipleLinearRegression();
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();

        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
                x[i][0] =  orderRepository.getOrders().get(i).getAnnouncement().getProperty().getProperty_area();;
                x[i][1] =  orderRepository.getOrders().get(i).getAnnouncement().getProperty().getDistanceFromCenter();;
        }
        regression.newSampleData(y, x);
        System.out.println("Slope: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Intercept: " + regression.estimateRegressionParameters()[1]);
        System.out.println("R-Square: " + regression.calculateRSquared());
        System.out.println("Slope Std Error: " + regression.estimateRegressionParametersStandardErrors()[0]);
        System.out.println("Intercept Std Error: " + regression.estimateRegressionParametersStandardErrors()[1]);
        System.out.println("Significance: " + regression.calculateResidualSumOfSquares());
        System.out.println("Slope Confidence Interval: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Predict(100): " + regression.estimateRegressionParameters()[0]*100+regression.estimateRegressionParameters()[1]*100);

    }
    public void AreaAndNumberOfBedroomsP() {
        AreaAndNumberOfBedrooms();
    }
    private void  AreaAndNumberOfBedrooms(){
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] =  orderRepository.getOrders().get(i).getAnnouncement().getProperty().getProperty_area();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][1]  = house.getNumberOfRooms();
            }else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][1]  = apartment.getNumberOfRooms();
                }
            }
        }
        regression.newSampleData(y, x);
        System.out.println("Slope: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Intercept: " + regression.estimateRegressionParameters()[1]);
        System.out.println("R-Square: " + regression.calculateRSquared());
        System.out.println("Slope Std Error: " + regression.estimateRegressionParametersStandardErrors()[0]);
        System.out.println("Intercept Std Error: " + regression.estimateRegressionParametersStandardErrors()[1]);
        System.out.println("Significance: " + regression.calculateResidualSumOfSquares());
        System.out.println("Slope Confidence Interval: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Predict(100): " + regression.estimateRegressionParameters()[0]*100+regression.estimateRegressionParameters()[1]*100);

    }
    public void AreaAndNumberOfBathroomsP() {
        AreaAndNumberOfBathrooms();
    }
    private void  AreaAndNumberOfBathrooms(){
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] =  orderRepository.getOrders().get(i).getAnnouncement().getProperty().getProperty_area();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][1]  = house.getNumberOfBathrooms();
            }else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][1]  = apartment.getNumberOfBathrooms();
                }
            }
        }
        regression.newSampleData(y, x);
        System.out.println("Slope: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Intercept: " + regression.estimateRegressionParameters()[1]);
        System.out.println("R-Square: " + regression.calculateRSquared());
        System.out.println("Slope Std Error: " + regression.estimateRegressionParametersStandardErrors()[0]);
        System.out.println("Intercept Std Error: " + regression.estimateRegressionParametersStandardErrors()[1]);
        System.out.println("Significance: " + regression.calculateResidualSumOfSquares());
        System.out.println("Slope Confidence Interval: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Predict(100): " + regression.estimateRegressionParameters()[0]*100+regression.estimateRegressionParameters()[1]*100);

    }
    public void AreaAndNumberOfGaragesP() {
        AreaAndNumberOfGarages();
    }

    private void AreaAndNumberOfGarages(){
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] =  orderRepository.getOrders().get(i).getAnnouncement().getProperty().getProperty_area();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][1]  = house.getNumberOfGarages();
            }else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][1]  = apartment.getNumberOfGarages();
                }
            }
        }
        regression.newSampleData(y, x);
        System.out.println("Slope: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Intercept: " + regression.estimateRegressionParameters()[1]);
        System.out.println("R-Square: " + regression.calculateRSquared());
        System.out.println("Slope Std Error: " + regression.estimateRegressionParametersStandardErrors()[0]);
        System.out.println("Intercept Std Error: " + regression.estimateRegressionParametersStandardErrors()[1]);
        System.out.println("Significance: " + regression.calculateResidualSumOfSquares());
        System.out.println("Slope Confidence Interval: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Predict(100): " + regression.estimateRegressionParameters()[0]*100+regression.estimateRegressionParameters()[1]*100);

    }
    public void DistanceAndNumberOfRoomsP() {
        DistanceAndNumberOfRooms();
    }

    private void DistanceAndNumberOfRooms(){
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] =  orderRepository.getOrders().get(i).getAnnouncement().getProperty().getDistanceFromCenter();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][1]  = house.getNumberOfRooms();
            }else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][1]  = apartment.getNumberOfRooms();
                }
            }
        }
        regression.newSampleData(y, x);
        System.out.println("Slope: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Intercept: " + regression.estimateRegressionParameters()[1]);
        System.out.println("R-Square: " + regression.calculateRSquared());
        System.out.println("Slope Std Error: " + regression.estimateRegressionParametersStandardErrors()[0]);
        System.out.println("Intercept Std Error: " + regression.estimateRegressionParametersStandardErrors()[1]);
        System.out.println("Significance: " + regression.calculateResidualSumOfSquares());
        System.out.println("Slope Confidence Interval: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Predict(100): " + regression.estimateRegressionParameters()[0]*100+regression.estimateRegressionParameters()[1]*100);

    }
    public void DistanceAndNumberOfBathroomsP() {
        DistanceAndNumberOfBathrooms();
    }

    private void DistanceAndNumberOfBathrooms(){
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] =  orderRepository.getOrders().get(i).getAnnouncement().getProperty().getDistanceFromCenter();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][1]  = house.getNumberOfBathrooms();
            }else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][1]  = apartment.getNumberOfBathrooms();
                }
            }
        }
        regression.newSampleData(y, x);
        System.out.println("Slope: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Intercept: " + regression.estimateRegressionParameters()[1]);
        System.out.println("R-Square: " + regression.calculateRSquared());
        System.out.println("Slope Std Error: " + regression.estimateRegressionParametersStandardErrors()[0]);
        System.out.println("Intercept Std Error: " + regression.estimateRegressionParametersStandardErrors()[1]);
        System.out.println("Significance: " + regression.calculateResidualSumOfSquares());
        System.out.println("Slope Confidence Interval: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Predict(100): " + regression.estimateRegressionParameters()[0]*100+regression.estimateRegressionParameters()[1]*100);

    }

    public void DistanceAndNumberOfGaragesP() {
        DistanceAndNumberOfGarages();
    }

    private void DistanceAndNumberOfGarages(){
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] =  orderRepository.getOrders().get(i).getAnnouncement().getProperty().getDistanceFromCenter();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][1]  = house.getNumberOfGarages();
            }else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][1]  = apartment.getNumberOfGarages();
                }
            }
        }
        regression.newSampleData(y, x);
        System.out.println("Slope: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Intercept: " + regression.estimateRegressionParameters()[1]);
        System.out.println("R-Square: " + regression.calculateRSquared());
        System.out.println("Slope Std Error: " + regression.estimateRegressionParametersStandardErrors()[0]);
        System.out.println("Intercept Std Error: " + regression.estimateRegressionParametersStandardErrors()[1]);
        System.out.println("Significance: " + regression.calculateResidualSumOfSquares());
        System.out.println("Slope Confidence Interval: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Predict(100): " + regression.estimateRegressionParameters()[0]*100+regression.estimateRegressionParameters()[1]*100);

    }

    public void NumberOfRoomsAndNumberOfBathroomsP() {
        NumberOfRoomsAndNumberOfBathrooms();
    }

    private void NumberOfRoomsAndNumberOfBathrooms(){
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][0]  = house.getNumberOfRooms();
                x[i][1]  = house.getNumberOfBathrooms();
            }else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][0]  = apartment.getNumberOfRooms();
                    x[i][1]  = apartment.getNumberOfBathrooms();
                }
            }
        }
        regression.newSampleData(y, x);
        System.out.println("Slope: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Intercept: " + regression.estimateRegressionParameters()[1]);
        System.out.println("R-Square: " + regression.calculateRSquared());
        System.out.println("Slope Std Error: " + regression.estimateRegressionParametersStandardErrors()[0]);
        System.out.println("Intercept Std Error: " + regression.estimateRegressionParametersStandardErrors()[1]);
        System.out.println("Significance: " + regression.calculateResidualSumOfSquares());
        System.out.println("Slope Confidence Interval: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Predict(100): " + regression.estimateRegressionParameters()[0]*100+regression.estimateRegressionParameters()[1]*100);

    }

    public void NumberOfRoomsAndNumberOfGaragesP() {
        NumberOfRoomsAndNumberOfGarages();
    }

    private void NumberOfRoomsAndNumberOfGarages(){
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][0]  = house.getNumberOfRooms();
                x[i][1]  = house.getNumberOfGarages();
            }else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][0]  = apartment.getNumberOfRooms();
                    x[i][1]  = apartment.getNumberOfGarages();
                }
            }
        }
        regression.newSampleData(y, x);
        System.out.println("Slope: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Intercept: " + regression.estimateRegressionParameters()[1]);
        System.out.println("R-Square: " + regression.calculateRSquared());
        System.out.println("Slope Std Error: " + regression.estimateRegressionParametersStandardErrors()[0]);
        System.out.println("Intercept Std Error: " + regression.estimateRegressionParametersStandardErrors()[1]);
        System.out.println("Significance: " + regression.calculateResidualSumOfSquares());
        System.out.println("Slope Confidence Interval: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Predict(100): " + regression.estimateRegressionParameters()[0]*100+regression.estimateRegressionParameters()[1]*100);

    }

    public void NumberOfBathroomsAndNumberOfGaragesP() {
        NumberOfBathroomsAndNumberOfGarages();
    }

    private void NumberOfBathroomsAndNumberOfGarages(){
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][0]  = house.getNumberOfBathrooms();
                x[i][1]  = house.getNumberOfGarages();
            }else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][0]  = apartment.getNumberOfBathrooms();
                    x[i][1]  = apartment.getNumberOfGarages();
                }
            }
        }
        regression.newSampleData(y, x);
        System.out.println("Slope: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Intercept: " + regression.estimateRegressionParameters()[1]);
        System.out.println("R-Square: " + regression.calculateRSquared());
        System.out.println("Slope Std Error: " + regression.estimateRegressionParametersStandardErrors()[0]);
        System.out.println("Intercept Std Error: " + regression.estimateRegressionParametersStandardErrors()[1]);
        System.out.println("Significance: " + regression.calculateResidualSumOfSquares());
        System.out.println("Slope Confidence Interval: " + regression.estimateRegressionParameters()[0]);
        System.out.println("Predict(100): " + regression.estimateRegressionParameters()[0]*100+regression.estimateRegressionParameters()[1]*100);

    }


}

