import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static String metaDataFile;

    private static ArrayList<String> createReadableFiles(String path) {

        ArrayList<String> metaDataList = new ArrayList<>();

        try {

            Scanner file = new Scanner(new File(path + "\\" + metaDataFile));

            while(file.hasNextLine()) {

                String line = file.nextLine().strip();

                if (! line.equals("testfiler")) {

                    String[] lineData = line.split(",");

                    metaDataList.add(lineData[0]);

                }
            }

            file.close();

        } catch (Exception e) {
            System.out.println("Error");
        }
        return metaDataList;
    }

    public static void test(String path) {

        SubsequenceRegister sr = new SubsequenceRegister();

        HashMap<String, Subsequence> testMap = new HashMap<>();
        ArrayList<String> sequenceFiles = createReadableFiles(path);

        for (String file : sequenceFiles) {

            testMap = sr.readImmuneRepertoire(path + "\\" + file);
            sr.addHashMap(testMap);

        }

        if (sr.size() > 0) {

            testMap = sr.getHashmap(0);

            while (sr.size() > 0) {
                testMap = sr.merge(testMap, sr.getHashmap(0));
            }

            int mostOcrs = 0;
            for (String key : testMap.keySet()) {

                if (testMap.get(key).getAmount() > mostOcrs) {
                    mostOcrs = testMap.get(key).getAmount();
                }

            }

            System.out.println("Pattern(s) with the most occurrences across files: ");

            for (String key : testMap.keySet()) {

                if (testMap.get(key).getAmount() == mostOcrs) {
                    System.out.println(testMap.get(key).toString());
                }
                
            }
        }
    }

    public static void main(String[] args) {

        metaDataFile = "metaData.csv";

        String[] testFolders = new String[] 
        {
            "C:\\Users\\fredr\\GAMI\\Application projects\\Immune_analyzis\\testFiles",
        };
        
        for (String folder : testFolders) {
            test(folder);
        }

    }

}