/*
 * @Author Chris Hellen
 */
package utilities;

import reports.*;
import accounts.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MainAccountingProcedure {
    SummaryReport summaryReport;
    MemberReport memberReport;
    ProviderReport providerReport;
    EFTReport eftReport;
    private List<Provider> providerList;
    private List<Member> memberList;
    
    public MainAccountingProcedure(List<Provider> providerList, List <Member> memberList){
        this.memberList = memberList;
        this.providerList = providerList;
        summaryReport = new SummaryReport(providerList);
        eftReport = new EFTReport(providerList);
    }

    public void runProcedure(){
        Timer timer = new Timer();

        // Get the current date and time
        Calendar now = Calendar.getInstance();

        // Calculate the delay until the next Friday at midnight
        int daysUntilFriday = (Calendar.FRIDAY - now.get(Calendar.DAY_OF_WEEK) + 7) % 7;
        int hoursUntilMidnight = 24 - now.get(Calendar.HOUR_OF_DAY);
        int minutesUntilMidnight = 60 - now.get(Calendar.MINUTE);
        int secondsUntilMidnight = 60 - now.get(Calendar.SECOND);

        long initialDelay = TimeUnit.DAYS.toMillis(daysUntilFriday) +
                            TimeUnit.HOURS.toMillis(hoursUntilMidnight) +
                            TimeUnit.MINUTES.toMillis(minutesUntilMidnight) +
                            TimeUnit.SECONDS.toMillis(secondsUntilMidnight);

        // Schedule the task to run every 7 days (1 week)
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                summaryReport.print();
                eftReport.print();

                for (Provider provider : providerList){
                    ProviderReport providerReport = new ProviderReport(provider);
                    providerReport.print();
                }

                for (Member member : memberList){
                    MemberReport memberReport = new MemberReport(member);
                    memberReport.print();
                }
            }
        }, initialDelay, 7 * 24 * 60 * 60 * 1000); // 7 days in milliseconds
    }
}
