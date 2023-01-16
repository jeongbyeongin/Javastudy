package practice03_Watch;

public class Watch {

	// 필드
	private int hour;  // 0 ~ 23
	private int minute;  // 0 ~ 59
	private int second;  // 0 ~ 59
	
	// 생성자
	public Watch(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	// 메소드
		public void addHour(int hour) {
			this.hour += hour;
			while(this.hour > 24) {
				this.hour -= 24;
			}
		}
		public void addMinute(int minute) {
			this.minute += minute;
			while(this.minute > 60) {
				this.minute -= 60;
				this.hour += 1;
			}
		}
		public void addSecond(int second) {
			this.second += second;
			while(this.second > 60) {
				this.second -= 60;
				this.minute += 1;
				while(this.minute > 60) {
					this.minute -= 60;
					this.hour ++;
					
					
				}
			}
			}
		public void see() {
			System.out.println(this.hour + "시간" + this.minute + "분" + this.second + "초");
		}
}
		
		