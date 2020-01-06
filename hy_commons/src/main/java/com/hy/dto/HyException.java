package com.hy.dto;

import com.hy.jopo.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HyException extends RuntimeException {

    private ExceptionEnums exceptionEnums;
}
