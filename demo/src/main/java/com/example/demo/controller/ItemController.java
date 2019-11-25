package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.model.Character;
import com.example.demo.model.Item;
import com.example.demo.model.ItemType;
import org.primefaces.extensions.component.slideout.SlideOut;

import javax.inject.Named;
import javax.xml.crypto.Data;
import java.util.ArrayList;


@Named
public class ItemController {


    private static ArrayList<Item> items;

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static void setItems(ArrayList<Item> items) {
        System.out.println("Setting items..");

        ItemController.items = items;
    }


    public ItemType getItemType(Item item) {

        if (item.getType() == 0) return ItemType.TEMPLATE;
        else if (item.getType() == 1) return ItemType.ARMOR;
        else if (item.getType() == 2) return ItemType.GLOVES;
        else if (item.getType() == 3) return ItemType.HELMET;
        else if (item.getType() == 4) return ItemType.WEAPON;
        else if (item.getType() == 5) return ItemType.JEWELLERY;
        else return ItemType.UNDEFINED;
    }

    public static Item getItemById(int id) {
        for (Item item: items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeItemFromInventory(Character character, String inventory) {
        if (inventory.equals("inv1")) {
            DatabaseHandler.updateUser(character.getName(), "inv1", 0);
            character.setInv1(0);
        }
        if (inventory.equals("inv2")) {
            DatabaseHandler.updateUser(character.getName(), "inv2", 0);
            character.setInv2(0);
        }
        if (inventory.equals("inv3")) {
            DatabaseHandler.updateUser(character.getName(), "inv3", 0);
            character.setInv3(0);
        }
        if (inventory.equals("inv4")) {
            DatabaseHandler.updateUser(character.getName(), "inv4", 0);
            character.setInv4(0);
        }
        if (inventory.equals("inv5")) {
            DatabaseHandler.updateUser(character.getName(), "inv5", 0);
            character.setInv5(0);
        }
        if (inventory.equals("inv6")) {
            DatabaseHandler.updateUser(character.getName(), "inv6", 0);
            character.setInv6(0);
        }
        if (inventory.equals("inv7")) {
            DatabaseHandler.updateUser(character.getName(), "inv7", 0);
            character.setInv7(0);
        }
        if (inventory.equals("inv8")) {
            DatabaseHandler.updateUser(character.getName(), "inv8", 0);
            character.setInv8(0);
        }

    }

    public String findFirstFreeSpaceInInventory(Character character) {
        if (character.getInv1() == 0) {
            return "inv1";
        }
        else if (character.getInv2() == 0) {
            return "inv2";
        }
        else if (character.getInv3() == 0) {
            return "inv3";
        }
        else if (character.getInv4() == 0) {
            return "inv4";
        }
        else if (character.getInv5() == 0) {
            return "inv5";
        }
        else if (character.getInv6() == 0) {
            return "inv6";
        }
        else if (character.getInv7() == 0) {
            return "inv7";
        }
        else if (character.getInv8() == 0) {
            return "inv8";
        } else {
            return "none";
        }








    }

    public void setInventorySpaceToItem(Character character, Item item, String firstFreeSpace) {
        switch (firstFreeSpace) {
            case "inv1":
                character.setInv1(item.getId());
                DatabaseHandler.updateUser(character.getName(), "inv1", item.getId());
                break;
            case "inv2":
                character.setInv2(item.getId());
                DatabaseHandler.updateUser(character.getName(), "inv2", item.getId());
                break;
            case "inv3":
                character.setInv3(item.getId());
                DatabaseHandler.updateUser(character.getName(), "inv3", item.getId());
                break;
            case "inv4":
                character.setInv4(item.getId());
                DatabaseHandler.updateUser(character.getName(), "inv4", item.getId());
                break;
            case "inv5":
                character.setInv5(item.getId());
                DatabaseHandler.updateUser(character.getName(), "inv5", item.getId());
                break;
            case "inv6":
                character.setInv6(item.getId());
                DatabaseHandler.updateUser(character.getName(), "inv6", item.getId());
                break;
            case "inv7":
                character.setInv7(item.getId());
                DatabaseHandler.updateUser(character.getName(), "inv7", item.getId());
                break;
        }
    }


    public void unequipArmor(Character character, Item item, String firstFreeSpace) {
        setInventorySpaceToItem(character, item, firstFreeSpace);
        character.setOutfit(0);
        DatabaseHandler.updateUser(character.getName(), "weapon", 0);

    }

    public void unequipWeapon(Character character, Item item, String firstFreeSpace) {
        setInventorySpaceToItem(character, item, firstFreeSpace);
        character.setWeapon(0);
        DatabaseHandler.updateUser(character.getName(), "weapon", 0);
    }

    public void unequipHelmet(Character character, Item item, String firstFreeSpace) {
        setInventorySpaceToItem(character, item, firstFreeSpace);
        character.setHelmet(0);
        DatabaseHandler.updateUser(character.getName(), "helmet", 0);
    }

    public void unequipGloves(Character character, Item item, String firstFreeSpace) {
        setInventorySpaceToItem(character, item, firstFreeSpace);
        character.setGloves(0);
        DatabaseHandler.updateUser(character.getName(), "gloves", 0);
    }

    public void unequipJew1(Character character, Item item, String firstFreeSpace) {
        setInventorySpaceToItem(character, item, firstFreeSpace);
        character.setJew1(0);
        DatabaseHandler.updateUser(character.getName(), "jewellery1", 0);
    }

    public void unequipJew2(Character character, Item item, String firstFreeSpace) {
        setInventorySpaceToItem(character, item, firstFreeSpace);
        character.setJew2(0);
        DatabaseHandler.updateUser(character.getName(), "jewellery2", 0);
    }

    public void unequipItem(Character character, Item item) {
        String firstFreeSpace = findFirstFreeSpaceInInventory(character);
        ItemType itemType = getItemType(item);
        System.out.println("First free space in inventory is " + firstFreeSpace);
        if (itemType == ItemType.ARMOR) {
            unequipArmor(character, item, firstFreeSpace);
        }
        else if (itemType == ItemType.WEAPON) {
            unequipWeapon(character, item, firstFreeSpace);
        }
        else if (itemType == ItemType.HELMET) {
            unequipHelmet(character, item, firstFreeSpace);
        }
        else if (itemType == ItemType.GLOVES) {
            unequipGloves(character, item, firstFreeSpace);
        }
        else if (itemType == ItemType.JEWELLERY) {
            unequipJew1(character, item, firstFreeSpace);
            unequipJew2(character, item, firstFreeSpace);
        }

    }

    public void equipItem(Character character, Item item, String inventory) {
        ItemType itemType = getItemType(item);
        System.out.println(itemType);


        if (itemType == ItemType.ARMOR) {
            System.out.println("Type is armor");
            System.out.println(character.getOutfit());
            if (character.getOutfit() <= 0) {
                System.out.println("Equipping armor..");
                character.setOutfit(item.getId());
                DatabaseHandler.updateUser(character.getName(), "outfit", item.getId());
                removeItemFromInventory(character, inventory);
            }


        } else if (itemType == ItemType.GLOVES) {
            if (character.getGloves() <= 0) {
                System.out.println("Equipping gloves..");
                character.setGloves(item.getId());
                DatabaseHandler.updateUser(character.getName(), "gloves", item.getId());
                removeItemFromInventory(character, inventory);

            }
        } else if (itemType == ItemType.HELMET) {
            if (character.getHelmet() <= 0) {
                System.out.println("Equipping helmet..");
                character.setHelmet(item.getId());
                DatabaseHandler.updateUser(character.getName(), "helmet", item.getId());
                removeItemFromInventory(character, inventory);

            }
        } else if (itemType == ItemType.WEAPON) {
            if (character.getWeapon() <= 0) {
                character.setWeapon(item.getId());
                System.out.println("Equipping weapon..");
                DatabaseHandler.updateUser(character.getName(), "weapon", item.getId());
                removeItemFromInventory(character, inventory);

            }
        } else if (itemType == ItemType.JEWELLERY) {
            if (character.getJew1() <= 0) {
                System.out.println("Equipping jew1..");
                character.setJew1(item.getId());
                DatabaseHandler.updateUser(character.getName(), "jewellery1", item.getId());
                removeItemFromInventory(character, inventory);

            }  else if (character.getJew2() <= 0) {
                System.out.println("Equipping jew2..");
                character.setJew2(item.getId());
                DatabaseHandler.updateUser(character.getName(), "jewellery2", item.getId());
                removeItemFromInventory(character, inventory);

            }
        }




    }



}
