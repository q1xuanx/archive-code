import java.util.Scanner;

public class Ma_Tran_Vuong {

	public Ma_Tran_Vuong() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = nhapN(scan);
		int a[][] = taoMang(n, scan);
		xuatMang(a, n);
		// duongCheoChinh(a,n);
		// duongCheoPhu(a,n);
		// if(kiemTraDoiXung(a,n) == 0) {
		// System.out.println("Ma tran khong doi xung ");
		// }else {
		// System.out.println("Ma tran doi xung");
		// }
		//System.out.println("Tong cac phan tu tren duong cheo chinh: " + tinhTongTrenDuongCheoChinh(a, n));
		System.out.println("Tong cac phan tu duoi duong cheo chinh: " + tinhTongDuoiDuongCheoChinh(a, n));
	}

	public static int nhapN(Scanner scan) {
		int n = Integer.parseInt(scan.nextLine());
		return n;
	}

	public static int[][] taoMang(int n, Scanner scan) {
		int a[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("a[" + i + "][" + j + "]: ");
				a[i][j] = Integer.parseInt(scan.nextLine());
			}
		}
		return a;
	}

	public static void xuatMang(int a[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void duongCheoChinh(int a[][], int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i][i] + "\t");
		}
	}

	public static void duongCheoPhu(int a[][], int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i][n - 1 - i] + "\t");
		}
	}

	public static int kiemTraDoiXung(int a[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] != a[j][i]) {
					return 0;
				}
			}
		}
		return 1;
	}

	public static int tinhTongTrenDuongCheoChinh(int a[][], int n) {
		int tong = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				tong += a[i][j];
			}
		}
		return tong;
	}

	public static int tinhTongDuoiDuongCheoChinh(int a[][], int n) {
		int tong = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				tong += a[i][j];
			}
		}
		return tong;
	}
}
