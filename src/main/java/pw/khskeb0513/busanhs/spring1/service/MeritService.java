package pw.khskeb0513.busanhs.spring1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pw.khskeb0513.busanhs.spring1.domain.merit.Merit;
import pw.khskeb0513.busanhs.spring1.domain.merit.MeritRepository;
import pw.khskeb0513.busanhs.spring1.domain.student.Student;
import pw.khskeb0513.busanhs.spring1.web.dto.MeritByStudentResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MeritService {

    private final MeritRepository meritRepository;

    @Transactional(readOnly = true)
    public List<Merit> findByStudentName(Student student) {
        return meritRepository.findByStudentId(student.getStudentId());
    }

    @Transactional(readOnly = true)
    public List<Merit> findByMDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return meritRepository.findByMDateBetween(startDate, endDate);
    }

    public List<MeritByStudentResponseDto> groupByStudentId(List<Merit> meritList) {
        Map<String, List<Merit>> meritListForStudentId = new HashMap<>();
        meritList.forEach(v -> {
            try {
                meritListForStudentId.get(v.getStudentId()).add(v);
            } catch (NullPointerException e) {
                List<Merit> value = new ArrayList<>();
                value.add(v);
                meritListForStudentId.put(v.getStudentId(), value);
            }
        });
        List<MeritByStudentResponseDto> meritByStudentResponseDtoList = new ArrayList<>();
        meritListForStudentId.keySet().forEach(v -> {
            meritByStudentResponseDtoList.add(new MeritByStudentResponseDto(v, meritListForStudentId.get(v)));
        });
        return meritByStudentResponseDtoList;
    }
}
