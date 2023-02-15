package api;

public class Accident {
		
	
	// 사고 1건의 정보를 
	// 1개로 만들어주기 위해서 만든다 Bean이나 Map으로 만든다.
	
	
	private String occrrncDt;
	private String occrrncDayCd;
	private int dthDnvCnt;
	private int injpsnCnt;
	
	public String getOccrrncDt() {
		return occrrncDt;
	}
	public void setOccrrncDt(String occrrncDt) {
		this.occrrncDt = occrrncDt;
	}
	public String getOccrrncDayCd() {
		return occrrncDayCd;
	}
	public void setOccrrncDayCd(String occrrncDayCd) {
		this.occrrncDayCd = occrrncDayCd;
	}
	public int getDthDnvCnt() {
		return dthDnvCnt;
	}
	public void setDthDnvCnt(int dthDnvCnt) {
		this.dthDnvCnt = dthDnvCnt;
	}
	public int getInjpsnCnt() {
		return injpsnCnt;
	}
	public void setInjpsnCnt(int injpsnCnt) {
		this.injpsnCnt = injpsnCnt;
	}
	
	
}
