package com.lybyb.journey.signIn.service;

import com.lybyb.journey.signIn.model.SignIn;

import java.util.Map;

/**
 * @author liyanbo
 * @description
 * @date
 */
public interface SignInService {
    Map<String,Object>getSignInList(SignIn signIn);
    Map<String,Object>addSignIn(SignIn signIn);
    Map<String,Object>deleteSignIn(Long signInId);

}
