package or.yonsai.mapper;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import or.yonsai.domain.Criteria;
import or.yonsai.domain.ReplyVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private int[] bnoArr = {30, 29, 28, 27, 26};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
//	@Test
//	public void test() {
//		
//		log.info(".........................." + mapper);
//	}
	
//	@Test
//	public void testCreate() {
//		
//		IntStream.rangeClosed(0,9).forEach(i -> {
//			
//			ReplyVO vo = new ReplyVO();
//			
//			vo.setBno(bnoArr[i % 5]);
//			vo.setReply("댓글테스트_" + (i+1));
//			vo.setReplyer("replyer" + (i+1));
//			
//			mapper.insert(vo);
//		});
//		
//	}
	
//	@Test
//	public void testRead() {
//		
//		int targetRno = 5;
//		
//		ReplyVO vo = mapper.read(targetRno);
//		
//		log.info("............................." + vo);
//	}
	
//	@Test
//	public void testDelete() {
//		
//		int targetRno = 1;
//		
//		int a = mapper.delete(targetRno);
//		
//		log.info("................................"+ a);
//	}
	
//	@Test
//	public void testUpdate() {
//		
//		int targetRno = 10;
//		
//		ReplyVO vo = mapper.read(targetRno);
//		
//		vo.setReply("수정수정");
//		
//		int count = mapper.update(vo);
//		
//		log.info("..................................UPDATE COUNT: " + count);
//	}
	
//	@Test
//	public void testList() {
//		
//		Criteria cri = new Criteria();
//		
//		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
//		
//		replies.forEach(reply -> log.info("..........." + reply));
//	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2,5);
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 30);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	
}
