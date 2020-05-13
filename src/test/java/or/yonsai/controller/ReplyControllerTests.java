package or.yonsai.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.taglibs.standard.tag.common.core.RemoveTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import or.yonsai.domain.ReplyVO;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration

@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class ReplyControllerTests {

	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = 
				MockMvcBuilders.webAppContextSetup(ctx)
				.build();}
//	@Test
//	public void test() throws Exception{
//		
//		ReplyVO vo = new ReplyVO();
//		vo.setBno(23);
//		vo.setReply("test test");
//		vo.setReplyer("user");
//		
//		String jsonStr = new Gson().toJson(vo);
//		
//		log.info(jsonStr);
//		
//		mockMvc.perform(post("/replies/new")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(jsonStr))
//				.andExpect(status()
//						.is(200));
//	}

//	@Test
//	public void testPUT() throws Exception{
//	
//		ReplyVO vo = new ReplyVO();
//		vo.setReply("수정 수정 수정");
//		
//		ObjectMapper objectMapper =new ObjectMapper();
////		String jsonStr = new Gson().toJson(vo);
//		
////		log.info("................" + jsonStr);
//		
//		mockMvc.perform(put("/replies/31")
//				.contentType(MediaType.APPLICATION_JSON_VALUE)
////				.content(jsonStr))
//				.content(objectMapper.writeValueAsString(vo)))
//				.andExpect(status()
//						.is(200));
//	}
	
	@Test
	public void testDelete() throws Exception{
			
		mockMvc.perform(delete("/replies/32"))
				.andExpect(status()
						.is(200));

	}
}
