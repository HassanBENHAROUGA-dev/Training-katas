package org.example.SupermarketCheckout;

import java.util.HashMap;
import java.util.Map;

public class SupermarketCheckout {
    Map<Character, Integer> itemsSelected = new HashMap<>();
    void scan(char item){
        itemsSelected.put(item, itemsSelected.getOrDefault(item, 0)+1);
    }
    int total(){
        int total = 0;
        for (Character key : itemsSelected.keySet()) {
            int itemQuantity = itemsSelected.get(key);
            if(key.equals('A') && itemQuantity>2){
                int discount = itemQuantity/3;
                int noDiscount = itemQuantity%3;
                total += discount * 130 + noDiscount * 50;
            }else if(key.equals('A') && itemQuantity<=2){
                total += itemQuantity * 50;
            }

            if(key.equals('B') && itemQuantity>1){
                int discount = itemQuantity/2;
                int noDiscount = itemQuantity%2;
                total += discount * 45 + noDiscount * 30;
            }else if(key.equals('B') && itemQuantity==1){
                total += itemQuantity * 30;
            }

            if(key.equals('C')){
                total += 20 * itemQuantity;
            }else if(key.equals('D')){
                total += 15 * itemQuantity;
            }
        }
        return total;
    }
}
/* VERSION PERFECTO
* for (Character item : itemsSelected.keySet()) {
            int quantity = itemsSelected.get(item);

            if (item == 'A') {
                total += (quantity / 3) * 130 + (quantity % 3) * 50;
            } else if (item == 'B') {
                total += (quantity / 2) * 45 + (quantity % 2) * 30;
            } else if (item == 'C') {
                total += quantity * 20;
            } else if (item == 'D') {
                total += quantity * 15;
            }
        }
* */