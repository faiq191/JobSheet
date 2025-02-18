public class Function {
    static final int PRICES[] = {75000, 50000, 60000, 10000};
    
    static final int STOCKS[][] = {
        {10, 5, 15, 7}, 
        {6, 11, 9, 12}, 
        {2, 10, 10, 5}, 
        {5, 7, 12, 9}
    };
    
    static final int STOCK_REDUCTION[] = {-1, -2, 0, -5};

    public static void calculateIncome() {
        for (int i = 0; i < STOCKS.length; i++) {
            int income = 0;
            for (int j = 0; j < STOCKS[i].length; j++) {
                income += STOCKS[i][j] * PRICES[j];
            }
            System.out.println("Income of RoyalGarden " + (i + 1) + ": " + income);
        }
    }
    
    public static void calculateRemainingStock() {
        int updatedStock[] = new int[STOCKS[3].length];
        for (int i = 0; i < STOCKS[3].length; i++) {
            updatedStock[i] = STOCKS[3][i] + STOCK_REDUCTION[i];
        }
        
        System.out.println("Updated stock in RoyalGarden 4:");
        System.out.println("Aglonema: " + updatedStock[0]);
        System.out.println("Keladi: " + updatedStock[1]);
        System.out.println("Alocasia: " + updatedStock[2]);
        System.out.println("Mawar: " + updatedStock[3]);
    }
    
    public static void main(String[] args) {
        calculateIncome();
        System.out.println();
        calculateRemainingStock();
    }
}
