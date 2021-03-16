import com.google.common.collect.*;
import kotlin.sequences.*;

import java.time.*;
import java.time.temporal.*;
import java.util.stream.*;

public class AAA {

  public static void main(String[] args) {


    YearMonth yearMonth = YearMonth.of(2020, 1);

    LocalDate date = yearMonth.atEndOfMonth()
      .with(TemporalAdjusters.firstDayOfMonth());


    System.out.println(date);


  }
}
