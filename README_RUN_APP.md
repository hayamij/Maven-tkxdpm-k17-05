# HƯỚNG DẪN CHẠY CHƯƠNG TRÌNH

## Cách chạy ứng dụng

### Bước 1: Compile project
```bash
mvn clean compile
```

### Bước 2: Chạy ứng dụng
```bash
java -cp target/classes App
```

## Giao diện CLI Menu

Khi chạy chương trình, bạn sẽ thấy menu như sau:

```
╔════════════════════════════════════════╗
║     CHƯƠNG TRÌNH TÍNH TOÁN 2 SỐ       ║
╚════════════════════════════════════════╝

Vui lòng chọn chức năng:
  1. Nhân 2 số
  2. Kiểm tra chẵn lẻ
  3. Cộng 2 số
  4. Trừ 2 số
  5. Chia 2 số
  0. Thoát chương trình

Nhập lựa chọn của bạn:
```

## Hướng dẫn sử dụng

1. **Nhập số** tương ứng với chức năng bạn muốn sử dụng (0-5)
2. **Giao diện GUI** của usecase đó sẽ được mở ra
3. Nhập dữ liệu vào GUI và nhấn nút để thực hiện phép tính
4. Sau khi đóng GUI, menu sẽ hiện lại để bạn chọn chức năng khác
5. Nhập **0** để thoát chương trình

## Các chức năng

| Số | Chức năng | Mô tả |
|---|-----------|-------|
| 1 | Nhân 2 số | Tính tích của 2 số nguyên |
| 2 | Kiểm tra chẵn lẻ | Kiểm tra số nhập vào là chẵn hay lẻ |
| 3 | Cộng 2 số | Tính tổng của 2 số nguyên |
| 4 | Trừ 2 số | Tính hiệu của 2 số nguyên |
| 5 | Chia 2 số | Tính thương của 2 số nguyên (có xử lý chia cho 0) |
| 0 | Thoát | Kết thúc chương trình |

## Kiến trúc Clean Architecture

Chương trình được xây dựng theo kiến trúc Clean Architecture với các layer:

- **Entities**: Logic nghiệp vụ cốt lõi
- **Use Cases**: Các use case control
- **Interface Adapters**: Controllers, Presenters, ViewModels
- **Frameworks**: GUI Desktop (Swing)
- **App**: Entry point với CLI menu

## Lưu ý

- Tất cả các GUI sử dụng Observer pattern để cập nhật view
- Các use case hoàn toàn độc lập, tuân theo nguyên tắc SOLID
- Mỗi use case có cấu trúc tương tự nhau, dễ mở rộng
