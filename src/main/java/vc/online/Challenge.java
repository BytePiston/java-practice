package vc.online;

import java.time.LocalDate;
import java.time.YearMonth;

public class Challenge {

    public static int monthlyCharge(String month, Subscription subscription, User[] users) {
        if(month == null || month.isEmpty() || subscription == null)
            return 0;
//Taken help from StackOverflow: https://stackoverflow.com/questions/12499079/how-to-generate-a-date-from-just-month-and-year-in-java
//Assuming that day start 1 so we will be converting it to standard.
        YearMonth yearMonth = YearMonth.parse(month);
        int numOfDays = yearMonth.lengthOfMonth();
        double dailyCharge = ((double)subscription.monthlyPriceInCents/numOfDays);
        LocalDate startDate = firstDayOfMonth(yearMonth);
        LocalDate endDate = lastDayOfMonth(yearMonth);
        double monthlyAmount = 0;
        for(User user: users){
            //Handling case where customerId of user is not matching subscription.customerId;
            if(user.customerId != subscription.customerId){
                continue;
            }
            //Handling case where user.activatedOn is null;
            if(user.activatedon == null){
                continue;
            }
            int numActiveDays = 0;
            //Taken help from: https://stackoverflow.com/questions/4534924/how-to-iterate-through-range-of-dates-in-java
            for(LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date.plusDays(1)){
                if(user.deactivatedon == null){
                    if(date.isEqual(user.activatedon) || date.isAfter(user.activatedon)){
                        numActiveDays++;
                    }
                } else{
                    //Taken help from: http://www.java2s.com/example/java-utility-method/localdate-between/isbetween-localdate-date-localdate-before-localdate-after-02af9.html
                    if(date.isEqual(user.activatedon) || date.isEqual(user.deactivatedon) || (date.isAfter(user.activatedon) && date.isBefore(user.deactivatedon))){
                        numActiveDays++;
                    }
                }
                date = date.plusDays(1);
            }
            double totalAmount = numActiveDays * dailyCharge;
            monthlyAmount += totalAmount;
        }
        return (int)monthlyAmount;
    }

    private static LocalDate firstDayOfMonth(YearMonth date) {
        return date.atDay(1);
    }

    private static LocalDate lastDayOfMonth(YearMonth date) {
        return date.atEndOfMonth();
    }
}
