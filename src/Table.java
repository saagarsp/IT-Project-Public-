

public class Table {
	int reservations=0;
	int tableNo;
	Time[] startTime =  new Time[100];
	Time[] endTime = new Time[100];

	public void setStartandEndTime(Time a, Time b, int pos) {
		this.startTime[pos] = a;
		this.endTime[pos] = b;
	}
}
