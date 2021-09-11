package com.kdk.codepaste.service;

import com.kdk.codepaste.pojo.Msg;

import java.io.IOException;

public interface CodeService {
    public Msg checkError(String shareKey, String codeContext);
    public String getCodetext(String shareKey);
    public Msg checkShareKey(String shareKey);
    public Msg checkQuery(String shareKey);
    public void insertCode(String shareKey, String codeContext, String shareDuration) throws IOException;
}
