package com.sds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class GetGeo
 */
@WebServlet({ "/GetGeo", "/getgeo" })
public class GetGeo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGeo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		ArrayList<Geo> list = new ArrayList<>();
		list.add(new Geo("���빮��ȸ", "37.555210", "126.974943"));
		list.add(new Geo("���￪", "37.555805", "126.969697"));
		list.add(new Geo("û�ĵ�����", "37.553917", "126.967530"));
		list.add(new Geo("GS25", "37.553364", "126.973506"));
		list.add(new Geo("�ձ�����ȭü������", "37.555693", "126.964769"));
		
		JSONArray ja = new JSONArray();
		for(Geo g:list) {
			JSONObject obj = new JSONObject();
			obj.put("name", g.getName());
			obj.put("x", g.getX());
			obj.put("y", g.getY());
			ja.add(obj);
		}
		System.out.println(ja);
		
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
	}

}
