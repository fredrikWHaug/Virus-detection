
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class SubsequenceRegister {

    private ArrayList<HashMap<String, Subsequence>> register;

    public SubsequenceRegister() {
        register = new ArrayList<>();
    }

    public void addHashMap(HashMap<String, Subsequence> hm) {
        register.add(hm);
    }

    public HashMap<String, Subsequence> getHashmap(int i) {
        return register.remove(i);
    }

    public int size() {
        return register.size();
    }

    public HashMap<String, Subsequence> readImmuneRepertoire(String filename) {

        HashMap<String, Subsequence> newHM = new HashMap<>();

        try {
            
            Scanner file = new Scanner(new File(filename));

            while (file.hasNextLine()) {

                String line = file.nextLine().strip();

                int lineLength = line.length();

                int subLength = lineLength - 3;

                if (subLength > 0) {

                    for (int i = 0; i < subLength; i ++) {

                        String sub = line.substring(i, i + 4);

                        if (! newHM.containsKey(sub)) {

                            Subsequence newS = new Subsequence(sub, 1);
                            newHM.put(sub, newS);

                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return newHM;
    }

    public static HashMap<String, Subsequence> merge(HashMap<String, Subsequence> hM1, 
    HashMap<String, Subsequence> hM2) {

        HashMap<String, Subsequence> mergedMap = new HashMap<>();

        for (String key : hM1.keySet()) {

            if (! hM2.containsKey(key)) {

                Subsequence newSubs = new Subsequence(key, hM1.get(key).getAmount());
                mergedMap.put(key, newSubs);

            } else {

            Subsequence newSubs = new Subsequence(key, hM1.get(key).getAmount() + hM2.get(key).getAmount());
            mergedMap.put(key, newSubs);

        }
        }

        for (String key : hM2.keySet()) {

            if (! mergedMap.containsKey(key)) {

                Subsequence newSubs = new Subsequence(key, hM2.get(key).getAmount());
                mergedMap.put(key, newSubs);

            }
        }
        return mergedMap;
    }

}
