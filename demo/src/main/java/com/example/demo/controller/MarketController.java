package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.model.Character;
import com.example.demo.model.Item;
import com.example.demo.model.Market;

import javax.inject.Named;

import static org.bitbucket.dollar.Dollar.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Named
public class MarketController {
    private Random random = new Random();

    public int getRandomIndex() {
        return random.nextInt(ItemController.getItems().size());
    }


    public static void randomizeMarketItems(Character character){
        Market market = new Market();
        List<Integer> numbers =  $(4, ItemController.getItems().size()).toList();
        Collections.shuffle(numbers);
        market.setMarketSlot1(numbers.get(0));
        market.setMarketSlot2(numbers.get(1));
        market.setMarketSlot3(numbers.get(2));
        market.setMarketSlot4(numbers.get(3));
        market.setMarketSlot5(numbers.get(4));
        market.setMarketSlot6(numbers.get(5));

        character.setMarket(market);

    }



    public void buyItem(Character character, Item item, String marketSlot) {
        String firstFreeSpace = ItemController.findFirstFreeSpaceInInventory(character);
        if (!firstFreeSpace.equals("none") && character.getCash() > item.getPrice()) {
            switch (marketSlot) {
                case "slot1":
                    character.getMarket().setMarketSlot1(0);
                    break;
                case "slot2":
                    character.getMarket().setMarketSlot2(0);
                    break;
                case "slot3":
                    character.getMarket().setMarketSlot3(0);
                    break;
                case "slot4":
                    character.getMarket().setMarketSlot4(0);
                    break;
                case "slot5":
                    character.getMarket().setMarketSlot5(0);
                    break;
                case "slot6":
                    character.getMarket().setMarketSlot6(0);
                    break;

            }
            int newCash = character.getCash() - item.getPrice();
            character.setCash(newCash);
            DatabaseHandler.updateUser(character.getName(), "cash", newCash);
            ItemController.setInventorySpaceToItem(character, item, ItemController.findFirstFreeSpaceInInventory(character));
        }
    }

    public void sellItem(Character character, Item item, String invSlot) {
        int newCash = character.getCash() + item.getPrice();

        character.setCash(newCash);
        DatabaseHandler.updateUser(character.getName(), "cash", newCash);

        ItemController.removeItemFromInventory(character, invSlot);

    }

}
