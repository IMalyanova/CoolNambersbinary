import javafx.print.Collation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoolNumbers {
    public static void main(String[] args) throws IOException {

//        ArrayList<String> coolNumbers = new ArrayList<>(); // 222087        2041027-binary
//        HashSet<String> coolNumbers = new HashSet<>();  // 162566
        TreeSet<String> coolNumbers = new TreeSet<>();     //277129

        String str = "00";
        coolNumbers.add("000");
        coolNumbers.add("ААА");          coolNumbers.add("АОО");
        coolNumbers.add("МОО");          coolNumbers.add("ЕЕЕ");
        coolNumbers.add("ККК");          coolNumbers.add("МММ");
        coolNumbers.add("ННН");          coolNumbers.add("ООО");
        coolNumbers.add("ССС");          coolNumbers.add("УУУ");
        coolNumbers.add("ХХХ");          coolNumbers.add("БОО");

        coolNumbers.add("ооо");
        coolNumbers.add("ааа");          coolNumbers.add("аоо");
        coolNumbers.add("моо");          coolNumbers.add("еее");
        coolNumbers.add("ккк");          coolNumbers.add("ммм");
        coolNumbers.add("ннн");          coolNumbers.add("ооо");
        coolNumbers.add("ссс");          coolNumbers.add("ууу");
        coolNumbers.add("ххх");          coolNumbers.add("боо");

        for (int i = 1; i < 10; i ++){
            coolNumbers.add(str + Integer.toString(i));
            coolNumbers.add(Integer.toString(i) + str);
        }

        int i = 0;
        while (i < 999){
            i += 111;
            coolNumbers.add(Integer.toString(i));
        }

        // Вводится номер и происходит проверка:
        System.out.println("Введите номер (на кирилице): ");
        String scrn = (new BufferedReader(new InputStreamReader(System.in))).readLine();

        Pattern pattern = Pattern.compile("\\s*[А-Яа-я]{1}\\d{3}[А-Яа-я]{2}\\s*+");
        Matcher matcher = pattern.matcher(scrn);
        Boolean result = matcher.matches();

        if (!result){
            System.out.println("Вы неверно ввели данные.");
        } else{
            scrn = scrn.trim();
            String scrn1 = scrn.substring(1,4);
            String[] scrn2 = scrn.split("\\d+");
            String scrn3 = scrn2[0] + scrn2[1];

            long startTime = System.nanoTime();

//--------------------------------------------------------------------------------------
//            Collections.sort(coolNumbers);
//            int serch1 = Collections.binarySearch(coolNumbers, scrn1);
//            int serch3 = Collections.binarySearch(coolNumbers, scrn3);
//            if (serch1 > 0 | serch3 > 0) {
//                System.out.println(" *** блатной номер ***");
//            }else {
//                 System.out.println("Это обычный номер.");
//            }
//
//            long estimatedTime = System.nanoTime() - startTime;
//            System.out.println(estimatedTime);

//--------------------------------------------------------------------------------------

            if (  (coolNumbers.contains(scrn1))|(coolNumbers.contains(scrn3)) ){
                 System.out.println(scrn + ": *** блатной номер ***");
            }else {
                 System.out.println("Это обычный номер.");
            }
            long estimatedTime = System.nanoTime() - startTime;
            System.out.println(estimatedTime);
//--------------------------------------------------------------------------------------

        }

    }
}
