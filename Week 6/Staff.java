/** 
	Staff object to manage salaries and hours worked.
*/
public class Staff {
	// Attributes
	private String name;  // name of the staff
	private double salary_per_hour;  // hourly salary rate
	private double hours_unpaid;  // outstanding unpaid hours
	private double hours_standard_per_day;  // standard work hours per day
	
	/**
		Open a new staff record with the standard hours per day of 7.5.
		@param staff_name name of the staff
		@param staff_salary_per_hour hourly salary rate
	*/
	public Staff(String staff_name, double staff_salary_per_hour) {
		name = staff_name;
		salary_per_hour = staff_salary_per_hour;
		hours_standard_per_day = 7.5;
		hours_unpaid = 0;  // 0 starting balance
	}

	/**
		Increment balance of hours worked by a specified number of days
		@param days number of days
	*/
	public void work_days(double days) {
		hours_unpaid = hours_unpaid + days * hours_standard_per_day;
	}

	/**
		Return salary amount and reset outstanding hours unpaid.
	*/
	public double pay_salary() {
		double salary = hours_unpaid * salary_per_hour;
		hours_unpaid = 0;
		return salary;
	}

	/**
		Print a summary of salary details.
	*/
	public void summary() {
		System.out.println("*** Summary of Staff Details ***");
		System.out.println("Staff name: " + name);
		System.out.printf("Salary per hour: %.5f\n", salary_per_hour);
		System.out.printf("Standard work hours per day: %.2f\n", hours_standard_per_day);
		System.out.printf("Current accummulated hours for next payment: %.2f\n", hours_unpaid);
	}

	/**
		Test code
	*/
	public static void main(String[] args) {
		Staff test_staff = new Staff("John Titor", 19.70);
		test_staff.summary();
		test_staff.work_days(10);  // work for two weeks
		test_staff.summary();
		double payment = test_staff.pay_salary();
		System.out.printf("Paid amount: $%.2f\n", payment);
		test_staff.summary();
	}
}
