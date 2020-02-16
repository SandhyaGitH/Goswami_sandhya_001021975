/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.List;

/**
 *
 * @author samarth
 */
public class Test {
    public List<Integer> list;

    public void mystery(int n) {
        for (int i = 0; i < n; i++) {
            Object obj = list.remove(0);
            list.add((Integer) obj);
        }
    }
}
