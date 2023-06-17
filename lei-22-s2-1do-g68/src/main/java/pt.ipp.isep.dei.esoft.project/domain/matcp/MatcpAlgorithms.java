package pt.ipp.isep.dei.esoft.project.domain.matcp;

import org.apache.commons.math4.legacy.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math4.legacy.stat.regression.MultipleLinearRegression;
import org.apache.commons.math4.legacy.stat.regression.OLSMultipleLinearRegression;
import org.apache.commons.math4.legacy.stat.regression.SimpleRegression;
import org.apache.commons.statistics.distribution.FDistribution;
import org.apache.commons.statistics.distribution.TDistribution;
import pt.ipp.isep.dei.esoft.project.domain.Apartment;
import pt.ipp.isep.dei.esoft.project.domain.House;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class MatcpAlgorithms {

    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();

    PropertyRepository propertyRepository = Repositories.getInstance().getPropertyRepository();



    private void SimpleRegression(SimpleRegression regression) {

// Estimate the slope and intercept of the regression line
        double slope = regression.getSlope();
        double intercept = regression.getIntercept();

// Get other statistics
        double r = regression.getR();
        double rSquare = regression.getRSquare();
        int n = (int) regression.getN();
        int k = 1;
        double adjustedRSquare = 1 - ((1 - rSquare) * (n - 1) / (n - k - 1));
        System.out.println("Slope: " + slope);
        System.out.println("Intercept: " + intercept);
        System.out.println("R-Square: " + rSquare);
        System.out.println("Adjusted R-Square: " + adjustedRSquare);

// Get a confidence interval for the slope
        double alpha = 0.95; // significance level
        double lowerBound = regression.getSlopeConfidenceInterval(alpha);
        double upperBound = regression.getSlopeConfidenceInterval(alpha);
        System.out.println("Confidence Interval: " + lowerBound + " - " + upperBound);

// Perform a hypothesis test for the slope
        double pValue = regression.getSignificance();
        System.out.println("p-value: " + pValue);

    }

    private void MultipleLinearRegression(OLSMultipleLinearRegression regression,int n,int p) {
        double rSquared = regression.calculateRSquared();
        double adjustedRSquared = regression.calculateAdjustedRSquared();
        System.out.println("R-squared: " + rSquared);
        System.out.println("Adjusted R-squared: " + adjustedRSquared);

        // Get the regression coefficients, their standard errors, and t-statistics
/*
        double pointEstimate = stats.getMean();
        double standardDeviation = stats.getStandardDeviation();

 */
        double criticalValue = 1.96; // for 95% confidence interval
        /*
        long sampleSize = stats.getN();
        double standardError = standardDeviation / Math.sqrt(sampleSize);
        double marginOfError = criticalValue * standardError;
        double lowerBound = pointEstimate - marginOfError;
        double upperBound = pointEstimate + marginOfError;
        System.out.println("Confidence Interval: " + lowerBound + " - " + upperBound);

         */
        double[] beta = regression.estimateRegressionParameters();
        double[] standardErrors = regression.estimateRegressionParametersStandardErrors();
        for (int i = 0; i < beta.length; i++) {
            double lowerBound = beta[i] - criticalValue * standardErrors[i];
            double upperBound = beta[i] + criticalValue * standardErrors[i];
            System.out.println("Coefficient " + i + ": " + beta[i] + " +/- " + criticalValue * standardErrors[i] + " [" + lowerBound + ", " + upperBound + "]");
        }
        // Perform a hypothesis test for the regression coefficients

        double fStatistic = (rSquared / (p - 1)) / ((1 - rSquared) / (n - p));

        System.out.println("F-statistic: " + fStatistic);
/*
        FDistribution fDist = new FDistribution(p - 1, n - p);
        double pValue = 1 - fDist.cumulativeProbability(fStatistic);


 */
        
        if (fStatistic > criticalValue) {
            System.out.println("Reject the null hypothesis at a significance level of 0.95");
        } else {
            System.out.println("Do not reject the null hypothesis at a significance level of  0.95");
        }
    }

    public void PropertyArea() {
        PropertyArea2();
    }

    private void PropertyArea2() {
        SimpleRegression regression = new SimpleRegression();

        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            double propretyArea = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getProperty_area();
            regression.addData(propretyArea, orderRepository.getOrders().get(i).getValue());
        }
        SimpleRegression(regression);
    }

    public void DistanceFromCenter() {
        DistanceFromCenter2();
    }

    private void DistanceFromCenter2() {
        SimpleRegression regression = new SimpleRegression();

        DescriptiveStatistics stats = new DescriptiveStatistics();

        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            int DistanceFromCenter = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getDistanceFromCenter();
            regression.addData(DistanceFromCenter, orderRepository.getOrders().get(i).getValue());
            stats.addValue(DistanceFromCenter);
        }
        SimpleRegression(regression);
    }

    public void numberOfBedroomsP() {
        numberOfBedrooms();
    }

    private void numberOfBedrooms() {
        SimpleRegression regression = new SimpleRegression();
        int numberOfBedrooms = -1;
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                numberOfBedrooms = house.getNumberOfRooms();
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    numberOfBedrooms = apartment.getNumberOfRooms();
                }
            }
            if (numberOfBedrooms == -1) {
                System.out.println("Number of bathrooms not found");

            } else {
                regression.addData(numberOfBedrooms, orderRepository.getOrders().get(i).getValue());
            }
        }
        SimpleRegression(regression);

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
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    numberOfBathrooms = apartment.getNumberOfBathrooms();
                }
            }
            if (numberOfBathrooms == -1) {
                System.out.println("Number of bathrooms not found");

            } else {
                regression.addData(numberOfBathrooms, orderRepository.getOrders().get(i).getValue());
            }
        }
        SimpleRegression(regression);

    }

    public void numberOfGaragesP() {
        numberOfGarages();
    }

    private void numberOfGarages() {
        SimpleRegression regression = new SimpleRegression();
        int numberOfGarages = -1;
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                numberOfGarages = house.getNumberOfGarages();
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    numberOfGarages = apartment.getNumberOfGarages();
                }
            }
            if (numberOfGarages == -1) {
                System.out.println("Number of bathrooms not found");

            } else {
                regression.addData(numberOfGarages, orderRepository.getOrders().get(i).getValue());
            }
        }
        SimpleRegression(regression);

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
            x[i][0] = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getProperty_area();

            x[i][1] = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getDistanceFromCenter();

        }
        regression.newSampleData(y, x);
        MultipleLinearRegression(regression,y.length,x[0].length);
    }

    public void AreaAndNumberOfBedroomsP() {
        AreaAndNumberOfBedrooms();
    }

    private void AreaAndNumberOfBedrooms() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getProperty_area();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][1] = house.getNumberOfRooms();
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][1] = apartment.getNumberOfRooms();
                }
            }
        }
        regression.newSampleData(y, x);
        MultipleLinearRegression(regression,y.length,x[0].length);
    }

    public void AreaAndNumberOfBathroomsP() {
        AreaAndNumberOfBathrooms();
    }

    private void AreaAndNumberOfBathrooms() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getProperty_area();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][1] = house.getNumberOfBathrooms();
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][1] = apartment.getNumberOfBathrooms();
                }
            }
        }
        regression.newSampleData(y, x);
        MultipleLinearRegression(regression,y.length,x[0].length);
    }

    public void AreaAndNumberOfGaragesP() {
        AreaAndNumberOfGarages();
    }

    private void AreaAndNumberOfGarages() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getProperty_area();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][1] = house.getNumberOfGarages();
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][1] = apartment.getNumberOfGarages();
                }
            }
        }
        regression.newSampleData(y, x);
        MultipleLinearRegression(regression,y.length,x[0].length);
    }

    public void DistanceAndNumberOfRoomsP() {
        DistanceAndNumberOfRooms();
    }

    private void DistanceAndNumberOfRooms() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getDistanceFromCenter();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][1] = house.getNumberOfRooms();
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][1] = apartment.getNumberOfRooms();
                }
            }
        }
        regression.newSampleData(y, x);
        MultipleLinearRegression(regression,y.length,x[0].length);
    }

    public void DistanceAndNumberOfBathroomsP() {
        DistanceAndNumberOfBathrooms();
    }

    private void DistanceAndNumberOfBathrooms() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getDistanceFromCenter();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][1] = house.getNumberOfBathrooms();
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][1] = apartment.getNumberOfBathrooms();
                }
            }
        }
        regression.newSampleData(y, x);
        MultipleLinearRegression(regression,y.length,x[0].length);
    }

    public void DistanceAndNumberOfGaragesP() {
        DistanceAndNumberOfGarages();
    }

    private void DistanceAndNumberOfGarages() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getDistanceFromCenter();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][1] = house.getNumberOfGarages();
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][1] = apartment.getNumberOfGarages();
                }
            }
        }
        regression.newSampleData(y, x);
        MultipleLinearRegression(regression,y.length,x[0].length);
    }

    public void NumberOfRoomsAndNumberOfBathroomsP() {
        NumberOfRoomsAndNumberOfBathrooms();
    }

    private void NumberOfRoomsAndNumberOfBathrooms() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][0] = house.getNumberOfRooms();
                x[i][1] = house.getNumberOfBathrooms();
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][0] = apartment.getNumberOfRooms();
                    x[i][1] = apartment.getNumberOfBathrooms();
                }
            }
        }
        regression.newSampleData(y, x);
        MultipleLinearRegression(regression,y.length,x[0].length);
    }

    public void NumberOfRoomsAndNumberOfGaragesP() {
        NumberOfRoomsAndNumberOfGarages();
    }

    private void NumberOfRoomsAndNumberOfGarages() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][0] = house.getNumberOfRooms();
                x[i][1] = house.getNumberOfGarages();
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][0] = apartment.getNumberOfRooms();
                    x[i][1] = apartment.getNumberOfGarages();
                }
            }
        }
        regression.newSampleData(y, x);
        MultipleLinearRegression(regression,y.length,x[0].length);
    }

    public void NumberOfBathroomsAndNumberOfGaragesP() {
        NumberOfBathroomsAndNumberOfGarages();
    }

    private void NumberOfBathroomsAndNumberOfGarages() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][2];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][0] = house.getNumberOfBathrooms();
                x[i][1] = house.getNumberOfGarages();
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][0] = apartment.getNumberOfBathrooms();
                    x[i][1] = apartment.getNumberOfGarages();
                }
            }
        }
        regression.newSampleData(y, x);
        MultipleLinearRegression(regression,y.length,x[0].length);
    }
}

