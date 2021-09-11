package com.kdk.codepaste.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class CodePaste {
    private String id;
    private String shareKey;
    private String filePath;
    private String codeContext;
    private Date shareTime;

    public CodePaste() {}

    public CodePaste(String id, String shareKey, String filePath) {
        this.id = id;
        this.shareKey = shareKey;
        this.filePath = filePath;
    }
}