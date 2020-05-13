package or.yonsai.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import or.yonsai.domain.Criteria;
import or.yonsai.domain.ReplyPageDTO;
import or.yonsai.domain.ReplyVO;
import or.yonsai.service.ReplyService;

@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

	private ReplyService service;

//	댓글등록
	@PostMapping(value = "/new",
			consumes= "application/json",					//json 형태만 처리
			produces = { MediaType.TEXT_PLAIN_VALUE})		//문자열로 반환
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){			//json을 객체로 변환하는 어노테이션
		
		log.info("ReplyVO:..............................." + vo);
		
		int insertCount = service.register(vo);
		
		log.info("Reply INSERT COUNT:........................... " + insertCount);
		
		return insertCount == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	댓글 목록			테스트X, url로 확인
	@GetMapping(value = "/pages/{bno}/{page}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(
			@PathVariable("page") int page,
			@PathVariable("bno") int bno){

		Criteria cri =new Criteria(page, 10);
		
		log.info("get Reply List bno......................: "+ bno);
		log.info("cri of getList....................." + cri);
		
		return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
	}

// 	개별 댓글 조회			테스트X, url로 확인
	@GetMapping(value = "/{rno}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") int rno){
		
		log.info("get...........................rno: " + rno);
		
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	
//	댓글 삭제
	@DeleteMapping(value = "/{rno}",
			produces = {
					MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") int rno){
		
		log.info("remove...........................rno: " + rno);
		
		return service.remove(rno) == 1
				?new ResponseEntity<>("success", HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	댓글 수정
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH},
			value = "/{rno}",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(
				@RequestBody ReplyVO vo,
				@PathVariable("rno") int rno) {
		
		vo.setRno(rno);
		
		log.info("modify...........................rno: " + rno);
		
		log.info("modify............................" + vo);
		
		return service.modify(vo) ==1
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
