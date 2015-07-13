package com.alibaba.monitor.mavenWeb.contral;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.Schedule;

/**
 * @author lxb Created by 2015年6月7日 下午11:24:01
 */
public class ArrayClassModeThreeAction {
	private int n;
	private int ave1 = 0;
	private int ave2 = 0;
	private int ave3 = 0;
	private int flag10 = 0;
	private int flag8 = 0;
	private int count10 = 0;
	private int count8 = 0;
	private int count10test = 0;
	private int count8test = 0;
	private int daysOfmonth;
	private int[][] convert = null;

	/**
	 * @param args
	 */
	public List<Schedule> getArrayger(List<Emp> emplist, int year, int month,int day) {
		this.n = emplist.size();
		this.daysOfmonth = DateAction.daysOfmonth(year, month);
		// System.out.println(this.n);
		method(n);
		DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		List<Schedule> schlist = new ArrayList<Schedule>();
		for (int i = 0; i < n; i++) {
			// System.out.print(i+": ");
			for (int j = 5+day; j < 6 + daysOfmonth; j++) {
				Schedule sch = new Schedule();
				sch.setEmpno(emplist.get(i).getEmpno());
				sch.setClassid(convert[i][j]);
				try {
					sch.setDates(dd.parse(year + "-" + month + "-" + (j - 5)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				schlist.add(sch);
			}
			// System.out.print("\n");
		}
		return schlist;
	}

	private void method(int num) {
		// TODO Auto-generated method stub

		int[][] paiban = new int[daysOfmonth + 6][num];
		convert = new int[num][40];
		int[][] testpaiban = new int[daysOfmonth + 6][4];
		ave1 = workhour(num) / 28;
		ave2 = workhour(num) / 28;
		ave3 = (workhour(num) - 10 * (ave1 + ave2)) / 8;
		for (int i = 0; i < daysOfmonth + 6; i++) {
			for (int j = 0; j < num; j++) {
				if (i <= 5) {
					paiban[i][j] = 4;
				} else {
					paiban[i][j] = shulie(i, j, paiban);
					logic(i, j, paiban);
					if (paiban[i][j] == 1) {
						if (testpaiban[i][1] >= ave1) {
							paiban[i][j] = 3;
							logic(i, j, paiban);
							if (testpaiban[i][3] >= ave3) {
								paiban[i][j] = 2;
								logic(i, j, paiban);
								if (testpaiban[i][2] >= ave2) {
									paiban[i][j] = 4;
									logic(i, j, paiban);
								} else {
									// logic(i,j,paiban);
									if (paiban[i][j] == 2) {
										testpaiban[i][2]++;
									}
								}

							} else {
								// logic(i,j,paiban);
								if (paiban[i][j] == 3) {
									testpaiban[i][3]++;
								}

							}

						} else {
							// logic(i,j,paiban);
							if (paiban[i][j] == 1) {
								testpaiban[i][1]++;
							}
						}
					} else if (paiban[i][j] == 2) {
						if (testpaiban[i][2] >= ave2) {
							paiban[i][j] = 3;
							logic(i, j, paiban);
							if (testpaiban[i][3] >= ave3) {
								paiban[i][j] = 1;
								logic(i, j, paiban);
								if (testpaiban[i][1] >= ave1) {
									paiban[i][j] = 4;
									logic(i, j, paiban);
								} else {
									// logic(i,j,paiban);
									if (paiban[i][j] == 1) {
										testpaiban[i][1]++;
									}
								}
							} else {
								// logic(i,j,paiban);
								if (paiban[i][j] == 3) {
									testpaiban[i][3]++;
								}
							}
						} else {

							// logic(i,j,paiban);
							if (paiban[i][j] == 2) {
								testpaiban[i][2]++;
							}
						}
					}

					else if (paiban[i][j] == 3) {
						if (testpaiban[i][3] >= ave3) {
							paiban[i][j] = 1;
							logic(i, j, paiban);
							if (testpaiban[i][1] >= ave1) {
								paiban[i][j] = 2;
								logic(i, j, paiban);
								if (testpaiban[i][2] >= ave2) {
									paiban[i][j] = 4;
									logic(i, j, paiban);
								} else {

									// logic(i,j,paiban);
									if (paiban[i][j] == 2) {
										testpaiban[i][2]++;
									}
								}
							} else {
								// logic(i,j,paiban);
								if (paiban[i][j] == 1) {
									testpaiban[i][1]++;
								}
							}
						} else {
							// logic(i,j,paiban);
							if (paiban[i][j] == 3) {
								testpaiban[i][3]++;
							}
						}
					} else {
						continue;
					}
				}
			}
		}

		for (int n = 0; n < num; n++) {
			for (int m = 0; m < daysOfmonth+6; m++) {
				convert[n][m] = paiban[m][n];
			}

			for (int k = 0; k <  daysOfmonth+6; k++) {
				if (convert[n][k] == 4) {
					continue;
				} else if (convert[n][k] == 3) {
					count8++;
				} else {
					count10++;
				}
			}

			if (count10 * 10 + count8 * 8 < 150) {
				for (int i = 6; i < 13 && calculator(n, 6, convert) < 33; i++) {
					if (convert[n][i] == 4 && convert[n][i - 1] != 2) {
						convert[n][i] = 3;
						count8++;
					}
					if (count10 * 10 + count8 * 8 > 168) {
						break;
					}
				}

				for (int i = 13; i < 20 && calculator(n, 13, convert) < 33; i++) {
					if (convert[n][i] == 4 && convert[n][i - 1] != 2) {
						convert[n][i] = 3;
						count8++;
					}
					if (count10 * 10 + count8 * 8 > 168) {
						break;
					}
				}

				for (int i = 20; i < 27 && calculator(n, 20, convert) < 33; i++) {
					if (convert[n][i] == 4 && convert[n][i - 1] != 2) {
						convert[n][i] = 3;
						count8++;
					}
					if (count10 * 10 + count8 * 8 > 168) {
						break;
					}
				}

				for (int i = 27; i < 34 && calculator(n, 27, convert) < 33; i++) {
					if (convert[n][i] == 4 && convert[n][i - 1] != 2) {
						convert[n][i] = 3;
						count8++;
					}
					if (count10 * 10 + count8 * 8 > 168) {
						break;
					}
				}
				if (count10 * 10 + count8 * 8 < 150) {
					if (convert[n][34] == 4) {
						convert[n][34] = 1;
						count10++;
					}
					if (convert[n][35] == 4) {
						convert[n][35] = 1;
						count10++;
					}

				}

			}
			// System.out.println("人员"+(n+1)+"的工作总时间为：  "+(count10*10+count8*8)+"小时");
			count10 = 0;
			count8 = 0;
		}

		// for(int p= 0;p<num;p++){
		// for(int q = 0;q<36;q++){
		// if(q==0){
		// System.out.println("人员"+(p+1)+"的排班情况如下：  ");
		// //System.out.print(paiban[p][q]+"\t");
		// }
		// if((q+1)%7==0){
		// System.out.print(convert[p][q]+"\t");
		// System.out.println();
		//
		// }else{
		// System.out.print(convert[p][q]+"\t");
		// }
		// }
		// }

	}

	public int shulie(int n, int m, int[][] array) {
		if (n == 6) {
			int b = new Random().nextInt(3) + 1;
			return b;

		} else {
			if (array[n - 1][m] == 4) {
				int i = new Random().nextInt(3) + 1;
				return i;
			} else if (array[n - 1][m] == 1 || array[n - 1][m] == 3) {
				int i = new Random().nextInt(3) + 1;
				return i;
			} else {
				int i = new Random().nextInt(3) + 1;
				if (i == 2) {
					return i;
				} else {
					return 2;
				}
			}
		}
	}

	public int average(int number) {
		int ave = 0;
		ave = number * 4 / 7;
		return ave;
	}

	public int workhour(int number) {
		int hour;
		hour = number * 30 * 40 / 7;
		return hour;
	}

	public void logic(int n, int m, int[][] paiban) {
		for (int a = n - 6; a <= n; a++) {
			if (paiban[a][m] == 4) {
				continue;
			} else if (paiban[a][m] == 3) {
				flag8++;
			} else {
				flag10++;
			}
		}
		if (flag10 * 10 + flag8 * 8 > 40) {
			paiban[n][m] = 4;
			flag10 = 0;
			flag8 = 0;
		}
	}

	public void logic2(int n, int m, int[][] paiban) {
		for (int a = m - 6; a <= n; a++) {
			if (paiban[n][a] == 4) {
				continue;
			} else if (paiban[n][a] == 3) {
				flag8++;
			} else {
				flag10++;
			}
		}
		if (flag10 * 10 + flag8 * 8 > 40) {
			paiban[n][m] = 4;
			flag10 = 0;
			flag8 = 0;
		}
	}

	public int calculator(int n, int m, int[][] array) {
		count8test = 0;
		count10test = 0;
		for (int i = m; i < m + 7; i++) {
			if (array[n][i] == 4) {
				continue;
			} else if (array[n][i] == 3) {
				count8test++;
			} else {
				count10test++;
			}
		}
		return count8test * 8 + count10test * 10;
	}

}
