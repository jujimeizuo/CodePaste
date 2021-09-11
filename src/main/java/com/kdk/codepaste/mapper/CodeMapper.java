package com.kdk.codepaste.mapper;

import com.kdk.codepaste.pojo.CodePaste;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CodeMapper {
    public CodePaste selectByPasteKey(String shareKey);
    public int insertCode(CodePaste codePaste);
    public int deleteByShareKey(String shareKey);
}