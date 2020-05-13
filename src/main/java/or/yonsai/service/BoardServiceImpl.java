package or.yonsai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import or.yonsai.domain.BoardVO;
import or.yonsai.domain.Criteria;
import or.yonsai.mapper.BoardMapper;

@Log4j
@Service
@AllArgsConstructor

public class BoardServiceImpl implements BoardService {

//@allargsconstructor 		or		@Setter(onMethod_ = @Autowired)			
	//@autowired 생략(spring 4.3 이상부터)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		
		log.info("register......"+board);
		
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(int bno) {
		
		log.info("get........."+ bno);
		
		return mapper.read(bno);
		
	}

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify.........." + board);
		
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(int bno) {
		
		log.info("remove............." + bno);
		
		return mapper.delete(bno) == 1;
	}

//	@Override
//	public List<BoardVO> getList() {
//		
//		log.info("getList..........");
//		return mapper.getList();
//	}
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		log.info("get List With criteria:.........."+cri);
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		
		log.info("get total count service...................");
		
		return mapper.getTotalCount(cri);
	}
}
