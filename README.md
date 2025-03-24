# CookMates Backend

## 🚀 Giới thiệu
CookMates Backend là hệ thống API phục vụ cho ứng dụng quản lý công thức nấu ăn. Người dùng có thể tạo, chỉnh sửa, tìm kiếm công thức, đánh giá, yêu thích món ăn và nhiều tính năng khác.

---

## 📊 Entity Relationship Diagram (ERD)
![Main2](https://github.com/user-attachments/assets/c9c4de73-a206-494c-b0b7-a60b8fc6c204)

---

## 🏗 Công nghệ sử dụng
- **Java 17**
- **Spring Boot 3** (Spring MVC, Spring Data JPA, Spring Security, Spring Validation)
- **Hibernate**
- **MySQL**
- **Lombok**
- **Swagger OpenAPI**
- **JWT Authentication**
- **Cloudinary** (Lưu trữ ảnh)

---

## 🔧 Cấu hình và chạy dự án

### 1️⃣ Cài đặt các công cụ cần thiết:
- **Java 17**
- **Maven**
- **MySQL Server**

### 2️⃣ Clone project
```bash
git clone https://github.com/username/cookmates-backend.git
cd cookmates-backend
```

### 3️⃣ Cấu hình **application.properties**
Tạo file `src/main/resources/application.properties` với nội dung:
```properties
# Cấu hình Database
spring.datasource.url=jdbc:mysql://localhost:3306/cookmates
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA & Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT Config
jwt.secret=your-secret-key
jwt.expiration=86400000  # Token sống trong 24h

# Cloudinary (lưu trữ ảnh)
cloudinary.cloud-name=your-cloud-name
cloudinary.api-key=your-api-key
cloudinary.api-secret=your-api-secret
```

### 4️⃣ Chạy ứng dụng
#### Chạy bằng Maven:
```bash
mvn spring-boot:run
```

#### Hoặc build và chạy file JAR:
```bash
mvn clean package
java -jar target/cookmates-backend-0.0.1-SNAPSHOT.jar
```

#### Hoặc chạy bằng Docker:
```bash
docker-compose up --build
```

Ứng dụng sẽ chạy tại `http://localhost:8080` 🚀

---

## 📌 Các API chính

| Method | Endpoint | Chức năng |
|--------|-------------------------|--------------------------|
| `POST` | `/api/auth/register` | Đăng ký tài khoản |
| `POST` | `/api/auth/login` | Đăng nhập, nhận JWT |
| `GET` | `/api/recipes` | Lấy danh sách công thức |
| `POST` | `/api/recipes` | Tạo công thức mới |
| `GET` | `/api/recipes/{id}` | Lấy chi tiết công thức |
| `PUT` | `/api/recipes/{id}` | Cập nhật công thức |
| `DELETE` | `/api/recipes/{id}` | Xóa công thức |
| `POST` | `/api/recipes/{id}/reviews` | Đánh giá món ăn |
| `GET` | `/api/categories` | Lấy danh sách danh mục |

Chi tiết API có thể xem trong Swagger tại: `http://localhost:8080/swagger-ui/index.html`(Vẫn còn đang cập nhật...)

---

## 🔐 Bảo mật & Authentication
- Hệ thống sử dụng **JWT** để xác thực.
- Các API liên quan đến người dùng cần token hợp lệ để truy cập.
- Cấu hình bảo mật trong **Spring Security**.

---

## 🖼 Upload Ảnh
- Ảnh sẽ được lưu trữ trên **Cloudinary**.
- API `/api/recipes/{id}/upload-image` dùng để upload ảnh món ăn.

---

## 🛠 Mở rộng và phát triển
- **Tích hợp Redis** để caching dữ liệu.
- **Xây dựng API realtime với WebSocket** cho tính năng chat, bình luận.
- **Hỗ trợ đa ngôn ngữ**.

---

## 🤝 Đóng góp
Mọi đóng góp đều được hoan nghênh! Nếu bạn muốn góp ý hoặc cải thiện dự án, hãy tạo **Pull Request** hoặc **Issue** trên GitHub.

---

## 🚀 Lịch sử phát triển
- **Ngày 24/03/2025**
   + Thiết kế mô hình dữ liệu và tạo Entity
   + Cấu hình Hibernate và MySQL
   + Thiết lập DTO và thêm validation
   + Thêm trường image cho Step khi trả về response

