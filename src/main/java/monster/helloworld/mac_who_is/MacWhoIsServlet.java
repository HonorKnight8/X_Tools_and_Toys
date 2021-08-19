package monster.helloworld.mac_who_is;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MacWhoIsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){


        // 接收前端提交的数据

        // 判断用户输入是否为空

        // 进行输入合规性判断

        // 把数据传给 services

        // 收到 services 返回的 map


        // 向前端返回 map

    }
}
