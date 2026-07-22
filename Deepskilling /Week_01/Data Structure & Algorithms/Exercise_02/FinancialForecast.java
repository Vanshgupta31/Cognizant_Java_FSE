public class FinancialForecast {

    static double forecast(double currentValue, double growthRate, int years) {

        if (years == 0)
            return currentValue;

        return forecast(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {

        double presentValue = 10000;
        double annualGrowth = 0.10;
        int years = 5;

        double predictedValue = forecast(presentValue, annualGrowth, years);

        System.out.printf("Present Value : %.2f%n", presentValue);
        System.out.printf("Growth Rate   : %.0f%%%n", annualGrowth * 100);
        System.out.println("Years         : " + years);
        System.out.printf("Future Value  : %.2f%n", predictedValue);
    }
}
