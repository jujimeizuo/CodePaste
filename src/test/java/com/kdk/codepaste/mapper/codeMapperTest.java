package com.kdk.codepaste.mapper;

import com.kdk.codepaste.CodepasteApplication;
import com.kdk.codepaste.pojo.CodePaste;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CodepasteApplication.class)
public class codeMapperTest {
    @Resource
    private CodeMapper codeMapper;
    @Test
    void selectByPasteKey() {
    }

    @Test
    void insert() {
        codeMapper.insertCode(new CodePaste("123", "111","115"));
    }

    @Test
    void deleteByShareKey() {
    }
}