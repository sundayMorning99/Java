import java.util.*;

class ETFData{
    String ticker;
    String assetClass;
    double expenseRatio;
    double allocationPercentage;

    //constructor
    public ETFData (String ticker, String assetClass, double expenseRatio){
        this.ticker=ticker;
        this.assetClass=assetClass;
        this.expenseRatio=expenseRatio;
    }

    public void setAllocation(double allocationPercentage){
        this.allocationPercentage = allocationPercentage;
    }

    public double calculateInvestment(double totalAmount){
        return totalAmount*allocationPercentage;
    }

}


public class InvestmentAllocator{

    static List<ETFData> getETFList(){
        List<ETFData> etfs = new ArrayList<>();
        etfs.add(new ETFData("IVV", "Large Cap",0.03));
        etfs.add(new ETFData("IJH", "Mid Cap",0.05));
        etfs.add(new ETFData("IJR", "Small Cap", 0.06));
        etfs.add(new ETFData("IEFA", "Internation", 0.07));
        etfs.add(new ETFData("IEMG", "Emerging", 0.09));
        etfs.add(new ETFData("AGG", "Bonds", 0.03));
        return etfs;
    }

    static void applyStyle(String style, List<ETFData> etfs){
        switch(style.toLowerCase()){
            case "aggressive":
                etfs.get(0).setAllocation(0.35);
                etfs.get(1).setAllocation(0.05);
                etfs.get(2).setAllocation(0.10);
                etfs.get(3).setAllocation(0.15);
                etfs.get(4).setAllocation(0.05);
                etfs.get(5).setAllocation(0.30);
                break;
            
            case "balanced":
                etfs.get(0).setAllocation(0.30);
                etfs.get(1).setAllocation(0.03);
                etfs.get(2).setAllocation(0.07);
                etfs.get(3).setAllocation(0.12);
                etfs.get(4).setAllocation(0.03);
                etfs.get(5).setAllocation(0.40);
                break;

            case "conservative":
                etfs.get(0).setAllocation(0.20);
                etfs.get(1).setAllocation(0.02);
                etfs.get(2).setAllocation(0.05);
                etfs.get(3).setAllocation(0.10);
                etfs.get(4).setAllocation(0.03);
                etfs.get(5).setAllocation(0.60);
                break;
            default:
                throw new IllegalArgumentException("Unknown investment style: " + style);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Total Investment Amount: ");
        double totalInvestment = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter Investment Style (aggeressive, balanced, conservative): ");
        String style = scanner.nextLine();

        List<ETFData> etfs = getETFList();
        applyStyle(style, etfs);

        System.out.println("\nInvestment Allocation");
        for (ETFData etf : etfs){
            double investmentAmount = etf.calculateInvestment(totalInvestment);
            System.out.printf("%s (%s): $%.2f (%,0f%%)%n", etf.ticker, etf.assetClass,investmentAmount, etf.allocationPercentage*100);
        }

        scanner.close();
    }
}