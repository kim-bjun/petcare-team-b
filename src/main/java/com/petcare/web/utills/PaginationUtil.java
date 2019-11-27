package com.petcare.web.utills;

/**
 * 페이징처리유틸 
 * @author jwpark
 *
 */
public class PaginationUtil {
	
	public static PaginationUtil instance = new PaginationUtil();
	
	private int offset;
	private int lastPage;
	
	private PaginationUtil(){
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
	public String autoPaging(long totalRows, long perPage, long numberLinks,
			long currentPage) {
		StringBuffer output = new StringBuffer();

		if (totalRows == 0L)
			return output.toString();

		long numberPages = (long) Math.ceil((float) totalRows /(float) perPage);
		
		this.setOffset((int) ((currentPage - 1L) * perPage));
		this.setLastPage((int) numberPages);

		output.append("<ul class=\"pagination\">\n");

		// 첫페이지로 가기
		if (currentPage - numberLinks > 0) {
			output.append("<li><a href=\"#\" data-page=\"1\" >");
			output.append("<span class=\"glyphicon glyphicon-fast-backward\"></span>");
			output.append("</a></li>\n");
		} else {
		//	output.append("<li class=\"disabled\"><a href=\"#\"><span class=\"glyphicon glyphicon-fast-backward\"></span></a></li>\n");
		}

		// 10페이지 뒤로 가기
		if (currentPage > numberLinks) {
			String s2;

			if (currentPage % numberLinks == 0L) {
				s2 = Long.toString(currentPage - numberLinks);
			} else {
				s2 = Long.toString(currentPage - (currentPage % numberLinks));
			}

			output.append("<li><a href=\"#\" data-page=\"").append(s2)
					.append("\" >");
			output.append("<span class=\"glyphicon glyphicon-step-backward\"></span>");
			output.append("</a></li>\n");

		} else {
		//	output.append("<li class=\"disabled\"><a href=\"#\"><span class=\"glyphicon glyphicon-step-backward\"></span></a></li>\n");
		}

		// 페이지 출력
		long pageConunt = currentPage / numberLinks;

		if (currentPage % numberLinks == 0L) {
			pageConunt = currentPage / numberLinks - 1L;
		}

		long start = pageConunt * numberLinks + 1L;
		long end = (pageConunt + 1L) * numberLinks + 1L;

		for (long index = start; index < end; index++) {

			String tsFontBegin = "<li>";
			String tsFonfEnd = "</li>\n";

			// 현재페이지
			if (index == currentPage) {
				tsFontBegin = "<li class=\"active\">";
				tsFonfEnd = "</li>\n";
			}

			output.append(tsFontBegin);
			output.append("<a href=\"#\" data-page=\"")
					.append(Long.toString(index)).append("\" >")
					.append(Long.toString(index)).append("</a>");
			output.append(tsFonfEnd);

			if (index == numberPages) {
				break;
			}
		}

		// 10페이지 앞으로 가기
		if (numberPages > (pageConunt + 1L) * numberLinks) {

			output.append("<li><a href=\"#\" data-page=\"")
					.append(Long.toString((pageConunt + 1L) * numberLinks + 1L))
					.append("\" >");
			output.append("<span class=\"glyphicon glyphicon-step-forward\"></span>");
			output.append("</a></li>\n");

		} else {
		//	output.append("<li class=\"disabled\"><a href=\"#\"><span class=\"glyphicon glyphicon-step-forward\"></span></a></li>\n");
		}

		// 마지막페이지가기
		if (currentPage + numberLinks < pageConunt) {
			output.append("<li><a href=\"#\" data-page=\"")
					.append(Long.toString(pageConunt)).append("\" >");
			output.append("<span class=\"glyphicon glyphicon-fast-forward\"></span>");
			output.append("</a></li>\n");
		} else {
		//	output.append("<li class=\"disabled\"><a href=\"#\"><span class=\"glyphicon glyphicon-fast-forward\"></span></a></li>\n");
		}

		output.append("</ul>");

		return output.toString();
	}

}
