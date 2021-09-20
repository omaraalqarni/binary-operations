
import java.util.*;
import java.io.*;
public class SimulatorProject {

	public static void main(String[] args) throws IOException {
		int A = 0, B = 0, n = 0, x, y = 0;
		boolean exitFlag = true;
		boolean settingFlag = false;
		String filein, fileout = null;
		Scanner kb = new Scanner(System.in);
		PrintWriter pf = null;
		FileOutputStream outstream = null;

		do {
			System.out.println();
			System.out.println("...............................................");
			System.out.println("1.Settings\n2.Adder\n3.Subtractor\n4.Exit\r");
			System.out.println("...............................................");
			x = kb.nextInt();
			// Settings
			if (x == 1) {
				do {
					System.out.println("Please choose the input stream");
					System.out.println("1.keyboard");
					System.out.println("2.file");
					y = kb.nextInt();
					// keyboard
					if (y == 1) {
						boolean setting1Flag = true;
						do {
							System.out.println("Please Enter the maximum number of bits ");
							n = kb.nextInt();
							if (n > 0) {
								System.out.println("Please Enter The first integer number >0");
								A = kb.nextInt();
								if (A < 0 || A > Math.pow(2.0, n))
									System.out.println("Error");
								else {
									System.out.println("Please Enter The second integer number>0");
									B = kb.nextInt();
									if (B < 0 || B > Math.pow(2.0, n))
										System.out.println("error");
									else {
										setting1Flag = false;
										settingFlag = true;
										System.out.println("Okay");
									}
								}
							} else
								System.out.println("Wrong Value for n, Try Again!!");

						} while (setting1Flag);
					}
					// file
					else if (y == 2) {
						boolean setting2Flag = false;
						do {
							try {
								System.out.println("Please Enter input file name");
								filein = kb.next();
								filein = filein + ".txt";
								FileInputStream fin = new FileInputStream(filein);
								Scanner inf = new Scanner(fin);
								System.out.println("please Enter output file name");
								fileout = kb.next();
								fileout = fileout + ".txt"; 
								outstream = new FileOutputStream(fileout);
								pf = new PrintWriter(outstream);

								boolean setting1Flag = true;
								do {
									n = inf.nextInt();
									if (n > 0) {
										A = inf.nextInt();
										if (A < 0 || A > Math.pow(2.0, n))
											System.out.println("Error");
										else {
											B = inf.nextInt();
											if (B < 0 || B > Math.pow(2.0, n))
												System.out.println("error");
											else {
												setting1Flag = false;
												settingFlag = true;
											}

										}
									} else
										System.out.println("Wrong Value for n, Try Again!!");

								} while (setting1Flag);
								inf.close();
							} catch (FileNotFoundException e) {
								System.out.println("File not found. " + e);
								System.out.println("Try Again");
								setting2Flag= true;
							}
						} while (setting2Flag);
					} else
						System.out.println("Wrong Input, Tey Again!!");
				} while (!settingFlag);
			}
			// Addition
			else if (x == 2 && settingFlag) {
				intAdder Adding = new intAdder(n);
				Adding.setA(A);
				Adding.setB(B);
				Adding.add();
				boolean[] aArray=  BinOperations.int2Bin(A, n);
				boolean[] bArray=  BinOperations.int2Bin(B, n);
				boolean[] sArray=  BinOperations.int2Bin(Adding.getS(), n);
				//Addition monitor out put
				if(y==1) {
					System.out.print("A= " + A + "\t\t");
					for(int i=0; i< n; i++) {
						if(aArray[i] == true)
							System.out.print("1");
						else
							System.out.print("0");
					}

					System.out.print("\nB= " + B + "\t\t");
					for(int i=0; i< n; i++) {
						if(bArray[i] == true)
							System.out.print("1");
						else
							System.out.print("0");
					}

					System.out.print("\nA+B= " + Adding.getS() + "\t\t");
					for(int i=0; i< n; i++) {
						if(sArray[i] == true)
							System.out.print("1");
						else
							System.out.print("0");
					}
				}
				//Addition file out put
				else if(y==2) {
					outstream = new FileOutputStream(fileout,true);
					pf = new PrintWriter(outstream);
					System.out.println("the file has been created");
					pf.print("A= " + A + "\t\t");
					for(int i=0; i< n; i++) {
						if(aArray[i] == true)
							pf.print("1");
						else
							pf.print("0");
					}

					pf.print("\nB= " + B + "\t\t");
					for(int i=0; i< n; i++) {
						if(bArray[i] == true)
							pf.print("1");
						else
							pf.print("0");
					}

					pf.print("\nA+B= " + Adding.getS() + "\t\t");
					for(int i=0; i< n; i++) {
						if(sArray[i] == true)
							pf.print("1");
						else
							pf.print("0");
					}
					pf.println("");
					pf.println("...........................................");
					pf.flush();
					pf.close();
				}
			}
			// Subtraction
			else if (x == 3 && settingFlag) {
				Subtractor Subtracting = new Subtractor(n);
				Subtracting.setA(A);
				Subtracting.setB(B);
				Subtracting.substract();
				boolean[] aArray=  BinOperations.int2Bin(A, n);
				boolean[] bArray=  BinOperations.int2Bin(B, n);
				boolean[] sArray=  BinOperations.int2Bin(Subtracting.getS(), n);
				//Subtraction monitor output
				if(y==1) {
					System.out.print("A= " + A + "\t\t");
					for(int i=0; i< n; i++) {
						if(aArray[i] == true)
							System.out.print("1");
						else
							System.out.print("0");
					}

					System.out.print("\nB= " + B + "\t\t");
					for(int i=0; i< n; i++) {
						if(bArray[i] == true)
							System.out.print("1");
						else
							System.out.print("0");
					}

					System.out.print("\nA-B= " + Subtracting.getS() + "\t\t");
					if(Subtracting.getCout() == true) 
						System.out.print("1");
					else
						System.out.print("0");

					for(int i=0; i< n; i++) {
						if(sArray[i] == true)
							System.out.print("1");
						else
							System.out.print("0");
					}
				}
				//Subtraction file output
				else if(y==2) {
					outstream = new FileOutputStream(fileout,true);
					pf = new PrintWriter(outstream);
					System.out.println("the file has been created");
					pf.print("A= " + A + "\t\t");
					for(int i=0; i< n; i++) {
						if(aArray[i] == true)
							pf.print("1");
						else
							pf.print("0");
					}

					pf.print("\nB= " + B + "\t\t");
					for(int i=0; i< n; i++) {
						if(bArray[i] == true)
							pf.print("1");
						else
							pf.print("0");
					}

					pf.print("\nA-B= " + Subtracting.getS() + "\t\t");
					if(Subtracting.getCout() == true) 
						System.out.print("1");
					else
						System.out.print("0");
					for(int i=0; i< n; i++) {
						if(sArray[i] == true)
							pf.print("1");
						else
							pf.print("0");
					}
					pf.println("");
					pf.println("...........................................");
					pf.flush();
					pf.close();

				}
				//Exit
			} else if (x == 4) {
				exitFlag = false;
				
			}

			if (!settingFlag && x !=4)
				System.out.println("Please you should put the setting first!!");

		} while (exitFlag);
		System.out.println("Thank you for using the program!!");
		kb.close();
		

	}
}
