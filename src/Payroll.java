import java.util.Scanner;

public class Payroll 
{
	public static void main(String[] args)
	{
			Scanner in = new Scanner(System.in);
			boolean a = true;
			Employee A = new Employee();
			double sum = 0.0, avg;
			int count=0;
			while(a!=false)
			{
				count=count + 1;
				System.out.println("\n//////////////////| EMPLOYEE PAYROLL CALCULATOR > CLIENT " +count +" |//////////////////");
				System.out.println("Welcome to St. John's Student Payroll System\n");
				System.out.print("Please Enter employee's id: [last four digits of SSN number]:");
						while(!in.hasNext("[0-9A-Za-z]+"))
						{
							in.next();
				    		System.out.print("ERROR: Please enter only Numerical last four digits of SSN number: ");
						}
						String employeeId = in.next();
						A.setEmployeeId(employeeId);
						int length = employeeId.length();
						if(length != 4)
						{
							Scanner input = new Scanner(System.in);
							System.out.println("ERROR: Please enter relevant value as per feild");
							System.out.print("       If you wish to terminate type 'Yes' or 'No' to continue: ");
							while(!input.hasNext("[A-Za-z]+"))
							{
								input.next();
								System.out.print("ERROR: Please enter only an alphabetical value: ");
							}
							String in1= input.next();
							if(in1.equalsIgnoreCase("Yes"))
							{
								a = false;										
							}
							else
							{
								a = true;
							}
						}
						else
						{
							System.out.print("Please enter your First Name followed by Last Name: ");
							while(!in.hasNext("[A-Za-z]+"))
							{
							    in.next();
							    System.out.print("ERROR: Please enter only an alphabetical value: ");
							}
							String fname = in.next();
										A.setFname(fname);
							while(!in.hasNext("[A-Za-z]+"))
							{
								in.next();
								System.out.print("ERROR: Please enter only an alphabetical value: ");
							}
							String lname = in.next();
							A.setLname(lname);
							System.out.print("Please enter your Marital Status (Single or Married): ");
							while(!in.hasNext("[A-Za-z]+"))
							{
							    in.next();
							    System.out.print("Please enter only an alphabetical value: ");
							}
							String Martial = in.next();
							A.setMartial(Martial);
							if(Martial.compareToIgnoreCase("Married")==0 || Martial.compareToIgnoreCase("Single")==0)
							{
								System.out.print("Please Enter Hours Worked in a Week: ");
								while(!in.hasNextDouble())
								{
									in.next();
									System.out.print("ERROR: Please Enter only positive Numerical value: ");
								}
								double hours = in.nextDouble();
								A.setHours(hours);
								if(hours<0)
								{
									Scanner input = new Scanner(System.in);
									System.out.println("ERROR: Please enter relevant value as per feild");
									System.out.print("       If you wish to terminate type 'Yes' or 'No' to continue: ");
									while(!input.hasNext("[A-Za-z]+"))
									{
										input.next();
										System.out.print("ERROR: Please enter only an alphabetical value: ");
									}
									String in2= input.next();
									if(in2.equalsIgnoreCase("Yes"))
									{
										a = false;										
									}
									else
									{
										a = true;
									}
								}
								else
								{
									System.out.print("Please Enter the Hourly Rate: ");
									while(!in.hasNextDouble())
									{
									    in.next();
									    System.out.println("ERROR: Please enter the rate only in positive Numerical Digits");
									}
									double rate = in.nextDouble();
									A.setRate(rate);
									if(rate<0)
									{
										Scanner input = new Scanner(System.in);
										System.out.println("ERROR: Please enter relevant value as per feild");
										System.out.print("       If you wish to terminate type 'Yes' or 'No' to continue: ");
										while(!input.hasNext("[A-Za-z]+"))
										{
											input.next();
											System.out.print("ERROR: Please enter only an alphabetical value: ");
										}
										String in3= input.next();
										if(in3.equalsIgnoreCase("Yes"))
										{
											a = false;										
										}
										else
										{
											a = true;
										}
									}
								}
							A.computeGrossPay();
							sum = sum + A.getGross();
							A.computeTaxAmount();
							A.computeNetPay();
							A.displayEmployeeInfo();
							}
							else
							{
								Scanner input = new Scanner(System.in);
								System.out.println("ERROR: Please enter relevant value as per feild");
								System.out.print("       If you wish to terminate type 'Yes' or 'No' to continue: ");
								while(!input.hasNext("[A-Za-z]+"))
								{
									input.next();
									System.out.print("ERROR: Please enter only an alphabetical value: ");
								}
								String in4= input.next();
								if(in4.equalsIgnoreCase("Yes"))
								{
									a = false;										
								}
								else
								{
									a = true;
								}
							}
				}
				System.out.println("\n////////////////| PAYROLL PHASE 4 EMPLOYEE " +count +" DONE |///////////////\n");
				Scanner input = new Scanner(System.in);
				System.out.print("       Do wish to continue enter 'YES' else 'NO': ");
				while(!input.hasNext("[A-Za-z]+"))
				{
					input.next();
					System.out.print("ERROR: Please enter only an alphabetical value: ");
				}
				String in4= input.next();
				if(in4.equalsIgnoreCase("Yes"))
				{
					a = true;										
				}
				else
				{
					a = false;
				}
			}
			if(count>0)
			{
				avg = sum / count;
			}
			else
			{
				avg = 0.0;
			}
			System.out.println("\nAverage of employee's Gross Pay is: $" + avg + "\n");
			System.out.println("////////////////////////////////////////////////////////////////////");
			System.out.println("                      Program Terminated");
			System.out.println("////////////////////////////////////////////////////////////////////");
		}
}