package pt.ipp.isep.dei.esoft.project.domain.matcp;

import org.apache.commons.math4.legacy.stat.regression.MultipleLinearRegression;
import org.apache.commons.math4.legacy.stat.regression.SimpleRegression;
import pt.ipp.isep.dei.esoft.project.repository.OrderRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class MatcpAlgorithms {

    OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();


    private void PropertyArea() {
        SimpleRegression regression = new SimpleRegression();

        for (int i = 0; i < orderRepository.getOrders().size(); i++) {
            double propretyArea=orderRepository.getOrders().get(i).getAnnouncement().getProperty().getProperty_area();
            regression.addData(propretyArea,orderRepository.getOrders().get(i).getValue());
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

    private void DistanceFromCenter(){
        SimpleRegression regression = new SimpleRegression();

        for (int i = 0; i <orderRepository.getOrders().size() ; i++) {

            int DistanceFromCenter=orderRepository.getOrders().get(i).getAnnouncement().getProperty().getDistanceFromCenter();
            regression.addData(DistanceFromCenter,orderRepository.getOrders().get(i).getValue());
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

    private void MultipleRegression(){
        //MultipleLinearRegression regression = new MultipleLinearRegression();

    }

}
