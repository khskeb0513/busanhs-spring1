package pw.khskeb0513.busanhs.spring1.web.dto;

import lombok.RequiredArgsConstructor;
import pw.khskeb0513.busanhs.spring1.domain.merit.Merit;

import java.util.List;

@RequiredArgsConstructor
public class MeritByStudentResponseDto {

    private final String studentId;
    private final List<Merit> meritByStudent;
}
