public class InsuranceCalculator {

    private  InsuranceStrategyVeryHigh strategy;


    public double calculateInsurance(double income) {
        if (income <= 10000) {
            return income*0.365;
        } else if (income <= 30000) {
            return (income-10000)*0.2+35600;
        } else if (income <= 60000) {
            return (income-30000)*0.1+76500;
        } else {
            strategy = new InsuranceStrategyVeryHigh();
            return strategy.calculateInsuranceVeryHigh(income);
        }
    }



    public class InsuranceStrategyVeryHigh extends InsuranceStrategy {
        public InsuranceStrategyVeryHigh() {
        }

        @Override
        public int getConstant() {
            return 105600;
        }

        @Override
        public double getWeight() {
            return 0.02;
        }

        @Override
        public int getAdjustment() {
            return 60000;
        }
    }
}
