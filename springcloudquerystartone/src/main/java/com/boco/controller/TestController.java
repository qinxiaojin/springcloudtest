package com.boco.controller;

import com.alibaba.fastjson.JSONObject;
import com.boco.entity.Test;
import com.boco.server.TestServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    TestServer testServer;
    @RequestMapping(value = "test",method = {RequestMethod.GET})
    public String test(){
        Test test = testServer.selectById(1);
        System.out.println(test.toString());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("test",test);
        if (jsonObject != null){
            return jsonObject.toString();
        }
        return "kongle";
    }
	 @RequestMapping(value = "download",method = {RequestMethod.GET})
    public void download(String id, HttpServletRequest request, HttpServletResponse response){
        int ids = Integer.parseInt(id);
        PubTenantInfoEntity pubTenantInfoEntity = pubTenantInfoService.getById(ids);
        /**项目路径*/
        String path = request.getSession().getServletContext().getRealPath("");
        System.out.println("path:"+path);
        String fileName = System.nanoTime() + "租户信息.xlsx";
        File finalXlsxFile = new File(path + "//" + fileName);
        //生成表格
        new XLSXTable().createForm(pubTenantInfoEntity,finalXlsxFile);
        //声明下载
        response.setContentType("application/x-download");
        try {
            fileName = URLEncoder.encode(fileName,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        //此处记得清理下。在释放在jsp中使用的对象时，会调用response.getWriter(),因为这个方法是和response.getOutputStream()相冲突的！
        OutputStream outp = null;
        FileInputStream in = null;
        try{
            outp = response.getOutputStream();
            in = new FileInputStream(finalXlsxFile);
            byte[] b = new byte[1024];
            int i = 0;
            while ((i = in.read(b)) > 0){
                outp.write(b, 0, i);
            }
            outp.flush();
        }catch (Exception e){
            System.out.println("Download Error!");
            e.printStackTrace();
        }finally{
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outp != null){
                try {
                    outp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
