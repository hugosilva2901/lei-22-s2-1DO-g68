package pt.ipp.isep.dei.esoft.project.domain.matcp;

import org.apache.commons.math4.legacy.stat.descriptive.DescriptiveStatistics;
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

    private void SimpleRegression(SimpleRegression regression) {

// Estimate the slope and intercept of the regression line
        double slope = regression.getSlope();
        double intercept = regression.getIntercept();
// Calculate the mean square regression (MSR)
        int n = (int) regression.getN();
        double sse = regression.getSumSquaredErrors();
        double sst = regression.getTotalSumSquares();
        double ssr = sst - sse;
        double msr = ssr;
        // Calculate the mean square error (MSE)
        double mse = sse / (n - 2);
// Get other statistics
        double r = regression.getR();
        double rSquare = regression.getRSquare();
        int k = 1;
        double adjustedRSquare = 1 - ((1 - rSquare) * (n - 1) / (n - k - 1));
        System.out.println("R: "+r);
        System.out.println("Slope: " + slope);
        System.out.println("Intercept: " + intercept);
        System.out.println("R-Square: " + rSquare);
        System.out.println("Adjusted R-Square: " + adjustedRSquare);
        System.out.println("Sum of Squares Total: " + sst);
        System.out.println("Sum of Squares Error: " + sse);
        System.out.println("Sum of Total: " + (sst+sse));
        System.out.println("Sum of Squares Regression: " + ssr);
        System.out.println("Mean Square Regression: " + msr);
        System.out.println("Mean Square Error: " + mse);

// Get a confidence interval for the slope
        double alpha = 0.95; // significance level
        double b1 = regression.getSlope(); // estimated slope
        double se = regression.getSlopeStdErr(); // standard error
        double criticalValue = 1.96; // for 95% confidence interval
        double marginOfError = se * criticalValue;
        double lowerBound = b1-marginOfError;
        double upperBound = b1+marginOfError;
        System.out.println("Confidence Interval: " + lowerBound + " - " + upperBound + " for " + alpha + "%");

        alpha = 0.90; // significance level
        criticalValue = 1.645; // for 90% confidence interval
        marginOfError = se * criticalValue;
        lowerBound =  b1-marginOfError;
        upperBound =  b1+marginOfError;
        System.out.println("Confidence Interval: " + lowerBound + " - " + upperBound + " for " + alpha + "%");

// Perform a hypothesis test for the slope
        double pValue = regression.getSignificance();
        double fStatistic =msr / mse;
        System.out.println("F-Statistic: " + fStatistic);
        System.out.println("p-value: " + pValue);

    }

    private void MultipleLinearRegression(OLSMultipleLinearRegression regression, int n, int p) {
        double rSquared = regression.calculateRSquared();
        double adjustedRSquared = regression.calculateAdjustedRSquared();
        double sse = regression.calculateResidualSumOfSquares();
        double sst = regression.calculateTotalSumOfSquares();
        double ssr = sst - sse;
        double mse = sse / (n - p - 1);
        double msr = ssr / p;
        System.out.println("Multiple Linear Regression");
        System.out.println("R-squared: " + rSquared);
        System.out.println("Adjusted R-squared: " + adjustedRSquared);
        System.out.println("degres of liberty of the model: " + (p ));
        System.out.println("degres of liberty of the residuals: " + (n - p));
        System.out.println("Sum of Squares Total: " + sst);
        System.out.println("Sum of Squares Error: " + sse);
        System.out.println("Sum of Total: " + (sst+sse));
        System.out.println("Sum of Squares Regression: " + ssr);
        System.out.println("Mean Square Regression: " + msr);
        System.out.println("Mean Square Error: " + mse);
        double criticalValue = 1.96; // for 95% confidence interval

        double[] beta = regression.estimateRegressionParameters();
        double[] standardErrors = regression.estimateRegressionParametersStandardErrors();
        for (int i = 0; i < beta.length; i++) {
            System.out.println("confidence levels of 95%");
            double lowerBound = beta[i] - criticalValue * standardErrors[i];
            double upperBound = beta[i] + criticalValue * standardErrors[i];
            System.out.println("Coefficient " + i + ": " + beta[i] + " +/- " + criticalValue * standardErrors[i] + " [" + lowerBound + ", " + upperBound + "]");
        }
        criticalValue = 1.645; // for 90% confidence interval
        beta = regression.estimateRegressionParameters();
        standardErrors = regression.estimateRegressionParametersStandardErrors();
        for (int i = 0; i < beta.length; i++) {
            System.out.println("confidence levels of 90%");
            double lowerBound = beta[i] - criticalValue * standardErrors[i];
            double upperBound = beta[i] + criticalValue * standardErrors[i];
            System.out.println("Coefficient " + i + ": " + beta[i] + " +/- " + criticalValue * standardErrors[i] + " [" + lowerBound + ", " + upperBound + "]");
        }

        // Perform a hypothesis test for the regression coefficients
        // Calculate the F-statistic
         // n number of observations
         // p number of independent variables

        double fStatistic = msr / mse;

        System.out.println("F-statistic: " + fStatistic);

        criticalValue=2.23215118;// Critical F-value for significance level of 5%
        if (fStatistic > criticalValue) {
            System.out.println("Reject the null hypothesis at a significance level of 5%");
        } else {
            System.out.println("Do not reject the null hypothesis at a significance level of 5%");
        }
        criticalValue=3.05419133;//  Critical F-value for significant levels of 1%
        if (fStatistic > criticalValue) {
            System.out.println("Reject the null hypothesis at a significance level of 1%");
        } else {
            System.out.println("Do not reject the null hypothesis at a significance level of   1%");
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
    public void mult(){
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        double[] y = new double[orderRepository.getOrders().size()];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            y[i] = orderRepository.getOrders().get(i).getValue();
        }
        double[][] x = new double[orderRepository.getOrders().size()][5];
        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            x[i][0] = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getProperty_area();

            x[i][1] = orderRepository.getOrders().get(i).getAnnouncement().getProperty().getDistanceFromCenter();
            House house = propertyRepository.getHouseByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
            if (house != null) {
                x[i][2] = house.getNumberOfRooms();
                x[i][3] = house.getNumberOfBathrooms();
                x[i][4] = house.getNumberOfGarages();
            } else {
                Apartment apartment = propertyRepository.getApartmentByAddress(orderRepository.getOrders().get(i).getAnnouncement().getProperty().getAddress());
                if (apartment != null) {
                    x[i][2] = apartment.getNumberOfRooms();
                    x[i][3] = apartment.getNumberOfBathrooms();
                    x[i][4] = apartment.getNumberOfGarages();
                }
            }
        }
        regression.newSampleData(y, x);
        MultipleLinearRegression(regression, y.length, x[0].length);
    }


}

