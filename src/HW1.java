import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;

public class HW1 {
    public static void main(String[]args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("입력 파일 이름?");
        String fileName = scanner.next();

        Scanner textFile_in = new Scanner(new File(fileName)).useDelimiter(" ");
        List<String> words = new ArrayList<>();
        while(textFile_in.hasNext()){

            String words_check = textFile_in.next();
            if(words_check.contains("\n")) {
                String[] split_words = words_check.split("\n");
                for(int k = 0; k < split_words.length ;k++){
                    if(split_words[k].equals("")){}
                    else
                        words.add(split_words[k]);
                }
            }
            else{
                if(words_check.equals("")){}
                else
                    words.add(words_check);
            }
        }

        String[] wordsArr = words.toArray(new String[0]);
        String[] copy1 = wordsArr;
        String[] copy2 = wordsArr;
        String[] copy3 = wordsArr;
        String[] copy4 = wordsArr;
        String[] copy5 = wordsArr;

        System.out.println("1. 단어의 수 = " + wordsArr.length);
        long startTime = System.currentTimeMillis();
        Selection.sort(copy1);
        long EndTime = System.currentTimeMillis();
        System.out.println("2. 선택정렬: 정렬 여부 = " + Selection.isSorted(copy1) + ", 소요 시간 = " + (EndTime - startTime)/1000 + "ms");
        startTime = System.currentTimeMillis();
        Insertion.sort(copy2);
        EndTime = System.currentTimeMillis();
        System.out.println("3. 삽입정렬: 정렬 여부 = " + Insertion.isSorted(copy2) + ", 소요 시간 = " + (EndTime - startTime)/1000 + "ms");
        startTime = System.currentTimeMillis();
        Shell.sort(copy3);
        EndTime = System.currentTimeMillis();
        System.out.println("4. Shell정렬: 정렬 여부 = " + Shell.isSorted(copy3) + ", 소요 시간 = " + (EndTime - startTime)/1000 + "ms");
        startTime = System.currentTimeMillis();
        MergeTD.sort(copy4);
        EndTime = System.currentTimeMillis();
        System.out.println("5. Top Down 합병정렬: 정렬 여부 = " + MergeTD.isSorted(copy4) + ", 소요 시간 = " + (EndTime - startTime)/1000 + "ms");
        startTime = System.currentTimeMillis();
        MergeBU.sort(copy5);
        EndTime = System.currentTimeMillis();
        System.out.println("6. Bottom Up 합병정렬: 정렬 여부 = " + MergeBU.isSorted(copy5) + ", 소요 시간 = " + (EndTime - startTime)/1000 + "ms");
    }
}
