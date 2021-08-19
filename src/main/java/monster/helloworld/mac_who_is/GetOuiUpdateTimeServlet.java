package monster.helloworld.mac_who_is;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class GetOuiUpdateTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        // 设置编码
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=utf-8");

        // 接收前端提交上来的文件名

        HashMap<String,Object> map = new HashMap<>(); // 用于存放返回信息

        // 获取 oui 文件的 lastmodifiedtime
        String lastModifiedTime = new OuiFileDao().getLastModifiedTime();
        System.out.println(lastModifiedTime);

        if(!lastModifiedTime.equals("")){
            map.put("flag",true);
            map.put("returnUpdateTime","资料库更新时间：" + lastModifiedTime);
        }else{
            map.put("flag",false);
            map.put("returnMsg","获取资料库更新时间出错！");
        }

        // 返回部分
        ObjectMapper om = new ObjectMapper();
        String mapJson = null;
        PrintWriter out = null;

        try {
            // map转json
            mapJson = om.writeValueAsString(map);
            out = resp.getWriter();
            System.out.println(mapJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回给前端
        out.println(mapJson);

    }
}
