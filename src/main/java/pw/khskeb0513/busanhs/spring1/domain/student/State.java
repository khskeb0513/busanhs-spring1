package pw.khskeb0513.busanhs.spring1.domain.student;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum State {

    UNDERGRADUATE("Y", "A", "재학"),
    CHANGE("M", "B", "전출"),
    DROP("N", "C", "자퇴"),
    DEFAULT("", "", "입력값을 확인하세요.");

    private final String dbStr;
    private final String inputStr;
    private final String korStr;

    public static State inputStrToState(String inputStr) {
        return Arrays.stream(State.values())
                .filter(v -> inputStr.toUpperCase().equals(v.getInputStr()))
                .findFirst()
                .orElse(State.DEFAULT);
    }
}
