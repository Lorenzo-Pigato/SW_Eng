package exams.extra;

import java.util.ArrayList;
import java.util.List;
import exams.e2022_06_24.exercise_3.FormattedText;

public class Wallet implements Runnable {
    private List<Stock> stocks = new ArrayList<>();

    public Wallet(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public synchronized void update(Stock stock, Double value) {
        if (stocks.contains(stock)) {
            stocks.remove(stock);
            stock.setValue(value);
            stocks.add(stock);
        }
        this.notifyAll();
    }

    public synchronized double getAverageROI() {
        Double avgROI = stocks.stream().mapToDouble(s -> s.getRoi()).average().orElse(0.0);
        return avgROI;
    }

    @Override
    public void run() {
        while (true) {
            Double roi;
            synchronized (this) {
                while ((roi = getAverageROI()) <= 0) {
                    try {this.wait();} 
                    catch (Exception e) {}
                }
                    
                System.out.println(FormattedText.apply("Positive ROI: " + roi, "green"));

                try {this.wait();} 
                catch (Exception e) {}
            }
        }
    }

    public static void main(String[] args) {
        List<Stock> myStocks = new ArrayList<>();
        Wallet myWallet = new Wallet(myStocks);

        Stock tesla = new Stock("TSLA", 150.0, myWallet);
        Stock meta = new Stock("META", 400.0, myWallet);
        Stock solarcity = new Stock("SCTY", 100.0, myWallet);

        myStocks.add(meta);
        myStocks.add(tesla);
        myStocks.add(solarcity);

        new Thread(myWallet).start();
        new Thread(meta).start();
        new Thread(tesla).start();
        new Thread(solarcity).start();

    }

}

class Stock implements Runnable {
    private String name;
    private Double value;
    private Double roi = 0.0;
    private Wallet wallet;

    public Stock(String name, Double value, Wallet wallet) {
        this.name = name;
        this.value = value;
        this.wallet = wallet;
    }

    public void setValue(Double newValue) {
        roi = newValue - value;
        System.out.println(name + ": new price: " + newValue + " ROI: " + roi);
        value = newValue;
    }

    public String getName() {
        return name;
    }

    public Double getRoi() {
        return roi;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public void run() {
        while (true) {
            wallet.update(this, Math.random() * 1000);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (Exception e) {
            }
        }
    }

}
