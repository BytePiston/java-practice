package velocity_global;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import velocity_global.online.Challenge;
import velocity_global.online.Subscription;
import velocity_global.online.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonthlyChargeTests {

    Subscription plan = new Subscription(1, 1, 5000);
    User[] users = {
            new User(1, "Employee #1", LocalDate.of(2019, 1, 1), null, 1),
            new User(2, "Employee #2", LocalDate.of(2019, 1, 1), null, 1)};

    @Test
    public void worksWhenNoUsersAreActive() {
        Assertions.assertEquals(0, Challenge.monthlyCharge("2018-10", plan, users));
    }

    @Test
    public void worksWhenTheActiveUsersAreActiveTheEntireMonth() {
        float expectedUserCount = 2;
        assertEquals(expectedUserCount * 5000, Challenge.monthlyCharge("2020-12", plan, users), 1);
    }
}
