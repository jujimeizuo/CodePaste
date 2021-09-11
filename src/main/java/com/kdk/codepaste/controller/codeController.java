package com.kdk.codepaste.controller;

import com.kdk.codepaste.pojo.Msg;
import com.kdk.codepaste.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("")
public class codeController {

    @Autowired
    private CodeService codeService;

    //当请求为get时说明是查询请求
    @GetMapping("/code-paste/{shareKey}")
    public Msg getCodeContext(@PathVariable("shareKey") String shareKey) {
        String codeContext = codeService.getCodetext(shareKey);
        if(codeContext != null)
            return Msg.success("查询成功！").add("shareKey", codeContext);
        else {
            Msg msg = codeService.checkQuery(shareKey);
            return msg;
        }

    }
    //当请求为post时说明是上传请求
    @PostMapping("/code-paste/{shareKey}")
    public Msg storeCodeContext(@PathVariable("shareKey") String shareKey, @RequestParam("codeContext") String codeContext, @RequestParam("shareDuration")String shareDuration) {
        Msg msg = codeService.checkError(shareKey, codeContext);
        if(!("success".equals(msg.getMsg()))) return msg;
        try {
            codeService.insertCode(shareKey, codeContext, shareDuration);
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println(e.printStackTrace());
            return Msg.fail("代码存入失败!");
        }
        return Msg.success("保存成功，请分享给您的朋友~").add("shareKey", shareKey);
    }
    //检查code是否已被占用
    @GetMapping("/check-code-exist/{shareKey}")
    public Msg checkCodeExist(@PathVariable("shareKey") String shareKey){
        Msg msg = codeService.checkShareKey(shareKey);
        return msg;
    }
}
