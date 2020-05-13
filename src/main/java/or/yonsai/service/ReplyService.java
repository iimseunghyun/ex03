package or.yonsai.service;

import java.util.List;

import or.yonsai.domain.Criteria;
import or.yonsai.domain.ReplyPageDTO;
import or.yonsai.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO vo);
	
	public ReplyVO get(int rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(int rno);
	
	public List<ReplyVO> getList(Criteria cri, int bno);
	
	public ReplyPageDTO getListPage(Criteria cri, int bno);
	
}
