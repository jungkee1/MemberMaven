package org.member.controller;

import java.util.HashMap;
import java.util.List;

import org.member.mybatis.mapper.MemberDAOImpl;
import org.member.mybatis.mapper.ZipcodeDAOImpl;
import org.member.mybatis.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberMyController {
	@Autowired //자동주입 Autowired를 쓰면 객체가 생성 되고  @Repository랑 서로 맵핑 된다
	private MemberDAOImpl mdao;
	
	@Autowired
	private ZipcodeDAOImpl zdao;
	
	//test
	@RequestMapping("mytest.my")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data","myBatis controller test");
		mv.setViewName("result");
		return mv;
	}
	
	
	//insert-form
	@RequestMapping("myInsert.my")
	public ModelAndView insert() {
		return new ModelAndView("memberInsert");
	}
	
	//insert
	@RequestMapping(value="myInsert.my", method=RequestMethod.POST)
	public ModelAndView insert(MemberVO user) {
		mdao.insert(user);
		return new ModelAndView("redirect:myList.my");
	}

	//list
	@RequestMapping("myList.my")
	public ModelAndView list() {
		List<MemberVO> vo = mdao.getMemberList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo",vo);
		mv.setViewName("list");
		return mv;
	}
	
	//delete
	@RequestMapping("myDelete.my")
	public ModelAndView delete(String id) {
		mdao.delete(id);
		return new ModelAndView("redirect:myList.my");
		
	}
	
	//detail
	@RequestMapping("myDetail.my")
	public ModelAndView findById(String id) {
		MemberVO vo = mdao.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.setViewName("detail");
		return mv;
	}
	
	//update
	@RequestMapping("myUpdate.my")
	public ModelAndView update(MemberVO vo) {
		mdao.update(vo);
		return new ModelAndView("redirect:myList.my");
	}
	
	//검색
	@RequestMapping("member_list.do")
	public ModelAndView search(String field, String word) {
		HashMap<String, String> map = new HashMap<>();
		map.put("field", field);
		map.put("word", word);
		List<MemberVO> vo = mdao.search(map);
		int count = mdao.searchCount(map);//갯수
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.addObject("count", count);
		mv.setViewName("search");
		return mv;
	}
	
	
	
//	//zipSearch - form
//	@RequestMapping("myZipSearch.my")
//	public ModelAndView zipSearch() {
//		return new ModelAndView("zipSearch");
//	}
	//zipFind
//	@RequestMapping("zipFind.my")
//	public ModelAndView zipFind(String dong, HttpServletResponse resp) {
//		List<ZipCodeVO> vo = zdao.zipSearch(dong); // 이미 LIST형으로 오니깐 
//		JSONArray jarr = new JSONArray();	//JSON 객체 생성해서 돌리면서 처 넣을껄
//		for(ZipCodeVO z:vo) {
//			JSONObject obj = new JSONObject();
//			obj.put("zipcode", z.getZipcode());
//			obj.put("sido", z.getSido());
//			obj.put("gugun", z.getGugun());
//			obj.put("dong", z.getDong());
//			obj.put("bunji",z.getBunji());
//			jarr.add(obj);
//		}
//		resp.setContentType("text/html;charset=utf-8");
//		PrintWriter out;
//		try {
//			out = resp.getWriter();
//			out.println(jarr.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	
	
	
	
	
	
}
