package com.shopping.util;

public class PageUtil {
	public static Page createPage(int currentPage, int pageCount, int totalCount) {
		int totalPage = getTotalPage(pageCount, totalCount);
		int startIndex = getStaticIndex(currentPage, pageCount);
		boolean hasNextPage = getHasNextPage(currentPage, totalPage);
		boolean hasLastPage = getHasLastPage(currentPage);
		Page page = new Page(currentPage, pageCount, hasNextPage, hasLastPage,
				totalCount, totalPage, startIndex);
		return page;
	}

	// 求总页数
	public static int getTotalPage(int pageCount, int totalCount) {
		int totalPage = 0;
		if (totalCount % pageCount == 0) {
			totalPage = totalCount / pageCount;
		} else {
			totalPage = 1 + totalCount / pageCount;
		}
		return totalPage;
	}

	// 求开始索引
	public static int getStaticIndex(int currentPage, int pageCount) {
		return (currentPage - 1) * pageCount;
	}

	// 是否有下一页
	public static boolean getHasNextPage(int currentPage, int totalPage) {
		if (currentPage < totalPage) {
			return true;
		}
		return false;
	}

	// 是否有上一页
	public static boolean getHasLastPage(int currentPage) {
		if (currentPage > 1) {
			return true;
		}
		return false;
	}
}
