package monster.helloworld.file_name;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class FileNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        // 设置编码
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=utf-8");

        // 接收前端提交上来的文件名
        System.out.println("___接收到客户端发送过来的信息：" + req.getParameter("filename"));
        String filename = StringEscapeUtils.escapeHtml4(req.getParameter("filename")); // 将特殊字符转换为 HTML 实体
        filename = filename.trim();

        HashMap<String,Object> map = new HashMap<>(); // 用于存放返回信息

        if(filename.length() >= 100){
            // 太长
            map.put("flag",false);
            map.put("returnMsg","长度超过限定值");
        }else if(!checkFileName(filename)){
            map.put("flag",false);
            map.put("returnMsg","非法字符");
        }else{
            map.put("flag",true);
            map.put("returnFileName", convertFileName(filename));
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

    /**
     * 检查输入合法性，只允许输入：
     *  大写字母、小写字母、数字、点 “.” 、连字符 “-” 、下划线 “_” 、空格
     * @param string 输入待检查的字符串
     * @return boolean 返回结果，布尔值
     */
    public boolean checkFileName(String string){
        return string.matches("[\\w-.\\s]+");
    }

    /**
     * 进行转换
     *  全部转小写
     *  连字符 “-” 、空格 转成 下划线 “_”
     *  连续的多个下划线，合并为一个
     *  连续的多个点  “.” ，合并为一个
     *  去掉 点  “.” 左右相邻的的 下划线 “_”
     * @param string
     * @return
     */
    public String convertFileName(String string){
        string = string.toLowerCase();
        string = string.replaceAll("[\\s-]","_");
        string = string.replaceAll("_+","_");
        string = string.replaceAll("[.]+",".");
        string = string.replaceAll("[_][.]",".");
        string = string.replaceAll("[.][_]",".");
        return string;
    }
}
