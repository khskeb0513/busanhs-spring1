package pw.khskeb0513.busanhs.spring1.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CommonService {

    public LocalDateTime stringToLocalDateTime(String string) {
        return LocalDate.parse(string, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
    }
}
