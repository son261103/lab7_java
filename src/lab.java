import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Nguoi {
    String ten;
    int tuoi;
    String diaChi;

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        ten = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        tuoi = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự xuống dòng
        System.out.println("Nhập địa chỉ: ");
        diaChi = scanner.nextLine();
    }

    public void hienThiThongTin() {
        System.out.println("Tên: " + ten + ", Tuổi: " + tuoi + ", Địa chỉ: " + diaChi);
    }
}

class NhanVien extends Nguoi {
    double luong;
    String chucVu;

    public void nhapThongTin() {
        super.nhapThongTin(); // Gọi phương thức nhập của lớp cha (Nguoi)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập lương: ");
        luong = scanner.nextDouble();
        scanner.nextLine(); // Đọc ký tự xuống dòng
        System.out.println("Nhập chức vụ: ");
        chucVu = scanner.nextLine();
    }

    public void hienThiThongTin() {
        super.hienThiThongTin(); // Gọi phương thức hiển thị của lớp cha (Nguoi)
        System.out.println("Lương: " + luong + ", Chức vụ: " + chucVu);
    }

    public double getLuong() {
        return luong;
    }
}

class CongTy {
    int soLuongNhanVien;
    List<NhanVien> nhanViens;

    public CongTy() {
        nhanViens = new ArrayList<>();
    }

    public void nhapDuLieu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng nhân viên: ");
        soLuongNhanVien = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự xuống dòng

        for (int i = 0; i < soLuongNhanVien; i++) {
            NhanVien nhanVien = new NhanVien();
            System.out.println("Nhập thông tin cho nhân viên " + (i + 1) + ": ");
            nhanVien.nhapThongTin();
            nhanViens.add(nhanVien);
        }
    }

    public void hienThiDuLieu() {
        System.out.println("Thông tin nhân viên:");
        for (NhanVien nhanVien : nhanViens) {
            nhanVien.hienThiThongTin();
        }
    }

    public NhanVien timNhanVienCoLuongCaoNhat() {
        if (nhanViens.isEmpty()) {
            return null;
        }

        return Collections.max(nhanViens, Comparator.comparingDouble(NhanVien::getLuong));
    }

    public NhanVien timNhanVienTheoTen(String ten) {
        for (NhanVien nhanVien : nhanViens) {
            if (nhanVien.ten.equalsIgnoreCase(ten)) {
                return nhanVien;
            }
        }
        return null;
    }

    public void sapXepNhanVienTheoLuong() {
        Collections.sort(nhanViens, Comparator.comparingDouble(NhanVien::getLuong).reversed());
    }

    public void sapXepNhanVienTheoTen() {
        Collections.sort(nhanViens, Comparator.comparing(nhanVien -> nhanVien.ten));
    }
}

public class lab {
    public static void main(String[] args) {
        CongTy congTy = new CongTy();
        congTy.nhapDuLieu();

        // Hiển thị thông tin nhân viên
        congTy.hienThiDuLieu();

        // Tìm và hiển thị nhân viên có lương cao nhất
        NhanVien nhanVienLuongCaoNhat = congTy.timNhanVienCoLuongCaoNhat();
        if (nhanVienLuongCaoNhat != null) {
            System.out.println("Nhân viên có lương cao nhất:");
            nhanVienLuongCaoNhat.hienThiThongTin();
        } else {
            System.out.println("Không có nhân viên trong công ty.");
        }

        // Tìm và hiển thị nhân viên theo tên
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên cần tìm kiếm: ");
        String tenTimKiem = scanner.nextLine();
        NhanVien nhanVienTimKiem = congTy.timNhanVienTheoTen(tenTimKiem);
        if (nhanVienTimKiem != null) {
            System.out.println("Nhân viên được tìm thấy:");
            nhanVienTimKiem.hienThiThongTin();
        } else {
            System.out.println("Không tìm thấy nhân viên.");
        }

        // Sắp xếp nhân viên theo lương và hiển thị
        congTy.sapXepNhanVienTheoLuong();
        System.out.println("Nhân viên được sắp xếp theo lương:");
        congTy.hienThiDuLieu();

        // Sắp xếp nhân viên theo tên và hiển thị
        congTy.sapXepNhanVienTheoTen();
        System.out.println("Nhân viên được sắp xếp theo tên:");
        congTy.hienThiDuLieu();
    }
}
