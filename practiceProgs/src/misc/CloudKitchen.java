package misc;

// Pad for Shouvik Dutta - Backend Engineer - New York City (P)

/*
You have been tasked with parsing menus from a large restaurant group. Each menu is streamed to clients via a provided interface. You must design object(s) that represents a menu and can be instantiated with data from the provided interface. Your design should contain an appropriate class structure to contain the parsed data, as well as a function or set of functions to perform the parsing.

Consumers will use your object(s) to access a complete representation of the data sent by the menu stream after it has finished loading. Your objects should provide easy access to the full representation of the menu. It should be possible to reconstruct the menu stream from your object.

The menu stream represents a list of menu items. Each line in the stream is a property of a menu item, and each item will be separated by an empty string. The attributes of each item are as follows:

  Line 0: The ID of the item
  Line 1: The item type, either CATEGORY, DISH or OPTION
  Line 2: The name of the item
  Line 3: The price of the item for DISH and OPTION. Not present for CATEGORY items.
  Any other line: A list of item IDs that are linked to the current item. OPTIONs do not have any linked items.
*/

/*
4
DISH
Spaghetti
10.95
2
3

1
CATEGORY
Pasta
4
5

2
OPTION
Meatballs
1.00

3
OPTION
Chicken
2.00

5
DISH
Lasagna
12.00

6
DISH
Caesar Salad
9.75
3
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.*;

interface MenuStream {

    String nextLine();
}

class MenuStreamImpl implements MenuStream {

    private final List<String> lines = new ArrayList<>(Arrays.asList("4", "DISH", "Spaghetti", "10.95", "2", "3", "", "1", "CATEGORY", "Pasta", "4", "5", "", "2", "OPTION", "Meatballs", "1.00", "", "3", "OPTION", "Chicken", "2.00", "", "5", "DISH", "Lasagna", "12.00", "", "6", "DISH", "Caesar Salad", "9.75", "3", ""));

    private final Iterator<String> it = lines.iterator();

    @Override
    public String nextLine() {
        if (it.hasNext()) {
            return it.next();
        } else {
            return null;
        }
    }

}

class MenuParser {

    public Collection<Menu> parse(MenuStream menuStream) {
        int menuLineCount = 0;
        Map<Integer,Menu> map = new HashMap<>();
        String val = menuStream.nextLine();
        Menu menu = null;

        while(val != null) {
            System.out.println("menuLineCount::" + menuLineCount);
            System.out.println("val::" + val);

            switch(menuLineCount) {
                case 0:
                    menu = new Menu();
                    menu.id = Integer.parseInt(val);
                    menuLineCount++;
                    break;
                case 1:
                    menu.menuType = MenuType.valueOf(val);
                    menuLineCount++;
                    break;
                case 2:
                    menu.name = val;
                    menuLineCount++;
                    break;
                default:
                    if(menu.menuType != MenuType.CATEGORY && !val.equals("")) {
                        menu.price = Double.parseDouble(val);
                        menuLineCount++;
                    } else if(!val.equals("")) {
                        menu.linkedItems.add(Integer.parseInt(val));
                        menuLineCount++;
                    } else {
                        // store this and proceed to next menu item
                        map.put(menu.id, menu);
                        menuLineCount = 0;
                    }
                    break;
            }
            val = menuStream.nextLine();
        }

        //post process to link actual objects instead of IDs
        for(Integer id : map.keySet()) {
            Menu temp = map.get(id);
            for(Integer linkedId : temp.linkedItems) {
                temp.linkedMenus.add(map.get(linkedId));
            }
        }
        return map.values();
    }
}

enum MenuType {
    CATEGORY,
    DISH,
    OPTION;
}

class Menu {

    Integer id;
    MenuType menuType;
    String name;
    Double price;
    transient List<Integer> linkedItems = new ArrayList<>();
    List<Menu> linkedMenus = new ArrayList<>();

    //getters and setters

    @Override
    public String toString() {
        return id + " : " + menuType + " : " + name + " : " + price + " :::: " + linkedMenus;
    }
}

public class CloudKitchen {
    public static void main(String[] args) {
        MenuStream impl = new MenuStreamImpl();
        MenuParser parser = new MenuParser();
        Collection<Menu> menus = parser.parse(impl);

        System.out.println(menus);
    }
}

