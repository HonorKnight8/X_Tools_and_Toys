package monster.helloworld.mac_who_is;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * 用于前台页面提交 MAC 地址时，进行查询响应
 */
public class MacWhoIsServlet extends HttpServlet {

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

        // 接收前端提交的数据
        String macAddress = StringEscapeUtils.escapeHtml4(req.getParameter("macAddress")); // 将特殊字符转换为 HTML 实体
        macAddress = macAddress.trim(); // 去掉前后空格
        System.out.println("___接收到客户端提交的数据：" + macAddress);

        HashMap<String, Object> map = new HashMap<>(); // 用于存放返回信息

        // 判断用户输入是否为空
        if (macAddress.equals("")) {
            map.put("flag", false);
            map.put("returnMsg", "MAC 地址不能为空");
        } else {
            // 全角冒号转换为半角，将全角逗号转换为半角，转大写
            macAddress = macAddress.replaceAll("：", ":");
            macAddress = macAddress.replaceAll("，", ",");
            macAddress = macAddress.toUpperCase();


            // 进行输入合规性判断
            // 只允许 数字、A-F、连字符、冒号、空格、点号、逗号，这几种字符
            // 只要匹配到这几种字符以外的任意字符，就返回 “非法字符”
            if (macAddress.matches("[\\s\\S]*[^A-F0-9\\-: \\.,][\\s\\S]*")) {
                map.put("flag", false);
                map.put("returnMsg", "非法字符");
            } else {
                // 把数据传给 service 进行查询，接收到返回的结果 map
                map.put("flag", true);
                map.put("returnResults", MacWhoIsService.inquire(macAddress));
            }
        }

        // 把 map 转成 json ，最后返回给前端
        ObjectMapper om = new ObjectMapper();
        String mapJson = null;
        PrintWriter out = null;

        try {
            // map转json
            mapJson = om.writeValueAsString(map);
            out = resp.getWriter();
            // System.out.println(mapJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回给前端
        out.println(mapJson);

    }
}
