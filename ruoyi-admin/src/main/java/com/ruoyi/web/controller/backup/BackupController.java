package com.ruoyi.web.controller.backup;

import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date 2021/1/16 -- 12:11
 **/
@RestController("/backup/mysql")
public class BackupController {
    @PostMapping("/export")
    public AjaxResult backup(String url,String username,String password,String baseName,String fileUrl) throws Exception {
        Runtime run = Runtime.getRuntime();
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
        String format = sdf.format(date);
        run.exec("mysqldump -h"+url+" -u"+username+" -p"+password+" "+baseName+">"+fileUrl+"/"+format+".sql]");
        return AjaxResult.success();
    }
}
