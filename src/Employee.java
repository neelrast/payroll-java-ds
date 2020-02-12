public class Employee 
{
	private String employeeId;		//employee's Identification number
	private String fname;			//employee's First name.
	private String lname;			//employee's Last Name
	private String Martial;			//employees's Martial Status
	private double hours;			//No. of Working hours (Inclusive Overtime)
	private double rate;			//Rate of Income per Hour
	private double Gross;			//Gross Payment
	private double taxPay;			//Amount of Tax as per Gross.
	private double net;
	
	/**
	 * default constructor to initialize the values.
	 */
	public Employee()
	{
		setEmployeeId(null);
		setFname(null);
		setLname(null);
		setMartial(null);
		hours = 0.0;
		rate = 0.0;
		Gross=0.0;
		taxPay=0.0;
		net = 0.0;
	}
	
	/**
	 * Overloaded Constructor to set the values.
	 * @param employeeId = employee's Identification Number.
	 * @param fname = employee's First Name.
	 * @param lname = employee's Last Name.
	 * @param Martial = employee's Martial Status (i.e. Single or married).
	 * @param hours = No. of working Hours;
	 * @param rate = Rate of Salary per Hour;
	 * @param Gross = Gross amount;
	 * @param taxPay = amount of Tax as per Gross;
	 */
	public Employee(String employeeId, String fname, String lname, String Martial, double hours, double rate, double Gross, double taxPay, double net)
	{
		this.employeeId = employeeId;
		this.fname = fname;
		this.lname = lname;
		this.Martial = Martial;
		this.hours = hours;
		this.rate = rate;
		this.Gross = Gross;
		this.taxPay = taxPay;
		this.net = net;
	}
	
	/**
	 * To Compute Gross Pay of the Employee (with Overtime bonus payment)
	 * @param hours = No. of Working Hours (inclusive of OverTime)
	 * @param rate = Rate of Salary per Hour;
	 * @return Gross = Total amount of money for the hours worked.
	 */
	public void computeGrossPay()
	{
		if(getHours()>40)
		{
			Gross=(40*getRate()) + ((getHours()-40)*(1.5)*getRate());
		}
		else
		{
			Gross= getHours()*getRate();
		}
		getGross();
	}
	/**
	 * to Compute the Tax Amount.
	 */
	public void computeTaxAmount()
	{
		double taxRate = 0.1;
		String Marital1 = "Single";
		if(getMartial().compareToIgnoreCase(Marital1)==0)
		{
						if(getGross() <= 44)
						{
							taxRate = 0;
							taxPay = taxRate;
						}
						else if(getGross() >44 && getGross()<=222)
						{
							taxPay = (0.0) + taxRate*(getGross()-44);
						}
						else if(getGross()>222 && getGross()<=764)
						{
							taxRate = 0.15;
							taxPay = (17.80) + taxRate*(getGross()-222);
						}
						else if(getGross()>764 && getGross()<=1789)
						{
							taxRate = 0.25;
							taxPay = (99.10) + taxRate*(getGross()-764);
						}
						else if(getGross()>1789 && getGross()<=3685)
						{
							taxRate = 0.28;
							taxPay = (355.35) + taxRate*(getGross()-1789);
						}
						else if(getGross()>3685 && getGross()<=7958)
						{
							taxRate = 0.33;
							taxPay = (886.23) + taxRate*(getGross()-3685);
						}
						else if(getGross()>7958 && getGross()<=7990)
						{
							taxRate = 0.35;
							taxPay =(2296.32) + taxRate*(getGross()-7958);
						}
						else
						{
							taxRate = 0.396;
							taxPay =(2307.52) + taxRate*(getGross()-7990);
						}
		}
		else
		{
						if(getGross() <= 165)
						{
							taxRate = 0;
							taxPay = taxRate;
						}
						else if(getGross( )>165 && getGross() <=520)
						{
							taxRate = 0.10;
							taxPay = (0.0) + taxRate*(getGross()-165);
						}
						else if(getGross() >520 && getGross() <=1606)
						{
							taxRate = 0.15;
							taxPay = (35.50) + taxRate*(getGross()-520);
						}
						else if(getGross()>1606 && getGross()<=3073)
						{
							taxRate = 0.25;
							taxPay = (198.40) + taxRate*(getGross()-1606);
						}
						else if(getGross()>3073 && getGross()<=4597)
						{
							taxRate = 0.28;
							taxPay = (565.15) + taxRate*(getGross()-3073);
						}
						else if(getGross()>4597 && getGross()<=8079)
						{
							taxRate = 0.33;
							taxPay = (991.87) + taxRate*(getGross()-4597);
						}
						else if(getGross()>8079 && getGross()<=9105)
						{
							taxRate = 0.35;
							taxPay =(2140.93) + taxRate*(getGross()-8079);
						}
						else
						{
							taxRate = 0.396;
							taxPay =(2500.03) + taxRate*(getGross()-9105);
						}
		}
		getTaxPay();
	}
	/**
	 * to compute the net pay of employee.
	 */
	public void computeNetPay()
	{
		net = getGross()-getTaxPay();
		getNet();
	}
	/**
	 * to display the info of Entered employee.
	 */
	public void displayEmployeeInfo()
	{
		System.out.print("\nPayroll Summary for Employee ID: "+ getEmployeeId() + "\n");
		System.out.print("Employee's name: " + getFname() + " " + getLname() + "\n");
		System.out.print("Hours Worked: \t " + (getHours()) + " hrs\n");
		if(getHours()>40)
		{
			System.out.print("Hours Over Time: " + (getHours()-40) + " hrs \n");
		}
		System.out.print("Hourly Rate: \t $ " + getRate() + "\n");
		System.out.print("Gross Pay: \t $ " + getGross() + "\n");
		System.out.printf("Tax Amount: \t $ %.2f \n", getTaxPay());
		System.out.printf("Net Pay: \t $ %.2f \n", getNet());
	}
	/**
	 * to get the employee identification number.
	 * @return employeeID = employee Identification Number.
	 */
	public String getEmployeeId() 
	{
		return employeeId;
	}
	/**
	 * to set the employee's ID to the variable employee ID
	 * @param employeeId = Employee's Identification No.
	 */
	public void setEmployeeId(String employeeId) 
	{
		this.employeeId = employeeId;
	}
	/**
	 * to get the first name.
	 * @return fname.charAt(0) = to return the First name initial.
	 */
	public char getFname() 
	{
		return fname.charAt(0);
	}
	/**
	 * set the value of string first name in variable fname.
	 * @param fname= Employee's first name;
	 */
	public void setFname(String fname) 
	{
		this.fname = fname;
	}
	/**
	 * to get the last name.
	 * @return lname = Last name of the employee. 
	 */
	public String getLname() 
	{
		return lname;
	}
	/**
	 * set the value of String last name in the variable lname;
	 * @param lname = Employee's Last Name.
	 */
	public void setLname(String lname) 
	{
		this.lname = lname;
	}
	/**
	 * to get the martial status.
	 * @return Martial = employee's martial Status.
	 */
	public String getMartial() 
	{
		return Martial;
	}
	/**
	 * set the martial Status of Employee to the variable martial.
	 * @param martial = Martial Status of Employee.
	 */
	public void setMartial(String martial) 
	{
		Martial = martial;
	}
	/**
	 * to get the working hours.
	 * @return hours = Employee's Working Hours.
	 */
	public double getHours() 
	{
		return hours;
	}
	/**
	 * to set the hours of employee's job.
	 * @param hours = employee's working hours.
	 */
	public void setHours(double hours) 
	{
		this.hours = hours;
	}
	/**
	 * to get the working hour rate.
	 * @return rate = Rate of employee's working hours in $.
	 */
	public double getRate() 
	{
		return rate;
	}
	/**
	 * to set the rate of payment of employee per hour.
	 * @param rate = Employee's payment rate.
	 */
	public void setRate(double rate) 
	{
		this.rate = rate;
	}
	/**
	 * to get the gross salary.
	 * @return Gross = Gross amount of Employee.
	 */
	public double getGross()
	{
		return Gross;
	}
	/**
	 * to get the Tax Amount.
	 * @return taxPay = Employee's tax amount with respect to his/her Gross Payment and Martial Status.
	 */
	public double getTaxPay()
	{
		return taxPay;
	}
	/**
	 * to get net Pay.
	 * @return net = Employee's net Amount ( Gross - tax ).
	 */
	public double getNet()
	{
		return net;
	}
}