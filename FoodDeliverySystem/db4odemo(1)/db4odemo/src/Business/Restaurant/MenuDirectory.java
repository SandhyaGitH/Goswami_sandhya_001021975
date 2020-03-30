/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import java.util.ArrayList;

/**
 *
 * @author samarth
 */


public class MenuDirectory {
    private ArrayList<Menu> menuItemList;
    //private WorkQueue workQueue;
    public MenuDirectory() {
        menuItemList = new ArrayList();
    }

    public ArrayList<Menu> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(ArrayList<Menu> menuItemList) {
        this.menuItemList = menuItemList;
    }
    
    public void addMenuItem(Menu menu) {
        
        this.menuItemList.add(menu);
    }
    public void removeMenuItem(Menu menu) {
        
        this.menuItemList.remove(menu);
    }
    
}
