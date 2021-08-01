
public class Time {
	
	private final int hour;
	private final int min;
	
	public Time(int hour, int min) {
		this.hour=hour;
		this.min = min;
		
	}
	public boolean afterTime(Time t) {
		if(this.hour>t.hour) {
			return true;
		}
		else if(this.hour==t.hour) {
			if(this.min>t.min) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public boolean sameTime(Time t1)
	{
		if(this.hour==t1.hour && this.min==t1.min)
		{
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean intersects(Time st,Time et,Time st2,Time et2 )
	{
		if(st2.afterTime(st)&& et.afterTime(et2)) {
			return true;
		}
		if(st2.afterTime(st)&&et.afterTime(st2)&&et2.afterTime(et))
		{
			return true;
		}
		if(st.afterTime(st2)&&et2.afterTime(st)&&et.afterTime(et2))
		{
			return true;
		}
		if(st.afterTime(st2)&&et2.afterTime(et))
		{
			return true;
		}
		if(st.sameTime(st2)&&et2.afterTime(et))
		{
			return true;
		}
		if(st.afterTime(st2)&& et.sameTime(et2))
		{
			return true;
		}
		if(st.sameTime(st2)&&et.sameTime(et2))
		{
			return true;
		}
		
		return false;
	}
	
	public String toString(){
		return hour+":"+min;
	}
	

}
