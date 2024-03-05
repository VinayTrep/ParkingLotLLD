package services.Strategy.SpotAllocationStrategy;

public class SpotAllocationStrategyFactory {
    public static SpotAllocationStrategy getSpotAllocationStrategy(SpotAllocationStrategyType strategyType) {

        return switch (strategyType){
            case LINEAR -> new LinearSpotAllocationStrategy();
            case RANDOM -> null;
        };
    }

}
