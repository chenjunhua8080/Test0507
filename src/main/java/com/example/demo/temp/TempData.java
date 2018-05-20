package com.example.demo.temp;

public class TempData {

	private TempItem first;
	private TempItem keyword1;
	private TempItem keyword2;
	private TempItem remark;
	public TempData(TempItem first, TempItem keyword1, TempItem keyword2, TempItem remark) {
		this.first = first;
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.remark = remark;
	}
	public TempData() {
	}
	@Override
	public String toString() {
		return "TempData [first=" + first + ", keyword1=" + keyword1 + ", keyword2=" + keyword2 + ", remark=" + remark
				+ "]";
	}
	public TempItem getFirst() {
		return first;
	}
	public void setFirst(TempItem first) {
		this.first = first;
	}
	public TempItem getKeyword1() {
		return keyword1;
	}
	public void setKeyword1(TempItem keyword1) {
		this.keyword1 = keyword1;
	}
	public TempItem getKeyword2() {
		return keyword2;
	}
	public void setKeyword2(TempItem keyword2) {
		this.keyword2 = keyword2;
	}
	public TempItem getRemark() {
		return remark;
	}
	public void setRemark(TempItem remark) {
		this.remark = remark;
	}
	
	

}
