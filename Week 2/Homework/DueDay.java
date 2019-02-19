public class DueDay
{
	static public void main(String[] args)
	{
		// Initialise the day index (0 = Sunday, 1 = Monday, 2 = Tuesday, ...), and days until due date
		final int day_index = 3;
		final int due_days = 10;
		
		// Index of the due day
		int due_day_index = (day_index + due_days) % 7;
		
		// Map index to name of day
		String[] day_map = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		String due_day = day_map[due_day_index];
		
		System.out.println("Due day: " + due_day);
	}
}
