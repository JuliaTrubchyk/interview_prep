import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> numbers = List.of("(123) 456-7890", "987-654-3210", "555 123 4567");
        String telNum = "(123) 456-7890";
        String cleaned = telNum.replaceAll("[ .]", "");
        System.out.println(cleanPhoneNumbers(numbers));
    }

    public static List<String> cleanPhoneNumbers(List<String> numbers){
        List<String> list = new ArrayList<>();
        for(String tel : numbers){
            list.add(tel.replaceAll("\\D+", ""));
        }
        return list;
    }











}