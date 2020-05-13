package or.yonsai.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum;
	private int amount;
	private int offsetNum;				//매핑에 쓰인다.
	
	private String type;
	private String keyword;
	
	public Criteria() {				//기본생성자
		this(1,5);					//생성자로, 최근 게시물 5개 리스트업
	}
	
	public Criteria(int pageNum, int amount) {		//생성자
		this.pageNum = pageNum;
		this.amount = amount;
//		this.offsetNum = (pageNum-1) *amount;
		updateOffsetNum();
	}
	
	public void updateOffsetNum() {
		this.offsetNum = (pageNum-1) * amount;
	}
	
	public String[] getTypeArr() {
		
		return type == null? new String[] {}: type.split("");
	}
	
	public String getListLink() {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		
		return builder.toUriString();
	}
	
}
