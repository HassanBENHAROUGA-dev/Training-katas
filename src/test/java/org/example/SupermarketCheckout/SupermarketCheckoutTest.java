package org.example.SupermarketCheckout;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupermarketCheckoutTest {
    @Test
    void ItShouldReturnEmptyCheckout(){
        SupermarketCheckout supermarketCheckout = new SupermarketCheckout();

        assertEquals(0, supermarketCheckout.total());
    }

    @Test
    void ItShouldReturnSum(){
        SupermarketCheckout supermarketCheckout = new SupermarketCheckout();
        List<Character> items = List.of('A','A');
        for(Character item : items){
            supermarketCheckout.scan(item);
        }
        assertEquals(100, supermarketCheckout.total());
    }

    @Test
    void ItShouldReturnSumWithDiscount130ForA(){
        SupermarketCheckout supermarketCheckout = new SupermarketCheckout();
        List<Character> items = List.of('A','A','A');
        for(Character item : items){
            supermarketCheckout.scan(item);
        }
        assertEquals(130, supermarketCheckout.total());
    }

    @Test
    void ItShouldReturnSumWithDiscount180ForA(){
        SupermarketCheckout supermarketCheckout = new SupermarketCheckout();
        List<Character> items = List.of('A','A','A','A');
        for(Character item : items){
            supermarketCheckout.scan(item);
        }
        assertEquals(180, supermarketCheckout.total());
    }

    @Test
    void ItShouldReturnSumWithDiscount30ForB(){
        SupermarketCheckout supermarketCheckout = new SupermarketCheckout();
        List<Character> items = List.of('B');
        for(Character item : items){
            supermarketCheckout.scan(item);
        }
        assertEquals(30, supermarketCheckout.total());
    }

    @Test
    void ItShouldReturnSumWithDiscount75ForB(){
        SupermarketCheckout supermarketCheckout = new SupermarketCheckout();
        List<Character> items = List.of('B', 'B', 'B');
        for(Character item : items){
            supermarketCheckout.scan(item);
        }
        assertEquals(75, supermarketCheckout.total());
    }

    @Test
    void ItShouldReturnSumWithDiscount60ForC(){
        SupermarketCheckout supermarketCheckout = new SupermarketCheckout();
        List<Character> items = List.of('C', 'C', 'C');
        for(Character item : items){
            supermarketCheckout.scan(item);
        }
        assertEquals(60, supermarketCheckout.total());
    }

    @Test
    void ItShouldReturnSumWithDiscount60ForD(){
        SupermarketCheckout supermarketCheckout = new SupermarketCheckout();
        List<Character> items = List.of('D', 'D', 'D', 'D');
        for(Character item : items){
            supermarketCheckout.scan(item);
        }
        assertEquals(60, supermarketCheckout.total());
    }

    @Test
    void ItShouldReturnSumWithDiscount60ForAll(){
        SupermarketCheckout supermarketCheckout = new SupermarketCheckout();
        List<Character> items = List.of('A','A','A','A','A','A','A','B','B','B','C','C','D','D');
        for(Character item : items){
            supermarketCheckout.scan(item);
        }
        assertEquals(455, supermarketCheckout.total());
    }
}
