package HashSet_HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class HashSetEtMap {
     public static void main(String[] args) {
          // Hashmap -> tableau assiociatif
          HashMap<String, String> departements = new HashMap<String, String>();
          departements.put("29", "Finistère");
          departements.put("56", "Morbihan");
          departements.put("22", "Cote d'armor");
          departements.put("35", "ile et vilaine");

          System.out.println(departements.get("29"));

          HashSet<String> aux = new HashSet<String>();
          aux.add("TOTO");
          aux.add("XXX");
          aux.add("TOTO");
          aux.add("tatin");

          System.out.println(aux);
     }
}