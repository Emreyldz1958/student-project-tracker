# 🎓 Student Project Tracker

Bu proje, bir öğrencinin görev ve proje sürecini yönetebileceği, görevlerin durumlarını takip edebileceği, öğretmenlerin öğrencilere proje ve görev atayabileceği basit bir görev yönetim sistemidir.

---

## 📌 Proje Amacı

Bu proje, görev yönetim sistemi tasarlamak ve uygulamak amacıyla yapılmıştır. Sistem; kullanıcı, proje ve görev yapılarını içermekte, görevlerin durumlarının takibini sağlamaktadır.

---

## 🚀 Kullanılan Teknolojiler

- ✅ Java 17
- ✅ Spring Boot 3
- ✅ Spring Data JPA (Hibernate)
- ✅ PostgreSQL 14
- ✅ pgAdmin 4
- ✅ Docker & Docker Compose
- ✅ Postman
- ✅ RESTful API mimarisi

---

## ⚙️ Kurulum Adımları

### 1. Veritabanı ve pgAdmin'i başlat 

```bash
docker-compose up -d


pgAdmin: http://localhost:5050

Kullanıcı: admin@admin.com

Şifre: admin

Veritabanı bağlantı adı: db

PostgreSQL user: admin, password: password


### 2. Spring Boot Uygulamasını Başlat

cd backend
mvn spring-boot:run

Uygulama portu: http://localhost:8080


📁 Proje Yapısı

student-project-tracker/
├── backend/               
│   ├── model/             
│   ├── controller/        
│   ├── repository/        
│   └── application.properties
├── docker-compose.yml     
└── README.md              
