package printDates;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrintReversedDates {
    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        PrintReversedDates printReversedDates = new PrintReversedDates();
        List<LocalDate> allDatesInRange = printReversedDates.getAllDatesInRange(fromYear, toYear);

        for (LocalDate date : allDatesInRange) {
            if (printReversedDates.checkIfDateIsReversed(date)) {
                System.out.println(date);
            }
        }
    }

    private boolean checkIfDateIsReversed (LocalDate date) {
        String dateString = date.toString().replace("-", "");
        String year = dateString.substring(0, 4);
        String monthDay = dateString.substring(4);
        String reversedMonthDay = new StringBuilder(monthDay).reverse().toString();

        if (year.equals(reversedMonthDay)) {
            return true;
        } else {
            return false;
        }
    }

    private List<LocalDate> getAllDatesInRange(int fromYear, int toYear) {
        List<LocalDate> dates = new ArrayList<>();

        for (int i = fromYear; i <= toYear; i++) {
            LocalDate startDate = LocalDate.of(i, 1,1);
            LocalDate lastDate = LocalDate.of(i, 12, 31);

            for (LocalDate date = startDate; date.isBefore(lastDate.plusDays(1)); date = date.plusDays(1)) {
                dates.add(date);
            }
        }
        return dates;
    }
}
