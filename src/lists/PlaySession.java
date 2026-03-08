package lists;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PlaySession(int gameId,
                          double hours,
                          LocalDateTime dateTime
) {

}
