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
public class ArrayClassModeTwoAction {
	private int daysOfmonth;
	private int ave1 = 0;
	private int ave2 = 0;
	private int flag10 = 0;
	private int count10 = 0;
	private int count10test = 0;
	private int n;
	private int convert[][];
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

	public void method(int num) {
		int[][] paiban = new int[6 + daysOfmonth][num];
		convert = new int[num][6 + daysOfmonth];
		int[][] testpaiban = new int[6 + daysOfmonth][3];
		ave1 = workhour(num) / 20;
		ave2 = (workhour(num) - 10 * ave1) / 10;
		for (int i = 0; i < 6 + daysOfmonth; i++) {
			for (int j = 0; j < num; j++) {
				if (i <= 5) {
					paiban[i][j] = 4;
				} else {
					paiban[i][j] = shulie(i, j, paiban);
					logic(i, j, paiban);
					if (paiban[i][j] == 1) {
						if (testpaiban[i][1] >= ave1) {
							paiban[i][j] = 2;
							logic(i, j, paiban);
							if (testpaiban[i][2] >= ave2) {
								paiban[i][j] = 4;
								logic(i, j, paiban);
							} else {
								if (paiban[i][j] == 2) {
									testpaiban[i][2]++;
								}
							}
						} else {
							if (paiban[i][j] == 1) {
								testpaiban[i][1]++;
							}
						}

					} else if (paiban[i][j] == 2) {
						if (testpaiban[i][2] >= ave2) {
							paiban[i][j] = 1;
							logic(i, j, paiban);
							if (testpaiban[i][1] >= ave1) {
								paiban[i][j] = 4;
								logic(i, j, paiban);
							} else {
								if (paiban[i][j] == 1) {
									testpaiban[i][1]++;
								}
							}
						} else {
							if (paiban[i][2] == 2) {
								testpaiban[i][2]++;
							}
						}
					} else {
						continue;
					}

				}

			}
		}
		for (int n = 0; n < num; n++) {
			for (int m = 0; m < 6 + daysOfmonth; m++) {
				convert[n][m] = paiban[m][n];
			}

			for (int k = 0; k < 6 + daysOfmonth; k++) {
				if (convert[n][k] == 4) {
					continue;
				} else {
					count10++;
				}
			}
			if (count10 * 10 < 160) {
				for (int i = 6; i < 13 && calculator(n, 6, convert) < 30; i++) {
					if (convert[n][i] == 4 && convert[n][i - 1] != 2) {
						convert[n][i] = 1;
						count10++;
					}
					if (count10 * 10 > 170) {
						break;
					}
				}

				for (int i = 13; i < 20 && calculator(n, 13, convert) < 30; i++) {
					if (convert[n][i] == 4 && convert[n][i - 1] != 2) {
						convert[n][i] = 1;
						count10++;
					}
					if (count10 * 10 > 170) {
						break;
					}
				}

				for (int i = 20; i < 27 && calculator(n, 20, convert) < 30; i++) {
					if (convert[n][i] == 4 && convert[n][i - 1] != 2) {
						convert[n][i] = 1;
						count10++;
					}
					if (count10 * 10 > 170) {
						break;
					}
				}

				for (int i = 27; i < 34 && calculator(n, 27, convert) < 30; i++) {
					if (convert[n][i] == 4 && convert[n][i - 1] != 2) {
						convert[n][i] = 1;
						count10++;
					}
					if (count10 * 10 > 170) {
						break;
					}
				}
				if (count10 * 10 < 160) {
					if (convert[n][6 + daysOfmonth - 2] == 4) {
						convert[n][34] = 1;
						count10++;
					}
					if (convert[n][6 + daysOfmonth - 1] == 4) {
						convert[n][35] = 1;
						count10++;
					}

				}

			}
			//System.out.println("人员" + (n + 1) + "的工作总时间为：  " + (count10 * 10)
			//		+ "小时");
			count10 = 0;

		}

//		for (int p = 0; p < num; p++) {
//			for (int q = 0; q < 6 + daysOfmonth; q++) {
//				if (q == 0) {
//					//System.out.println("人员" + (p + 1) + "的排班情况如下：  ");
//
//				}
//				if ((q + 1) % 7 == 0) {
//					//System.out.print(convert[p][q] + "\t");
//					//System.out.println();
//
//				} else {
//					//System.out.print(convert[p][q] + "\t");
//				}
//			}
//		}

	}

	public int shulie(int n, int m, int[][] array) {
		if (n == 6) {
			int b = new Random().nextInt(2) + 1;
			return b;

		} else {
			if (array[n - 1][m] == 4) {
				int i = new Random().nextInt(2) + 1;
				return i;
			} else if (array[n - 1][m] == 1) {
				int i = new Random().nextInt(2) + 1;
				return i;
			} else {
				int i = new Random().nextInt(2) + 1;
				if (i == 2) {
					return i;
				} else {
					return 2;
				}
			}
		}
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
			} else {
				flag10++;
			}
		}
		if (flag10 * 10 > 40) {
			paiban[n][m] = 4;
			flag10 = 0;
		}

	}

	public int calculator(int n, int m, int[][] array) {
		count10test = 0;
		for (int i = m; i < m + 7; i++) {
			if (array[n][i] == 4) {
				continue;
			} else {
				count10test++;
			}
		}
		return count10test * 10;
	}
}
