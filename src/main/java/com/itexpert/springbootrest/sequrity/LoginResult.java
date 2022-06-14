package com.itexpert.springbootrest.sequrity;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginResult {

    @NotNull
    private String token;
}
