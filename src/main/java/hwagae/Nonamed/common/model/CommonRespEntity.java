package hwagae.Nonamed.common.model;

import lombok.Data;

/**
 * @ 2024.07.20
 * @ author : WhiteKIM
 * @ comment
 * API 공통 반환 모델
 * 기본적인 API 표준 데이터로 사용됩니다.
 */
@Data
public class CommonRespEntity<T>{
    private int code;//HTTP 상태코드
    private String message;//상태 메시지
    private T data;//API 데이터

    public CommonRespEntity(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
