package services.Strategy.BillGenerationStrategy;

public class BillGenerationStrategyFactory {

    public static BillGenerationStrategy getBillGenerationStrategy(BillGenerationStrategyType strategyType){
        return switch (strategyType){

            case SIMPLE -> new SimpleBillGenerationStrategy();
            case SURGE -> null;
        };
    }
}
