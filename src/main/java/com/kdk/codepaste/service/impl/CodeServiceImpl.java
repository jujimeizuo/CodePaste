package com.kdk.codepaste.service.impl;


import com.kdk.codepaste.mapper.CodeMapper;
import com.kdk.codepaste.pojo.CodePaste;
import com.kdk.codepaste.pojo.Msg;
import com.kdk.codepaste.service.CodeService;
import com.kdk.codepaste.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.UUID;

@Service
public class CodeServiceImpl implements CodeService {
    
    @Autowired
    private RedisUtil redisUtil;
    
    @Autowired
    private CodeMapper codeMapper;
    
    @Override
    public Msg checkError(String shareKey, String codeContext) {
        if("".equals(shareKey))
            return Msg.fail("口令为空！");
        if("".equals(codeContext))
            return Msg.fail("代码为空！");
        if(redisUtil.get(shareKey,0) != null)
            return Msg.fail("口令已被使用！");
        return Msg.success("success");
    }
    
    @Override
    public Msg checkShareKey(String shareKey) {
        if("".equals(shareKey))
            return Msg.fail("shareKey为空");
        boolean exist = redisUtil.exists(shareKey, 0);
        if(exist)
            return Msg.fail("shareKey已经存在！").add("shareKey", redisUtil.get(shareKey, 0));
        else
            return Msg.success("shareKey可以使用！");
    }

    @Override
    public String getCodetext(String shareKey) {
        String codeContext = redisUtil.get(shareKey, 0);
        return codeContext;
    }

    @Override
    public Msg checkQuery(String shareKey) {
        String codeContext = redisUtil.get(shareKey, 0);
        if(codeContext != null)
            return Msg.success("查询成功！").add("shareKey", codeContext);
        else {
            String src = "./file/" + shareKey + ".txt";
            File file = new File(src);
            if(!file.exists()) return Msg.fail("该口令不存在");
            FileReader fileReader;
            BufferedReader br = null;
            try {
                fileReader = new FileReader(file);
                br = new BufferedReader(fileReader);
                StringBuilder sb = new StringBuilder();
                String temp;
                while ((temp = br.readLine()) != null) {
                    // 拼接换行符
                    sb.append(temp + "\n");
                }
                String js = sb.toString();
                redisUtil.set(shareKey, js, 0);
                return Msg.success("查询成功！").add("shareKey", js);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if(br != null)
                    try {
                        br.close();
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
            }
            return Msg.fail("该口令不存在");
        }
    }

    @Override
    public void insertCode(String shareKey, String codeContext, String shareDuration) throws IOException {
        redisUtil.set(shareKey, codeContext, 0);
        if("permanent".equals(shareDuration)) {
            String filePath = "./file/";
            File file = new File(filePath);
            if(!file.exists()) {
                file.mkdirs();
            }
            filePath = filePath + shareKey + ".txt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(codeContext);
            bw.close();
            String id = UUID.randomUUID().toString();
            CodePaste codePaste = new CodePaste(id, shareKey, filePath);
            codeMapper.insertCode(codePaste);
        }
    }
}
