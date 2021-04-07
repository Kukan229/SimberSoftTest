import java.io.*;

import org.jsoup.Jsoup;

public class Counter { //Данный класс читает указанный файл проводит очистку от html тегов, сохраняя тектс, после чего делит тест на слова по средствам разделителей
    public Counter(File a) throws IOException {
        File text = new File("C:\\text2.txt"); //Создание файла с очищенным текстом, чисто для мониторинга, почему-то весь поток не умещается в текстовый фаил, но файл бтв не нужен
        FileWriter fw = new FileWriter(text);
        FileReader fr = new FileReader(a);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        String line2 = Jsoup.parse(line).text(); //Очистка файла
        String[] arr = line2.split("[\\s., —;:!?()«»\\s|/\" ]+");//Разделение на отдельные слова
        outer: for (int i=0;i!=arr.length;i++)// Подсчёт количества повторов слов
        {
             int rep = 1; //количество повторов слов на странице
             if (i>0) // Проверка было ли уже проверенно проверяемое в данный момент слово
             {
                 for (int z=i-1;z!=0;z--)
                 {
                     if (i==arr.length) break ;
                     if (arr[i].equals(arr[z])) continue outer;//если да, переход к следующий итерации цикла
                 }
             }
             for (int j=i+1;j!=arr.length;j++) //подсчёт сколько раз встречается слово
             {
                 if (i==arr.length) break ;
                 if (arr[i].equals(arr[j]))
                 {
                     rep++;
                 }
             }
             System.out.println(arr[i] +" - "+ rep);
        }
        fw.write(line2);
        br.close();
        fr.close();
        }


}
