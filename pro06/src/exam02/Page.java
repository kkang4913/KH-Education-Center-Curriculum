package exam02;

public class Page {
	private int pageNumber; // 페이지 번호
	private int limitPageNumber; // 최대 페이지 번호
	
	public void movePage(int pageNumber) {
		if (pageNumber <= limitPageNumber && pageNumber >=1) {
			this.pageNumber = pageNumber;
		}else {
			System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");

		}
	}
	public void nextPage() {
		if (!existsNextPage()) {
			System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");
		} else {
			this.pageNumber++;
		}
	}

	public void nextPage(int count) {
		if (!existPrevPage(count)) {
			System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");

		} else {
			this.pageNumber += count;
		}
	}

	public void prevPage() {
		if (!existPrevPage()) {
			System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");
		} else {
			this.pageNumber--;
		}
	}

	public void prevage(int count) {
		if (!existPrevPage(count)) {
			System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");

		} else {
			this.pageNumber -= count;
		}
	}

	public boolean existsNextPage() {
		if (pageNumber + 1 <= limitPageNumber) {
			return true;
		} else {
			return false;
		}
	}

	public boolean existsNextPage(int count) {
		if (pageNumber + 1 <= limitPageNumber) {
			return true;
		} else {
			return false;
		}
	}

	public boolean existPrevPage() {
		if (pageNumber - 1 >= 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean existPrevPage(int count) {
		if (pageNumber - count >= 1) {
			return true;
		} else {
			return false;
		}
	}

}
