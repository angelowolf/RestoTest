/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soporte;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ang_2
 */
public class CommonsUtil {

    public static Map<Integer, Integer> listToHash(List<Integer> lista) {
        Map<Integer, Integer> map = new HashMap<>();
        if (lista != null && !lista.isEmpty()) {
            for (Integer i : lista) {
                map.put(i, i);
            }
        }
        return map;
    }

    public static String upFirstLetter(String palabra) {
        return palabra.substring(0, 1).toUpperCase() + palabra.substring(1);
    }

}
