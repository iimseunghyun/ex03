package or.yonsai.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;

import or.yonsai.domain.BoardVO;
import or.yonsai.domain.Criteria;

public interface BoardMapper {
	
//	@Select("select * from tbl_board where bno > 0")		//쿼리문 테스트해보기, mapper.xml 있을 때 필요없음 
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(int bno);
	
	public int delete(int bno);
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);

	public void updateReplyCnt(@Param("bno") int bno, @Param("amount") int amount);
}
