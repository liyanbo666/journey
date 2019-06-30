package com.lybyb.journey.signIn.dao;

import com.lybyb.journey.signIn.model.SignIn;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liyanbo
 * @description
 * @date
 */
@Mapper
public interface SignInMapper {
    List<SignIn> getSignInList(SignIn signIn);
    void addSignIn(SignIn signIn);
    @Delete("delete from sign_in where id=#{signId}")
    void deleteSignIn(Long signId);
}
