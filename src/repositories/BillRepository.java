package repositories;

import exceptions.BillNotFoundException;
import models.Bill;

import java.util.HashMap;

public class BillRepository {
    private final HashMap<Integer, Bill> billHashMap;
    public static BillRepository instance;
    private static int id = 0;

    private BillRepository() {
        this.billHashMap = new HashMap<>();
    }
    public static BillRepository getInstance(){
        if (instance == null){
            instance = new BillRepository();
        }
        return instance;
    }

    public void add(Bill bill){
        bill.setId(++id);
        billHashMap.put(bill.getId(),bill);
    }

    public Bill getBill(int billId){
        Bill bill = billHashMap.get(billId);

        if (bill == null){
            throw new BillNotFoundException("The bill with billId " + billId + " does not exist");
        }
        return bill;
    }
}
